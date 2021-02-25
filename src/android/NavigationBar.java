//Copyright (c) 2014 Sang Ki Kwon (Cranberrygame)
//Email: cranberrygame@yahoo.com
//Homepage: http://www.github.com/cranberrygame
//License: MIT (http://opensource.org/licenses/MIT)
package com.cranberrygame.cordova.plugin.navigationbar;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActionBar;
import android.os.Build;
import android.util.Log;
//
import android.view.View;
import android.os.Handler;
//
import java.lang.reflect.Method;

public class NavigationBar extends CordovaPlugin {
	private static final String LOG_TAG = "NavigationBar";

	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);

	}

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		PluginResult result = null;

		// args.length()
		// args.getString(0)
		// args.getString(1)
		// args.getInt(0)
		// args.getInt(1)
		// args.getBoolean(0)
		// args.getBoolean(1)
		// JSONObject json = args.optJSONObject(0);
		// json.optString("adUnit")
		// json.optString("adUnitFullScreen")
		// JSONObject inJson = json.optJSONObject("inJson");

		if (action.equals("autoHide")) {

			final boolean enableImmersiveSticky = args.getBoolean(0);
			final boolean hideStatusBar = args.getBoolean(1);

			final CallbackContext delayedCC = callbackContext;
			cordova.getActivity().runOnUiThread(new Runnable() {
				@Override
				public void run() {
					_autoHide(enableImmersiveSticky, hideStatusBar);

					PluginResult pr = new PluginResult(PluginResult.Status.OK);
					// pr.setKeepCallback(true);
					delayedCC.sendPluginResult(pr);
					// PluginResult pr = new PluginResult(PluginResult.Status.ERROR);
					// pr.setKeepCallback(true);
					// delayedCC.sendPluginResult(pr);
				}
			});

			return true;
		} else if (action.equals("hideNavigationBar")) {

			final boolean enableImmersiveSticky = args.getBoolean(0);
			final boolean hideStatusBar = args.getBoolean(1);

			final CallbackContext delayedCC = callbackContext;
			cordova.getActivity().runOnUiThread(new Runnable() {
				@Override
				public void run() {
					_hideNavigationBar(enableImmersiveSticky, hideStatusBar);

					PluginResult pr = new PluginResult(PluginResult.Status.OK);
					// pr.setKeepCallback(true);
					delayedCC.sendPluginResult(pr);
					// PluginResult pr = new PluginResult(PluginResult.Status.ERROR);
					// pr.setKeepCallback(true);
					// delayedCC.sendPluginResult(pr);
				}
			});

			return true;
		} else if (action.equals("reset")) {

			final CallbackContext delayedCC = callbackContext;
			cordova.getActivity().runOnUiThread(new Runnable() {
				@Override
				public void run() {
					_reset();

					PluginResult pr = new PluginResult(PluginResult.Status.OK);
					// pr.setKeepCallback(true);
					delayedCC.sendPluginResult(pr);
					// PluginResult pr = new PluginResult(PluginResult.Status.ERROR);
					// pr.setKeepCallback(true);
					// delayedCC.sendPluginResult(pr);
				}
			});

			return true;
		} else if (action.equals("hideStatusBar")) {

			final CallbackContext delayedCC = callbackContext;
			cordova.getActivity().runOnUiThread(new Runnable() {
				@Override
				public void run() {
					_hideStatusBar();

					PluginResult pr = new PluginResult(PluginResult.Status.OK);
					// pr.setKeepCallback(true);
					delayedCC.sendPluginResult(pr);
					// PluginResult pr = new PluginResult(PluginResult.Status.ERROR);
					// pr.setKeepCallback(true);
					// delayedCC.sendPluginResult(pr);
				}
			});

			return true;
		} else if (action.equals("dimStatusAndNavBars")) {

			final CallbackContext delayedCC = callbackContext;
			cordova.getActivity().runOnUiThread(new Runnable() {
				@Override
				public void run() {
					_dimStatusAndNavBars();

					PluginResult pr = new PluginResult(PluginResult.Status.OK);
					// pr.setKeepCallback(true);
					delayedCC.sendPluginResult(pr);
					// PluginResult pr = new PluginResult(PluginResult.Status.ERROR);
					// pr.setKeepCallback(true);
					// delayedCC.sendPluginResult(pr);
				}
			});

			return true;
		} else if (action.equals("showStatusAndNavBars")) {

			final CallbackContext delayedCC = callbackContext;
			cordova.getActivity().runOnUiThread(new Runnable() {
				@Override
				public void run() {
					_showStatusAndNavBars();

					PluginResult pr = new PluginResult(PluginResult.Status.OK);
					// pr.setKeepCallback(true);
					delayedCC.sendPluginResult(pr);
					// PluginResult pr = new PluginResult(PluginResult.Status.ERROR);
					// pr.setKeepCallback(true);
					// delayedCC.sendPluginResult(pr);
				}
			});

			return true;
		}

		return false; // Returning false results in a "MethodNotFound" error.
	}
	// -------------------------------------

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void _autoHide(boolean enableImmersiveSticky, boolean hideStatusBar) {

		_hideNavigationBar(enableImmersiveSticky, hideStatusBar);

		final CordovaInterface cordova_final = cordova;
		// http://stackoverflow.com/questions/11762306/listen-for-first-touchevent-when-using-system-ui-flag-hide-navigation
		// http://stackoverflow.com/questions/15103339/android-full-screen-modeics-first-touch-shows-the-navigation-bar
		// http://developer.android.com/reference/android/view/View.OnSystemUiVisibilityChangeListener.html
		// webView.setOnSystemUiVisibilityChangeListener(new
		// View.OnSystemUiVisibilityChangeListener(){//cordova5 build error
		getView(webView).setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {// fixed
																												// cordova5
																												// build
																												// error
			@Override
			public void onSystemUiVisibilityChange(int vis) {
				if (vis == 0) {
					// http://stackoverflow.com/questions/3072173/how-to-call-a-method-after-a-delay-in-android
					Handler handler = new Handler();
					handler.postDelayed(new Runnable() {
						@Override
						public void run() {
							_hideNavigationBar(enableImmersiveSticky, hideStatusBar);
						}
					}, 3000);// after ms
				}
			}
		});
	}

	public static View getView(CordovaWebView webView) {
		if (View.class.isAssignableFrom(CordovaWebView.class)) {
			return (View) webView;
		}

		try {
			Method getViewMethod = CordovaWebView.class.getMethod("getView", (Class<?>[]) null);
			if (getViewMethod != null) {
				Object[] args = {};
				return (View) getViewMethod.invoke(webView, args);
			}
		} catch (Exception e) {
		}

		return null;
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void _hideNavigationBar(boolean enableImmersiveSticky, boolean hideStatusBar) {
		Activity activity = cordova.getActivity();
		View decorView = activity.getWindow().getDecorView();
		int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
		if (hideStatusBar) {
			uiOptions |= View.SYSTEM_UI_FLAG_FULLSCREEN;
		}
		if (enableImmersiveSticky) {
			uiOptions |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
		}
		decorView.setSystemUiVisibility(uiOptions);
	}

	private void _hideStatusBar() {
		Activity activity = cordova.getActivity();
		View decorView = activity.getWindow().getDecorView();
		// Hide the status bar.
		int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
		decorView.setSystemUiVisibility(uiOptions);
		// Remember that you should never show the action bar if the
		// status bar is hidden, so hide that too if necessary.
		try {
			ActionBar actionBar = activity.getActionBar();
			actionBar.hide();
		} catch (Exception e) {
			// do nothing
		}
	}

	private void _dimStatusAndNavBars() {
		Activity activity = cordova.getActivity();
		View decorView = activity.getWindow().getDecorView();
		int uiOptions = View.SYSTEM_UI_FLAG_LOW_PROFILE;
		decorView.setSystemUiVisibility(uiOptions);
	}

	private void _showStatusAndNavBars() {
		int newVis = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
		Activity activity = cordova.getActivity();
		activity.getWindow().getDecorView().setSystemUiVisibility(newVis);
	}

	private void _reset() {
		int newVis = View.SYSTEM_UI_FLAG_VISIBLE;
		Activity activity = cordova.getActivity();
		activity.getWindow().getDecorView().setSystemUiVisibility(newVis);
	}
}
