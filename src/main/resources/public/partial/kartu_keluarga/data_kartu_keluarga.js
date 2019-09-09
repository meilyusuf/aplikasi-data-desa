angular.module('appKartuKeluargaController', []).controller('DataKartuKeluargaController', function($http, $scope) {
	
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
});