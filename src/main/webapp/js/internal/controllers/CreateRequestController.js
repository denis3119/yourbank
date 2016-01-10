(function () {

    angular.module('yourbank')
        .controller('CreateRequestController', CreateRequestController);

    function CreateRequestController($http, $location) {
        var vm = this;

        vm.submit = function() {
            var fio = vm.request.fio.split(' ');
            vm.request.firstName = fio[1];
            vm.request.lastName = fio[0];
            vm.request.patronymic = fio[2];
            $http.post('request/new/add', vm.request).then(function () {
                $location.path('/');
            })
        }
    }
})();

