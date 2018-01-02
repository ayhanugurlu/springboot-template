(function () {
    'use strict';

    angular
        .module('templateApp')
        .config(function ($urlRouterProvider, $stateProvider) {

            // set states
            $stateProvider
                // MAIN
                .state('main', {
                    url: "/welcome",
                    templateUrl: "main/welcome.html"
                })
                // login
                .state('sign-up', {
                    url: "/sign-up",
                    templateUrl: "user/sign-up.html"
                })
                .state('sign-in', {
                    url: "/sign-in",
                    templateUrl: "user/sign-in.html"
                });


        });

})();
