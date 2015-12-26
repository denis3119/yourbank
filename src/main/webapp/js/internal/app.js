var App = angular.module('yourbank', [
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
            .when('/register', {
                templateUrl: 'register/layout', controller: 'RegisterController', controllerAs: 'register'
            })
            .otherwise({
                redirectTo: '/home'
            });
    }]);
