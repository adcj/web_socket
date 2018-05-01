'use strict';

/* App Module */
/*
 * Application Main Module - Angular initializes from here
 *
 */
angular.module('ngApp', ['ngRoute', 'ngUtil', 'ngWebSocket']).
    /*
     * Config	: Application configurations, like partials (html DIV blocks) and their 
     *            respective controllers, etc.
     */
config(function ($routeProvider, $locationProvider) {
        $locationProvider.hashPrefix('!');
        $routeProvider.
        when('/home', {
            templateUrl: 'partials/home.html',
            controller: NotificationController
        }).
        otherwise({
            redirectTo: '/home'
        });
    }).
    /*
     * Run: Runtime configurations for the application, event handlers
     *
     */
run(function ($rootScope, $location, $log) {

    }).
    /*
     * Constant	: Application constants, global across the entire
     *            application and it's supporting modules
     */
constant('appConstant', {
    appVersion: '1.0.0',
    webSocketBaseUrl: 'http://localhost:8080/DPP/socket',
    message: ''
});
