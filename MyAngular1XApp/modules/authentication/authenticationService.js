var module = angular.module('authentication');
module.factory('AuthService',['$rootScope', '$q', 'Session',function($rootScope, $q, Session){
    var service = {};
    service.authenticate = function(user){
        var deffered = $q.defer();
        deffered.resolve(user);
        Session.create(user.sessionId, user.id , user.role);
        console.info(user.login + ' , ' + user.password);
        return deffered.promise;

    };

    service.isAuthenticated = function () {
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