var app = angular
  .module('myApp', ['ui.router','ngCookies'])   

.config(['$stateProvider', '$urlRouterProvider' , function($stateProvider,
      $urlRouterProvider) {
      console.log('config');
    
    $stateProvider
        .state('login', {
                url: '/login',
                templateUrl: 'resources/views/login.html',
                controller: 'loginController',
          })
        .state('register', {
                url: '/register',
                templateUrl: 'resources/views/register.html',
                controller: 'registerController',
          })         
        .state('userinfo', {
                url: '/userinfo',
                templateUrl: 'resources/views/userinfo.html',
                controller: 'userController',
        })
    $urlRouterProvider.otherwise('login');
  }])


.run(['$cookies', '$rootScope', '$state', function($cookies, $rootScope, $state) {
    
    $rootScope.user = $cookies.get('user');
    
    $rootScope.$on('$stateChangeStart', function(event, next) {
        // redirect to login page if not logged in
        if (next.authenticate && !$rootScope.user) {
            event.preventDefault(); //prevent current page from loading
            $state.go('login');
        }
    })
}])
.controller("MainController", ['$state', function($state, $scope) {
    console.log("runs");
    $state.go('login');
}])


.factory('people',function(){
	return {
        id: '',
        name: '',
        age: '',
        role: '',
}});











    