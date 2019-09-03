angular.module('appDataPendudukController', []).controller('DataPendudukController', function($http, $scope) {
	
	
	$scope.listPenduduk = [];
	
	 _listPendudukData();
	 	 
	 function _listPendudukData() {
			$http({
				method : 'GET',
				url : '/api/penduduk/getAll'
			}).then(function(response) { // success
				$scope.listPenduduk = response.data;
			}, function(response) { // error
				console.log("Error: " + response.status + " : " + response.data);
			});
		}
});