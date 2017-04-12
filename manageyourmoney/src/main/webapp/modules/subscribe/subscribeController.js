'use strict';
angular.module('Subscribe').controller('SubscribeController', ['SubscribeService', function (SubscribeService) {
    var sc = this;
    sc.user = { firstName: '', lastName: '', email:''};
    sc.message = 'subscribe now';
    sc.subcribe = function () {
        SubscribeService.subscribe(sc.user).then(function (reponse) {
            console.info(response);
        });
    };

}]);