'use strict';
angular.module('Subscribe').factory('SubscribeService', ['$http', 'SERVER_URL', function($http, SERVER_URL){
    var service = {};
    var url = SERVER_URL.protocol+'://'+SERVER_URL.serverName+':'+SERVER_URL.port+'/'+SERVER_URL.context;
    service.subscribe = function(user){
        return $http.put(url+'/api/subscribe/addNewUser',user);
    };

    return service;
}]);