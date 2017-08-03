angular.module("authentication").factory('LoginFactory', function ($http, $cookieStore, $rootScope, hmacInterceptor) {
    var loginService = {};

    loginService.authenticate = function (login, password) {
        return $http.put('http://localhost:8060/manageyourmoney/api/authenticate', { login: login, password: password }).success(function (data, status, headers) {
            $cookieStore.put('hmacApp-account', JSON.stringify(data));

            hmacInterceptor.readHmacRequest(headers());

            $rootScope.authenticated = true;
            return data;
        }).error(function (data, status, headers) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        })
    },
        loginService.isAuthenticated = function () {
            return !!$cookieStore.get('hmacApp-account') && hmacInterceptor.isSecured();
        },
        loginService.isAuthorized = function (roles) {
            if (!!$cookieStore.get('hmacApp-account')) {
                var account = JSON.parse($cookieStore.get('hmacApp-account'));
                var authorized = false;
                angular.forEach(roles, function (role) {
                    if (account && account.authorities && account.authorities.indexOf(role) !== -1) {
                        authorized = true;
                    }
                });
                return authorized;
            }
            return false;
        },
        loginService.getAccount = function () {
            if (!!$cookieStore.get('hmacApp-account')) {
                return JSON.parse($cookieStore.get('hmacApp-account'));
            }
        },
        loginService.removeAccount = function () {
            $cookieStore.remove('hmacApp-account');
            hmacInterceptor.removeSecurity();
            $rootScope.authenticated = false;
        },
        loginService.logout = function () {
            var self = this;
            return $http.get('http://localhost:8080/api/logout').success(function () {
                self.removeAccount();
                return true;
            });
        }
    return loginService;
});