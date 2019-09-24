var app = angular.module('appLookupKartuKeluargaController', ['ui.router', 'ngAnimate', 'ngSanitize', 'ui.bootstrap']);

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
