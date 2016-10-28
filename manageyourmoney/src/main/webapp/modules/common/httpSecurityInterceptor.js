angular.module('common').factory('httpSecurityInterceptor', ['$q','$rootScope',function ($q,$rootScope) {
    return {
        responseError:function(rejection){
            $rootScope.$broadcast('event:unauthorized', {message:rejection.data});
            return $q.reject(rejection);
        }
    };
	}]
);