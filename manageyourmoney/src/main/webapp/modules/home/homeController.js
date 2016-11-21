var module = angular.module('home');

module.controller('HomeController', ['$scope','HomeService', function($scope, HomeService){
    $scope.message = "home page";
    var vm = this;
    vm.testHomee = function(){
        return false;
    }
    $scope.getAllUsers = function(){
    	HomeService.getUsers().then(function(response){
    		console.log(response);
    	})
    };

    $scope.saveUser = function(){
    	HomeService.saveUser().then(function(response){
    		console.log(response);
    	})
    };

}]);


