(function () {

    angular.module('yourbank')
        .controller('ManagerController', ManagerController);

    function ManagerController($http) {
        var vm = this;

        vm.requests = {};

        (function () {
            $http.get('request/all').then(function (data) {
                vm.requests = data.data;
            })
        })();

        vm.approve = function(request) {
            request.status = 'success';
        };

        vm.decline = function(request) {
            request.status = 'danger';
        };
    }
})();
