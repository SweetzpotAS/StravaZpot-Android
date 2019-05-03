package com.sweetzpot.stravazpot.authenticaton.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageButton;

import com.sweetzpot.stravazpot.R;

public class StravaLoginButton extends android.support.v7.widget.AppCompatImageButton {
    public StravaLoginButton(Context context) {
        this(context, null);
    }

    public StravaLoginButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StravaLoginButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        int imageResource = R.drawable.btn_strava_connectwith_light;
        if(attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.StravaLoginButton,
                    0, 0);

            try {
                imageResource = a.getInteger(R.styleable.StravaLoginButton_type, 0) == 0 ?
                                    R.drawable.btn_strava_connectwith_light :
                                    R.drawable.btn_strava_connectwith_orange;
            } finally {
                a.recycle();
            }
        }

        this.setImageResource(imageResource);
    }

}
