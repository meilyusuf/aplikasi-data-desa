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
  .when("/input-kartu-keluarga", {
    templateUrl : "partial/kartu_keluarga/input_kartu_keluarga.html"
  })
  
  ;

});
  

  
