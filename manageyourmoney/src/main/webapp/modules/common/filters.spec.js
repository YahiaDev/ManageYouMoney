describe('filters', function(){
	var upperCaseFilter;
	beforeEach(angular.mock.module('myApp'));
	beforeEach(inject(function(_$filter_){
		upperCaseFilter = _$filter_('myUpperCaseFilter');
	}))
	describe('myUpperCaseFilters',function(){
		it('should be exist', function(){
			expect(upperCaseFilter).toBeDefined();
		});
		it('should be filter the param passed', function(){
			expect(upperCaseFilter('yahia')).toEqual('YAHIA');
		});
		it('should throw exeption: test with string number', function(){
			expect(upperCaseFilter.bind(null, '12')).toThrow();
		});
		it('should throw exeption: test with number', function(){
			expect(upperCaseFilter.bind(null, 2)).toThrow();
		});
		
	});
	
});