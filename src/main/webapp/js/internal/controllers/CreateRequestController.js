(function () {

    angular.module('yourbank')
        .controller('CreateRequestController', CreateRequestController);

    function CreateRequestController($http, $location) {
        var vm = this;

        vm.credits = [];

        (function () {
            $http.get('credit/all').then(function (responce) {
                vm.credits = responce.data;
            })
        })();

        vm.submit = function() {
            $http.post('request/new/add', vm.request).then(function () {
                $location.path('/request/new/completed');
            })
        }
    }
})();

