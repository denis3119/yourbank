(function () {

    angular.module('yourbank')
        .controller('EditProfileController', EditProfileController);

    function EditProfileController($scope, $http, growl) {

        $scope.changePassword = function() {
            $http.post('profile/changePassword', $scope.newPassword).then(function () {
                growl.success("Password was updated");
            }).catch(function () {
                growl.error("Wrong password");
            }).finally(function () {
                $scope.newPassword = '';
            })
        }
    }
})();


