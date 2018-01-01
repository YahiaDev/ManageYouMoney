'use strict';
var module = angular.module("authentication");

module.controller('AuthenticationController', ['$scope', '$state', '$rootScope', 'AuthService', 'AUTH_EVENTS', 'LoginFactory', '$cookieStore', function ($scope, $state, $rootScope, AuthService, AUTH_EVENTS, LoginFactory, $cookieStore) {

	var auC = this;
    auC.authenticationOk = false;
    auC.user = { sessionId: '1', id: '12', login: '', password: '', role: 'admin' };

    auC.login = function () {
        console.log('login ' + auC.user.login + ' password ' + auC.user.password);
        //AuthService.authenticate(auC.user);
        AuthService.authenticate(auC.user.login, auC.user.password).then(function (response) {
            //$location.path('/users');
            auC.user = response.data;
            console.log($cookieStore);
            $cookieStore.put('logedUser', response.data);
            console.log($cookieStore.get('logedUser'));
            auC.authenticationOk = true;
            $state.go('home');
        }, function (response) {
            if ((response.status === 403 || response.status == 500) && response.data) {
                if (response.data.exception && response.data.exception.indexOf('BadCredentialsException') !== -1) {
                    auC.httpError = 'Username and/or password are invalid !';
                }
            }
        });
    };
    
    //regarde comment thrower une exeption et comment la tester




    $rootScope.$on('event:unauthorized', function (rejection, data) {
        auC.httpError = data.message;
    });

    $scope.$on(AUTH_EVENTS.notAuthorized, function () {
        $state.go('authentication');
    });

    $scope.$on(AUTH_EVENTS.notAuthenticated, function () {
        $state.go('authentication');
    });
}]);