(function () {

    angular.module('yourbank')
        .controller('LoginController', LoginController);
    
    function LoginController($routeParams) {
        var vm = this;

        vm.showError = $routeParams.error;
    }
})();
