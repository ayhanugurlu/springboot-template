'use strict';

angular.module('templateApp').factory('UserService',
    [ '$http', 'urls',
        function ($http, urls) {

            this.http = $http;

            this.login = function (loginRequest) {
                console.debug("login request");
                var req = {
                    method: 'POST',
                    url: urls.BASE+"login",
                    data: loginRequest
                };
                return this.http(req);
            };

            return this;
        }
    ]);