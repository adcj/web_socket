'use strict';

function NotificationController($scope, $rootScope, $location, $timeout, webSocket, appConstant) {
    $scope.message = '';
    $scope.counter = 0;

    init();

    /*
     * Function: init
     * init (initialize) method: first method to be executed on controller load. 
     */
    function init() {
        webSocket.connect();
    }

    $scope.$on('$newMessage', function (e) {
        $scope.$apply(function () {
            $scope.message = appConstant.message;
			
			mytimeout = $timeout($scope.onTimeout, 10000);
        });
    });
    
    $scope.onTimeout = function(){
        $scope.message = '';
    }
    
    var mytimeout = $timeout($scope.onTimeout, 10000);

    $scope.stop = function(){
        $timeout.cancel(mytimeout);
    }
}
