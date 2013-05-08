var UPDATE_STEP = 200;
var LAST_UPDATES_COUNT = 1000 / UPDATE_STEP;

/**
 * Get the local timer normalized.
 *
 * @return {Number} The local timer normalized.
 */
function getLocalTimerNormalized() {
    return Math.floor(new Date().getTime() / 1000) * 1000;
}