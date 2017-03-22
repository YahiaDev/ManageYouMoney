'use strict';
angular.module('myApp').controller('RowEditCtrl',['$scope', '$rootScope', 'purchaseService', '$uibModalInstance', 'PurchaseCatSchema', 'grid', 'row', 'schema', 'form', 'modalEditTitle', function($scope, $rootScope, purchaseService, $uibModalInstance, PurchaseCatSchema, grid, row, schema, form, modalEditTitle){
  
 
  $scope.init = function(){
  
  $scope.selectedItem = '';
  $scope.searchItem = '';
  $scope.schema = schema;
  $scope.form = form;
  $scope.modalEditTitle = modalEditTitle;
  $scope.entity = angular.copy(row.entity);
  $scope.dataToFilterOn = {};
  for (var key in $scope.schema){
    if ($scope.schema[key].type === 'autocomplete'){
      $scope.dataToFilterOn['data'] = $scope.schema[key].data;
      $scope.dataToFilterOn['idForAutoComplete'] = $scope.schema[key].idForAutoComplete;
      $scope.dataToFilterOn['dataToDisplay'] = $scope.schema[key].dataToDisplay;
      $scope.selectedItem = $scope.schema[key].data.filter(function(el){
        return el[$scope.dataToFilterOn['idForAutoComplete']] === $scope.entity[key.toLowerCase()][$scope.dataToFilterOn['idForAutoComplete']];
      })[0].labelCat;
      break;
    }
  }

  angular.forEach($scope.schema, function(el){
    if (el.type === 'Date'){
      $scope.entity[el.id] = new Date($scope.entity[el.id]);
      //moment($scope.entity[el.id]).format('DD-MM-YYYY');
    }
    });
  };

   $scope.init();
  
  $scope.save =  function () {
    // Copy row values over
    $scope.requiredData = false;
    if ($scope.schema.required !== undefined && $scope.schema.required !== null){
      angular.forEach($scope.schema.required,function(element){
        if (row.entity[element] === null || row.entity[element] === undefined){
          $scope.requiredData = true;
        }
      })
    }
    if (!$scope.requiredData){
      angular.extend(row.entity, $scope.entity);
      $rootScope.$broadcast('gridDataEdited', {data:$scope.entity});
      $uibModalInstance.close(row.entity);
      /*purchaseService.updatePurchaseCat($scope.entity).then(function(response){
        $uibModalInstance.close(row.entity);
      });*/
    }
    
  };

  //autocomplete field functions
  $scope.searchTextChange = function(item){
    console.log('search text changed to '+item);
  };

  $scope.selectedItemChange = function(item){
    if (item !== undefined){
      console.info('select item changed to '+item[$scope.dataToFilterOn['dataToDisplay']]);
    }
  };

  $scope.querySearch = function(query) {
      /*var dataToFilterOn = [];
      for (var item in $scope.schema){
        if ($scope.schema[item].type === 'autocomplete'){
          dataToFilterOn = $scope.schema[item].data;
          break;
        }
      }*/
      var results = query ? $scope.dataToFilterOn['data'].filter( $scope.createFilterFor(query) ) : $scope.dataToFilterOn['data'];
          
      /*if (self.simulateQuery) {
        deferred = $q.defer();
        $timeout(function () { deferred.resolve( results ); }, Math.random() * 1000, false);
        return deferred.promise;
      } else {*/
        return results;
      //}
    };

    $scope.createFilterFor = function(query) {
      var lowercaseQuery = angular.lowercase(query);

      return function filterFn(state) {
        return (state[$scope.dataToFilterOn['dataToDisplay']].indexOf(lowercaseQuery) === 0);
      };

    };

    //end autocomplete field functions
  
 }]);