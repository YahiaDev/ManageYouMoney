'use strict';
angular.module('myApp').controller('myGridController',['$scope', 'RowEditor', function($scope, RowEditor){

	$scope.modifColumnDefs = [
		/*{field: 'remove', name: '  ', cellTemplate: 'modules/purchase/delete-button.html', enableFiltering: false, enableSorting: false, width: 34}*/
		{field: 'edit', name: ' ', cellTemplate: 'modules/directives/myGrid/views/edit-button.html', enableFiltering: false, enableSorting: false, width: 34}
		
	];

	//$scope.allColumnDefs = $scope.modifColumnDefs
	$scope.gridOptions = {
    	enableFiltering: true,
	    enableColumnResize: true,
	    enableRowSelection:true,
	    paginationPageSizes: [25, 50, 75],
		paginationPageSize: 5,
		data: $scope.gridData,
		columnDefs: $scope.modifColumnDefs.concat($scope.columnDefs)
    };

    $scope.clickOnEditButton = function(grid, row){
    	RowEditor.editRow(grid, row, $scope.schema, $scope.form);
    };

}]);