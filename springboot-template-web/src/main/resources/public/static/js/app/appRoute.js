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
                    templateUrl: "view/main/welcome.html"
                })
                // login
                .state('sign-up', {
                    url: "/sign-up",
                    templateUrl: "view/user/sign-up.html"
                })
                .state('sign-in', {
                    url: "/sign-in",
                    templateUrl: "view/user/sign-in.html"
                });


        });

})();
