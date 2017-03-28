angular.module('home').factory('HomeService',['$http', 'SERVER_URL', function($http, SERVER_URL){
	
    var url = SERVER_URL.protocol+'://'+SERVER_URL.serverName+':'+SERVER_URL.port+'/'+SERVER_URL.context;

    var service = {};
    service.testHome = function(){
        return true;
    };
	service.getUsers = function(){
     return   $http.get('http://localhost:8060/manageyourmoney/api/users').success(function(users, status, headers){
            return users;
        },function errorCallback(response){
        	console.log('error during getting users')
        });
    };

    service.saveUser = function(){
    	var user = {login:"yahia.ammar@talan.tn",passwod:"yahia"};
    	return $http.put('http://localhost:8060/manageyourmoney/api/users/2',user).success(function(user){
            /*var account = LoginFactory.getAccount();
            if(account && account.login === user.login){
                LoginFactory.logout();
            } else {
                $location.path('/users');
            }*/
            return user;
            console.log(user);
        },function errorCallback(response){
        	 console.log("error saving user");
        });
    };

    service.getPurchaseGroupedByCateg = function(){
        return $http.get(url+'/api/purchase/getPurchaseGroupedByCateg');
    };

    service.getPurchaseGroupedByDate = function(){
        return $http.get(url+'/api/purchase/getPurchaseGroupedByDate');
    };

	return service;

}]);