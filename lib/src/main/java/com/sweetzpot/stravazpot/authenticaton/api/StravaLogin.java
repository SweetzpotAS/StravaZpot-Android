package com.sweetzpot.stravazpot.authenticaton.api;

import android.content.Context;
import android.content.Intent;

import android.net.Uri;
import com.sweetzpot.stravazpot.authenticaton.ui.StravaLoginActivity;

public class StravaLogin {

    private static final String STRAVA_LOGIN_URL_MOBILE = "https://www.strava.com/oauth/mobile/authorize";
    private static final String STRAVA_LOGIN_URL_WEB = "https://www.strava.com/oauth/authorize";

    private Context context;
    private int clientID;
    private String redirectURI;
    private ApprovalPrompt approvalPrompt;
    private AccessScope accessScope;

    public static StravaLogin withContext(Context context) {
        return new StravaLogin(context);
    }

    public StravaLogin(Context context) {
        this.context = context;
    }

    public StravaLogin withClientID(int clientID) {
        this.clientID = clientID;
        return this;
    }

    public StravaLogin withRedirectURI(String redirectURI) {
        this.redirectURI = redirectURI;
        return this;
    }

    public StravaLogin withApprovalPrompt(ApprovalPrompt approvalPrompt) {
        this.approvalPrompt = approvalPrompt;
        return this;
    }

    public StravaLogin withAccessScope(AccessScope accessScope) {
        this.accessScope = accessScope;
        return this;
    }


    public Intent makeMobileIntent() {
        Intent intent = new Intent(Intent.ACTION_VIEW, makeLoginURL(STRAVA_LOGIN_URL_MOBILE));
        return intent;
    }


    public Intent makeWebIntent() {
        Intent intent = new Intent(context, StravaLoginActivity.class);
        intent.putExtra(StravaLoginActivity.EXTRA_LOGIN_URL, makeLoginURL(STRAVA_LOGIN_URL_WEB).toString());
        intent.putExtra(StravaLoginActivity.EXTRA_REDIRECT_URL, redirectURI);
        return intent;
    }



    private Uri makeLoginURL(String url) {

        return Uri.parse(url)
                .buildUpon()
                .appendQueryParameter("client_id", clientIDParameter())
                .appendQueryParameter("redirect_uri", redirectURIParameter())
                .appendQueryParameter("response_type", "code")
                .appendQueryParameter("approval_prompt", approvalPromptParameter())
                .appendQueryParameter("scope", accessScopeParameter())
                .build();
    }




    private String clientIDParameter() {
        return "" + clientID;
    }

    private String redirectURIParameter() {
        if(redirectURI != null) {
            return redirectURI;
        } else {
            return "";
        }
    }

    private String approvalPromptParameter() {
        if(approvalPrompt != null) {
            return approvalPrompt.toString();
        } else {
            return "";
        }
    }

    private String accessScopeParameter() {
        if(accessScope == null) {
            accessScope = AccessScope.PUBLIC;
        }
        return accessScope.toString();

    }


}
