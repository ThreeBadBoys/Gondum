package com.dsproject.gondum;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {

    Button one;
    Button two;
    Typeface typeface;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_layout);
        changeStatusBarColor();
        init();
        changeFont();
        avoidStatusBarChange();
        mediaPlayer = MediaPlayer.create(this, R.raw.main);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.release();
    }

    void init() {
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        typeface = Typeface.createFromAsset(getResources().getAssets(), "iransansweb.ttf");
    }

    void changeFont() {
        one.setTypeface(typeface);
        two.setTypeface(typeface);
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        }
    }

    public void onClickListener(View view) {
        switch (view.getId()) {
            case R.id.one:
                Intent intent1 = new Intent(this, OnePlayersActivity.class);
                startActivity(intent1);
                break;
            case R.id.two:
                Intent intent2 = new Intent(this, TwoPlayersActivity.class);
                startActivity(intent2);
                break;
            case R.id.three:
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
                break;
        }

    }

    private void avoidStatusBarChange() {
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN ) == 0){
                    changeStatusBarColor();

                } else{
                    changeStatusBarColor();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Window window = getWindow();
                        window.getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_FULLSCREEN);
                        window.setStatusBarColor(Color.parseColor("#1EB83C"));
                    }
                }
            }
        });

    }
}