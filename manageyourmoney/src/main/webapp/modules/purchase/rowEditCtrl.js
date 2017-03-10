'use strict';
angular.module('PurchaseCat').controller('RowEditCtrl',['$modalInstance', 'PurchaseCat', 'grid', 'row',function($modalInstance, PurchaseCat, grid, row){
	var vm = this;
  
  vm.schema = PurchaseCat;
  vm.entity = angular.copy(row.entity);
  vm.form = [
    'labelCat',
    'description'
  ];
  
  vm.save = save;
  
  function save() {
    // Copy row values over
    row.entity = angular.extend(row.entity, vm.entity);
    $modalInstance.close(row.entity);
  }

}]);