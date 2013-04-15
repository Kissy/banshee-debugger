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
                    self.filterProperties(object);
                    this[object['id']] = object;
                }, this.objects);
                console.log(this.objects);
            },
            filterProperties: function (object) {
                var properties = {};
                object.propertiesLength = object.properties.length;
                angular.forEach(object.properties, function (property) {
                    if (!this[property['category']]) {
                        this[property['category']] = {};
                    }
                    this[property['category']][property['key']] = property['value'];
                }, properties);
                object.properties = properties;
            },
            getObjects: function() {
                return this.objects;
            },
            getObject: function(objectId) {
                return this.objects[objectId];
            }
        }
    });