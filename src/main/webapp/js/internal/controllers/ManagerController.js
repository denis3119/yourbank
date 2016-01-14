(function () {

    angular.module('yourbank')
        .controller('ManagerController', ManagerController);

    function ManagerController($http, $rootScope, $uibModal) {
        var vm = this;

        vm.requests = [];

        vm.initData = function() {
            $http.get('request/all').then(function (data) {
                vm.requests = data.data;
            })
        };

        vm.initData();

        vm.approve = function(request) {
            vm.busy = $http.post('request/approve', request).then(function (responce) {
                _.extend(_.find(vm.requests, function (elem) {
                    return elem.id == responce.data.id;
                }), responce.data);
            });
        };

        vm.decline = function(request) {
            vm.busy = $http.post('request/decline', request).then(function (responce) {
                _.extend(_.find(vm.requests, function (elem) {
                    return elem.id == responce.data.id;
                }), responce.data);
            });
        };

        vm.createCredit = function(request) {
            $uibModal.open({
                scope: _.extend($rootScope.$new(), {credit: request}),
                controller: 'CreateCreditController',
                size: 'lg',
                templateUrl: 'credit/new/layout'
            }).result.then(function (result) {
                    $http.post('credit/approve/' + request.id, result).then(function (responce) {
                        _.extend(_.find(vm.requests, function (elem) {
                            return elem.id == responce.data.id;
                        }), responce.data);
                    }).then(vm.initData);
                });
        }
    }
})();
