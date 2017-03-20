'use strict';
angular.module('myApp').controller('RowEditCtrl',['$scope', '$rootScope', 'purchaseService', '$uibModalInstance', 'PurchaseCatSchema', 'grid', 'row', 'schema', 'form', function($scope, $rootScope, purchaseService, $uibModalInstance, PurchaseCatSchema, grid, row, schema, form){
	$scope.schema = schema;
  $scope.entity = angular.copy(row.entity);
  $scope.form = form;
  $scope.city = 'Rades';
  
  $scope.save =  function () {
    // Copy row values over
    $scope.requiredData = false;
    if ($scope.schema.required !== undefined && $scope.schema.required !== null){
      angular.forEach($scope.schema.required,function(element){
        if (row.entity[element] === null || row.entity[element] === undefined){
          $scope.requiredData = true;
        }
      })
    }
    if (!$scope.requiredData){
      angular.extend(row.entity, $scope.entity);
      $rootScope.$broadcast('gridDataEdited', {data:row.entity});
      $uibModalInstance.close(row.entity);
      /*purchaseService.updatePurchaseCat($scope.entity).then(function(response){
        $uibModalInstance.close(row.entity);
      });*/
    }
    
  };
  
 

}]);