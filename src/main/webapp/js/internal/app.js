(function () {

    angular
        .module('yourbank', [
            'ngRoute',
            'ui.bootstrap',
            'ui.mask'
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
                .when('/request/new', {
                    templateUrl: 'request/new/layout', controller: 'CreateRequestController', controllerAs: 'request'
                })
                .when('/request/new/completed', {
                    templateUrl: 'request/new/completed/layout'
                })
                .when('/manager', {
                    templateUrl: 'manager/layout', controller: 'ManagerController', controllerAs: 'manager'
                })
                .when('/admin', {
                    templateUrl: 'admin/layout', controller: 'AdminController', controllerAs: 'admin'
                })
                .otherwise({
                    redirectTo: '/home'
                });
        }]);
})();


