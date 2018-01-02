angular.module('templateApp').controller('MainController',
    ['MainService', '$scope','$state', function (MainService, $scope, $state) {

        var self = this;
        $scope.viewModel = new  ViewModelMain();

        self.service = MainService;
        $scope.controller = self;


        function getAllUser() {
            console.log('getAllUser');

            $scope.controller.service.getUsers().success(function (data) {
                $state.go('main');
                $scope.viewModel.userInfos = data.data;
                console.debug("Got response data from server, response message: " + data);

            }).error(function (data, status) {
                alertify.error(data.message);
                console.debug(data.message);
            });
        }

        getAllUser();
    }
    ]);