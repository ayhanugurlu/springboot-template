(function () {
    'use strict';
    angular.module('templateApp', ['ngRoute', 'ui.router', 'ngAlertify',]);

    angular.module('templateApp').constant('urls', {
        BASE: 'http://localhost:8080/'
    });

    angular.module('templateApp').constant('auth', {HEADER_STRING: 'Authorization'});

    angular.module('templateApp')
        .config([
            '$httpProvider',
            function ($httpProvider) {
                $httpProvider.interceptors.push('tokenInjector');
                $httpProvider.interceptors.push('responseObserver');
            }
        ]);


    angular.module('templateApp')
        .factory('responseObserver', function responseObserver($q, $window) {
            return {
                'responseError': function (errorResponse) {
                    switch (errorResponse.status) {
                        case 403:
                            window.localStorage.removeItem(auth.HEADER_STRING);
                            console.debug('got 403 response from server, will redirect to login');
                            $window.location.href = 'index.html#/sign-in';
                            break;
                    }
                    return $q.reject(errorResponse);
                }
            };
        });

    angular.module('templateApp').factory('tokenInjector', ['$window', 'auth', '$state', 'urls',
        function ($window, auth, $state, urls) {
            return {
                request: function (config) {

                    if(!config.url.startsWith("view/")){
                        var token = window.localStorage.getItem(auth.HEADER_STRING);
                        if (token !== null ) {
                            config.headers[auth.HEADER_STRING] = token;
                        } else {
                            if(config.url !== urls.BASE+'login' || !config.url == urls.BASE+'create'){
                                console.debug('user token missing in local storage, will redirect to login');
                                $window.location.href = 'index.html';
                            }
                        }
                    }


                    return config;
                }
            };
        }
    ]);

})();