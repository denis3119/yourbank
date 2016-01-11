(function () {

    angular.module('yourbank')
        .controller('CreateRequestController', CreateRequestController);

    function CreateRequestController($http, $location) {
        var vm = this;

        vm.submit = function() {
            $http.post('request/new/add', vm.request).then(function () {
                $location.path('/');
            })
        }
    }
})();

