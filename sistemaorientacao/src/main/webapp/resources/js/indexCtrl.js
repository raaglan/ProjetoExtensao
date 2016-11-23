var indexApp = angular.module('indexApp',['ngRoute'])

.config(function($routeProvider,$locationProvider){
	$routeProvider
		.when('/login',{
			templateUrl:'login.html',
			controller:'loginCtrl'
			
		})
		.when('/index',{
			templateUrl:'index.html',
			controller:'indexCtrl'
		})
		.when('/home',{
			templateUrl:'homeSys.html',
			controller:'homeCtrl'
		})
		.when('/cadAluno',{
			templateUrl:'cadastroAluno.html',
			controller:'alunoCtrl'
		})
		.when('/cadProf',{
			templateUrl:'cadastroProfessor.html',
			controller:'professorCtrl'
		})
		.when('/cadOrientacao',{
			templateUrl:'cadastroOrientacao.html',
			controller:'orientacaoCtrl'
		})
		.when('/acompanhamentos',{
			templateUrl:'acompanhamentos.html',
			controller:'acompCtrl'
		})
		.otherwise({ redirectTo: '/login'});
		
})

.controller('indexCtrl',function(){
	
})
.controller('loginCtrl', function(){
	
})
.controller('alunoCtrl', function(){
	
})
.controller('professorCtrl', function(){
	
})
.controller('orientacaoCtrl', function(){
	
})
.controller('acompCtrl', function(){
	
})
.controller('homeCtrl',function(){
	
});
