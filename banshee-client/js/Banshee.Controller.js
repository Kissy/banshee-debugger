angular.module('Banshee.Controller', [])
    .controller('HomeController', function($scope) {
    })
    .controller('ObjectsController', function($scope, $timeout, DataService) {
        $scope.objects = DataService.objects;
        $scope.localTimer = getLocalTimerNormalized();
        $timeout(function() {
            $scope.localTimer += UPDATE_STEP;
            DataService.calculateObjectsUpdatesPerSeconds();
            // Schedule for next second
            $timeout(arguments.callee, UPDATE_STEP + $scope.localTimer - new Date().getTime());
        }, UPDATE_STEP + $scope.localTimer - new Date().getTime());
    })
    .controller('ObjectController', function($scope, $timeout, $routeParams, DataService) {
        $scope.objectId = $routeParams['objectId'];
        $scope.objects = DataService.objects;
        $scope.localTimer = getLocalTimerNormalized();
        $timeout(function() {
            $scope.localTimer += UPDATE_STEP;
            DataService.calculatePropertiesUpdatesPerSeconds($scope.objectId);
            // Schedule for next second
            $timeout(arguments.callee, UPDATE_STEP + $scope.localTimer - new Date().getTime());
        }, UPDATE_STEP + $scope.localTimer - new Date().getTime());
    })
    .controller('LogsController', function($scope, DataService) {
        $scope.logs = DataService.logs;
    });

