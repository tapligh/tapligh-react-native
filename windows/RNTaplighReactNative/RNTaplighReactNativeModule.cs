using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Tapligh.React.Native.RNTaplighReactNative
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNTaplighReactNativeModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNTaplighReactNativeModule"/>.
        /// </summary>
        internal RNTaplighReactNativeModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNTaplighReactNative";
            }
        }
    }
}
