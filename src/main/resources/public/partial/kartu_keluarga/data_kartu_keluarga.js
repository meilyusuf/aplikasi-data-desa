angular.module('appKartuKeluargaController', []).controller('DataKartuKeluargaController', 
		function($http, $scope, $location, myFactory) {
	
	$scope.listKartuKeluarga = [];
	
	 _listKartuKeluarga();
	 	 
	 function _listKartuKeluarga() {
			$http({
				method : 'GET',
				url : '/api/kartuKeluarga/getAll'
			}).then(function(response) { // success
				console.log(response.data);
				$scope.listKartuKeluarga = response.data;
			}, function(response) { // error
				console.log("Error: " + response.status + " : " + response.data);
			});
	}
	 
	 $scope.lookup = function(kartuKeluarga) {
		 console.log(kartuKeluarga);
		 myFactory.set(kartuKeluarga);
		 $location.path("/lookup-kartu-keluarga");
	 }
	 
});