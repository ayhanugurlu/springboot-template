'use strict';

angular.module('templateApp').controller('UserController',
    ['UserService', '$scope',  function( UserService, $scope) {

        var self = this;
        $scope.loginReg = new LoginReq();
        self.login = login;
        self.service = UserService;
        $scope.controller = self;

        console.log('load');


        function login() {
            console.log('login');
            console.log($scope.loginReg);
            $scope.controller.service.login($scope.loginReg ).success(function (data) {
                console.debug("Got response data from server, response message: " + data);

            }).error(function (data, status) {
                var errorMessage = 'Unable to load login, data: ' + data + ' status: ' + status;
                console.debug(errorMessage);
            });

        }

        function createUser() {
            console.log('About to create user');
        }

        function getAllUsers(){
            console.log('About to getAllUsers');
        }

    }


    ]);