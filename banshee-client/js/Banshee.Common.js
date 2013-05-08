var UPDATE_STEP = 200;
var LAST_UPDATES_COUNT = 1000 / UPDATE_STEP;
var CHART_LINE_COLORS = {
    'label': '#999999',
    'label label-success': '#468847',
    'label label-warning': '#f89406',
    'label label-important': '#b94a48',
    'label label-info': '#3a87ad',
    'label label-inverse': '#333333'
};

/**
 * Get the local timer normalized.
 *
 * @return {Number} The local timer normalized.
 */
function getLocalTimerNormalized() {
    return Math.floor(new Date().getTime() / 1000) * 1000;
}