var module = angular.module('nav');

module.directive('navDirective', function(){
    return{
        restrict: 'A',
        templateUrl: 'modules/nav/navTemplate.html',
        scope: {home: '@', options:'@'}
    }

});