angular.module('appLookupKartuKeluargaController', []).controller('LookupKartuKeluargaController', 
		function($http, $scope, $location, myFactory) {
	
	$scope.Kartukeluarga = myFactory.get();
	console.log($scope.Kartukeluarga);
	 
});