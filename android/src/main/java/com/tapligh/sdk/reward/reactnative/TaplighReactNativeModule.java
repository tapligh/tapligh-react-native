
package com.tapligh.sdk.reward.reactnative;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.tapligh.sdk.adview.Tapligh;
import com.tapligh.sdk.adview.adutils.ADResultListener;
import com.tapligh.sdk.adview.adutils.AdLoadListener;
import com.tapligh.sdk.adview.adutils.VerifyTokenListener;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

public class TaplighReactNativeModule extends ReactContextBaseJavaModule {

    private Tapligh tapligh = null;
    private ReactContext context;

    private static final String UNIT_CODE_KEY = "unit_code";
    private static final String AD_TOKEN_KEY = "ad_token";

    private static final String LOAD_ERROR_STATUS_KEY = "load_error_status";
    private static final String AD_RESULT_STATUS_KEY = "ad_result_status";
    private static final String REWARD_KEY = "reward";
    private static final String TOKEN_RESULT_STATUS_KEY = "token_result";

    private static final String ON_AD_READY_EVENT = "onAdReady";
    private static final String ON_LOAD_ERROR_EVENT = "onLoadError";
    private static final String ON_AD_RESULT_EVENT = "onAdResult";
    private static final String ON_REWARD_READY_EVENT = "onRewardReady";
    private static final String ON_TOKEN_VERIFIED_EVENT = "onTokenVerified";



    public TaplighReactNativeModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.context = reactContext;

        if (getCurrentActivity() != null && tapligh == null) {
            tapligh = Tapligh.newInstance(getCurrentActivity());
        }
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        HashMap<String, Object> constants = new HashMap<>();;
        constants.put("KEY_UNIT_CODE" , UNIT_CODE_KEY);
        constants.put("KEY_AD_TOKEN" , AD_TOKEN_KEY);
        constants.put("KEY_LOAD_ERROR" , LOAD_ERROR_STATUS_KEY);
        constants.put("KEY_AD_RESULT" , AD_RESULT_STATUS_KEY);
        constants.put("KEY_REWARD" , REWARD_KEY);
        constants.put("KEY_TOKEN_RESULT" , TOKEN_RESULT_STATUS_KEY);

        constants.put("EVENT_ON_AD_READY" , ON_AD_READY_EVENT);
        constants.put("EVENT_ON_LOAD_ERROR" , ON_LOAD_ERROR_EVENT);
        constants.put("EVENT_ON_AD_RESULT" , ON_AD_RESULT_EVENT);
        constants.put("EVENT_ON_REWARD_READY" , ON_REWARD_READY_EVENT);
        constants.put("EVENT_ON_TOKEN_VERIFIED" , ON_TOKEN_VERIFIED_EVENT);

        return constants;
    }

    @Override
    public String getName() {
        return "TaplighReactNative";
    }

    @ReactMethod
    public void setToken(String token, boolean testMode){
        if (tapligh != null) {
            tapligh.setToken(token, testMode);
        }
    }

    @ReactMethod
    public void loadAd(String unitCode){
        if(tapligh == null){
            throw new NullPointerException("Oops!! tapligh Instance is null");
        }

        tapligh.loadAd(unitCode, new AdLoadListener() {
            @Override
            public void onAdReady(String unitCode, String token) {
                WritableMap map = Arguments.createMap();
                map.putString(UNIT_CODE_KEY, unitCode);
                map.putString(AD_TOKEN_KEY, token);

                sendMessageToReact(context, ON_AD_READY_EVENT, map);
            }

            @Override
            public void onLoadError(String unitCode, LoadErrorStatus loadErrorStatus) {
                WritableMap map = Arguments.createMap();
                map.putString(UNIT_CODE_KEY, unitCode);
                map.putString(LOAD_ERROR_STATUS_KEY, loadErrorStatus.name());

                sendMessageToReact(context, ON_LOAD_ERROR_EVENT, map);
            }
        });

    }

    @ReactMethod
    public void showAd(String unitCode){
        tapligh.showAd(unitCode, new ADResultListener() {
            @Override
            public void onAdResult(ADResult adResult, String token) {
                WritableMap map = Arguments.createMap();
                map.putString(AD_RESULT_STATUS_KEY, adResult.name());
                map.putString(AD_TOKEN_KEY, token);

                sendMessageToReact(context, ON_AD_RESULT_EVENT, map);
            }

            @Override
            public void onRewardReady(String reward) {
                WritableMap map = Arguments.createMap();
                map.putString(REWARD_KEY, reward);

                sendMessageToReact(context, REWARD_KEY, map);
            }
        });
    }

    @ReactMethod
    public void verifyToken(String token) {
        tapligh.verifyToken(token, new VerifyTokenListener() {
            @Override
            public void onTokenVerified(TokenResult tokenResult) {
                WritableMap map = Arguments.createMap();
                map.putString(TOKEN_RESULT_STATUS_KEY, tokenResult.name());

                sendMessageToReact(context, ON_TOKEN_VERIFIED_EVENT, map);
            }
        });
    }

    @ReactMethod
    public void isInitializeDone(Callback callback){

        boolean isInitializeDone = false;
        if(tapligh != null){
            isInitializeDone = tapligh.isInitializeDone();
        }

        if(callback != null ){

            callback.invoke(isInitializeDone);
        }

    }

    @ReactMethod
    public void getSdkVersion(Callback callback){
        String sdkVersion = "";
        if(tapligh != null){
            sdkVersion = tapligh.getTaplighVersion();
        }

        if(callback != null){
            callback.invoke(sdkVersion);
        }
    }

    private void sendMessageToReact(ReactContext context, String eventName, @Nullable WritableMap data){
        context.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(eventName, data);
    }
}