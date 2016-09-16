'use strict'
var module = angular.module("authentication");

module.controller('AuthenticationController',['$scope', '$state', '$rootScope', 'AuthService', 'AUTH_EVENTS',function($scope, $state, $rootScope, AuthService, AUTH_EVENTS) {

    $scope.user = {sessionId:'1', id:'12', login:'',password:'', role:'admin'};
    $scope.login = function (){
        console.log('login '+$scope.user.login+' password '+ $scope.user.password);
        AuthService.authenticate($scope.user);
    }

    $scope.$on(AUTH_EVENTS.notAuthorized,function(){
        $state.go('authentication');
    });

    $scope.$on(AUTH_EVENTS.notAuthenticated,function(){
        $state.go('authentication');
    });
        

}]);