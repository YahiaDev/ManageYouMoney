describe('login factory',function(){
	/*it('has dummy spec to test  2+2',function(){
		expect(2 + 2).toEqual(4);
	});*/

	var authService;

	beforeEach(function(){
		//angular.mock.module('ngCookies',[]);
		angular.module('ngCookies',[]);
		module('authentication');
		//angular.mock.module('ab-base64','myApp','ngCookies','authentication');
		});
	//beforeEach();

	/*beforeEach(inject(function(_AuthenticationController_){
		AuthenticationController = _AuthenticationController_;

	}));*/

	beforeEach(inject(function(){
		var $injector = angular.injector(['authentication']);
		 console.log('yahiaaaaaaaaaaaaaaaaaaaaaaaaaa');
		authService = $injector.get('AuthService');

		console.log('bsaaaaaaaaaaaaaal'+authService);
	}));

	it('is very true', inject(function(){
      console.log('ammaaaaaaaaaaaaaaaaaaar'+authService);
      var output = authService.test();
      expect(output).toBeTruthy();
    }));

	/*it('should exists', function(){
		expect(authService).toBeDefined()
	});*/

});