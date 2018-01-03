angular.module('templateApp').controller('MainController',
    ['MainService', '$scope','$state','$window','auth', function (MainService, $scope, $state,$window,auth) {

        var self = this;
        $scope.viewModel = new  ViewModelMain();

        self.service = MainService;
        self.logout = logout;
        $scope.controller = self;


        function getAllUser() {
            console.log('getAllUser');

            $scope.controller.service.getUsers().success(function (data) {
                $scope.viewModel.userInfos = data;
                console.debug("Got response data from server, response message: " + data);

            }).error(function (data, status) {
                alertify.error(data.message);
                console.debug(data.message);
            });
        };


        function logout() {
            console.log('logout');
            window.localStorage.removeItem(auth.HEADER_STRING);
            $state.go('sign-in');

        };

        getAllUser();
    }
    ]);