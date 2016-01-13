(function () {

    angular.module('yourbank')
        .controller('ManagerController', ManagerController);

    function ManagerController($http) {
        var vm = this;

        vm.requests = [];

        (function () {
            $http.get('request/all').then(function (data) {
                vm.requests = data.data;
            })
        })();

        vm.approve = function(request) {
            $http.post('request/approve', request).then(function (responce) {
                _.extend(_.find(vm.requests, function (elem) {
                    return elem.id == responce.data.id;
                }), responce.data);
            });
        };

        vm.decline = function(request) {
            $http.post('request/decline', request).then(function (responce) {
                _.extend(_.find(vm.requests, function (elem) {
                    return elem.id == responce.data.id;
                }), responce.data);
            });
        };
    }
})();
