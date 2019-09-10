var app = angular.module("appRouter", ['ui.router']);

app.config(function($stateProvider, $urlRouterProvider) {
	
	 $urlRouterProvider.otherwise('/');
  
$stateProvider
  .state("home", {
	url: '/',
    templateUrl : "partial/home.html"
  })
  .state("/InputPenduduk", {
	url : "/input-penduduk",
    templateUrl : "partial/inputPenduduk/input-penduduk.html"
  })
  .state("DataPenduduk", {
	url : "/data-penduduk",
    templateUrl : "partial/datapenduduk/datapenduduk.html"
  })
  .state("InputKartuKeluarga", {
	url : "/input-kartu-keluarga",
    templateUrl : "partial/kartu_keluarga/input_kartu_keluarga.html"
  })
   .state("DataKartuKeluarga", {
	url : "/data-kartu-keluarga",
    templateUrl : "partial/kartu_keluarga/data_kartu_keluarga.html"
  })
  .state("LookupKartuKeluarga", {
	url : "/lookup-kartu-keluarga",
    templateUrl : "partial/kartu_keluarga/lookup_kartu_keluarga.html"
  }) 
  ;

});

app.factory("myFactory", function() {
	var savedData = {}
	function set(data) {
		savedData = data;
	}
	function get() {
		return savedData;		
	}
	return {
		set : set,
		get : get
	}
})
  

  
