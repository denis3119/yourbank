(function () {

    angular
        .module('yourbank', [
            'ngRoute'
        ])
        .config(['$routeProvider', function($routeProvider) {
            $routeProvider
                .when('/home', {
                    templateUrl: 'public/home/layout', controller: 'HomeController', controllerAs: 'home'
                })
                .when('/login', {
                    templateUrl: 'login/layout', controller: 'LoginController', controllerAs: 'login'
                })
                .when('/profile', {
                    templateUrl: 'profile/layout', controller: 'ProfileController', controllerAs: 'profile'
                })
                .when('/register', {
                    templateUrl: 'register/layout', controller: 'RegisterController', controllerAs: 'register'
                })
                .otherwise({
                    redirectTo: '/home'
                });
        }]);
})();


