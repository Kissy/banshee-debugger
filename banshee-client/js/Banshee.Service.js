angular.module('Banshee.Service', [])
    .factory('WebSocketService', ['$rootScope', function ($rootScope) {
        var socket = new WebSocket("ws://kissy.synology.me:26900/banshee/ws");
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
                        updatesPerSeconds: 0,
                        currentUpdate: 0,
                        lastUpdates: {}
                    };
                    // Init last updates
                    for (var i = 0; i < LAST_UPDATES_COUNT; i++) {
                        this.objects[entityId].lastUpdates[i] = 0;
                    }
                }

                var currentObject = this.objects[entityId];
                currentObject.name = entity.name;
                currentObject.category = entity.category;
                currentObject.lastUpdates[currentObject.currentUpdate]++;

                // Entity properties
                angular.forEach(entity.properties, this.updateEntityProperties, {
                    self: this,
                    object: currentObject
                });
            },
            updateEntityProperties: function (propertyGroup) {
                angular.forEach(propertyGroup.properties, this.self.updateEntityPropertyCategory, {
                    self: this.self,
                    object: this.object,
                    category: propertyGroup.category
                });
            },
            updateEntityPropertyCategory: function(property) {
                var propertyId = this.object.category + '|' + property.name;
                if (!this.object.properties[propertyId]) {
                    this.object.properties[propertyId] = {
                        name: property.name,
                        updatesPerSeconds: 0,
                        currentUpdate: 0,
                        lastUpdates: {},
                        plot: {}
                    };
                    var i;
                    // Init last updates
                    for (i = 0; i < LAST_UPDATES_COUNT; i++) {
                        this.object.properties[propertyId].lastUpdates[i] = 0;
                    }
                    // Init plot
                    for (i = 0; i < property.value.length; i++) {
                        this.object.properties[propertyId].plot[i] = {
                            style: null,
                            checked: false
                        };
                    }
                }
                this.object.properties[propertyId].value = property.value;
                this.object.properties[propertyId].category = this.object.category;
                this.object.properties[propertyId].lastUpdates[this.object.properties[propertyId].currentUpdate]++;
            },
            calculateObjectsUpdatesPerSeconds: function() {
                angular.forEach(this.objects, this.calculateUpdatesPerSeconds, this);
            },
            calculatePropertiesUpdatesPerSeconds: function(objectId) {
                if (!this.objects[objectId]) {
                    return;
                }
                angular.forEach(this.objects[objectId].properties, this.calculateUpdatesPerSeconds, this);
            },
            calculateUpdatesPerSeconds: function(object) {
                var newUpdatesPerSeconds = 0;
                for (var i = 0; i < LAST_UPDATES_COUNT; i++) {
                    newUpdatesPerSeconds += object.lastUpdates[object.currentUpdate];
                }
                object.updatesPerSeconds = newUpdatesPerSeconds;
                object.lastUpdates[object.currentUpdate] = 0;
                if (++object.currentUpdate >= LAST_UPDATES_COUNT) {
                    object.currentUpdate = 0;
                }
            }
        }
    });