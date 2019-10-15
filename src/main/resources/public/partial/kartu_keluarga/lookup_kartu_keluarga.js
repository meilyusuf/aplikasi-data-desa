var app = angular.module('appLookupKartuKeluargaController', ['ui.router', 'ngAnimate', 'ngSanitize', 'ui.bootstrap']);

app.controller('LookupKartuKeluargaController', function($http, $scope, $location, myFactory,  $uibModal) {
	
	$scope.kartuKeluarga = myFactory.get();
	console.log($scope.kartuKeluarga);	
	//$scope.anggotaKk = kartuKeluarga.anggotaKk;

	
	
	 var pc = this;
	  pc.data = "Lorem Name Test"; 

	  pc.open = function (size) {
	    var modalInstance = $uibModal.open({
	      animation: true,
	      ariaLabelledBy: 'modal-title',
	      ariaDescribedBy: 'modal-body',
	      templateUrl: 'partial/template/input_anggota_kk_modal.html',
	      controller: 'ModalInstanceCtrl',
	      controllerAs: 'pc',
	      size: size,
	      resolve: {
	        data: function () {
	          return pc.kartuKeluarga;
	        }
	      }
	    });

	    modalInstance.result.then(function () {
	     
	    },function rejection(error) {
	        return error;
	    });
	    
	  };
	
	 
});

app.controller('ModalInstanceCtrl', function ($uibModalInstance, data) {
	  var pc = this;
	  pc.kartuKeluarga = data;
	  
	  pc.ok = function () {    	  
	    $scope.anggotaKk.kartuKeluarga =  pc.kartuKeluarga;
	    console.log($scope.anggotaKk);
	    $http.post('api/penduduk/insert', $scope.kartuKeluarga).then(success, failed);
	     	function success(response) {
	            console.log(response);
	        }
	        function failed(response) {
	            console.log(response);       
	        }
	     
	   
	    $uibModalInstance.close();
	  };

	  pc.cancel = function () {
	    //{...}
	  
	    $uibModalInstance.dismiss('cancel');
	  };
});
