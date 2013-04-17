angular.module('Banshee.Service', [])
    .factory('WebSocketService', ['$rootScope', function ($rootScope) {
        var socket = new WebSocket("ws://localhost:8080/banshee/ws");
        return {
            on: function (eventName, callback) {
                socket[eventName] = function () {
                    var args = arguments;
                    $rootScope.$apply(function () {
                        callback.apply(socket, args);
                    });
                }
            }
        };

    }])
    .factory('DataService', function($rootScope, WebSocketService) {
        return {
            objects: {},
            init: function () {
                var self = this;
                WebSocketService.on('onopen', function () {
                    console.log("connected");
                });
                WebSocketService.on('onerror', function (error) {
                    console.log(error);
                });
                WebSocketService.on('onmessage', function (event) {
                    var reader = new FileReader();
                    reader['onload'] = function (data) {
                        $rootScope.$apply(function() {
                            self.updateData(data.target.result);
                        });
                    };
                    reader.readAsArrayBuffer(event.data);
                });
            },
            updateData: function(result) {
                var byteBuffer = dcodeIO.ByteBuffer.wrap(result);
                var debugHolderDTO = debugHolderProtoBuilder['DebugHolderProto'].decode(byteBuffer);
                angular.forEach(debugHolderDTO.objects, function (object) {
                    this.updateObject(object);
                }, this);
            },
            updateObject: function (object) {
                if (!this.objects[object['id']]) {
                    this.objects[object['id']] = {
                        properties: {},
                        numberOfProperties: 0,
                        updatesPerSeconds: 0,
                        lastUpdate: 0
                    };
                }

                var currentObject = this.objects[object['id']];

                // All properties
                angular.forEach(object, function(value, key) {
                   if (key == 'properties') {
                       return;
                   }
                   this[key] = value;
                }, currentObject);

                // Entity properties
                angular.forEach(object['properties'], function (property) {
                    var propertyId = property['category'] + '|' + property['key'];
                    if (!this[propertyId]) {
                        this[propertyId] = property;
                        this[propertyId].updatesPerSeconds = 0;
                        this[propertyId].lastUpdate = 0;
                    }
                    this[propertyId]['value'] = property['value'];
                    this[propertyId].updatesPerSeconds = Math.round(1000 / (new Date().getTime() - this[propertyId].lastUpdate));
                    this[propertyId].lastUpdate = new Date().getTime();
                }, currentObject['properties']);

                // Additional properties
                currentObject.numberOfProperties = object['properties'].length;
                currentObject.updatesPerSeconds = Math.round(1000 / (new Date().getTime() - currentObject.lastUpdate));
                currentObject.lastUpdate = new Date().getTime();
            }
        }
    });