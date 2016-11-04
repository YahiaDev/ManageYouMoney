angular.module('home').factory('HomeService',['$http',function($http){
	var service = {};

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
    }

	return service;

}]);