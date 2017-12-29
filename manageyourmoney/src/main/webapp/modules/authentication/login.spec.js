describe('authentification controller',function(){

	//beforeEach(angular.mock.module('home')); //load module<br />
	beforeEach(angular.mock.module('ui.grid'));
	beforeEach(angular.mock.module('ui.bootstrap'));
	beforeEach(angular.mock.module('ngMessages'));
	beforeEach(angular.mock.module('ngAnimate'));
	beforeEach(angular.mock.module('ngMaterial'));
	beforeEach(angular.mock.module('myApp'));
	beforeEach(angular.mock.module('schemaForm'));
	beforeEach(angular.mock.module('ui.router'));
	beforeEach(angular.mock.module('authentication')); //load module<br />
	var $controller;
	var $httpBackend;
	var authService;
	var scope;
	var controller;
	var $state

	beforeEach(inject(function(_$controller_, $rootScope, _$httpBackend_){
		$controller = _$controller_;
		//$httpBackend = _$httpBackend_;
		//authService = _AuthService_;
		//$state = _$state_;
		scope = $rootScope.$new();
		controller = $controller('AuthenticationController', { $scope: scope});
		
		//factory =  $AuthService('AuthService', { $scope: scope });
	}));
	
	describe('AuthenticationController', function() {
	    it('it should be defined', function() {
	      expect(controller).toBeDefined();
	   	});
  	});
	
	describe('authenticationOk', function(){
		it('should be exist', function(){
			expect(controller.authenticationOk).toBeDefined();
		});
		it('should be init to false', function(){
			expect(controller.authenticationOk).toBeFalsy();
		});
	})
	
	describe('login method', function() {
		it('should be defined', function(){
			expect(controller.login).toBeDefined();
		});
	});
	
	

  /*	describe('authification service', function(){
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
  	});*/

});