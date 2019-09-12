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
    hideNavigationBar: function(enableImmersiveSticky, successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            'NavigationBar',
            'hideNavigationBar',
            [enableImmersiveSticky]
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
    hideStatusBar: function(successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            'NavigationBar',
            'hideStatusBar',
            []
        ); 
    },
    dimStatusAndNavBars: function(successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            'NavigationBar',
            'dimStatusAndNavBars',
            []
        ); 
    }
};
