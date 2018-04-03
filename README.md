## DMIReactBridge
This project serves as a plugin to integrate Datami SDK to react-native apps

## Steps to integrate
1. Install the datami plugin `npm install https://github.com/avichopra1989/DmiNativeAndroidModule.git`
2. Eject the project from Expo `npm run eject`
    * Keep in mind that this step cannot be reversed, so keep the change in the CMS before editing. Pleaes follow the link
    ``` https://github.com/react-community/create-react-native-app/blob/master/EJECTING.md```
3. Link the library:
    * Add the following to `android/settings.gradle`:
        ```
        include ':dmi-native-android-module'
        project(':dmi-native-android-module').projectDir = new File(settingsDir, '../node_modules/dmi-native-android-module/app')
        ```

    * Add the following to `android/build.gradle`:
        ```xml
        ...

        allprojects {
            ...
                maven {
                    url 'https://s3.amazonaws.com/sdk-ga-releases.cloudmi.datami.com/android/mvn/smisdk/'
                }
            }
        }
        ```

    * Add the following to `android/app/build.gradle`:
        ```xml
        ...

        dependencies {
            ...
            compile project(':dmi-native-android-module')
        }
        ```
    * Add the following to `android/app/src/main/java/**/MainApplication.java`:
        ```java

        import smisdk.com.dminativeandroidmodule.DmiReactPackage;;  // add this for Datami react package

        public class MainApplication extends Application implements ReactApplication {

            @Override
            protected List<ReactPackage> getPackages() {
                return Arrays.<ReactPackage>asList(
                    new MainReactPackage(),
                    new DmiReactPackage()     // add this for Datami react package
                );
            }
        }
        ```
4. Import the Datami Library in the initial Javascript file : example **index.js**

    ```javascript
    ...
    import DmiBridge from 'dmi-native-android-module'

    ...
    DmiBridge.initialiseDatami(<API Key>);
    ```