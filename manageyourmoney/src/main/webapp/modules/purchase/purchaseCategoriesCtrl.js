'use strict';
angular.module('PurchaseCat').controller('PurchaseCategoriesCtrl',['$scope', '$uibModal', 'purchaseService', 'RowEditor', 'RowRemove', function($scope, $uibModal, purchaseService, RowEditor, RowRemove){
	
  	$scope.purchaseCat = {catName:'', description:''};
	$scope.purchaseCatAdded = false;
	
	$scope.dataLoaded =  false;
	$scope.addPurchase = function(){
		if ($scope.purchaseCat.catName !== ''){
			purchaseService.addPurCat($scope.purchaseCat).then(function(response){
				$scope.purchaseCatAdded = true;
				$scope.purchaseCat.catName = '';
				$scope.purchaseCat.description = '';
				$scope.gridOptions.data = response.data;
			});
		}
	};

	$scope.openModal = function(){
		RowEditor.editRow({},{});
	};

	$scope.getAllPurchaseCat = function(){
		purchaseService.getAllPurchaseCat().then(function(response){
		$scope.gridOptions.data = response.data;
		$scope.dataLoaded = true;
		});
	};

	$scope.columnDefs = [
		{field: 'remove', name: 'D', cellTemplate: 'modules/purchase/delete-button.html', enableFiltering: false, enableSorting: false, width: 34},
		{field: 'edit', name: 'E', cellTemplate: 'modules/purchase/edit-button.html', enableFiltering: false, enableSorting: false, width: 34},
		{field: 'labelCat', displayName : 'Category Label'},
		{field: 'description', displayName : 'Description'}
	];

    $scope.gridOptions = {
    	enableFiltering: true,
	    enableColumnResize: true,
	    enableRowSelection:true,
	    paginationPageSizes: [25, 50, 75],
		paginationPageSize: 5,
		columnDefs: $scope.columnDefs
    };

    $scope.clickOnEditButton = function(grid, row){
    	RowEditor.editRow(grid,row);
    };

    $scope.clickOnRemoveButton = function(grid, row){
    	RowRemove.removeRow(grid, row, $scope.gridOptions.data);
    };

	$scope.getAllPurchaseCat();
}]);


angular.module('PurchaseCat').constant('PurchaseCatSchema', {
  type: 'object',
  properties: {
    labelCat: { type: 'string', title: 'Category Label' },
    description: { type: 'string', title: 'Description' }
  }
});