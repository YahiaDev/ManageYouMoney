'user strict'
angular.module('common',['ab-base64']);
angular.module('home',[]);
angular.module('authentication',['ngCookies']);
angular.module('nav',['ngCookies']);
angular.module('options',[]);
var modules = ['ui.router', 'home', 'common', 'authentication', 'nav', 'options'];
var app = angular.module('myApp',modules);
app.constant('AUTH_EVENTS', {
    loginSuccess: 'auth-login-success',
    loginFailed: 'auth-login-failed',
    logoutSuccess: 'auth-logout-success',
    sessionTimeout: 'auth-session-timeout',
    notAuthenticated: 'auth-not-authenticated',
    notAuthorized: 'auth-not-authorized'
  });

  app.constant('USER_ROLES', {
    all: '*',
    admin: 'admin',
    editor: 'editor',
    guest: 'guest'
  });

  app.constant('SERVER_URL', {
    protocol: 'http',
    port: '8060',
    serverName: 'localhost',
    context:'manageyourmoney'
  });


app.config(['$stateProvider', '$urlRouterProvider', 'USER_ROLES', router]);

/*app.config(function ($httpProvider) {
  $httpProvider.interceptors.push([
    '$injector',
    function ($injector) {
      return $injector.get('AuthInterceptor');
    }
  ]);
});*/

app.config(function($httpProvider){
  $httpProvider.interceptors.push('httpSecurityInterceptor');
  $httpProvider.interceptors.push('hmacInterceptor');
});

app.config(function(hmacInterceptorProvider){
//Hmac security interceptor provider configuration
    hmacInterceptorProvider.config.rejectedApis = [{mustMatch:true,pattern:'/api'}, {mustMatch:false,pattern:'/api/authenticate'}];
});

//config for to allow CORS 
/*app.config(['$httpProvider', function ($httpProvider) {
  'use strict';
  $httpProvider.defaults.useXDomain = true;
  $httpProvider.defaults.withCredentials = true;
  delete $httpProvider.defaults.headers.common['X-Requested-With'];
  //$httpProvider.defaults.headers.common["Accept"] = "application/json";
  //$httpProvider.defaults.headers.common["Content-Type"] = "application/json";
}]);*/


app.controller('ApplicationController', function ($scope,
                                               USER_ROLES,
                                               AuthService) {
  $scope.isLoginPage = false;
  $scope.currentUser = null;
  $scope.userRoles = USER_ROLES;
  $scope.isAuthorized = AuthService.isAuthorized;
 
  $scope.setCurrentUser = function (user) {
    $scope.currentUser = user;
  };
});

app.factory('AuthInterceptor', function ($rootScope, $q,
                                      AUTH_EVENTS) {
  return {
    responseError: function (response) { 
      $rootScope.$broadcast({
        401: AUTH_EVENTS.notAuthenticated,
        403: AUTH_EVENTS.notAuthorized,
        419: AUTH_EVENTS.sessionTimeout,
        440: AUTH_EVENTS.sessionTimeout
      }[response.status], response);
      return $q.reject(response);
    }
  };
});

app.factory('AuthResolver', function ($q, $rootScope, $state) {
  return {
    resolve: function () {
      var deferred = $q.defer();
      var unwatch = $rootScope.$watch('currentUser', function (currentUser) {
        if (angular.isDefined(currentUser)) {
          if (currentUser) {
            deferred.resolve(currentUser);
          } else {
            deferred.reject();
            $state.go('user-login');
          }
          unwatch();
        }
      });
      return deferred.promise;
    }
  };
});

app.directive('loginDialog', function (AUTH_EVENTS) {
  return {
    restrict: 'A',
    template: `<div ng-if="visible"
                    ng-include="\'login-form.html\'">`,
    link: function (scope) {
      var showDialog = function () {
        scope.visible = true;
      };
  
      scope.visible = false;
      scope.$on(AUTH_EVENTS.notAuthenticated, showDialog);
      scope.$on(AUTH_EVENTS.sessionTimeout, showDialog)
    }
  };
});

app.run(function ($rootScope, AUTH_EVENTS, AuthService, LoginFactory,$location) {
  /*$rootScope.$on('$stateChangeStart', function (event, next) {
    if (next.name !== "authentication"){
      var authorizedRoles = next.data.authorizedRoles;
      if (!AuthService.isAuthorized(authorizedRoles)) {
        event.preventDefault();
        if (AuthService.isAuthenticated()) {
          // user is not allowed
          console.info('user loged in');
          $rootScope.$broadcast(AUTH_EVENTS.notAuthorized);
        } else {
          // user is not logged in
          console.log('user not loged in');
          $rootScope.$broadcast(AUTH_EVENTS.notAuthenticated);
        }
      }
    }
  });*/

  $rootScope.authenticated = false;

    $rootScope.isAuthorized = LoginFactory.isAuthorized;

    $rootScope.$on('event:unauthorized',function(){
        $location.path('/login');
        LoginFactory.removeAccount();
    });

    $rootScope.$on('$routeChangeStart', function () {
        if (!LoginFactory.isAuthenticated()) {
            $location.path('/login');
            $rootScope.authenticated = false;
        } else {
            $rootScope.authenticated = true;
        }
    });
});



  
function router($stateProvider, $urlRouterProvider, USER_ROLES){
    var homeState = {
      url: '/home',
      controller: 'HomeController',
      templateUrl: 'modules/home/homeTemplate.html',
      data: {
        authorizedRoles: [USER_ROLES.admin]
      }
      /*,
      resolve: {
        auth: function resolveAuthentication(AuthResolver) { 
              return AuthResolver.resolve();
            }
          }*/
    };

    var authenticationState = {
        url: '/authentication',
        controller: 'AuthenticationController',
        templateUrl: 'modules/authentication/authenticationTemplate.html',
        data: {
          authorizedRoles: [USER_ROLES.all]
        }
    };

    var optionsState = {
        url: '/options',
        controller: 'optionsController',
        templateUrl: 'modules/options/optionsTemplate.html',
        data: {
          authorizedRoles: [USER_ROLES.all, USER_ROLES.admin]
        }
    }
    

    $stateProvider.state('home', homeState)
                   .state('authentication', authenticationState)
                   .state('options', optionsState);
    $urlRouterProvider.otherwise('authentication'); 
};



