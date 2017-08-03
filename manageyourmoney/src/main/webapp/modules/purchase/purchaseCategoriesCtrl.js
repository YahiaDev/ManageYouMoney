'use strict';
angular.module('PurchaseCat').controller('PurchaseCategoriesCtrl', ['$scope',
	'$state', 'purchaseService', '$cookieStore', function ($scope, $state, purchaseService, $cookieStore) {
		var purCatC = this;
		purCatC.purchaseCat = { catName: '', description: '', user: '' };
		purCatC.purchaseCatAdded = false;
		purCatC.modalEditSchema = {
			labelCat: { type: 'string', id: 'labelCat', title: 'Category Label', required: 'true' },
			description: { type: 'string', id: 'description', title: 'Description', required: 'false' }
		};

		purCatC.modalEditForm = [
			'labelCat',
			'description'
		];

		purCatC.dataLoaded = false;
		purCatC.addPurchaseCat = function () {
			if (purCatC.purchaseCat.catName !== '') {
				purchaseService.addPurCat(purCatC.purchaseCat).then(function (response) {
					purCatC.purchaseCatAdded = true;
					purCatC.purchaseCat.catName = '';
					purCatC.purchaseCat.description = '';
					purCatC.purchaseCat.user = $cookieStore.get('logedUser');
					//purCatC.gridOptions.data = response.data;
					purCatC.gridData = response.data;
					$state.reload();
				});
			}
		};

		purCatC.getAllPurchaseCat = function () {
			purchaseService.getAllPurchaseCat($cookieStore.get('logedUser').id).then(function (response) {
				//purCatC.gridOptions.data = response.data;
				purCatC.gridData = response.data;
				purCatC.dataLoaded = true;
			});
		};

		purCatC.columnDefs = [
			{ field: 'labelCat', displayName: 'Category Label' },
			{ field: 'description', displayName: 'Description' }
		];


		$scope.$on('gridDataEdited', function (event, args) {
			purchaseService.updatePurchaseCat(args.data).then(function (response) {
				console.info(response.data);
				//purCatC.purchaseCatAdded = true;
				//purCatC.purchaseCat.catName = '';
				//purCatC.purchaseCat.description = '';
				//purCatC.gridOptions.data = response.data;
				//purCatC.gridData = response.data;
			});
		});

		$scope.$on('gridDataRowDeleted', function (event, args) {
			purchaseService.deletePurchaseCat(args.data).then(function (response) {
				purCatC.gridData = response.data;
				$state.reload();
				//data.splice(data.indexOf(row.entity),1);
				//$uibModalInstance.close(row.entity);
			});
		});

		purCatC.getAllPurchaseCat();
	}]);
