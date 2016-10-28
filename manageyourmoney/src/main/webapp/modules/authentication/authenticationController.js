'use strict';
var module = angular.module("authentication");

module.controller('AuthenticationController',['$scope', '$state', '$rootScope', 'AuthService', 'AUTH_EVENTS', 'LoginFactory',function($scope, $state, $rootScope, AuthService, AUTH_EVENTS, LoginFactory) {

    $scope.user = {sessionId:'1', id:'12', login:'',password:'', role:'admin'};
    $scope.login = function (){
        console.log('login '+$scope.user.login+' password '+ $scope.user.password);
        //AuthService.authenticate($scope.user);
        LoginFactory.authenticate($scope.user.login,$scope.user.password).then(function(){
            $location.path('/users');
        },function(response){
            if(response.status === 403 && response.data) {
                if (response.data.exception && response.data.exception.indexOf('BadCredentialsException') !== -1) {
                    $scope.httpError = 'Username and/or password are invalid !';
                }
            }
        });


    }

    $scope.$on(AUTH_EVENTS.notAuthorized,function(){
        $state.go('authentication');
    });

    $scope.$on(AUTH_EVENTS.notAuthenticated,function(){
        $state.go('authentication');
    });
        

}]);