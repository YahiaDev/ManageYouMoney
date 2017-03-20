'use strict';
angular.module('PurchaseCat').controller('PurchaseCategoriesCtrl',['$scope', '$uibModal', 'purchaseService', 'RowEditor', 'RowRemove', 'PurchaseCatSchema', function($scope, $uibModal, purchaseService, RowEditor, RowRemove, PurchaseCatSchema){
	
  	$scope.purchaseCat = {catName:'', description:''};
	$scope.purchaseCatAdded = false;
	//$scope.modalEditSchema = PurchaseCatSchema;
	$scope.modalEditSchema = {labelCat: { type: 'string', title: 'Category Label', required:'true' },
    						  description: { type: 'string', title: 'Description', required:'false' }};
  
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
			});
		}
	};

	$scope.openModal = function(){
		RowEditor.editRow({},{});
	};

	$scope.getAllPurchaseCat = function(){
		purchaseService.getAllPurchaseCat().then(function(response){
		$scope.gridOptions.data = response.data;
		$scope.gridData = response.data;
		$scope.dataLoaded = true;
		});
	};

	$scope.columnDefs = [
		/*{field: 'remove', name: '  ', cellTemplate: 'modules/purchase/delete-button.html', enableFiltering: false, enableSorting: false, width: 34},
		{field: 'edit', name: ' ', cellTemplate: 'modules/purchase/edit-button.html', enableFiltering: false, enableSorting: false, width: 34},*/
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

	$scope.getAllPurchaseCat();
}]);


angular.module('PurchaseCat').constant('PurchaseCatSchema', {
  type: 'object',
  properties: {
    labelCat: { type: 'string', title: 'Category Label' },
    description: { type: 'string', title: 'Description' }
  },
  required:['labelCat']
});