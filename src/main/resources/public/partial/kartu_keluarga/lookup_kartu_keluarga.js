var app = angular.module('appLookupKartuKeluargaController', ['ui.router', 'ngAnimate', 'ngSanitize', 'ui.bootstrap']);

app.controller('LookupKartuKeluargaController', function($http, $scope, $location, myFactory,  $uibModal) {
	
	$scope.kartuKeluarga = myFactory.get();
	console.log($scope.kartuKeluarga);		
	 var pc = this;	 
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
	          return $scope.kartuKeluarga;
	        }
	      }
	    });

	    modalInstance.result.then(function (result) {
	    	$scope.kartuKeluarga.anggotaKk.push(result);
	    },function rejection(error) {
	        return error;
	    });
	    
	  };
	  pc.deleteAnggotaKk = function(anggota, i) {
		console.log(anggota);
		$http.get('api/penduduk/'+anggota.id).then(success, failed);
	     	function success(response) {
	            console.log(response);
	            $scope.kartuKeluarga.anggotaKk.splice(i, 1);
	        }
	        function failed(response) {
	            console.log(response);       
	        }
	  	};
	  	
	 }
	
	 
});

app.controller('ModalInstanceCtrl', function ($http, $scope, $location, $uibModalInstance, data) {
	  var pc = this;
	  console.log(data);
	  $scope.anggotaKk = {
			  kkId:data.kkId
	  };
	  pc.ok = function () {    	  
	    console.log($scope.anggotaKk);
	    $http.post('api/penduduk/insert', $scope.anggotaKk).then(success, failed);
	     	function success(response) {
	            console.log(response);
	            
	            //$location.path("/data-kartu-keluarga");
	        }
	        function failed(response) {
	            console.log(response);       
	        }
	     
	   
	    $uibModalInstance.close($scope.anggotaKk);
	  };

	  pc.cancel = function () {
	    //{...}
	  
	    $uibModalInstance.dismiss('cancel');
	  };
});
