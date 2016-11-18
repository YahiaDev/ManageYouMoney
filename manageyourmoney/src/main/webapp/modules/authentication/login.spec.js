describe('login factory',function(){

	beforeEach(module('home')); //load module<br />
    describe('HomeController',function(){ //describe your app name<br />
        var myctrl;
        beforeEach(inject(function($controller){ //instantiate controller using $controller service
            myctrl = $controller('HomeController');
            console.log('aaaaaaaaaaaaaaa'+myctrl);
        }));
        it('is very true', inject(function(){
      
      var output = myctrl.testHomee();
      expect(output).toBeTruthy();
    }));
    });


	/*it('has dummy spec to test  2+2',function(){
		expect(2 + 2).toEqual(4);
	});*/

	/*var authService;

	beforeEach(function() {

    var x  = module('home');
	console.log('hahahahahhahahahha'+x);
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