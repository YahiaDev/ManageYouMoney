'use strict';

angular.module('authentication').factory('AuthService',['$rootScope', '$q', 'Session', '$cookieStore', '$http', 'AUTH_EVENTS', '$state', 'CommonService', 'hmacInterceptor',function($rootScope, $q, Session, $cookieStore, $http, AUTH_EVENTS, $state, CommonService, hmacInterceptor){
    var service = {};
    service.authenticate = function(login, password){
    return $http.put('http://localhost:8060/manageyourmoney/api/authenticate',{login:login,password:password}).success(function(user, status, headers){
        $cookieStore.put('hmacApp-account', JSON.stringify(user));
        hmacInterceptor.readHmacRequest(headers());
        $rootScope.authenticated = true;
        return user;
      }, function errorCallback(response){
        if(response.status === 403 && response.data) {
          if (response.data.exception && response.data.exception.indexOf('BadCredentialsException') !== -1) {
            $scope.httpError = 'Username and/or password are invalid !';
          }
        }
      });
    };

   /* service.isAuthenticated = function () {
      if (Session.userId === undefined || Session.userId === null){
        var user = $cookieStore.get('logedUser');
        if (user !== undefined && user !== null){
          Session.create(user.sessionId, user.id , user.role);
        }
    	}
      return !!Session.userId;
  	};*/

    service.isAuthenticated = function () {
      return !!$cookieStore.get('hmacApp-account') && hmacInterceptor.isSecured();
    };

  	/*service.isAuthorized = function (authorizedRoles) {
    if (!angular.isArray(authorizedRoles)) {
      authorizedRoles = [authorizedRoles];
    }
    return (service.isAuthenticated() &&
      authorizedRoles.indexOf(Session.userRole) !== -1);
  };*/

  service.isAuthorized = function (role) {
    if(!!$cookieStore.get('hmacApp-account')){
        var account = JSON.parse($cookieStore.get('hmacApp-account'));
        var authorized = false;
        angular.forEach(roles,function(role){
            if(account && account.authorities && account.authorities.indexOf(role) !== -1){
                authorized = true;
            }
        });
      return authorized;
    }
    return false;
  };

  service.getAccount = function(){
    if(!!$cookieStore.get('hmacApp-account')){
      return JSON.parse($cookieStore.get('hmacApp-account'));
    }
  };

  service.removeAccount = function(){
    $cookieStore.remove('hmacApp-account');
    hmacInterceptor.removeSecurity();
    $rootScope.authenticated = false;
  };

  service.logout = function(){
    var self = this;
      return $http.get('http://localhost:8080/api/logout').success(function(){
          self.removeAccount();
          return true;
    });
  };

    
  return service;

}]);