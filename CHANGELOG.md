## Version 3.10.0 (August 3, 2015)

- VAST UI improvements and bug fixes.
  - Pause trackers no longer fire when the ad is skipped.
  - Improved retrieval of blurred video frame when there is no companion ad.
- Added com.mopub:mopub-sdk AAR to [jCenter](https://bintray.com/mopub/mopub-android-sdk/mopub-android-sdk/view).
- Bug Fixes:
  - Fixed a NullPointerException in CacheService on devices with low storage space.
  - Improved redirect loading for in-app browser.

## Version 3.9.0 (July 1, 2015)

- Added **VAST 3.0** standard support for video ads.
- Improved **video player UX**.
- Added **RecyclerView** support for native ads. See the [integration guide](https://github.com/mopub/mopub-android-sdk/wiki/Native-Ads-with-Recycler-View).
- Improved **deep link** handling.
- Bug Fixes:
  - MRAID video interstitials now play automatically when displayed on Jellybean MR1 and newer.
  - MRAID relative assets are correctly rendered.
  - MoPubLog no longer duplicates some messages.
  - Fixed erroneous output of DeviceUtils.getScreenOrientationFromRotationAndOrientation().

## Version 3.8.0 (June 1, 2015)

- Updated Chartboost support to 5.3.0. This introduces a new shared class called ChartboostShared. If you are using Chartboost Custom Native Networks you will need to include this class in your build along with ChartboostInterstitial.

## Version 3.7.0 (April 30, 2015)

- Updated GooglePlayServices custom events to depend on the Google Play Services `play-services-ads 7.0.0` API.
- Vungle support updated to SDK 3.3.3.
- Updated InMobi and Greystripe custom events to accept application IDs from the MoPub UI.
  - For InMobi: `{"app_id" : "YOUR_INMOBI_APP_ID"}`
  - For Greystripe: `{"GUID" : "YOUR GREYSTRIPE_GUID"}`

- Added toasts to the MoPub Sample App for ad load failures due to no connection.
- Fixed a bug in processing VAST progress trackers in a VAST wrapper tag.
- Fixed a bug where ad refresh times could be incorrect when an ad request was not filled.

- Updated the following dependencies:
	- support-v4 AAR to 22.0.0
	- support-annotations JAR to 22.0.0
	- Android Maven Plugin to 4.2.0

#### Version 3.6.1 (April 6, 2015)

 - **Bug Fix** Fixed a compile error in FacebookBanner.java

## Version 3.6.0 (April 3, 2015)

 - **Facebook Update** Updated supported Facebook Audience Network version to 3.23.1
 - **Bug fix** Fixed a bug where interstitials could leak memory; Fixes [issue #153](https://github.com/mopub/mopub-android-sdk/issues/153)
 - **VAST Video** Updated the VAST video player to support Progress events.
 - Updated **Volley** version to 1.1.0.

## Version 3.5.0 (March 10, 2015)

 - Dependency changes in Maven and Gradle. No new dependencies have been added, but your build script will need to change slightly to include JCenter. See our [Getting Started Guide](https://github.com/mopub/mopub-android-sdk/wiki/Getting-Started#adding-the-support-libraries-to-your-project) for complete instructions.
 - Security Improvement: removed the @JavascriptInterface annotation for WebViews.
 - Fixed a bug where video playback would sometimes fail to stop when an ad was dismissed.
 - Fixed a bug where it was not possible to disable ad refresh; Fixes [issue #148](https://github.com/mopub/mopub-android-sdk/issues/148)
 - Fixed a null pointer exception in AdViewController; Fixes [issue #150](https://github.com/mopub/mopub-android-sdk/issues/150)

## Version 3.4.0 (January 30, 2015)

  - **Volley networking stack** MoPub for Android now uses Google's Volley library for HTTP requests. You will need to add our bundled Volley JAR (available at `mopub-sdk/libs/mopub-volley-1.0.0.jar`) as a compile-time dependency. See instructions in our [integration page](https://dev.twitter.com/mopub/android/getting-started).
  - **Updated Vungle Support** Certified the `VungleInterstitial` custom event against Vungle SDK 3.2.2
  - **VAST Video Bug Fixes**
    - Fixed inability to parse VAST tags referencing URLs that contain 3rd party macros
    - VAST videos no longer fire completion trackers upon video playback error
  - Added support for the `mopubnativebrowser://` click-destination scheme for Native, MRAID, and VAST ads (it was already supported for HTML ads). Links of this type (e.g. `mopubnativebrowser://navigate?url=http%3A%2F%2Fwww.mopub.com`) will open the specified URL in the device's default browser, rather than in MoPub's in-app browser.

## Version 3.3.0 (December 8, 2014)

  - **MRAID 2.0 Support** - The MoPub SDK is now compliant with the MRAID 2.0 specification to enable rich media ads in banners and interstitial ad units. Learn more about MRAID from the [IAB](http://www.iab.net/MRAID#MRAID).
  - **Location Polling Updates** - Changed the interaction between application- and device-provided location data: more recent location data is now always used (in the past, application-provided location data was always preferred).

    As before, you may still disable MoPub SDK's location polling by calling `MoPub.setLocationAwareness(LocationAwareness.DISABLED)`.
  - **Updated Chartboost SDK** Updated the `ChartboostInterstitial` custom event to support Chartboost SDK 5.0.4
  - **Android Support Annotations** Introduced a dependency on android-support-annotations.jar to support code analysis of `@Nullable` and `@NonNull` annotations.

#### Version 3.2.2 (October 29, 2014)
  - **Bug Fix** Fixes a bug in fetching the Google Advertising ID from Google Play Services.

#### Version 3.2.1 (October 21, 2014)
  - **Bug Fix** Fixes a bug in processing certain HTTP headers for Native Ads.

## Version 3.2.0 (October 17, 2014)

  - **Updated SDK License** Visit [http://www.mopub.com/legal/sdk-license-agreement/](http://www.mopub.com/legal/sdk-license-agreement/) for details.
  - **Bug Fixes**

## Version 3.1.0 (October 9, 2014)

  - **Updated Facebook SDK Compatibility to 3.18.1**
  Provided Custom Events for Facebook Banners, Interstitials and Native Ads (included
  in the extras/ folder) are now compatible with the latest SDK release from Facebook (3.18.1).
  - **Updated API for Native Ads Custom Event writers**
  If you are mediating Facebook or InMobi native ads, this change requires you to copy
  FacebookNative.java and InMobiNative.java custom events from the extras/ folder to
  com.mopub.nativeads package for compatibility.

## Version 3.0.0 (September 30, 2014)

  - **Location Settings are now SDK-wide**
    - Calls to `MoPubView#setLocationAwareness` and `MoPubInterstial#setLocationAwareness` are
    deprecated in favor of `MoPub#setLocationAwareness`
    - Calls to `MoPubView#setLocationPrecision` and `MoPubInterstitial#setLocationPrecision` are
    deprecated in favor of `MoPub#setLocationPrecision`
    - Calls to any of these methods have the effect of setting location awareness and precision
    globally for the SDK
  - **Build target SDK is now API Level 19.** If you are building the MoPub SDK from source,
  modify your dependencies to reference Android 4.4.2, API Level 19. This does not affect the
  minimum device API level, which remains at API Level 9.
  - **Source-level support for Gradle projects.** The SDK source now includes a build.gradle file you can use to build source as part of your Gradle project.
  - **The SDK now uses Play Services 5.0.89**
  - **Bug fixes:**
    - Millennial Interstitial caching now properly handles request failures
    - Fixed bug preventing native ads from loading after a request failure

## Version 2.4.0 (August 28, 2014)

  - **Minimum Android version now at API Level 9.** To use the new SDK, your app must run on Android 2.3.1 (Version 9, Gingerbread) or higher.
  - **Simplified APIs for inserting native ads.** See [Native Ads Integration](https://github.com/mopub/mopub-android-sdk/wiki/Native-Ads-Integration) for details.
  - **Automatic ad caching for smooth scrolling.** For native ads, the SDK will now automatically pre-load ads, resulting in smoother scrolling.
  - **Performance improvements** The SDK now makes more efficient use of memory for image caching and avoids allocating temporary objects while scrolling, resulting in fewer garbage collections.
  - **Sample app improvements.** An improved sample app allows saving ad unit IDs for testing.
  - **Bug fixes:**
    - Banner auto-refresh is now properly re-enabled when resuming your app.

## Version 2.3 (July 17, 2014)

  - **Improved impression tracking for Native Ads** Impression tracking for native ads is now more accurate and more efficient.
  - **Streamlined Maven Build and Dependencies** MoPub's Android SDK now depends on the Android v4 Support Library shipped with the Android Build tools. The MoPub Sample App also depends on Google Play Services to use the Android Advertising ID. We recommend building against Play Services in your app as well. For integration instructions, see the [wiki](https://github.com/mopub/mopub-android-sdk/wiki/Getting-Started).
  - **Removed AdMob Custom Events and JAR** AdMob's SDK is deprecated by Google and the APIs have been moved to Google Play Services. Existing AdMob adunits will now invoke the appropriate Google Play Services custom event. Developers must update their integration to use the Google Play Services custom events located in the extras folder by August 1.
  - **Updated Third-Party Network Compatibility** MoPub's provided Custom Events (included in the extras/ folder) are now compatible with the latest SDK releases from Millennial Media (5.3.0), Vungle (3.1.0), InMobi (4.4.1) and Google Play Services (5.0.77).
  - Fixed intermittent NullPointerException in MoPubNative#requestNativeAd; fixes [Github issue #97] (https://github.com/mopub/mopub-android-sdk/issues/97)
  - Fixed an issue where MRAID interstitials could be not be closed.

## Version 2.2 (June 19, 2014)

  - **Native ads mediation** release; integration instructions and documentation are available on the [GitHub wiki](https://github.com/mopub/mopub-android-sdk/wiki/Integrating-Native-Third-Party-Ad-Networks). Added custom event native implementations to the native extras directory of the SDK (`/extras/src/com/mopub/nativeads`), with initial support for the following networks:
  	- Facebook Audience Network (`FacebookNative.java`)
  	- InMobi Native Ads (`InMobiNative.java`)
  - **Native ads content filtering**: Added the ability to specify which native ad elements you want to receive from the MoPub Marketplace to optimize bandwidth use and download only required assets, via `RequestParameters.Builder#desiredAssets(…)`. This feature only works for the six standard Marketplace assets, found in `RequestParameters.NativeAdAsset`. Any additional elements added in direct sold ads will always be sent down in the extras.
  - Added star rating information to the `NativeResponse` object, via `NativeResponse#getStarRating()`. This method returns a `Double` corresponding to an app's rating on a 5-star scale.
  - VAST video quartile and completion trackers now always include the user-agent
  - Ensured that banners never autorefresh until they have been loaded at least once

## Version 2.1 (May 15, 2014)

  - Added custom events for Facebook ads. `FacebookBanner` and `FacebookInterstitial` can be found in the extras directory of the SDK (`/extras/src/com/mopub/mobileads`). For more information, please see the [help page for Facebook custom events](http://help.mopub.com/customer/portal/articles/1552301-how-to-integrate-facebook-audience-network-using-custom-events).
  - Significant improvements to video ads
    - Added overlay including a "Learn More" button, video length, and time left until the video may be skipped
    - Added support for companion banners (shown upon video completion)
  - Added Logcat warnings (and Toasts for debug builds) in cases where all necessary Activity permissions haven't been added to the `AndroidManifest`

#### Version 2.0.1 (April 30, 2014)

  - Fixed cases where VAST Video Interstitials were failing to fire `InterstitialAdListener` callbacks; fixes [GitHub issue #78](https://github.com/mopub/mopub-android-sdk/issues/78)
  - Simplified click tracking logic for HTML ads

## Version 2.0 (April 22, 2014)

  - **Native Ads** public release; integration instructions and documentation available on the [GitHub wiki](https://github.com/mopub/mopub-android-sdk/wiki/Native-Ads-Integration)
  - Changed minimum supported Android version to Froyo (Android 2.2, API level 8)
  - Added support for Google Play Services advertising identifier
  - Renamed the `com.mopub.mobileads.MraidBrowser` Activity to `com.mopub.common.MoPubBrowser`.
      - **Important Note:** This change requires a modification to the `AndroidManifest`. The updated set of requisite activity permissions are as follows:

      	```
    <activity android:name="com.mopub.common.MoPubBrowser"
				android:configChanges="keyboardHidden|orientation"/>
    <activity android:name="com.mopub.mobileads.MoPubActivity"
                android:configChanges="keyboardHidden|orientation"/>
    <activity android:name="com.mopub.mobileads.MraidActivity"
                android:configChanges="keyboardHidden|orientation"/>
	<activity android:name="com.mopub.mobileads.MraidVideoPlayerActivity"
                android:configChanges="keyboardHidden|orientation"/>
		```
  - Upgraded the bundled `android-support-v4` library to r19.1.
      - **Note for Maven users:** Newer versions of the `android-support-v4` artifact are unavailable on Maven central, so we have included a small script to update the version in your local artifact repository. Please navigate to the `mopub-sdk` directory, and run `scripts/mavenize_support_library`.

#### Version 1.17.3.1 (March 24, 2014)

  - Restricted use of methods and fields that require API 4+ (`WebView#removeJavascriptInterface` and `ConnectivityManager`'s connection types)

## Version 1.17.3 (March 19, 2014)

  - Added safeguards to prevent two different `MoPubInterstitial` objects from listening in on one other's lifecycle callbacks
  - Disabled Javascript loading into `destroy()`ed `WebView`s; fixes [GitHub issue #62](https://github.com/mopub/mopub-android-sdk/issues/62)
  - Fixed an `IllegalArgumentException` resulting from VAST videos with malformed redirect tags
  - MRAID ads that utilize `mraid.open()` now correctly record a click event
  - Added missing `FLAG_ACTIVITY_NEW_TASK` to `VastVideoView`'s intent creation; fixes part of [GitHub issue #56](https://github.com/mopub/mopub-android-sdk/issues/56)

## Version 1.17.2 (February 20, 2014)

  - Updated InMobi custom events to support InMobi SDK 4.0.3+ only
  - MRAID viewable property now correctly updates on viewability change
  - `MraidView` properly handles null schemes; fixes [GitHub issue #63](https://github.com/mopub/mopub-android-sdk/pull/63)
  - Internal disk LRU cache correctly hashes keys when checking for existing files

#### Version 1.17.1.1 (February 5, 2014)
  - Fixed bug that caused clicks to not be recorded in the MoPub UI (introduced in 1.17.1)

## Version 1.17.1 (January 23, 2014)

  - Added custom events for Google Play Services. `GooglePlayServicesBanner` and `GooglePlayServicesInterstitial` can be found in the extras directory of the SDK (`/extras/src/com/mopub/mobileads`)
  - Resolved issues with missing annotations on `addJavascriptInterface` when `targetSdkVersion` is set to API level 17 or above
  - Updated MoPub sample application to allow in-app text entry of ad unit IDs

## Version 1.17 (Nov 20, 2013)

  - Support for VAST 2.0 video playback via MoPub Marketplace
    - Short videos (less than 15 seconds) autoplay and and are unskippable
    - Longer videos autoplay and are skippable after 5 seconds
    - **Note:** The video cache can use up to 100 MB of internal storage. For developers sensitive to storage constraints, this value may be changed in `VastVideoInterstitial.CACHE_MAX_SIZE`.
  - Updated InMobi custom event support to 4.0.0
  - Added custom events for video ad network mediation, which can be found in the extras directory of the SDK (`/extras/src/com/mopub/mobileads/`)
    - Added the `AdColonyInterstitial` custom event
    - Added the `VungleInterstitial` custom event
    - **Note:** Virtual currency callbacks (v4vc) are not supported for the above ad networks
  - Enabled deeplinking via custom URIs in ad creatives
  - All `WebView`s are removed from their parents before `destroy()`; fixes [GitHub issue #38](https://github.com/mopub/mopub-android-sdk/issues/38)
  - Removed previously-deprecated `HTML5AdView`

## Version 1.16 (October 16, 2013)

  - Improved creative controls
    - Creative flagging
      - Allows users to report certain inappropriate ad experiences directly to MoPub with a special gesture
      - User must swipe back and forth at least four times in the ad view to flag a creative
      - Swipes must cover more than 1/3 of the ad width and should be completely horizontal
      - Only enabled for direct sold, Marketplace, and server-to-server networks ads
    - Creatives that attempt to auto-redirect are now blocked; ads cannot redirect without user interaction
    - Javascript alert, confirm, and prompt dialogs are blocked
  - Improved responsiveness of `showInterstitial()` for `HtmlInterstitial`s and `MraidInterstitial`s by pre-rendering HTML content
  - Simplified internal construction and handling of `WebView`s by removing `WebViewPool` and its subclasses
  - Updated mraid.getVersion() to return 2.0

#### Version 1.15.2.2 (September 20, 2013)
  - Removed `WebSettings.setPluginsEnabled()` so the SDK builds against Android API 18; fixes [GitHub issue #28](https://github.com/mopub/mopub-android-sdk/issues/28)
  - AdMob banners are now removed from the view hierarchy before they are destroyed; fixes the reopened [GitHub issue #23](https://github.com/mopub/mopub-android-sdk/issues/23)
  - Prevent ads from launching system features, such as a browser view, until the user has interacted with the ad.

#### Version 1.15.2.1 (September 13, 2013)
  - Made the SDK more resilient to creatives that improperly use the `mopubnativebrowser://` scheme; fixes [GitHub issue #36](https://github.com/mopub/mopub-android-sdk/issues/36)

## Version 1.15.2 (September 11, 2013)
  - Allowed Facebook Support to be disabled optionally with `setFacebookSupported(false)`:
  	- Use `MoPubInterstitial.setFacebookSupported(false);` for interstitials
  	- Use `MoPubView.setFacebookSupported(false);` for banners
  	- Note: the `setFacebookSupported(false)` method call must come __before__ `loadAd()`
  	- Note: facebook support is on by default
  - Changed banner refresh default to be 60 seconds when requests timed out
  - Fixed edge case in Millennial Media ad fetch failure when there is no inventory; fixes [GitHub issue #18](https://github.com/mopub/mopub-android-sdk/issues/18)
  - Fixed a bug where redirect URLs were malformed, causing the native browser to not render ads
  - Updated Millennial Media jar to 5.1.0
  - Updated Greystripe custom event support to 2.3.0
  - Fixed MRAID 2.0 `storePicture` command's messaging when a picture either fails to download or fails to save to device
  - Expanded MRAID 2.0 `createCalendarEvent` command to support both minute- and second-level granularity

#### Version 1.15.1.1 (September 4, 2013)
  - Made the SDK more resilient to unexpected Flash creatives

## Version 1.15.1 (August 27, 2013)
  - Updated documentation to remove the requirement for certain AndroidManifest permissions
  - Fixed minor bug with MRAID 2.0 `storePicture` command where the user sees a false download completed message

## Version 1.15 (August 21, 2013)

Includes support for ads in the MRAID 2.0 format. MRAID 2.0 allows advertisers to create ads with rich media functionality, including adding calendar events, storing pictures and playing videos in the native video player. To learn more about MRAID 2.0, read our [help article](http://j.mp/16MKSci).

  - Added the following MRAID 2.0 features: `createCalendarEvent` (Android 4.0 and above), `playVideo`, `storePicture`, and `supports`
  - Hardware Acceleration is now enabled by default for `MraidInterstitial`s on Android 4.0 and above
  - Ensured that Cursors in `FacebookKeywordProvider` are always closed properly; fixes [GitHub issue #8](https://github.com/mopub/mopub-android-sdk/issues/8)
  - Added tracking parameter to InMobi ad requests; fixes [GitHub issue #15](https://github.com/mopub/mopub-android-sdk/issues/15)
  - Banner WebViews are now removed from the view hierarchy before they are destroyed; fixes [GitHub issue #23](https://github.com/mopub/mopub-android-sdk/issues/23)

To correctly display ads that ask the user to save a picture (storePicture ads), you need to make the following change to AndroidManifest.xml:
* Add the`WRITE_EXTERNAL_STORAGE` permission. Note: **Adding the permission is optional**. If the permission is not added, we will not deliver any store picture ads to the users' devices. All other features will remain functional without the new permission.

To allow users to play videos using the native video player:
* Declare activity `com.mopub.mobileads.MraidVideoPlayerActivity`. This activity is required to support playing videos in the native player and we strongly recommend adding it.

## Version 1.14.1 (June 21, 2013)
  - Wait until after loaded interstitials are shown to report an impression
  - Remove phantom impression tracking from interstitials
  - Remove extra whitespace from Millennial banner ads
  - Added `onInterstitialClicked()` notification to `InterstitialAdListener`
  - Provide default implementations for `BannerAdListener` and `InterstitialAdListener`

## Version 1.14 (May 28, 2013)

  - Provided improved support for Android Unity by moving all project resources (including layouts, javascript, images, and values) into source
  - Removed reference to TYPE_DUMMY in AdUrlGenerator because it is not available in earlier versions of Android; fixes [GitHub issue #3](https://github.com/mopub/mopub-android-sdk/issues/3)
  - Fixed NPE in AdUrlGenerator when WiFi is off and Airplane mode is on; fixes [GitHub issue #5](https://github.com/mopub/mopub-android-sdk/issues/5)
  - `MraidInterstitial`s now properly notify `InterstitialAdListener` when they are shown and dismissed

## Version 1.13.1 (May 21, 2013)
  - Updated Millennial support to Millennial Media SDK version 5.0.1

#### Version 1.13.0.2 (May 17, 2013)

  - Relaxed access modifiers for `CustomEventBanner` and `CustomEventInterstitial`

#### Version 1.13.0.1 (May 15, 2013)

  - Removed extraneous display call in `MillennialInterstitial` custom event
  - Fixed potential NPE in `AdView`'s loadUrl()
  - Deprecated `HTML5AdView` after fixing some compilation issues

## Version 1.13 (May 9, 2013)
  - Moved all Android code and documentation to its own repository: [mopub-android-sdk](https://github.com/mopub/mopub-android-sdk)
  - Updated Millennial support to Millennial Media SDK version 5.0
      - Support for Millennial Media SDK 5.0.1 is ready and will be released when the new Milllennial SDK becomes available
  - Added `GoogleAdMobBanner`, `GoogleAdMobInterstitial`, `MillennialBanner`, and `MillennialInterstitial` custom event classes
  - Removed obsolete native network adapters
  - Added timeout for third-party networks (10 seconds for banners and 30 seconds for interstitials)
  - Added more data signals (application version, connection type, and location accuracy)

## Version 1.12 (April 26, 2013)
  - Chartboost custom event now automatically parses server data
  - Added support for Millennial Media SDK 5.0
  - Initial support for data signals (connectivity and carrier)

## Version 1.11 (March 13, 2013)
  - Deprecated multiple `MoPubView` event listener interfaces in favor of a unified `MoPubView.BannerAdListener` interface
  - Deprecated `MoPubInterstitial` listener interface in favor of a new `MoPubInterstitial.InterstitialAdListener` interface
  - Added "shown" and "dismissed" listener methods to `MoPubInterstitial.InterstitialAdListener` interface
  - Fixed a NullPointerException in `MoPubInterstitial` for waterfalls containing multiple custom events
  - Fixed a NullPointerException when tracking impressions for native network SDKs
  - Fixed issue causing `MoPubView` to left-align HTML banners
  - Fixed issue causing incorrect return value for `isReady` when using `MoPubInterstitial` and custom events

## Version 1.10 (February 13, 2013)
  - Introduced custom event classes
  - Improved error logging during `AdFetch`
  - Fixed view resource ID conflicts in `MraidDisplayController`
  - Fixed issue in which un-implemented custom events could disrupt the mediation waterfall
  - Added ability to force refresh ad units
  - Added testing accessors to `MoPubView` and `MoPubInterstitial`
  - Updated to correctly reflect MRAID capabilities in ad request
  - Updated to perform `HttpClient` shutdown on background thread

## Version 1.9 (September 27, 2012)
  - Added support for the Facebook ads test program
  - Updated the Millennial adapters to support SDK version 4.6.0

## Version 1.8 (September 6, 2012)
  - Fixed a crash resulting from following market:// links when Google Play is not installed
  - Added in-app browser support for more Google Play redirect styles
  - Added exponential backoff on ad server failure
  - Included new ad unit IDs for sample ads in SimpleAdsDemo
  - Removed extraneous image files

## Version 1.7 (August 2, 2012)
  - Added support for Millennial Media leaderboard ads

## Version 1.6 (June 29, 2012)
  - Improved click experience by directing clicks to an in-app browser
  - Fixed errors loading mraid.js from disk on Android 4.0+
  - Added `ThreadPoolExecutor` for AsyncTasks on Android 4.0+
  - Fixed incorrect failover behavior for Custom Native Network banners

## Version 1.5 (May 10, 2012)
  - Added support for Millennial Media SDK 4.5.5
  - Fixed ANR relating to synchronization in `LoadUrlTask`
  - Fixed IllegalArgumentExceptions when creating HttpGet objects with malformed URLs

## Version 1.4 (March 28, 2012)
  - Fixed some NullPointerExceptions in the AdMob and Millennial native adapters
  - Fixed issues in which third-party adapters might not properly fail over
  - Fixed a crash caused by unregistering non-existent broadcast receivers

## Version 1.3 (March 14, 2012)
  - Fixed handling of potential SecurityExceptions from network connectivity checks
  - Exposed keyword APIs for interstitials
  - Fixed click-tracking for custom:// and other non-http intents

## Version 1.2 (February 29, 2012)
  - Added support for custom events
  - Added network connectivity check before loading an ad
  - Added `OnAdPresentedOverlay` listener methods
