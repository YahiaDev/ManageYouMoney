'use strict';
var module = angular.module("authentication");

module.controller('AuthenticationController', ['$scope', '$state', '$rootScope', 'AuthService', 'AUTH_EVENTS', 'LoginFactory', '$cookieStore', function ($scope, $state, $rootScope, AuthService, AUTH_EVENTS, LoginFactory, $cookieStore) {


    $scope.authenticationOk = false;
    $scope.user = { sessionId: '1', id: '12', login: '', password: '', role: 'admin' };

    $scope.login = function () {
        console.log('login ' + $scope.user.login + ' password ' + $scope.user.password);
        //AuthService.authenticate($scope.user);
        AuthService.authenticate($scope.user.login, $scope.user.password).then(function (response) {
            //$location.path('/users');
            $scope.user = response.data;
            console.log($cookieStore);
            $cookieStore.put('logedUser', response.data);
            console.log($cookieStore.get('logedUser'));
            $scope.authenticationOk = true;
            $state.go('home');
        }, function (response) {
            if ((response.status === 403 || response.status == 500) && response.data) {
                if (response.data.exception && response.data.exception.indexOf('BadCredentialsException') !== -1) {
                    $scope.httpError = 'Username and/or password are invalid !';
                }
            }
        });
    };




    $rootScope.$on('event:unauthorized', function (rejection, data) {
        $scope.httpError = data.message;
    });

    $scope.$on(AUTH_EVENTS.notAuthorized, function () {
        $state.go('authentication');
    });

    $scope.$on(AUTH_EVENTS.notAuthenticated, function () {
        $state.go('authentication');
    });
}]);