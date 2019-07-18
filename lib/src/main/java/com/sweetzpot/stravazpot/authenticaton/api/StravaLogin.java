package com.sweetzpot.stravazpot.authenticaton.api;

import android.content.Context;
import android.content.Intent;

import com.sweetzpot.stravazpot.authenticaton.ui.StravaLoginActivity;

public class StravaLogin {

    private static final String STRAVA_LOGIN_URL = "https://www.strava.com/oauth/authorize?response_type=code";
    private Context context;
    private long clientID;
    private String redirectURI;
    private ApprovalPrompt approvalPrompt;
    private AccessScope accessScope;

    public static StravaLogin withContext(Context context) {
        return new StravaLogin(context);
    }

    public StravaLogin(Context context) {
        this.context = context;
    }

    public StravaLogin withClientID(long clientID) {
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

    public Intent makeIntent() {
        Intent intent = new Intent(context, StravaLoginActivity.class);
        intent.putExtra(StravaLoginActivity.EXTRA_LOGIN_URL, makeLoginURL());
        intent.putExtra(StravaLoginActivity.EXTRA_REDIRECT_URL, redirectURI);
        return intent;
    }

    private String makeLoginURL() {
        StringBuilder loginURLBuilder = new StringBuilder();
        loginURLBuilder.append(STRAVA_LOGIN_URL);
        loginURLBuilder.append(clientIDParameter());
        loginURLBuilder.append(redirectURIParameter());
        loginURLBuilder.append(approvalPromptParameter());
        loginURLBuilder.append(accessScopeParameter());
        return loginURLBuilder.toString();
    }

    private String clientIDParameter() {
        return "&client_id=" + clientID;
    }

    private String redirectURIParameter() {
        if(redirectURI != null) {
            return "&redirect_uri=" + redirectURI;
        } else {
            return "";
        }
    }

    private String approvalPromptParameter() {
        if(approvalPrompt != null) {
            return "&approval_prompt=" + approvalPrompt.toString();
        } else {
            return "";
        }
    }

    private String accessScopeParameter() {
        if(accessScope != null) {
            return "&scope=" + accessScope.toString();
        } else {
            return "";
        }
    }


}
