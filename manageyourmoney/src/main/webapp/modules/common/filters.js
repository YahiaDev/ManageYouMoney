'use strict';
var app = angular.module('myApp');
app.filter('myUpperCaseFilter',function(){
	return function(s){
		if (!isNaN(Number(s))){
			throw new ArgumentException('is not a string');
			return s;
		}
		return s.toUpperCase();
	}
});