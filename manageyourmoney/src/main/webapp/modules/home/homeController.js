var module = angular.module('home');

module.controller('HomeController', ['$scope','HomeService', function($scope, HomeService){
    $scope.message = "home page";
    var vm = this;
    vm.testHomee = function(){
        return true;
    }
    $scope.getAllUsers = function(){
    	HomeService.getUsers().then(function(response){
    		console.log(response);
    	})
    };

    $scope.saveUser = function(){
    	HomeService.saveUser().then(function(response){
    		console.log(response);
    	})
    };
    $scope.purchaseByCateg = {};
    $scope.getPurchaseGroupedByCateg = function(){
        HomeService.getPurchaseGroupedByCateg().then(function(response){
            $scope.purchaseByCateg = response.data;
        })
    };

     $scope.data = [
        {
            name : "Blue",
            value : 10,
            color : "#4a87ee",
            label : "ammar"
        },
        {
            name : "Green",
            value : 40,
            color : "#66cc33",
            label : "yahia"
        },
        {
            name : "Orange",
            value : 70,
            color : "#f0b840",
            label : "emna"
        },
        {
            name : "Red",
            value : 2,
            color : "#ef4e3a",
            label : "eya"
        }
    ];
    

   

  $scope.init = function(){
        $scope.getPurchaseGroupedByCateg();
        
    };
  $scope.init();

}]);


module.directive ("pieChart", function () {
    return {
        restrict : "A",
        scope : {
            data : "="
        },
        link : function (scope, element) {
            var width,
                height,
                radius,
                pie,
                arc,
                svg,
                path;
 
            width = element[0].clientWidth;
            height = element[0].clientHeight;
            radius = Math.min (width, height) / 2;
 
            pie = d3.layout.pie ()
                    .value (function (d) {return d.value;})
                    .sort (null);
 
            arc = d3.svg.arc ()
                    .outerRadius (radius - 20)
                    .innerRadius (radius - 80);
 
            svg = d3.select (element[0])
                    .append ("svg")
                    .attr ({width : width, height : height})
                    .append ("g")
                    .attr ("transform", "translate(" + width * 0.5 + "," + height * 0.5 + ")");
 
            path = svg.datum (scope.data)
                    .selectAll ("path")
                    .data (pie)
                    .enter ()
                    .append ("path")
                    .attr ({
                        fill : function (d, i) {return scope.data [i].color;},
                        d : arc
                    });
                
            scope.$watch (
                "data",
                function () {
                    pie.value (function (d) {return d.value;});
                    path = path.data(pie);
                    path.attr ("d", arc);
                },
                true
            );
        }
    };
});




