'use strict';
var module = angular.module('authentication');
module.factory('AuthService',['$rootScope', '$q', 'Session', '$cookieStore', '$http', 'AUTH_EVENTS', '$state',function($rootScope, $q, Session, $cookieStore, $http, AUTH_EVENTS){
    var service = {};
    service.authenticate = function(user){
        var deffered = $q.defer();
        deffered.resolve(user);
        $rootScope.logedUser = {};
        $rootScope.logedUser.userId = user.id;
        $rootScope.logedUser.userRole = user.role;
        $rootScope.logedUser.sessionId = user.sessionId;
        $cookieStore.put('logedUser', user);
        Session.create(user.sessionId, user.id , user.role);
        console.info(user.login + ' , ' + user.password);

        $http.get('http://localhost:8080/manageyourmoney/getUser').then(function successCallback(response){
          $rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
          console.log('success callback');
          $state.go('home');
        }, function errorCallback(response){
            $rootScope.$broadcast(AUTH_EVENTS.loginFailed);  
            console.log('error callback');

        });

        return deffered.promise;

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