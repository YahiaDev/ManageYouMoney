'use strict';
angular.module('myApp').directive('numbersOnly', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attr, ngModelCtrl) {
            function fromUser(text) {
                if (text) {
                    var transformedInput = text.replace(/[^0-9.]/g, '');
                    if (transformedInput.split('.').length > 2) {
                        transformedInput = transformedInput.substring(0, transformedInput.length - 1);
                    }
                    if (transformedInput !== text) {
                        ngModelCtrl.$setViewValue(transformedInput);
                        ngModelCtrl.$render();
                    }
                    return parseFloat(transformedInput);
                }
                return undefined;
            }
            ngModelCtrl.$parsers.push(fromUser);
        }
    };
});