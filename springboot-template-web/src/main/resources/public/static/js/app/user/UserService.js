'use strict';

angular.module('templateApp').factory('UserService',
    [ '$http', 'urls',
        function ($http, urls) {

            this.http = $http;

            this.login = function (loginRequest) {
                console.debug("login request");
                var req = {
                    method: 'POST',
                    url: "/login",
                    data: loginRequest
                };
                return this.http(req);
            };

            this.signUp = function (signUpRequest) {
                console.debug("login request");
                var req = {
                    method: 'POST',
                    url: "/sign-up",
                    data: signUpRequest
                };
                return this.http(req);
            };

            return this;
        }
    ]);