'use strict';
angular.module('PurchaseCat').controller('RowRemoveCtrl',['$scope', 'purchaseService', '$uibModalInstance', 'PurchaseCatSchema', 'grid', 'row', 'data', function($scope, purchaseService, $uibModalInstance, PurchaseCatSchema, grid, row, data){
	
  $scope.save =  function () {
    // Copy row values over
    purchaseService.deletePurchaseCat(row.entity).then(function(response){
      	data.splice(data.indexOf(row.entity),1);
      	$uibModalInstance.close(row.entity);
    });
    
  };
  
 

}]);