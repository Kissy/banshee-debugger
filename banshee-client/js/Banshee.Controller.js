angular.module('Banshee.Controller', [])
    .controller('HomeController', function($scope) {
    })
    .controller('ObjectsController', function($scope, $timeout, DataService) {
        $scope.objects = DataService.objects;
        $scope.localTimer = getLocalTimerNormalized();
        var timeoutPromise = $timeout(function() {
            $scope.localTimer += UPDATE_STEP;
            DataService.calculateObjectsUpdatesPerSeconds();
            // Schedule for next second
            timeoutPromise = $timeout(arguments.callee, UPDATE_STEP + $scope.localTimer - new Date().getTime());
        }, UPDATE_STEP + $scope.localTimer - new Date().getTime());
        $scope.$on('$routeChangeStart', function (scope, next, current) {
            $timeout.cancel(timeoutPromise);
        });
    })
    .controller('ObjectController', function($scope, $timeout, $routeParams, DataService) {
        $scope.objectId = $routeParams['objectId'];
        $scope.objects = DataService.objects;
        $scope.series = {};
        $scope.localTimer = getLocalTimerNormalized();
        var timeoutPromise = $timeout(function() {
            $scope.localTimer += UPDATE_STEP;
            DataService.calculatePropertiesUpdatesPerSeconds($scope.objectId);
            // Schedule for next second
            timeoutPromise = $timeout(arguments.callee, UPDATE_STEP + $scope.localTimer - new Date().getTime());
        }, UPDATE_STEP + $scope.localTimer - new Date().getTime());
        $scope.$on('$routeChangeStart', function (scope, next, current) {
            $timeout.cancel(timeoutPromise);
        });
    })
    .controller('LogsController', function($scope, DataService) {
        $scope.logs = DataService.logs;
    });

