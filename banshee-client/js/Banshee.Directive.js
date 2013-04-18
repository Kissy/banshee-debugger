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
                    angular.forEach(newValue, function(property, key) {
                        if (property['plot'] && !this[key]) {
                            this[key] = new TimeSeries();
                            chart.addTimeSeries(this[key], {
                                lineWidth: 1,
                                strokeStyle: '#0088cc',
                                fillStyle: 'rgba(221,221,221,0.5)'
                            });
                        } else if (!property['plot'] && this[key]) {
                            chart.removeTimeSeries(this[key]);
                            delete this[key];
                        }
                        if (this[key]) {
                            this[key].append(property['lastUpdate'], property['value'], false);
                        }
                    }, series);
                }, true);
            }
        }
    });