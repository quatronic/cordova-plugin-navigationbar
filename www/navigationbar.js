module.exports = {
   
    setUp: function(autoHideNavigationBar, enableImmersiveSticky, successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            'NavigationBar',
            'setUp',
            [autoHideNavigationBar, enableImmersiveSticky]
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
