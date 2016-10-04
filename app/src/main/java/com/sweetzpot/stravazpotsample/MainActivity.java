package com.sweetzpot.stravazpotsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.sweetzpot.stravazpot.authenticaton.ui.StravaLoginActivity;

public class MainActivity extends AppCompatActivity {

    private static final int RQ_LOGIN = 1001;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        Intent intent = new Intent(this, StravaLoginActivity.class);
        intent.putExtra(StravaLoginActivity.EXTRA_LOGIN_URL, "https://www.strava.com/oauth/authorize?client_id=13874&response_type=code&redirect_uri=http://truizlop.github.io/token_exchange&scope=write&state=mystate&approval_prompt=force");
        intent.putExtra(StravaLoginActivity.EXTRA_REDIRECT_URL, "http://truizlop.github.io/token_exchange");
        startActivityForResult(intent, RQ_LOGIN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RQ_LOGIN && resultCode == RESULT_OK && data != null) {
            Log.d("Strava code", data.getStringExtra(StravaLoginActivity.RESULT_CODE));
        }
    }
}
