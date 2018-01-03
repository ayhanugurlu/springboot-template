'use strict';

angular.module('templateApp').controller('UserController',
    ['UserService', '$scope', '$state', '$window', 'auth', function (UserService, $scope, $state, $window, auth) {

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

            $scope.controller.service.login($scope.loginReg).success(function (data, status, header, config) {
                window.localStorage.setItem(auth.HEADER_STRING, header(auth.HEADER_STRING));
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

        var token = window.localStorage.getItem(auth.HEADER_STRING);

        if (token == null && $state.current.name !== "sign-in" && $state.current.name !== "sign-up") {
            console.log($state.current);
            console.log($state.current);
            console.log($state.current);


            $state.go('sign-in');
        } else if (token != null && $state.current.name !== "sign-in") {
            $state.go('main');
        }

    }


    ]);