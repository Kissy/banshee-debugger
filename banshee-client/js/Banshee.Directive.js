angular.module('Banshee.Directive', [])
    .directive('propertyChart', function() {
        return {
            restrict: 'E',
            replace: true,
            scope: {
                width: '@canvasWidth',
                height: '@canvasHeight',
                series: '=',
                propertiesValue: '='
            },
            template: '<canvas width="{{width}}" height="{{height}}" ></canvas>',
            link: function postLink($scope, iElement, iAttrs) {
                var styles = Object.keys(CHART_LINE_COLORS);
                var chart = new SmoothieChart({
                        maxValueScale: 1.1,
                        scaleSmoothing: 1,
                        grid: {
                            sharpLines: true,
                            fillStyle: '#f5f5f5',
                            strokeStyle: '#e3e3e3',
                            verticalSections: 6
                        },
                        labels: {
                            fillStyle:'#333333'
                        }
                    });
                chart.streamTo(iElement[0], UPDATE_STEP);
                $scope.$watch('propertiesValue', function(newValue, oldValue) {
                    if (!newValue) {
                        return;
                    }
                    angular.forEach(newValue, function(property, property_key) {
                        for (var i = 0; i < property.value.length; i++) {
                            var key = property_key + '_' + i;
                            if (property.plot[i].checked && !this.series[key]) {
                                if (Object.keys(this.series).length >= 6) {
                                    return;
                                }

                                property.plot[i].style = this.styles.pop();
                                this.series[key] = new TimeSeries();
                                chart.addTimeSeries(this.series[key], {
                                    lineWidth: 1,
                                    strokeStyle: CHART_LINE_COLORS[property.plot[i].style]
                                });
                            } else if (!property.plot[i].checked && this.series[key]) {
                                this.styles.push(property.plot[i].style);
                                property.plot[i].style = null;
                                chart.removeTimeSeries(this.series[key]);
                                delete this.series[key];
                                return;
                            }
                            if (this.series[key]) {
                                this.series[key].append(new Date().getTime(), property.value[i], false);
                            }
                        }
                    }, {
                        series: $scope.series,
                        styles: styles
                    });
                }, true);
                $scope.$on('$routeChangeStart', function (scope, next, current) {
                    chart.stop();
                });
            }
        }
    });