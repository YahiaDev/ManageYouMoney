var module = angular.module('authentication');
module.factory('authenticationService',['$rootScope', '$q',function($rootScope, $q){
    var service = {};
    service.authenticate = function(user){
        var deffered = $q.defer();
        deffered.resolve(user);
        console.info(user.login + ' , ' + user.password);
        return deffered.promise;

    };

    return service;

}]);