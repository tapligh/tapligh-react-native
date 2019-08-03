import {
    Platform,
    NativeModules
} from 'react-native';

var Tapligh = NativeModules.TaplighReactNative;

module.exports = {
    UNIT_CODE_KEY: Tapligh.KEY_UNIT_CODE,
    AD_TOKEN_KEY: Tapligh.KEY_AD_TOKEN,
    LOAD_ERROR_STATUS_KEY: Tapligh.KEY_LOAD_ERROR,
    AD_RESULT_STATUS_KEY: Tapligh.KEY_AD_RESULT,
    REWARD_KEY: Tapligh.KEY_REWARD,
    TOKEN_RESULT_STATUS_KEY: Tapligh.KEY_TOKEN_RESULT,

    ON_AD_READY_EVENT: Tapligh.EVENT_ON_AD_READY,
    ON_LOAD_ERROR_EVENT: Tapligh.EVENT_ON_LOAD_ERROR,
    ON_AD_RESULT_EVENT: Tapligh.EVENT_ON_AD_RESULT,
    ON_REWARD_READY_EVENT: Tapligh.EVENT_ON_REWARD_READY,
    ON_TOKEN_VERIFIED_EVENT: Tapligh.EVENT_ON_TOKEN_VERIFIED
}