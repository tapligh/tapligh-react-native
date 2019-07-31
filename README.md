
# react-native-tapligh-react-native

## Getting started

`$ npm install react-native-tapligh-react-native --save`

### Mostly automatic installation

`$ react-native link react-native-tapligh-react-native`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-tapligh-react-native` and add `RNTaplighReactNative.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNTaplighReactNative.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.tapligh.sdk.RNTaplighReactNativePackage;` to the imports at the top of the file
  - Add `new RNTaplighReactNativePackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-tapligh-react-native'
  	project(':react-native-tapligh-react-native').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-tapligh-react-native/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-tapligh-react-native')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNTaplighReactNative.sln` in `node_modules/react-native-tapligh-react-native/windows/RNTaplighReactNative.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Tapligh.React.Native.RNTaplighReactNative;` to the usings at the top of the file
  - Add `new RNTaplighReactNativePackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNTaplighReactNative from 'react-native-tapligh-react-native';

// TODO: What to do with the module?
RNTaplighReactNative;
```
  