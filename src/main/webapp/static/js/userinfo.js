app.controller("userController",'$scope' ,'$http' , function ($scope,$http){
	
  $http.get('view').
        success(function(data,status){
           console.log("Request Success" + data);
           
      }).        
        error(function(data,status, headers, config){           	
           console.log("Request Failed" , data , status , headers, config);
       }); 
	
	
  $scope.people = [
    {id: 1 , name:'xyz', age: 30, role: 'Developer'},
    ];
    
  $scope.addPerson = function(){
    var person = {
        id: $scope.id,
        name: $scope.name,
        age: $scope.age,
        role: $scope.role,
    };
    
    $scope.people.push(person);
  };
   
   $scope.removePerson = function(index){
    $scope.people.splice(index, 1);
   };  

   $scope.editPerson = function(index){
    $scope.people(index, 1);
};  
});