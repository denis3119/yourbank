(function () {

    angular.module('yourbank')
        .service('CurrentUser', CurrentUserService);

    function CurrentUserService($http) {
        var self = this;

        self.current = {};

        this.updateUser = function () {
            $http.get("account/current").success(function (data) {
                self.current.user = data;
            });
        };

        self.updateUser();
    }
})();


