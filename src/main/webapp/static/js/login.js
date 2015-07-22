app.controller("loginController", function($scope,$state,$http) {
    console.log("Login runs");
        
    $scope.login = function() {
        console.log("function called");
//        $state.go('userinfo');
        $http.get('login').
        success(function(data,status){
           console.log("Request Success" + data);
      }).        
        error(function(data,status, headers, config){           	
           console.log("Request Failed" , data , status , headers, config);
       });      
       
}});