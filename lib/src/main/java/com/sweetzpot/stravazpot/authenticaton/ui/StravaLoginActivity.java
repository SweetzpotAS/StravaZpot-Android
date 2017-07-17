package com.sweetzpot.stravazpot.authenticaton.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.sweetzpot.stravazpot.R;

public class StravaLoginActivity extends AppCompatActivity {

    public static final String EXTRA_LOGIN_URL = "StravaLoginActivity.EXTRA_LOGIN_URL";
    public static final String EXTRA_REDIRECT_URL = "StravaLoginActivity.EXTRA_REDIRECT_URL";
    public static final String RESULT_CODE = "StravaLoginActivity.RESULT_CODE";

    private WebView loginWebview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strava_login);

        loginWebview = (WebView) findViewById(R.id.login_webview);

        configureWebViewClient();
        loadLoginURL();
    }

    private void configureWebViewClient() {
        loginWebview.getSettings().setJavaScriptEnabled(true);
        loginWebview.getSettings().setUserAgentString("Mozilla/5.0 Google");

        loginWebview.setWebViewClient(new WebViewClient(){
            @SuppressWarnings("deprecation")
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return handleUrl(Uri.parse(url)) || super.shouldOverrideUrlLoading(view, url);
            }

            @TargetApi(Build.VERSION_CODES.N)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                final Uri uri = request.getUrl();
                return handleUrl(uri) || super.shouldOverrideUrlLoading(view, request);
            }

            private boolean handleUrl(Uri uri) {
                String redirectURL = getIntent().getStringExtra(EXTRA_REDIRECT_URL);
                if(uri.toString().startsWith(redirectURL)) {
                    String code = uri.getQueryParameter("code");
                    return makeResult(code);
                }
                return false;
            }

            private boolean makeResult(String code) {
                if(code != null && !code.isEmpty()) {
                    Intent result = new Intent();
                    result.putExtra(RESULT_CODE, code);
                    setResult(RESULT_OK, result);
                    finish();
                    return true;
                }
                finish();
                return false;
            }
        });
    }

    private void loadLoginURL() {
        String loginURL = getIntent().getStringExtra(EXTRA_LOGIN_URL);
        loginWebview.loadUrl(loginURL);
    }
}
