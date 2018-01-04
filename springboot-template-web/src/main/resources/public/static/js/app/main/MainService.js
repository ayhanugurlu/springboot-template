'use strict';

angular.module('templateApp').factory('MainService',
    [ '$http', 'urls',
        function ($http, urls) {

            this.http = $http;

            this.getUsers = function () {
                console.debug("get users");
                var req = {
                    method: 'GET',
                    url: "/infos"
                };
                return this.http(req);
            };

            return this;
        }
    ]);