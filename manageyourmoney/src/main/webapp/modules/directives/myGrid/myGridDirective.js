'use strict';
angular.module('myApp').directive('myGrid', [function(){
	return{
		restrict: 'A',
		scope:{ gridData:'=', columnDefs:'=', schema:'=', form:'=', modalEditTitle:'=', confirmRemoveModalMessage:'='},
		templateUrl: 'modules/directives/myGrid/views/my-grid-template.html',
		controller:'myGridController'
	}
}])