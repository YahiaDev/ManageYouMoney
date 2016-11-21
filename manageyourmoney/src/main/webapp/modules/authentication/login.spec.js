describe('login factory',function(){

	//beforeEach(angular.mock.module('home')); //load module<br />
	beforeEach(angular.mock.module('myApp'));
	beforeEach(angular.mock.module('ui.router'));
	beforeEach(angular.mock.module('authentication')); //load module<br />
	var $controller;
	var $httpBackend;
	var authService;
	var scope;
	var controller;

	beforeEach(inject(function(_$controller_, $rootScope, _AuthService_, _$httpBackend_){
		$controller = _$controller_;
		$httpBackend = _$httpBackend_;
		authService = _AuthService_;
		scope = $rootScope.$new();
		controller = $controller('AuthenticationController', { $scope: scope });
		//factory =  $AuthService('AuthService', { $scope: scope });
	}));

	describe('AuthenticationController', function() {
	    it('it should be defined', function() {
	      expect(controller).toBeDefined();
	   	});
  	});

  	describe('authification service', function(){
  		it('authService should be defined', function(){
	   		expect(authService).toBeDefined();
	   	});
	   	it('authenticate method in authService should be defined', function(){
	   		expect(authService.authenticate()).toBeDefined();
	   	});
	   	it('test http response',inject(function($http){
	   		//var $scope = {};
	   		//$scope.authenticated = false;
	   		 //$http.put('http://localhost:8060/manageyourmoney/api/authenticate',-{login:'test@test.com',password:'yahia'}).success(function(user, status, headers){
		       //$cookieStore.put('hmacApp-account', JSON.stringify(user));
		        //hmacInterceptor.readHmacRequest(headers());
		       // console.log('yahiaaaaaaaaaaaaaaaaaaa');
		        //$scope.authenticated = true;
		        //return user;
		     // }, function errorCallback(response){
		        /*if(response.status === 403 && response.data) {
		          if (response.data.exception && response.data.exception.indexOf('BadCredentialsException') !== -1) {
		            $scope.httpError = 'Username and/or password are invalid !';
		          }
		        }*/
		      //});

	   		 /*$httpBackend
	   		 	.whenPUT('http://localhost:8060/manageyourmoney/api/authenticate')
		    	.respond(200, { firstName: 'yahia', lastName:'yahia' });

		    $httpBackend.flush();
	   		expect($scope.authenticated).toBe(true);*/

	   		var returData = {};

	   		//$httpBackend.whenGET("http://localhost:8060/manageyourmoney/api/authenticate").passThrough();
	   		$httpBackend.when('GET', 'modules/authentication/authenticationTemplate.html').respond({firstName:'yahia',lastName:'ammar'});
	   		$httpBackend.expect('PUT','http://localhost:8060/manageyourmoney/api/authenticate',{login:'test@test.com',password:'yahia'}).respond(returData);
	   		var result = {};
	   		var returnedPromise = authService.authenticate('test@test.com','yahia');
	   		returnedPromise.then(function(response){
	   			result = response;
	   		});
	   		console.info('yahiaaaaaa'+ typeof result);
	   		for (var property in result) {
	   			console.info('property: '+property+' value: '+result[property])
	    		//if (object.hasOwnProperty(property)) {
	        		// do stuff
	    		//}
			};
	   		$httpBackend.flush();
	   		//expect(result).toEqual(returnData);


	   	}));
  	});

});