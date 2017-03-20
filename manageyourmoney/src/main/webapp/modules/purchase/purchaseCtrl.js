'use strict';
angular.module('Purchase').controller('PurchaseCtrl',['$scope', 'purchaseService', function($scope, purchaseService){
	$scope.purchase = { label:'', 
					    date:'', 
					    amount:'', 
					    comment:'',
						category:''
					};

	$scope.selectedPurchaseCat = '';
	$scope.searchPurchaseCat = '';
	$scope.addPurchase = function(){
		$scope.purchase.category = $scope.selectedPurchaseCat;
		purchaseService.addPurchase($scope.purchase).then(function(response){
			$scope.gridOptions.data = response.data;
		});
	};

	$scope.getAllPurchaseCat = function (){
		purchaseService.getAllPurchaseCat().then(function(response){
			$scope.purhaseCat = response.data;
		})
	};

	$scope.dataLoaded = false;
	$scope.getAllPurchase = function (){
		purchaseService.getAllPurchase().then(function(response){
			$scope.gridOptions.data = response.data;
			$scope.dataLoaded = true;
		})
	};

	$scope.selectedItemChange = function(item){
		if (item !== undefined){
			console.info('select item changed to '+item.categoryId);
		}
	};


	$scope.searchTextChange = function(item){
		console.log('search text changed to '+item);
	};

	$scope.init = function(){
		$scope.getAllPurchaseCat();
		$scope.getAllPurchase();
	};

	$scope.createFilterFor = function(query) {
      var lowercaseQuery = angular.lowercase(query);

      return function filterFn(state) {
        return (state.labelCat.indexOf(lowercaseQuery) === 0);
      };

    };


    $scope.createNewPurchaseCat = function(purchaseCatLabel){
    	console.info('create new Purchase cat');
    };

    /**
     * Search for states... use $timeout to simulate
     * remote dataservice call.
     */
     $scope.querySearch = function(query) {
      var results = query ? $scope.purhaseCat.filter( $scope.createFilterFor(query) ) : $scope.purhaseCat;
          
      /*if (self.simulateQuery) {
        deferred = $q.defer();
        $timeout(function () { deferred.resolve( results ); }, Math.random() * 1000, false);
        return deferred.promise;
      } else {*/
        return results;
      //}
    };


    $scope.columnDefs = [
		{field: 'remove', name: ' ', cellTemplate: 'modules/purchase/delete-button.html', enableFiltering: false, enableSorting: false, width: 34},
		//{field: 'edit', name: 'E', cellTemplate: 'modules/purchase/edit-button.html', enableFiltering: false, enableSorting: false, width: 34},
		{field: 'category.labelCat', displayName : 'Category'},
		{field: 'label', displayName : 'Label'},
		{field: 'date', displayName : 'Purchase Date' , type: 'date', cellFilter: 'date:\'dd-MM-yyyy\'' },
		{field: 'amount', displayName : 'Purchase amount'},
	];

    $scope.gridOptions = {
    	enableFiltering: true,
	    enableColumnResize: true,
	    enableRowSelection:true,
	    paginationPageSizes: [25, 50, 75],
		paginationPageSize: 5,
		columnDefs: $scope.columnDefs
    };

    $scope.clickOnRemoveButton = function(grid, row){
    	RowRemove.removeRow(grid, row, $scope.gridOptions.data);
    };

	$scope.init();

}]);