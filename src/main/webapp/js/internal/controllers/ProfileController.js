(function () {

    angular.module('yourbank')
        .controller('ProfileController', ProfileController);

    function ProfileController() {
        var vm = this;

        vm.view = 'general';
    }
})();


