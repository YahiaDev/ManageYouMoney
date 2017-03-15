'use strict';
angular.module('Purchase').controller('PurchaseCtrl',['$scope',function($scope){
	$scope.purchase = { purchaseLabel:'', 
					    purchaseDate:'', 
					    purchaseAmount:'', 
					    purchaseComment:'',
						purchaseCat:{}
					};
	$scope.addPurchase = function(){
		console.info('add purchase function');
	}

}]);