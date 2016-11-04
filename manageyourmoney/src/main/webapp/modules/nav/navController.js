angular.module("nav").controller("NavController",["$scope", "NavService", function($scope, NavService){
    $scope.logOut = function (){
    	console.info('logOut');
    	NavService.logOut().then(function(){
    		console.log("logout success");
    	})
    	}
    
    	/*Session.destroy();
        $cookieStore.remove('logedUser');
        $state.go('authentication');*/
    
}]);