angular.module("nav").controller("NavController",["$scope", "$cookieStore", "$state", "Session", function($scope, $cookieStore, $state, Session){
    $scope.logOut = function (){
    	console.info('logOut');
    	Session.destroy();
        $cookieStore.remove('logedUser');
        $state.go('authentication');
    }
}]);