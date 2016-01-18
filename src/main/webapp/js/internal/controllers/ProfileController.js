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
                    $http.post('user/update', {userId: result.id, phone: result.phone, email: result.email}).then(function() {
                        CurrentUser.updateUser();
                        growl.success('Data was updated');
                    })
                });

        };

        vm.deposit = function() {
            $uibModal.open({
                scope: _.extend($rootScope.$new(), {score: CurrentUser.current.user.userProfile.score}),
                backdrop: 'static',
                controller: 'DepositController',
                templateUrl: 'profile/score/layout'
            }).result.then(function(value) {
                    $http.post('score/refill', {value: value.test}).then(function() {
                        CurrentUser.updateUser();
                        growl.success('Success');
                    });
                });
        };

        vm.pay = function(credit, accural) {
            $http.post('score/pay/', {sum: 0, credit: credit, accrual:credit.accruals[credit.accruals.length - 1]}).then(function () {
                growl.success('Success');
            })
        };
    }
})();


