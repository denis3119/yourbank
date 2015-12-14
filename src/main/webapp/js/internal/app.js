var App = angular.module('yourbank', [
    'ngRoute'
])
    .config(['$routeProvider', function($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'public/test/layout', controller: 'TestController'
            })
            .otherwise({redirectTo: '/'});
    }]);
