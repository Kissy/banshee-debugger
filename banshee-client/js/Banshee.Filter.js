angular.module('Banshee.Filter', [])
    .filter('categoryFilter', function() {
        return function(properties) {
            var result = {};
            angular.forEach(properties, function(property) {
                this[property['category']] = true;
            }, result);
            return Object.keys(result);
        };
    })
    .filter('propertyCategoryFilter', function() {
        return function(properties, category){
            if (!category) {
                return properties;
            }

            var result = [];
            angular.forEach(properties, function(property) {
                if (category == property['category']) {
                    this.push(property);
                }
            }, result);
            return result;
        };
    });