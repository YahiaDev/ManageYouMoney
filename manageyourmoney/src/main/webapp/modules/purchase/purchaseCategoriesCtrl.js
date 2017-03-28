'use strict';
angular.module('PurchaseCat').controller('PurchaseCategoriesCtrl',['$scope', 
	'$state', 'purchaseService', function($scope, $state, purchaseService){
	
  	$scope.purchaseCat = {catName:'', description:''};
	$scope.purchaseCatAdded = false;
	//$scope.modalEditSchema = PurchaseCatSchema;
	$scope.modalEditSchema = {labelCat: { type: 'string', id:'labelCat', title: 'Category Label', required:'true' },
    						  description: { type: 'string', id:'description', title: 'Description', required:'false' }};
  
	$scope.modalEditForm = [
    'labelCat',
    'description'
  	];
	
	$scope.dataLoaded =  false;
	$scope.addPurchaseCat = function(){
		if ($scope.purchaseCat.catName !== ''){
			purchaseService.addPurCat($scope.purchaseCat).then(function(response){
				$scope.purchaseCatAdded = true;
				$scope.purchaseCat.catName = '';
				$scope.purchaseCat.description = '';
				//$scope.gridOptions.data = response.data;
				$scope.gridData = response.data;
				$state.reload();
			});
		}
	};

	$scope.getAllPurchaseCat = function(){
		purchaseService.getAllPurchaseCat().then(function(response){
		//$scope.gridOptions.data = response.data;
		$scope.gridData = response.data;
		$scope.dataLoaded = true;
		});
	};

	$scope.columnDefs = [
		{field: 'labelCat', displayName : 'Category Label'},
		{field: 'description', displayName : 'Description'}
	];

    
	$scope.$on('gridDataEdited',function(event, args){
    	purchaseService.updatePurchaseCat(args.data).then(function(response){
    		console.info(response.data);
				//$scope.purchaseCatAdded = true;
				//$scope.purchaseCat.catName = '';
				//$scope.purchaseCat.description = '';
				//$scope.gridOptions.data = response.data;
				//$scope.gridData = response.data;
			});
    });

    $scope.$on('gridDataRowDeleted',function(event, args){
    	purchaseService.deletePurchaseCat(args.data).then(function(response){
    		$scope.gridData = response.data;
    		$state.reload();
	      	//data.splice(data.indexOf(row.entity),1);
	      	//$uibModalInstance.close(row.entity);
    	});
    });

	$scope.getAllPurchaseCat();
}]);
