import { NativeModules } from 'react-native';
import { DeviceEventEmitter, Platform } from "react-native";

import consts from './src/consts.js'

var Tapligh = NativeModules.TaplighReactNative;
let callback = {};

callback[consts.ON_AD_READY_EVENT] = {};
callback[consts.ON_LOAD_ERROR_EVENT] = {};
callback[consts.ON_AD_RESULT_EVENT] = {};
callback[consts.ON_REWARD_READY_EVENT] = {};
callback[consts.ON_TOKEN_VERIFIED_EVENT] = {};

const eventEmitter = DeviceEventEmitter;

eventEmitter.addListener(consts.ON_AD_READY_EVENT, event => {
    if(callback[consts.ON_AD_READY_EVENT]) {
        callback[consts.ON_AD_READY_EVENT](
            event.data
        )
    }
})
eventEmitter.addListener(consts.ON_LOAD_ERROR_EVENT, event => {
    if(callback[consts.ON_LOAD_ERROR_EVENT]) {
        callback[consts.ON_LOAD_ERROR_EVENT](
            event.data
        )
    }
})
eventEmitter.addListener(consts.ON_AD_RESULT_EVENT, event => {
    if(callback[consts.ON_AD_RESULT_EVENT]) {
        callback[consts.ON_AD_RESULT_EVENT](
            event.data
        )
    }
})
eventEmitter.addListener(consts.ON_REWARD_READY_EVENT, event => {
    if(callback[consts.ON_REWARD_READY_EVENT]) {
        callback[consts.ON_REWARD_READY_EVENT](
            event.data
        )
    }
})
eventEmitter.addListener(consts.ON_TOKEN_VERIFIED_EVENT, event => {
    if(callback[consts.ON_TOKEN_VERIFIED_EVENT]) {
        callback[consts.ON_TOKEN_VERIFIED_EVENT](
            event.data
        )
    }
})

module.exports = {
    initialize: function(appApiKey, testMode) {
        Tapligh.setToken(appApiKey, testMode);
    }

    loadAd: function(unitCode, adReadyFn, loadErrorFn) {
        callback[consts.ON_AD_READY_EVENT] = adReadyFn;
        callback[consts.ON_LOAD_ERROR_EVENT] = loadErrorFn;
        
        Tapligh.loadAd(unitCode);
    }

    showAd: function(unitCode, adResultFn, rewardReadyFn) {
        callback[consts.ON_AD_RESULT_EVENT] = adResultFn;
        callback[consts.ON_REWARD_READY_EVENT] = rewardReadyFn;

        Tapligh.showAd(unitCode);
    }

    verifyToken: function(token, tokenVerifiedFn) {
        callback[consts.ON_TOKEN_VERIFIED_EVENT] = tokenVerifiedFn;

        Tapligh.verifyToken(token);
    }

    isInitializeDone(callbackFn) {
        Tapligh.isInitializeDone(callbackFn);
    }

    getSdkVersion(callbackFn) {
        Tapligh.getSdkVersion(callbackFn);
    }
}