var module = angular.module("authentication");

module.controller('AuthenticationController',['$scope', '$state', function($scope, $state){

    $scope.user = {login:'',password:''};
   
    $scope.message = "authentication page";

    $scope.login = function (){
        console.log('login '+$scope.user.login+' password '+ $scope.user.password);

        $state.go('home');

    }

}]);