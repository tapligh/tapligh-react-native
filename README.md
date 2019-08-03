
# react-native-tapligh-react-native

## Getting started

`$ npm install tapligh-react-native --save`

### Mostly automatic installation

`$ react-native link tapligh-react-native`

### Manual installation

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.tapligh.sdk.TaplighReactNativePackage;` to the imports at the top of the file
  - Add `new TaplighReactNativePackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':tapligh-react-native'
  	project(':tapligh-react-native').projectDir = new File(rootProject.projectDir, 	'../node_modules/tapligh-react-native/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':tapligh-react-native')
  	```

## Usage
You can find the full [documentation here](https://tapligh.com/tapligh-react-native).

```javascript
import TaplighReactNative from 'tapligh-react-native';
// TODO: What to do with the module?
RNTaplighReactNative;
```


  
