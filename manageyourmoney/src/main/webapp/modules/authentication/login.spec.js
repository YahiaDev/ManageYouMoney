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
	   	it('test a success authentication authentication controller',inject(function($http){
	   		var returData = {login:'haha',password:'lalala'};
	   		$httpBackend.when('GET', 'modules/authentication/authenticationTemplate.html').respond({login:'test@test.com',password:'yahia'});
	   		$httpBackend.when('GET', 'modules/home/homeTemplate.html').respond({login:'test@test.com',password:'yahia'});
	   		//intercept http call
	   		$httpBackend.expect('PUT','http://localhost:8060/manageyourmoney/api/authenticate',{login:'test@test.com',password:'yahia'}).respond(200,returData);
	   		scope.user = {login:'test@test.com',password:'yahia'};
	   		//make a call
	   		scope.login();
	   		$httpBackend.flush();
	   		expect(scope.authenticationOk).toBe(true);
	   	}));
  	});

});