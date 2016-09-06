

angular.module('home',[]);
angular.module('authentication',[]);
angular.module('nav',[]);
angular.module('options',[]);
var modules = ['ui.router', 'home', 'authentication', 'nav', 'options'];
var app = angular.module('myApp',modules);
app.config(['$stateProvider', '$urlRouterProvider', router]);
app.constant('AUTH_EVENTS', {
  loginSuccess: 'auth-login-success',
  loginFailed: 'auth-login-failed',
  logoutSuccess: 'auth-logout-success',
  sessionTimeout: 'auth-session-timeout',
  notAuthenticated: 'auth-not-authenticated',
  notAuthorized: 'auth-not-authorized'
});
app.constant('USER_ROLES', {
  all: '*',
  admin: 'admin',
  editor: 'editor',
  guest: 'guest'
});
function router($stateProvider, $urlRouterProvider){
    var homeState = {
        url: '/home',
        controller: 'HomeController',
        templateUrl: 'modules/home/homeTemplate.html',
        date: {}
    };

    var authenticationState = {
        url: '/authentication',
        controller: 'AuthenticationController',
        templateUrl: 'modules/authentication/authenticationTemplate.html',
        date: {}
    };

    var optionsState = {
        url: '/options',
        controller: 'optionsController',
        templateUrl: 'modules/options/optionsTemplate.html'
    }

    $stateProvider.state('home', homeState)
                   .state('authentication', authenticationState)
                   .state('options', optionsState);
    $urlRouterProvider.otherwise('authentication'); 
}

