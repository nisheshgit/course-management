angular
  .module('postExample', [])
    
.controller("MainController", function($scope,$http) {
    console.log("runs");
    
    
    $scope.login = function() {
        console.log("function called");
        $http.get("10.11.6.107/greeting").
        success(function(response){
            console.log("Request Success" + str(response));
        }).        
        error(function(){   
            console.log("Request Failed");
        });
    
    };
    
});

