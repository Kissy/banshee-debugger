var ObjectsController = function($scope, bansheeData) {
    $scope.objects = bansheeData.getObjects();
};
var ObjectController = function($scope, $routeParams, bansheeData) {
    var objectId = $routeParams['objectId'];
    $scope.object = bansheeData.getObject(objectId);
};