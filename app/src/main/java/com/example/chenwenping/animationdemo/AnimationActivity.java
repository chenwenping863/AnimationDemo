package com.example.chenwenping.animationdemo;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

public class AnimationActivity extends AppCompatActivity {

    private Animation textAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        FrameLayout textContainer = (FrameLayout) findViewById(R.id.textview_container) ;

        ((ViewStub) textContainer.findViewById(R.id.viewstub)).inflate();
        final TextView textView = (TextView) findViewById(R.id.text_back_back);
        textContainer.postDelayed(new Runnable() {
            @Override
            public void run() {
                startBlinkAnimation(textView);
            }
        }, 1000);
    }

    private void startBlinkAnimation(TextView textView) {
        if (textAnimation == null) {
            textAnimation = AnimationUtils.loadAnimation(this, R.anim.view_blink);
        }
        textView.startAnimation(textAnimation);
    }
}
