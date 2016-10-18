'use strict';

angular.module('authentication').factory('AuthService',['$rootScope', '$q', 'Session', '$cookieStore', '$http', 'AUTH_EVENTS', '$state', 'CommonService',function($rootScope, $q, Session, $cookieStore, $http, AUTH_EVENTS, $state, CommonService){
    var service = {};
    service.authenticate = function(user){
        /*var deffered = $q.defer();
        deffered.resolve(user);*/
        $rootScope.logedUser = {};
        console.info(user);
        //var url = CommonService.getBasicUrl() + '/getUser';
        $http.post("http://localhost:8060/manageyourmoney/login/",user).then(function successCallback(response){
          $rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
          console.log('success callback');
          $rootScope.logedUser.userId = user.id;
          $rootScope.logedUser.userRole = user.role;
          $rootScope.logedUser.sessionId = user.sessionId;
          $cookieStore.put('logedUser', user);
          Session.create(user.sessionId, user.id , user.role);
          console.info(user.login + ' , ' + user.password);
          $state.go('home');
        }, function errorCallback(response){
            $rootScope.$broadcast(AUTH_EVENTS.loginFailed);  
            console.log('error callback');
        });
    };

    service.isAuthenticated = function () {
      if (Session.userId === undefined || Session.userId === null){
        var user = $cookieStore.get('logedUser');
        if (user !== undefined && user !== null){
          Session.create(user.sessionId, user.id , user.role);
        }
    	}
      return !!Session.userId;
  	};

  	service.isAuthorized = function (authorizedRoles) {
    if (!angular.isArray(authorizedRoles)) {
      authorizedRoles = [authorizedRoles];
    }
    return (service.isAuthenticated() &&
      authorizedRoles.indexOf(Session.userRole) !== -1);
  };

    return service;

}]);