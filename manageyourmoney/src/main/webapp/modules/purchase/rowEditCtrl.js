'use strict';
angular.module('PurchaseCat').controller('RowEditCtrl',['$scope', 'purchaseService', '$uibModalInstance', 'PurchaseCatSchema', 'grid', 'row', function($scope, purchaseService, $uibModalInstance, PurchaseCatSchema, grid, row){
	$scope.schema = PurchaseCatSchema;
  $scope.entity = angular.copy(row.entity);
  $scope.form = [
    'labelCat',
    'description'
  ];
  
  $scope.save =  function () {
    // Copy row values over
    angular.extend(row.entity, $scope.entity);
    purchaseService.updatePurchaseCat($scope.entity).then(function(response){
      $uibModalInstance.close(row.entity);
    });
    
  };
  
 

}]);