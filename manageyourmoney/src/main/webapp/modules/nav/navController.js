angular.module("nav").controller("NavController",["$scope", "NavService", "$state", function($scope, NavService, $state){
    $scope.logOut = function (){
    	console.info('logOut');
    	NavService.logOut().then(function(){
    		console.log("logout success");
    		$state.go('login');
    	})
    	}
    
    	/*Session.destroy();
        $cookieStore.remove('logedUser');
        $state.go('authentication');*/
    
}]);