var module = angular.module('home');

module.controller('HomeController', ['HomeService', 'MonthLabel', function(HomeService, MonthLabel){
    var vm = this;
    vm.purchaseByCateg = {};
    vm.loadedData = false;
    vm.selectedSearchCriteria = null;
    vm.searchOptions = ['Purchase by categories', 'Purchase by dates'];
    vm.selectedSearchCriteria = 'Purchase by categories';
    vm.getPurchaseGroupedByCateg = function(){
        vm.loadedData = false;
        HomeService.getPurchaseGroupedByCateg().then(function(response){
            vm.purchaseByCateg = response.data;
            vm.chartConfig.series[0].data = vm.formatPurchaseCatData(response.data);
            vm.loadedData = true;
        })
    };

    vm.getPurchaseGroupedByDate = function(){
        vm.loadedData = false;
        HomeService.getPurchaseGroupedByDate().then(function(response){
            vm.purchaseByMonth = response.data;
            vm.chartConfig.series[0].data = vm.formatPurchseByDateData(response.data);
            vm.loadedData = true;
        })
    };

    vm.formatPurchaseCatData = function(purchaseCatData){
        var formatedDataList = [];
        var formatedDataObject = null;
        angular.forEach(purchaseCatData, function(el){
            formatedDataObject = new Object();
            formatedDataObject['name'] = el.category.labelCat;
            formatedDataObject['y'] = el.count;
            formatedDataList.push(formatedDataObject);
        });
        return formatedDataList;
    };

    vm.formatPurchseByDateData = function(purchaseByDateData){
        var formatedDataList = [];
        var formatedDataObject = null;
        angular.forEach(purchaseByDateData, function(el){
            formatedDataObject = new Object();
            formatedDataObject['name'] = MonthLabel[el.month];
            formatedDataObject['y'] = el.amount;
            formatedDataList.push(formatedDataObject);
        });
        return formatedDataList;
    };


     vm.chartConfig = {
      chart: {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false,
        type: 'pie'
      },
      title: {
        text: vm.selectedSearchCriteria
      },
      tooltip: {
        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
      },
      credits: {
      enabled: false
     },
      plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
                enabled: true,
                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                style: {
                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                }
            }
        }
    },
    series: [{
        animation: {
                duration: 2000
            },
        name: vm.selectedSearchCriteria,
        id: 'series1',
        colorByPoint: true,
        data: []
    }]

    };

  

 vm.statCriteriaChanged = function(){
    if (vm.selectedSearchCriteria === 'Purchase by categories'){
        vm.getPurchaseGroupedByCateg();
    }else if (vm.selectedSearchCriteria === 'Purchase by dates'){
        vm.getPurchaseGroupedByDate();
    }
 };

  vm.init = function(){
    vm.getPurchaseGroupedByCateg();
  };
  vm.init();

}]);

angular.module('home').constant('MonthLabel', {
  1: 'January',
  2: 'February',
  3: 'March',
  4: 'April',
  5: 'May',
  6: 'June',
  7: 'July',
  8: 'August',
  9: 'September',
  10: 'October',
  11: 'November',
  12: 'December'    
});





