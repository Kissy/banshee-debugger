angular.module('Banshee.Directive', ['Banshee.Service'])
    .directive('propertyChart', function(DataService) {
        return {
            replace: true,
            scope: {
                width: '@canvasWidth',
                height: '@canvasHeight',
                objectId: '@'
            },
            template: '<canvas width="{{width}}" height="{{height}}" ></canvas>',
            link: function postLink(scope, iElement, iAttrs) {
                var canvas = iElement[0];
                var chart = new SmoothieChart({
                        grid: {
                            fillStyle: '#ffffff',
                            strokeStyle: '#d4d4d4',
                            verticalSections: 3
                        },
                        labels: {
                            fillStyle:'#555555'
                        }
                    });
                chart.streamTo(canvas, 500);

                iAttrs.$observe('objectId', function(value) {
                    if (!value) {
                        return;
                    }

                    var series = new TimeSeries();
                    chart.addTimeSeries(series, {
                        lineWidth: 1,
                        strokeStyle: '#0088cc',
                        fillStyle: 'rgba(221,221,221,0.47)'
                    });
                    setInterval(function() {
                        series.append(new Date().getTime(), Math.random(), true);
                    }, 1000);
                });
            }
        }
    });