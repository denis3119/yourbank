(function () {

    angular.module('yourbank')
        .controller('GlobalController', GlobalController);

    function GlobalController(CurrentUser) {
        var vm = this;

        vm.current = CurrentUser.current;

        vm.hasAnyRole = function(roles) {
            return vm.current.user ? _(vm.current.user.userRole).pluck('role').intersection(roles).value().length : false;
        }
    }
})();

