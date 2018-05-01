'use strict';

angular.module('ngWebSocket', []).
factory('webSocket', function ($log, $rootScope, appConstant) {
    return {
        connect: function () {
            var socket = new SockJS(appConstant.webSocketBaseUrl);
            var stompClient = Stomp.over(socket);

            stompClient.connect({}, function (frame) {
                stompClient.subscribe("/newmsg", function (message) {
                    appConstant.message = message.body;
                    
                    $rootScope.$broadcast('$newMessage');
                });
            }, function (error) {
                alert("STOMP error " + error);
            });
        }
    };
});
