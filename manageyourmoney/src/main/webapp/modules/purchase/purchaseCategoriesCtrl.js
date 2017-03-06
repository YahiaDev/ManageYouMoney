'use strict';
angular.module('PurchaseCat').controller('PurchaseCategoriesCtrl',['$scope', 'purchaseService',function($scope, purchaseService){

	//$scope.text = "hello";

	$scope.purchaseCat = {catName:'', description:''};

	$scope.addPurchase = function(){
		console.info('purchase cat '+$scope.purchaseCat.catName+' description' + $scope.purchaseCat.description);
		purchaseService.addPurCat($scope.purchaseCat).then(function(response){
			console.info("purchase added successfully");
		});
	};
}]);