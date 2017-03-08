'use strict';
angular.module('PurchaseCat').controller('PurchaseCategoriesCtrl',['$scope', 'purchaseService',function($scope, purchaseService){
	$scope.purchaseCat = {catName:'', description:''};
	$scope.purchaseCatAdded = false;
	$scope.addPurchase = function(){
		if ($scope.purchaseCat.catName !== ''){
			purchaseService.addPurCat($scope.purchaseCat).then(function(response){
				$scope.purchaseCatAdded = true;
				$scope.purchaseCat.catName = '';
				$scope.purchaseCat.description = '';
			});
		}
	};
}]);