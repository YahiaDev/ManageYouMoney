var module = angular.module('home');

module.controller('HomeController', ['$scope', function($scope){
    $scope.message = "home page";
}]);