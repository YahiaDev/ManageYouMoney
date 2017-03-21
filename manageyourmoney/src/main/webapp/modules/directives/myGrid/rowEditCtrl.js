'use strict';
angular.module('myApp').controller('RowEditCtrl',['$scope', '$rootScope', 'purchaseService', '$uibModalInstance', 'PurchaseCatSchema', 'grid', 'row', 'schema', 'form', 'modalEditTitle', function($scope, $rootScope, purchaseService, $uibModalInstance, PurchaseCatSchema, grid, row, schema, form, modalEditTitle){
  
 
  $scope.init = function(){
  $scope.schema = schema;
  $scope.entity = angular.copy(row.entity);
  $scope.form = form;
  $scope.modalEditTitle = modalEditTitle;
  $scope.testDate = null;
  angular.forEach($scope.schema, function(el){
    if (el.type === 'Date'){
      $scope.entity[el.id] = new Date($scope.entity[el.id]);
      //moment($scope.entity[el.id]).format('DD-MM-YYYY');
    }
    });
  };

   $scope.init();
  
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
      $rootScope.$broadcast('gridDataEdited', {data:$scope.entity});
      $uibModalInstance.close(row.entity);
      /*purchaseService.updatePurchaseCat($scope.entity).then(function(response){
        $uibModalInstance.close(row.entity);
      });*/
    }
    
  };
  
 

}]);