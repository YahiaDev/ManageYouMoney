var module = angular.module("authentication");

module.controller('AuthenticationController',['$scope', '$state', '$rootScope', 'authenticationService', function($scope, $state, $rootScope, authenticationService) {

    $scope.user = {login:'',password:''};
   
    $scope.message = "authentication page";

    $scope.login = function (){
        console.log('login '+$scope.user.login+' password '+ $scope.user.password);
        authenticationService.authenticate($scope.user).then(function(response){
            $rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
            console.info('in controller'+response.password);
            $state.go('home');
        },function(){
            $rootScope.$broadcast(AUTH_EVENTS.loginFailed);            
        });
        

    }

}]);