'use strict';
angular.module('Purchase').controller('PurchaseCtrl',['$scope', 'purchaseService', '$state', function($scope, purchaseService, $state){
	
	$scope.purchaseAdded = false;
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
			//$scope.gridOptions.data = response.data;
			$scope.purchaseAdded = true;
			$scope.gridData = response.data;
			$state.reload();
			//$scope.purchase = {};	 
				
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
			//$scope.gridOptions.data = response.data;
			$scope.gridData = response.data;
			$scope.purchaseDataLoaded = true;
		})
	};

	

	//autocomplete functions
     $scope.querySearch = function(query) {
      var results = query ? $scope.modalEditSchema['category']['data'].filter($scope.createFilterFor(query)) : $scope.modalEditSchema['category']['data'];
          
      /*if (self.simulateQuery) {
        deferred = $q.defer();
        $timeout(function () { deferred.resolve( results ); }, Math.random() * 1000, false);
        return deferred.promise;
      } else {*/
        return results;
      //}
    };

    $scope.createFilterFor = function(query) {
      var lowercaseQuery = angular.lowercase(query);

      return function filterFn(category) {
        return (category.labelCat.toLowerCase().indexOf(lowercaseQuery) === 0);
      };

    };


    // grid properties
    $scope.columnDefs = [
		{field: 'category.labelCat', displayName : 'category'},
		{field: 'label', displayName : 'Label'},
		{field: 'date', displayName : 'Purchase Date' , type: 'date', cellFilter: 'date:\'dd-MM-yyyy\'' },
		{field: 'amount', displayName : 'Purchase amount'},
	];

	
	
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

    
    $scope.init = function(){
		$scope.getAllPurchaseCat();
		$scope.getAllPurchase();
	};
	$scope.init();

}]);