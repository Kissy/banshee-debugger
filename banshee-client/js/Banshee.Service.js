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
            logs: {},
            init: function () {
                var self = this;
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
                var debugDTO = debugProtoBuilder['DebugProto'].decode(byteBuffer);
                angular.forEach(debugDTO.entities, this.updateEntity, this);
            },
            updateEntity: function (entity) {
                var entityId = entity['id'];
                if (!this.objects[entityId]) {
                    this.objects[entityId] = {
                        id: entityId,
                        properties: {},
                        numberOfProperties: 0,
                        updatesPerSeconds: 0,
                        lastUpdate: 0
                    };
                }

                var currentObject = this.objects[entityId];
                currentObject.name = entity.name;
                currentObject.category = entity.category;

                // Entity properties
                angular.forEach(entity.properties, this.updateEntityProperties, {
                    self: this,
                    properties: currentObject.properties
                });

                // Additional properties
                currentObject.numberOfProperties = entity.properties.length;
                currentObject.updatesPerSeconds = Math.round(1000 / (new Date().getTime() - currentObject.lastUpdate));
                currentObject.lastUpdate = new Date().getTime();
            },
            updateEntityProperties: function (propertyGroup) {
                angular.forEach(propertyGroup.properties, this.self.updateEntityPropertyCategory, {
                    self: this.self,
                    category: propertyGroup.category,
                    properties: this.properties
                });
            },
            updateEntityPropertyCategory: function(property) {
                var propertyId = this.category + '|' + property.name;
                if (!this.properties[propertyId]) {
                    this.properties[propertyId] = {
                        name: property.name,
                        updatesPerSeconds: 0,
                        lastUpdate: 0
                    };
                }
                console.log(property.value);
                this.properties[propertyId].value = property.value;
                this.properties[propertyId].category = this.category;
                this.properties[propertyId].updatesPerSeconds = Math.round(1000 / (new Date().getTime() - this.properties[propertyId].lastUpdate));
                this.properties[propertyId].lastUpdate = new Date().getTime();
            }
        }
    });