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
                var self = this;
                var byteBuffer = dcodeIO.ByteBuffer.wrap(result);
                var debugHolderDTO = debugHolderProtoBuilder['DebugHolderProto'].decode(byteBuffer);
                angular.forEach(debugHolderDTO.objects, function (object) {
                    self.updateObject(object);
                });
            },
            updateObject: function (object) {
                if (!this.objects[object['id']]) {
                    this.objects[object['id']] = {};
                }
                var currentObject = this.objects[object['id']];
                if (!currentObject.properties) {
                    currentObject.properties = {};
                }

                // All properties
                angular.forEach(object, function(value, key) {
                   if (key == 'properties') {
                       return;
                   }
                   currentObject[key] = value;
                });

                // Entity properties
                angular.forEach(object.properties, function (property) {
                    if (!this[property['category']]) {
                        this[property['category']] = {};
                    }
                    this[property['category']][property['key']] = property['value'];
                }, currentObject.properties);

                // Additional properties
                currentObject.numberOfProperties = object.properties.length;
                currentObject.updatesPerSeconds = 0;
            },
            getObjects: function() {
                return this.objects;
            }
        }
    });