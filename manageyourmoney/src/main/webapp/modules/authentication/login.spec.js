describe('login factory',function(){

	beforeEach(angular.mock.module('home')); //load module<br />

	var $controller;

	beforeEach(inject(function(_$controller_){
		//console.log('ammmmmmmmmmmmmmmmmar'+_$controller);
		$controller = _$controller_;
	}));

	describe('HomeController', function() {
    it('test home controller', function() {
      var $scope = {};
      var controller = $controller('HomeController', { $scope: $scope });
      expect(controller.testHomee()).toBeTruthy();
    	});
  	});

});