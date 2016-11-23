var homeApp = angular.module('homeApp',['ngRoute'])

.controller('homeCtrl',function(){
	
})
.config(function($routeProvider,$locationProvider){
	$routeProvider
		
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
		.otherwise({ redirectTo: '/'});
		
});
