angular.module('PurchaseCat').factory('purchaseService',['$http', 'SERVER_URL', function($http, SERVER_URL){

	var service = {};
	var url = SERVER_URL.protocol+'://'+SERVER_URL.serverName+':'+SERVER_URL.port+'/'+SERVER_URL.context;

	service.addPurCat = function(purCat){
		return $http.put(url+'/api/purchase/addPurchaseCategories?catName=' + purCat.catName + '&&catDesc=' + purCat.description);
	};

	service.getAllPurchaseCat = function(){
		return $http.get(url+'/api/purchase/getAllPurchaseCategories');
	};

	service.updatePurchaseCat = function(purCat){
		return $http.post(url+'/api/purchase/updatePurchaseCategories', purCat);
	};

	service.deletePurchaseCat = function(purCat){
		return $http.post(url+'/api/purchase/deletePurchaseCategories', purCat);
	};

	service.addPurchase = function(purchase){
		return $http.put(url+'/api/purchase/addPurchase', purchase);
	};

	service.getAllPurchase = function(){
		return $http.get(url+'/api/purchase/getAllPurchase');
	};
	

	return service;

}]);