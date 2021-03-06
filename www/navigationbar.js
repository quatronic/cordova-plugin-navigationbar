module.exports = {
   
    autoHide: function(enableImmersiveSticky, hideStatusBar, successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            'NavigationBar',
            'autoHide',
            [enableImmersiveSticky, hideStatusBar]
        ); 
    },
    hideNavigationBar: function(enableImmersiveSticky, hideStatusBar, successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            'NavigationBar',
            'hideNavigationBar',
            [enableImmersiveSticky,hideStatusBar]
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
    },
    showStatusAndNavBars: function(successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            'NavigationBar',
            'showStatusAndNavBars',
            []
        ); 
    }
};
