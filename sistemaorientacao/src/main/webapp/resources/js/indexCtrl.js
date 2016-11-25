var indexApp = angular.module('indexApp', [ 'ngRoute' ])

.config(function($routeProvider, $locationProvider) {
	$routeProvider.when('/login', {
		templateUrl : 'login.html',
		controller : 'loginCtrl'

	}).when('/index', {
		templateUrl : 'index.html',
		controller : 'indexCtrl'
	}).when('/home', {
		templateUrl : 'homeSys.html',
		controller : 'homeCtrl'
	}).when('/cadAluno', {
		templateUrl : 'cadastroAluno.html',
		controller : 'alunoCtrl'
	}).when('/cadProf', {
		templateUrl : 'cadastroProfessor.html',
		controller : 'professorCtrl'
	}).when('/cadOrientacao', {
		templateUrl : 'cadastroOrientacao.html',
		controller : 'orientacaoCtrl'
	}).when('/acompanhamentos', {
		templateUrl : 'acompanhamentos.html',
		controller : 'acompCtrl'
	}).when('/relatorio', {
		templateUrl : 'relatorio.html',
		controller : 'relCtrl'
	}).otherwise({
		redirectTo : '/login'
	});

})

.controller('indexCtrl', function() {

}).controller('loginCtrl', function() {

}).controller('alunoCtrl', function($scope, $http) {
	// Carregamento dos Cursos
	$http({
		method : 'GET',
		url : '/curso'

	}).success(function(response) {
		$scope.cursos = response;
	}).error(function() {

	});
	// Cadastrar Aluno
	$scope.salvarAluno = function(aluno) {
		$http({
			method : 'POST',
			url : '/aluno',
			data : JSON.stringify(aluno)

		}).success(function(response) {
			alert(response);
		}).error(function() {

		});
	}

}).controller('professorCtrl', function($scope, $http) {

	$scope.cursos1 = [];
	$scope.selected = function(curso) {
		var index = $scope.cursos1.indexOf(curso);

		if (index > -1){
			$scope.cursos1.splice(index, 1);
		}else{
			$scope.cursos1.push(curso);
			
		}
		console.log($scope.cursos1);
		$scope.professor.push($scope.cursos1);
	
	}

	$http({
		method : 'GET',
		url : '/curso'

	}).success(function(response) {
		$scope.cursos = response;
	}).error(function() {

	});
	$scope.salvar = function(professor) {
		
		console.log(professor);
		$http({
			method : 'POST',
			url : '/professor',
			data : JSON.stringify(professor)
		}).success(function() {
			alert("Cadastrado");
		}).error(function() {

		})
	}
}).controller('orientacaoCtrl', function() {

}).controller('acompCtrl', function() {

}).controller('homeCtrl', function() {

});
