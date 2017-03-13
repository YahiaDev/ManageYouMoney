angular.module('PurchaseCat').factory('RowRemove',['$rootScope', '$uibModal', function($rootScope, $uibModal){
  var service = {};

  service.removeRow = function(grid, row, data) {
   $uibModal.open({
      templateUrl: './modules/purchase/remove-modal.html',
      controller: 'RowRemoveCtrl',
      resolve: {
        grid: function () { return grid; },
        row: function () { return row; },
        data: function () { return data; }
      }
    });
  };
  
  
  
  return service;

}]);