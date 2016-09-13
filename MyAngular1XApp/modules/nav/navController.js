angular.module('nav').controller('NavController',['$scope', '$cookieStore',function($scope, $cookieStore){

    $scope.logOut = function (){
        $cookieStore.put('logedUser', user);
        $cookieStore.remove('logedUser');
    }
}]);