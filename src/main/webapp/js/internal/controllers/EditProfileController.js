(function () {

    angular.module('yourbank')
        .controller('EditProfileController', EditProfileController);

    function EditProfileController($scope, $http, growl) {

        $scope.changePassword = function() {
            $http.post('profile/changePassword', $scope.newPassword).then(function () {
                $scope.newPassword = '';
                growl.success("Password was updated");
            })
        }
    }
})();


