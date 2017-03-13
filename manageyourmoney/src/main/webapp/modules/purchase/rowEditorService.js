angular.module('PurchaseCat').factory('RowEditor',['$rootScope', '$uibModal', function($rootScope, $uibModal){
  var service = {};

  service.editRow = function(grid, row) {
   $uibModal.open({
      templateUrl: './modules/purchase/edit-modal.html',
      controller: 'RowEditCtrl',
      resolve: {
        grid: function () { return grid; },
        row: function () { return row; }
      }
    });
  };
  
  
  
  return service;

}]);