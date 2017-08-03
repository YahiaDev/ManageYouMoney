'use strict';
angular.module('Purchase').controller('PurchaseCtrl', ['$scope', 'purchaseService', '$state', 'AuthService', '$cookieStore', function ($scope, purchaseService, $state, AuthService, $cookieStore) {
	var purchaseC = this;
	purchaseC.purchaseAdded = false;
	purchaseC.purchase = {
		label: '',
		date: '',
		amount: '',
		comment: '',
		category: '',
		user: ''
	};

	purchaseC.selectedPurchaseCat = '';
	purchaseC.searchPurchaseCat = '';
	purchaseC.purchaseDataLoaded = false;
	purchaseC.addPurchase = function () {
		purchaseC.purchase.category = purchaseC.selectedPurchaseCat;
		purchaseC.purchase.user = $cookieStore.get('logedUser');
		purchaseService.addPurchase(purchaseC.purchase).then(function (response) {
			purchaseC.purchaseAdded = true;
			purchaseC.gridData = response.data;
			$state.reload();
		});
	};

	purchaseC.purchaseCatDataLoaded = false;
	purchaseC.getAllPurchaseCat = function () {
		purchaseService.getAllPurchaseCat($cookieStore.get('logedUser').id).then(function (response) {
			purchaseC.modalEditSchema['category']['data'] = response.data;
			purchaseC.purchaseCatDataLoaded = true;
		})
	};

	purchaseC.purchaseDataLoaded = false;
	purchaseC.getAllPurchase = function () {
		purchaseService.getAllPurchase($cookieStore.get('logedUser').id).then(function (response) {
			purchaseC.gridData = response.data;
			purchaseC.purchaseDataLoaded = true;
		})
	};



	//autocomplete functions
	purchaseC.querySearch = function (query) {
		var results = query ? purchaseC.modalEditSchema['category']['data'].filter(purchaseC.createFilterFor(query)) : purchaseC.modalEditSchema['category']['data'];
		return results;
	};

	purchaseC.createFilterFor = function (query) {
		var lowercaseQuery = angular.lowercase(query);

		return function filterFn(category) {
			return (category.labelCat.toLowerCase().indexOf(lowercaseQuery) === 0);
		};

	};


	// grid properties
	purchaseC.columnDefs = [
		{ field: 'category.labelCat', displayName: 'category' },
		{ field: 'label', displayName: 'Label' },
		{ field: 'date', displayName: 'Purchase Date', type: 'date', cellFilter: 'date:\'dd-MM-yyyy\'' },
		{ field: 'amount', displayName: 'Purchase amount' },
	];



	purchaseC.modalEditSchema = {
		category: { type: 'autocomplete', id: 'category', title: 'category', required: 'true', idForAutoComplete: 'categoryId', dataToDisplay: 'labelCat', data: [] },
		label: { type: 'string', id: 'label', title: 'Label', required: 'true' },
		date: { type: 'Date', id: 'date', title: 'Purchase Date', required: 'true' },
		amount: { type: 'number', id: 'amount', title: 'Purchase Amoutn', required: 'true' },
	};
	purchaseC.modalEditForm = [
		'category',
		'label',
		'date',
		'amount'
	];


	$scope.$on('gridDataRowDeleted', function (event, args) {
		purchaseService.deletePurchase(args.data).then(function (response) {
			purchaseC.gridData = response.data;
			$state.reload();
		});
	});

	$scope.$on('gridDataEdited', function (event, args) {
		args.data.user = $cookieStore.get('logedUser');
		purchaseService.updatePurchase(args.data).then(function (response) {
			purchaseC.gridData = response.data;
			$state.reload();
		});
	});


	purchaseC.init = function () {
		purchaseC.getAllPurchaseCat();
		purchaseC.getAllPurchase();
	};
	purchaseC.init();

}]);