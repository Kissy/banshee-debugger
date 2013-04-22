angular.module('Banshee', ['Banshee.Controller', 'Banshee.Service', 'Banshee.Directive', 'Banshee.Filter'])
    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.
            when('/objects', {templateUrl: 'html/objects.html', controller: 'ObjectsController'}).
            when('/objects/:objectId', {templateUrl: 'html/object.html', controller: 'ObjectController'}).
            when('/logs', {templateUrl: 'html/logs.html', controller: 'LogsController'}).
            otherwise({redirectTo: '/objects'});
    }])
    .run(function(DataService) {
        DataService.init();
    });