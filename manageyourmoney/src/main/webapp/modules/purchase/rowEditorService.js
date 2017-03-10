angular.module('PurchaseCat').service('RowEditor',['$rootScope', '$uibModal', function($rootScope, $uibModal){
  var service = {};
  service.editRow = editRow;
  
  function editRow(grid, row) {
   '$uibModal'.open({
      templateUrl: 'edit-modal.html',
      controller: ['$modalInstance', 'PurchaseCat', 'grid', 'row', 'RowEditCtrl'],
      controllerAs: 'vm',
      resolve: {
        grid: function () { return grid; },
        row: function () { return row; }
      }
    });
  }
  
  return service;

}]);