angular.module('Banshee.Directive', [])
    .directive('propertyChart', function() {
        return {
            restrict: 'E',
            replace: true,
            scope: {
                width: '@canvasWidth',
                height: '@canvasHeight',
                propertiesValue: '='
            },
            template: '<canvas width="{{width}}" height="{{height}}" ></canvas>',
            link: function postLink($scope, iElement, iAttrs) {
                var series = {};
                var chart = new SmoothieChart({
                        scaleSmoothing: 1,
                        interpolation:'linear',
                        grid: {
                            sharpLines:true,
                            fillStyle: '#f5f5f5',
                            strokeStyle: '#e3e3e3',
                            verticalSections: 6
                        },
                        labels: {
                            fillStyle:'#333333'
                        }
                    });
                chart.streamTo(iElement[0], 0);
                $scope.$watch('propertiesValue', function(newValue, oldValue) {
                    if (!newValue) {
                        return;
                    }
                    angular.forEach(newValue, function(property, property_key) {
                        for (var i = 0; i < property.value.length; i++) {
                            var key = property_key + '_' + i;
                            if (property.plot[i] && !this[key]) {
                                this[key] = new TimeSeries();
                                chart.addTimeSeries(this[key], {
                                    lineWidth: 1,
                                    strokeStyle: '#0088cc',
                                    fillStyle: 'rgba(221,221,221,0.5)'
                                });
                            } else if (!property.plot[i] && this[key]) {
                                chart.removeTimeSeries(this[key]);
                                delete this[key];
                                return;
                            }
                            if (this[key]) {
                                this[key].append(new Date().getTime(), property.value[i], false);
                            }
                        }
                    }, series);
                }, true);
                $scope.$on('$routeChangeStart', function (scope, next, current) {
                    chart.stop();
                });
            }
        }
    });