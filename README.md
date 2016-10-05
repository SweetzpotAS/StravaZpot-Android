# StravaZpot
A fluent API to integrate with Strava on Android apps.

## Usage

This document explains how to use **StravaZpot** in your Android app. For additional questions, you may want to check **Strava** official documentation [here](https://strava.github.io/api/).

## Authentication

### Login button

StravaZpot includes a custom view to include a login button according to Strava guidelines. To do that, you can add the following code to your XML layout:

```xml
<com.sweetzpot.stravazpot.authenticaton.ui.StravaLoginButton
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/login_button"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_gravity="center"
    app:type="orange"/>
```
The custom attribute `type` accepts two different values: `orange` and `light` (default). `StravaLoginButton` makes use of vector drawables in the support library. Thus, if you are targeting version prior to Android API 21, you would need to add the following code to your Activity:

```java
static {
    AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
}
```

### Login Activity

Strava uses OAuth 2.0 to authenticate users, and then request them to grant permission to your app. To get a Client ID and Secret from Strava for your app, follow [this link](https://www.strava.com/settings/api).

Once you have your app credentials, you can get an `Intent` to launch the login activity for your app. You can easily do it with:

```java
Intent intent = StravaLogin.withContext(this)
                  .withClientID(<YOUR_CLIENT_ID>)
                  .withRedirectURI(<YOUR_REDIRECT_URL>)
                  .withApprovalPrompt(ApprovalPrompt.AUTO)
                  .withAccessScope(AccessScope.VIEW_PRIVATE_WRITE)
                  .makeIntent();
startActivityForResult(intent, RQ_LOGIN);
```

You need to notice several things with this call:

- `<YOUR_CLIENT_ID>` must be replaced with the Client ID provided by Strava when you registered your application.
- `<YOUR_REDIRECT_URL>` must be in the domain you specified when you registered your app in Strava.
- Refer to `ApprovalPrompt` enum to get more options for this parameter.
- Refer to `AccessScope` enum to get more options for this parameter.
- You need to launch the intent with `startActivityForResult` since the login activity will return a value that you will need later to obtain a token. If login to Strava was successful and the user granted permission to your app, you will receive a `code` that you can retrieve with:

```java
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if(requestCode == RQ_LOGIN && resultCode == RESULT_OK && data != null) {
        String code = data.getStringExtra(StravaLoginActivity.RESULT_CODE));
        // Use code to obtain token
    }
}
```

### Obtain a Token

Every Strava API call needs a token to prove the user is authenticated and the app has permission to access the API. After you have obtained the code from user login, you need to exchange it with Strava to get a token. You can do it with the following code:

```java
AuthenticationConfig config = AuthenticationConfig.create()
                                                  .debug()
                                                  .build();
AuthenticationAPI api = new AuthenticationAPI(config);
LoginResult result = api.getTokenForApp(AppCredentials.with(CLIENT_ID, CLIENT_SECRET))
                        .withCode(CODE)
                        .execute();

```
Notice that in this call you must provide the Client ID and Secret provided by Strava when you registered your application, and the code obtained during the login process. Also, the execution of the previous code involves a network request; **you are responsible for calling this code in a suitable thread, outside the UI thread**. Otherwise, you will get an exception.

If the previous request is successful, you will get a `LoginResult`, which has a `Token` that you can use in your subsequent API calls, and an `Athlete` instance, representing the authenticated user.

## License


    Copyright 2016 SweetZpot AS

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.