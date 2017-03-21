angular.module('myApp').factory('RemoveRowService',['$rootScope', '$uibModal', function($rootScope, $uibModal){
  var service = {};

  service.removeRow = function(grid, row, confirmRemoveModalMessage) {
   $uibModal.open({
      templateUrl: './modules/directives/myGrid/views/remove-row-modal.html',
      controller: 'RemoveRowController',
      resolve: {
        grid: function () { return grid; },
        row: function () { return row; },
        confirmRemoveModalMessage : function () { return confirmRemoveModalMessage; }
      }
    });
  };
  
  
  
  return service;

}]);