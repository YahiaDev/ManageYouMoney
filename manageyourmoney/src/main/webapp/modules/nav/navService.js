'uses strict';
angular.module('nav').factory('NavService',['$http','$cookieStore', 'hmacInterceptor', '$rootScope', function($http, $cookieStore, hmacInterceptor, $rootScope){
	var service = {};

	service.removeAccount = function(){
		$cookieStore.remove('hmacApp-account');
        hmacInterceptor.removeSecurity();
        $rootScope.authenticated = false;
	};

	service.logOut = function(){
		var self = this;
        return $http.get('http://localhost:8060/manageyourmoney/api/logout').then(function(response){
            self.removeAccount();
            return true; 
		});
	};

	return service;


}]);