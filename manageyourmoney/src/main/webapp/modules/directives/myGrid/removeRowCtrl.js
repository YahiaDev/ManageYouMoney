'use strict';
angular.module('myApp').controller('RemoveRowController',['$scope', '$rootScope', '$uibModalInstance', 'row', 'grid', 'confirmRemoveModalMessage', function($scope, $rootScope, $uibModalInstance, row, grid, confirmRemoveModalMessage){
  $scope.entity = row.entity;
  $scope.message = confirmRemoveModalMessage;
  $scope.save =  function () {
    $rootScope.$broadcast('gridDataRowDeleted', {data:$scope.entity});
    $uibModalInstance.close(row.entity);
  };
  
}]);