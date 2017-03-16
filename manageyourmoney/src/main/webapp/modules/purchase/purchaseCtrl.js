'use strict';
angular.module('Purchase').controller('PurchaseCtrl',['$scope', 'purchaseService', function($scope, purchaseService){
	$scope.purchase = { label:'', 
					    date:'', 
					    amount:'', 
					    comment:'',
						category:''
					};
	$scope.addPurchase = function(){
		purchaseService.addPurchase($scope.purchase).then(function(response){
			$scope.purchaseData = response.data;
		});
	}

	$scope.getAllPurchaseCat = function (){
		purchaseService.getAllPurchaseCat().then(function(response){
			$scope.purhaseCat = response.data;
		})
	}

	$scope.init = function(){
		$scope.getAllPurchaseCat();
	}

	$scope.init();

}]);