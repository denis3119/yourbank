App.controller('LoginController', ['$scope', '$http',
    function($scope, $http) {
        var vm = this;

        vm.submit = function() {
            $http.post('/login', {username: vm.user.username, password: vm.user.password}).then(function (data) {
                console.log(data);
            });
        };
    }
]);
