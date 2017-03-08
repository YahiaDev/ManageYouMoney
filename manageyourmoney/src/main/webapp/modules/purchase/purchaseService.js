angular.module('PurchaseCat').factory('purchaseService',['$http', 'SERVER_URL', function($http, SERVER_URL){

	var service = {};
	var url = SERVER_URL.protocol+'://'+SERVER_URL.serverName+':'+SERVER_URL.port+'/'+SERVER_URL.context;

	service.addPurCat = function(purCat){
		return $http.put(url+'/api/purchase/addPurchaseCategories?catName=' + purCat.catName + '&&catDesc=' + purCat.description);
	};

	return service;

}]);