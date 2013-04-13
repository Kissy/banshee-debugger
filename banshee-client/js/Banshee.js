angular.module('Banshee', ['Banshee.Service'])
    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.
            when('/objects', {templateUrl: 'html/objects.html', controller: ObjectsController}).
            when('/objects/:objectId', {templateUrl: 'html/object.html', controller: ObjectController}).
            otherwise({redirectTo: '/objects'});
    }])
    .run(function(bansheeData) {
        bansheeData.init();
    });