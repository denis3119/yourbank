(function () {

    angular.module('yourbank')
        .controller('ProfileController', ProfileController);

    function ProfileController($rootScope, $uibModal, $http, CurrentUser, growl) {
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
                    $http.post('', result).then(function() {
                        CurrentUser.updateUser();
                        growl.success('Data was updated');
                    })
                });

        }
    }
})();


