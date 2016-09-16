//'user strict';
angular.module('common').factory('CommonService',['$http','SERVER_URL',function($http,SERVER_URL){
	var service = {};

	service.getBasicUrl = function(){
		return SERVER_URL.protocol + '://' + SERVER_URL.serverName + ':' + SERVER_URL.port + '/' + SERVER_URL.context;
	};


	return service;

}]);