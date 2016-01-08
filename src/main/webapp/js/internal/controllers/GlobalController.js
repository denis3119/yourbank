(function () {

    angular.module('yourbank')
        .controller('GlobalController', GlobalController);

    function GlobalController(CurrentUser) {
        var vm = this;

        vm.current = CurrentUser.current;
    }
})();

