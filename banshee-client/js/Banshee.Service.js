angular.module('Banshee.Service', []).
    factory('bansheeData', function($rootScope) {
        return {
            objects: {},
            init: function () {
                var self = this;
                this.socket = new WebSocket("ws://localhost:8080/banshee/ws");
                this.socket.onopen = function () {
                    console.log("connected");
                };
                this.socket.onclose = function () {
                    console.log("onclose");
                };
                this.socket.onerror = function (error) {
                    console.log(error);
                };
                this.socket.onmessage = function (event) {
                    var reader = new FileReader();
                    reader.onload = function (data) {
                        var byteBuffer = dcodeIO.ByteBuffer.wrap(data.target.result);
                        var debugHolderDTO = debugHolderProtoBuilder['DebugHolderProto'].decode(byteBuffer);
                        self.updateData(debugHolderDTO.objects);
                    };
                    reader.readAsArrayBuffer(event.data);
                };
            },
            updateData: function(objects) {
                var self = this;
                angular.forEach(objects, function (object) {
                    self.filterProperties(object);
                    this[object['id']] = object;
                }, this.objects);
                console.log(this.objects);
                $rootScope.$digest();
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