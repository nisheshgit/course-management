app.controller('loginController', ['$cookies', '$state', '$rootScope', '$scope' ,'$http', function($cookies, $state, $rootScope, $scope,$http) {
    $scope.register = function() {
        console.log('register');
        $state.go('register');
    }

    $scope.user = {};
    $scope.user.email = "new@new.com";
    $scope.user.password = "new";
    
    $scope.login = function() {
        console.log("function called");
//        $state.go('userinfo');
        $http.get('login').
        success(function(data,status){
           console.log("Request Success" + data);
           if(data="true")  $state.go('userinfo');
      }).        
        error(function(data,status, headers, config){           	
           console.log("Request Failed" , data , status , headers, config);
       })};      
       
}])

.controller('registerController',['$state', '$scope' ,'$http', function($state, $scope, $http) {
    $scope.user = {};
    $scope.user.name = "new";
    $scope.user.email = "new@new.com";
    $scope.user.password = "new";
    
    $scope.register = function() {
    	console.log(angular.toJson($scope.user));
    	
    	$http.post('register' , {User:$scope.user}).
        success(function(data,status){
           console.log("Request Success" + data);
      }).        
        error(function(data,status, headers, config){           	
           console.log("Request Failed" , data , status , headers , config);
       });  
    };    
          
    $scope.cancel = function(){
        $state.go('login');      
    }    
}]);
