'use strict';
angular.module('PurchaseCat').controller('PurchaseCategoriesCtrl',['$scope', '$uibModal', 'purchaseService', 'RowEditor', function($scope, $uibModal, purchaseService, RowEditor){
	var vm = this;
  
  	vm.editRow = RowEditor.editRow;


	vm.purchaseCat = {catName:'', description:''};
	vm.purchaseCatAdded = false;
	vm.purchaseCatData = [];
	$scope.dataLoaded =  false;
	vm.addPurchase = function(){
		if (vm.purchaseCat.catName !== ''){
			purchaseService.addPurCat(vm.purchaseCat).then(function(response){
				vm.purchaseCatAdded = true;
				vm.purchaseCat.catName = '';
				vm.purchaseCat.description = '';
			});
		}
	};

	$scope.getAllPurchaseCat = function(){
		purchaseService.getAllPurchaseCat().then(function(response){
		$scope.purchaseCatData = response.data;
		$scope.gridOptions.data = response.data;
		//vm.gridOptions.data = response.data;
		$scope.dataLoaded = true;

		//console.info(response);
		});
	};

	vm.columnDefs = [
		{field: 'id', name: '', cellTemplate: 'modules/purchase/edit-button.html', width: '4%'},
		{field: 'labelCat', displayName : 'Category Label', width: '40%'},
		{field: 'description', displayName : 'Description', width: '56%'}
	];

    $scope.gridOptions = {
    	enableFiltering: true,
	    enableColumnResize: true,
	    enableRowSelection:true,
	    paginationPageSizes: [25, 50, 75],
		paginationPageSize: 5,
		//data: $scope.purchaseCatData,
		columnDefs: vm.columnDefs
    };

    $scope.clickOnEditButton = function(grid,row){
    	console.info('hahahahahahha');
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