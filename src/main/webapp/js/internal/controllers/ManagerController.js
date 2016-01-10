(function () {

    angular.module('yourbank')
        .controller('ManagerController', ManagerController);

    function ManagerController($http) {
        var vm = this;

        vm.requests = {};

        (function () {
            $http.get('request/all').then(function (data) {
                vm.requests = data;
            })
        })();

        vm.approve = function() {

        };

        vm.decline = function() {

        };
    }
})();
