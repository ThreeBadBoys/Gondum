package com.dsproject.gondum;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class HowToPlayActivity extends AppCompatActivity {
    TextView textView;
    Typeface typeface;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);
        textView = findViewById(R.id.learning);
        typeface = Typeface.createFromAsset(getResources().getAssets(), "iransansweb.ttf");
        textView.setTypeface(typeface);
        changeStatusBarColor();
        avoidStatusBarChange();
        mediaPlayer = MediaPlayer.create(this, R.raw.best);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    private void avoidStatusBarChange() {
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                    changeStatusBarColor();

                } else {
                    changeStatusBarColor();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Window window = getWindow();
                        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
                        window.setStatusBarColor(Color.parseColor("#1EB83C"));
                    }
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        mediaPlayer.pause();
        startActivity(new Intent(this, MainMenuActivity.class));
        finish();
        super.onBackPressed();

    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        }
    }
}
