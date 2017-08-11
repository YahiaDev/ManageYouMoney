'use strict';
angular.module('common').factory('httpSecurityInterceptor', ['$q', '$rootScope', function ($q, $rootScope) {
    return {
        responseError: function (rejection) {
            // broadcast event:unauthorized only if the rejection type is different
            // from user conflict
            if (rejection.status !== 409) {
                $rootScope.$broadcast('event:unauthorized', { message: rejection.data });
            }
            return $q.reject(rejection);
        }
    };
}]
);