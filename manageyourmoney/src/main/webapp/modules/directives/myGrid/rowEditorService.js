angular.module('myApp').factory('RowEditor',['$rootScope', '$uibModal', function($rootScope, $uibModal){
  var service = {};

  service.editRow = function(grid, row, schema, form) {
   $uibModal.open({
      templateUrl: './modules/directives/myGrid/views/edit-modal.html',
      controller: 'RowEditCtrl',
      resolve: {
        grid: function () { return grid; },
        row: function () { return row; },
        schema: function() { return schema; },
        form: function() { return form; }
      }
    });
  };
  
  
  
  return service;

}]);