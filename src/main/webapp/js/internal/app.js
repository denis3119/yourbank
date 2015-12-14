var App = angular.module('yourbank', [
    'ngRoute'
])
    .config(['$routeProvider', function($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'public/test/layout', controller: 'TestController'
            })
            .when('/public/home/', {
                templateUrl: 'public/home/layout', controller: 'HomeController'
            })
            .otherwise({redirectTo: '/'});
    }]);
