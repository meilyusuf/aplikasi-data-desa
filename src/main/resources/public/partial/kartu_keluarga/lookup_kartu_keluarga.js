var app = angular.module('appLookupKartuKeluargaController', ['ui.router', 'ngAnimate', 'ngSanitize', 'ui.bootstrap']);

app.controller('LookupKartuKeluargaController', function($http, $scope, $location, myFactory,  $uibModal) {
	
	$scope.kartuKeluarga = myFactory.get();
	console.log($scope.kartuKeluarga);		
	 var pc = this;
	  pc.open = function (size, anggota) {
		  if(anggota != 0) {
			  var anggotaKk = {
					  	kkId: $scope.kartuKeluarga.kkId,		       			
		       			nama: anggota.nama,
		       			id: anggota.id,
		       			noNik: anggota.noNik,
		       			pekerjaan: anggota.pekerjaan,
		       			status: anggota.status,
		       			tanggalLahir: anggota.tanggalLahir,
		       			tempatLahir: anggota.tempatLahir
		       			};
		  } else {
			  var anggotaKk = {
					  	kkId: $scope.kartuKeluarga.kkId,		       			
		       			};
		  }
		  
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
	        	return anggotaKk; 	        	
	        }
	      }
	    });

	    modalInstance.result.then(function (result) {
	    	if($scope.kartuKeluarga.anggotaKk.find(x => x.id === result.id)) {
	    		$scope.kartuKeluarga.anggotaKk.splice(getAnggotaKkById(result.id), 1);
	    	}	    	
	    	$scope.kartuKeluarga.anggotaKk.push(result);
	    },function rejection(error) {
	        return error;
	    });
	    
	  };
	  
	  pc.deleteAnggotaKk = function(anggota, i) {
		console.log(anggota);
		$http.get('api/penduduk/delete/'+anggota.id).then(success, failed);
	     	function success(response) {
	            console.log(response);
	            $scope.kartuKeluarga.anggotaKk.splice(i, 1);
	        }
	        function failed(response) {
	            console.log(response);       
	        }
	  };
	  	
	  function getAnggotaKkById(id){
		  return $scope.kartuKeluarga.anggotaKk.filter(x => x.id === id);
	  }

	
	 
});

app.controller('ModalInstanceCtrl', function ($http, $scope, $location, $uibModalInstance, data) {
	  var pc = this;
		  $scope.anggotaKk = {
				  	kkId: data.kkId,
				  	nama: data.nama,
	       			id: data.id,
	       			noNik: data.noNik,
	       			pekerjaan: data.pekerjaan,
	       			status: data.status,
	       			tanggalLahir: data.tanggalLahir,
	       			tempatLahir: data.tempatLahir
		  };	  
	  	  
	  pc.ok = function () {    	  
	    console.log($scope.anggotaKk);
	    $http.post('api/penduduk/insert', $scope.anggotaKk).then(success, failed);
	     	function success(response) {
	            console.log(response);	            	           
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
