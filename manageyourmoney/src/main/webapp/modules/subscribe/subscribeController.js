'use strict';
angular.module('Subscribe').controller('SubscribeController', ['SubscribeService', function (SubscribeService) {
    var sc = this;
    sc.user = { firstName: '', lastName: '', login: '', password: '', confirmPassword: '' };
    sc.message = 'subscribe now';
    sc.showMessage = false;
    sc.userConflict = false;
    sc.showAddNewUserAlert = false;
    sc.subcribe = function () {
        SubscribeService.subscribe(sc.user).then(function (reponse) {
            //console.info(response);
            sc.showAddNewUserAlert = true;
        }, function (error) {
            sc.userConflict = true;
            console.info(error);
        });
    };

    sc.closeAlert = function () {
        sc.showAddNewUserAlert = false;
    }

}]);

angular.module('Subscribe').directive('compareTo', [function () {
    return {
        require: "ngModel",
        scope: {
            otherModelValue: "=compareTo"
        },
        link: function (scope, element, attributes, ngModel) {
            ngModel.$validators.compareTo = function (modelValue) {
                scope.showMessage = !(modelValue == scope.otherModelValue);
                return modelValue == scope.otherModelValue;
            };

            scope.$watch("otherModelValue", function () {
                ngModel.$validate();
            });
        }
    };
}]);