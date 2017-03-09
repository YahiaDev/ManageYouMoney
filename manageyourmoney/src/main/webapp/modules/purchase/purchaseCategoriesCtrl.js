'use strict';
angular.module('PurchaseCat').controller('PurchaseCategoriesCtrl',['$scope', '$uibModal', 'purchaseService', function($scope, $uibModal, purchaseService){
	$scope.purchaseCat = {catName:'', description:''};
	$scope.purchaseCatAdded = false;
	$scope.purchaseCatData = [];
	$scope.dataLoaded =  false;
	$scope.addPurchase = function(){
		if ($scope.purchaseCat.catName !== ''){
			purchaseService.addPurCat($scope.purchaseCat).then(function(response){
				$scope.purchaseCatAdded = true;
				$scope.purchaseCat.catName = '';
				$scope.purchaseCat.description = '';
			});
		}
	};

	$scope.getAllPurchaseCat = function(){
		purchaseService.getAllPurchaseCat().then(function(response){
		$scope.purchaseCatData = response.data;
		$scope.dataLoaded = true;
		//console.info(response);
		});
	};

	$scope.columnDefs = [
		{field: 'labelCat', displayName : 'Category Label', cellTemplate: 'modules/purchase/edit-button.html', width: '40%'},
		{field: 'description', displayName : 'Description', width: '60%'}
	];

    $scope.gridOptions = {
    	enableFiltering: true,
	    enableColumnResize: true,
	    enableRowSelection:true,
	    paginationPageSizes: [25, 50, 75],
		paginationPageSize: 5,
		data: "purchaseCatData",
		columnDefs: $scope.columnDefs
    };

    $scope.editRow =  function(grid, row) {
    $uibModal.open({
      templateUrl: 'modules/purchase/edit-modal.html',
      controller: 'RowEditCtrl',
      //controllerAs: 'vm',
      resolve: {
        grid: function () { return grid; },
        row: function () { return row; }
      }
    });
  };

	$scope.getAllPurchaseCat();
}]);