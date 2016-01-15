(function () {

    angular.module('yourbank')
        .controller('ProfileController', ProfileController);

    function ProfileController($rootScope, $uibModal, CurrentUser) {
        var vm = this;

        vm.view = 'general';
        vm.editUser = function(){
            $uibModal.open({
                scope: _.extend($rootScope.$new(), {user: CurrentUser.current.user}),
                backdrop: 'static',
                size: 'lg',
                controller: 'EditProfileController',
                templateUrl: 'profile/edit/layout'
            }).result.then(function (result) {
                    console.log(CurrentUser.current.user);
                });

        }
    }
})();


