import {
    Platform
} from 'react-native';

let Tapligh = require("react-native").NativeModules.TaplighReactNative;

module.exports = {
    UNIT_CODE_KEY: Tapligh.UNIT_CODE_KEY,
    AD_TOKEN_KEY: Tapligh.AD_TOKEN_KEY,
    LOAD_ERROR_STATUS_KEY: Tapligh.LOAD_ERROR_STATUS_KEY,
    AD_RESULT_STATUS_KEY: Tapligh.AD_RESULT_STATUS_KEY,
    REWARD_KEY: Tapligh.REWARD_KEY,
    TOKEN_RESULT_STATUS_KEY: Tapligh.TOKEN_RESULT_STATUS_KEY,

    ON_AD_READY_EVENT: Tapligh.ON_AD_READY_EVENT,
    ON_LOAD_ERROR_EVENT: Tapligh.ON_LOAD_ERROR_EVENT,
    ON_AD_RESULT_EVENT: Tapligh.ON_AD_RESULT_EVENT,
    ON_REWARD_READY_EVENT: Tapligh.ON_REWARD_READY_EVENT,
    ON_TOKEN_VERIFIED_EVENT: Tapligh.ON_TOKEN_VERIFIED_EVENT
}