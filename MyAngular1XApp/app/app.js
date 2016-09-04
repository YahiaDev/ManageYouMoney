

angular.module('home',[]);
angular.module('authentication',[]);
angular.module('nav',[]);
angular.module('options',[]);
var modules = ['ui.router', 'home', 'authentication', 'nav', 'options'];
var app = angular.module('myApp',modules);
app.config(['$stateProvider', '$urlRouterProvider', router]);
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

