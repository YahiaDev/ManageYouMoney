describe('login factory',function(){
	/*it('has dummy spec to test  2+2',function(){
		expect(2 + 2).toEqual(4);
	});*/

	var authService;

	beforeEach(function() {

    module('home');

	    inject(function(_HomeService_) {
	    	console.log('heeelooooooooooooooooooo'+_HomeService_);
	        authService = _HomeService_;
	    });
	});

	it('is very true', inject(function(){
      console.log('ammaaaaaaaaaaaaaaaaaaar'+authService);
      var output = authService.testHome();
      expect(output).toBeTruthy();
    }));


	//beforeEach(module('home'));

	//beforeEach(function(){
		//angular.mock.module('ngCookies',[]);
		//angular.module('ngCookies',[]);
	//	module('home');
		//angular.mock.module('ab-base64','myApp','ngCookies','authentication');
	//	});
	//beforeEach();

	/*beforeEach(inject(function(_AuthenticationController_){
		AuthenticationController = _AuthenticationController_;

	}));*/

	// Setup the mock service in an anonymous module.
	/*  beforeEach(module(function ($provide) {
	    $provide.value('oneOfMyOtherServicesStub', {
	        someVariable: 1
	    });
	  }));

	   it('can get an instance of my factory', inject(function(HomeService) {
    expect(HomeService).toBeDefined();
  	}));*/

	/*beforeEach(inject(function(){
		var $injector = angular.injector(['home']);
		 console.log('yahiaaaaaaaaaaaaaaaaaaaaaaaaaa');
		authService = $injector.get('HomeService');

		console.log('bsaaaaaaaaaaaaaal'+authService);
	}));

	it('is very true', inject(function(){
      console.log('ammaaaaaaaaaaaaaaaaaaar'+authService);
      var output = authService.testHome();
      expect(output).toBeTruthy();
    }));*/

	/*it('should exists', function(){
		expect(authService).toBeDefined()
	});*/

});