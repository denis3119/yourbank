(function () {

    angular.module('yourbank')
        .controller('CreateCreditController', CreateCreditController);

    function CreateCreditController($scope, CurrentUser) {
        $scope.credit.user = CurrentUser.current.user;
    }
})();

