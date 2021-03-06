angular.module('PurchaseCat').factory('purchaseService', ['$http', 'SERVER_URL', function ($http, SERVER_URL) {

	var service = {};
	var url = SERVER_URL.protocol + '://' + SERVER_URL.serverName + ':' + SERVER_URL.port + '/' + SERVER_URL.context;

	service.addPurCat = function (purCat) {
		//return $http.put(url + '/api/purchase/addPurchaseCategories?catName=' + purCat.catName + '&&catDesc=' + purCat.description);
		return $http.put(url + '/api/purchase/addPurchaseCategories', purCat);
	};

	service.getAllPurchaseCat = function (userId) {
		return $http.get(url + '/api/purchase/getAllPurchaseCategories?userId=' + userId);
	};

	service.updatePurchaseCat = function (purCat) {
		return $http.post(url + '/api/purchase/updatePurchaseCategories', purCat);
	};

	service.deletePurchaseCat = function (purCat) {
		return $http.post(url + '/api/purchase/deletePurchaseCategories', purCat);
	};

	service.addPurchase = function (purchase) {
		return $http.put(url + '/api/purchase/addPurchase', purchase);
	};

	service.getAllPurchase = function (userId) {
		return $http.get(url + '/api/purchase/getAllPurchase?userId=' + userId);
	};

	service.deletePurchase = function (purchase) {
		return $http.post(url + '/api/purchase/deletePurchase', purchase);
	};

	service.updatePurchase = function (purchase) {
		return $http.post(url + '/api/purchase/updatePurchase', purchase);
	};



	return service;

}]);