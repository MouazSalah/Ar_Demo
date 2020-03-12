package com.aliensglopal.ardemo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.aliensglopal.ardemo.R;
import com.aliensglopal.ardemo.ui.imagesactivity.AnimalsActivity;

import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class SplashActivity extends AppCompatActivity
{
    CircleImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageView = findViewById(R.id.splash_image);
        textView = findViewById(R.id.splash_name);

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashActivity.this, AnimalsActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, 5000);

        Animation a = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation b = AnimationUtils.loadAnimation(this, R.anim.fade_transition_btt);
        a.reset();
        a.setDuration(3000);
        b.reset();
        b.setDuration(3000);

        imageView.clearAnimation();
        imageView.startAnimation(a);
        textView.clearAnimation();
        textView.startAnimation(b);
    }
}


