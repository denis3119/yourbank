(function () {

    angular.module('yourbank')
        .controller('ProfileController', ProfileController);

    function ProfileController(CurrentUser) {
        var vm = this;

        vm.view = 'general';
        vm.editUser = function(){
            console.log(CurrentUser.current.user);

        }
    }
})();


