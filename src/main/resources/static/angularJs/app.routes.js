var app = angular.module("appRouter", ['ngRoute']);

app.config(function($routeProvider) {
  
$routeProvider
  .when("/", {
    templateUrl : "partial/home.html"
  })
  .when("/input-penduduk", {
    templateUrl : "partial/inputPenduduk/input-penduduk.html"
  })
  .when("/data-penduduk", {
    templateUrl : "partial/datapenduduk/datapenduduk.html"
  })
  ;

});
  

  
