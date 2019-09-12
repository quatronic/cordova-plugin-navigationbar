module.exports = {
   
    setUp: function(autoHideNavigationBar, successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            'NavigationBar',
            'setUp',
            [autoHideNavigationBar]
        ); 
    },
    hideNavigationBar: function(successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            'NavigationBar',
            'hideNavigationBar',
            []
        ); 
    },
    reset: function(successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            'NavigationBar',
            'reset',
            []
        ); 
    },
    enableImmersiveSticky: function(successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            'NavigationBar',
            'enableImmersiveSticky',
            []
        ); 
    },
    hideStatusBar: function(successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            'NavigationBar',
            'hideStatusBar',
            []
        ); 
    }
};
