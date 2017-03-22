'use strict';
angular.module('PurchaseCat').controller('PurchaseCategoriesCtrl',['$scope', '$uibModal', '$state', 'purchaseService', 'PurchaseCatSchema', function($scope, $uibModal, $state, purchaseService, PurchaseCatSchema){
	
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


angular.module('PurchaseCat').constant('PurchaseCatSchema', {
  type: 'object',
  properties: {
    labelCat: { type: 'string', title: 'Category Label' },
    description: { type: 'string', title: 'Description' }
  },
  required:['labelCat']
});