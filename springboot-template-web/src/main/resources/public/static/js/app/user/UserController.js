'use strict';

angular.module('templateApp').controller('UserController',
    ['UserService', '$scope','$state','$window', function (UserService, $scope, $state,$window) {

        var self = this;



        $scope.loginReg = new LoginReq();
        $scope.signUpReq = new CreateUserReq();




        self.login = login;
        self.sigup = sigup;
        self.service = UserService;
        $scope.controller = self;


        function login() {
            console.log('login');
            console.log($scope.loginReg);
            $scope.controller.service.login($scope.loginReg).success(function (data, status, headers, config) {
                window.localStorage.setItem('token', data.token);
                window.localStorage.setItem('username', $scope.loginReq.username);
                $state.go('main');
                console.debug("Got response data from server, response message: " + data);

            }).error(function (data, status) {
                alertify.error(data.message);
                console.debug(data.message);
            });
        }


        function sigup() {
            console.log('sigup');
            console.log($scope.signUpReq);
            $scope.controller.service.signUp($scope.signUpReq).success(function (data) {
                console.debug("Got response data from server, response message: " + data);
                $state.go('sign-in');

            }).error(function (data, status) {
                alertify.error(data.message);
                console.debug(data.message);
            });
        }


        function createUser() {
            console.log('About to create user');
        }

        function getAllUsers() {
            console.log('About to getAllUsers');
        }

        console.log($state.current);

        if($state.current.name.length == 0){
            $state.go('sign-in');
        }

    }


    ]);