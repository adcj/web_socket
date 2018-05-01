'use strict';

/*
 * Utility Functions: These methods acts as tools which provides support to
 * redundant tasks all across the application.
 */

angular.module('ngUtil', []).
factory('util', function ($log, $rootScope, appConfig) {
    return {
        printAppVersion: function () {
            console.log(appConfig.appVersion);
        }
    };
});
