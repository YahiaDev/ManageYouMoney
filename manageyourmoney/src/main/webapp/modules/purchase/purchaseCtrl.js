'use strict';
angular.module('Purchase').controller('PurchaseCtrl',['$scope', 'purchaseService', '$state', function($scope, purchaseService, $state){
	$scope.purchase = { label:'', 
					    date:'', 
					    amount:'', 
					    comment:'',
						category:''
					};

	$scope.selectedPurchaseCat = '';
	$scope.searchPurchaseCat = '';
	$scope.purchaseDataLoaded = false;
	$scope.addPurchase = function(){
		$scope.purchase.category = $scope.selectedPurchaseCat;
		purchaseService.addPurchase($scope.purchase).then(function(response){
			$scope.gridOptions.data = response.data;
			
		});
	};

	$scope.purchaseCatDataLoaded = false;
	$scope.getAllPurchaseCat = function (){
		purchaseService.getAllPurchaseCat().then(function(response){
			//$scope.modalEditSchema['category']['data'] = response.data;
			//$scope.modalEditSchema['category']['data'] = $scope.formatDataForAutoComplet($scope.modalEditSchema['category']['data']);
			$scope.modalEditSchema['category']['data'] = response.data;
			$scope.purchaseCatDataLoaded = true;
			//$scope.gridData = response.data;
		})
	};

	$scope.purchaseDataLoaded = false;
	$scope.getAllPurchase = function (){
		purchaseService.getAllPurchase().then(function(response){
			$scope.gridOptions.data = response.data;
			$scope.gridData = response.data;
			$scope.purchaseDataLoaded = true;
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
      var results = query ? $scope.modalEditSchema['category']['data'].filter( $scope.createFilterFor(query) ) : $scope.modalEditSchema['category']['data'];
          
      /*if (self.simulateQuery) {
        deferred = $q.defer();
        $timeout(function () { deferred.resolve( results ); }, Math.random() * 1000, false);
        return deferred.promise;
      } else {*/
        return results;
      //}
    };


    $scope.columnDefs = [
		{field: 'category.labelCat', displayName : 'category'},
		{field: 'label', displayName : 'Label'},
		{field: 'date', displayName : 'Purchase Date' , type: 'date', cellFilter: 'date:\'dd-MM-yyyy\'' },
		{field: 'amount', displayName : 'Purchase amount'},
	];

	$scope.formatDataForAutoComplet = function(dataToFormat){
		var formatedList = [];
		var formatedObject = {};
		angular.forEach(dataToFormat, function(el){
			formatedObject = {};
			formatedObject['dataToDisplay'] = el.labelCat;
			formatedObject['id'] = el.categoryId;
			formatedObject['description'] = el.description;
			formatedList.push(formatedObject);
		});
		return formatedList;
	};



	$scope.modalEditSchema = {category: { type: 'autocomplete', id:'category', title: 'category', required:'true', idForAutoComplete: 'categoryId', dataToDisplay: 'labelCat', data:[]},
    						  label: { type: 'string', id:'label', title: 'Label', required:'true' },
    						  date: { type: 'Date', id:'date', title: 'Purchase Date', required:'true' },
    						  amount: { type: 'number', id:'amount', title: 'Purchase Amoutn', required:'true' },
    						};
    $scope.modalEditForm = [
	    'category',
	    'label',
	    'date',
	    'amount'
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


    $scope.$on('gridDataRowDeleted',function(event, args){
    	purchaseService.deletePurchase(args.data).then(function(response){
    		$scope.gridData = response.data;
    		$state.reload();
    	});
    });

    $scope.$on('gridDataEdited',function(event, args){
    	purchaseService.updatePurchase(args.data).then(function(response){
    		$scope.gridData = response.data;
    		$state.reload();
    	});
    });

    

	$scope.init();

}]);