var app = angular.module('KartuKeluargaController', ['ui.router', 'ngAnimate', 'ngSanitize', 'ui.bootstrap']);

app.controller('DataKartuKeluargaController', 
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

app.controller('InputKartuKeluargaController', function($http, $scope, $window) {

    $scope.kartuKeluarga = {
        alamatDesa: null,
        desa : 'BUGO',
        availableOptions: [
          {id: '1', name: 'Ngancar RT: 1/ RW: 1'},
          {id: '2', name: 'Penjalin RT: 2/ RW: 1'},
          {id: '3', name: 'Tambak RT:3/ RW:1'},
          {id: '4', name: 'Kamandawa RT: 4/ RW: 1'},
          {id: '5', name: 'Gajah RT: 1/RW: 2'},
          {id: '6', name: 'Mintorogo RT: 2/RW: 2'},
          {id: '7', name: 'Pondok RT: 3/RW: 2'},
          {id: '8', name: 'KarangPanas RT: 4/RW: 2'}
        ]
       };

       $scope.simpanKartuKeluarga = function() {
    	   console.log($scope.kartuKeluarga);
        $http.post('/api/kartuKeluarga/insertKk', $scope.kartuKeluarga).then(success, failed);
        function success(response) {
            console.log(response);
            $window.location.reload();
        }
        function failed(response) {
            console.log(response);       
        }
    }
      
});

app.controller('LookupKartuKeluargaController', function($http, $scope, $location, myFactory,  $uibModal) {
	
	$scope.KartuKeluarga = myFactory.get();
	console.log($scope.KartuKeluarga);
	
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
	          return pc.data;
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
	  pc.data = data;
	  
	  pc.ok = function () {
	    //{...}
	   
	    $uibModalInstance.close();
	  };

	  pc.cancel = function () {
	    //{...}
	  
	    $uibModalInstance.dismiss('cancel');
	  };
});