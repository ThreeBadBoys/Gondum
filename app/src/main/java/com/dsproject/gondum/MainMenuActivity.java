package com.dsproject.gondum;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class MainMenuActivity extends AppCompatActivity {


    SharedPreferences pref;
    Button one;
    Button two;
    Typeface typeface;
    MediaPlayer mediaPlayer;
    ImageView imageView;
    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_layout);
        changeStatusBarColor();
        init();
        changeFont();
        avoidStatusBarChange();

        pref = getSharedPreferences("myprefs", MODE_PRIVATE);

        mediaPlayer = MediaPlayer.create(this, R.raw.main);
        mediaPlayer.setLooping(true);
        if (pref.getBoolean("SOUND", true)) {
            a = 1;
            imageView.setImageResource(R.drawable.audio);
            mediaPlayer.start();
        } else {
            a = 2;
            imageView.setImageResource(R.drawable.noaudio);
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a++;
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("SOUND", (a % 2 != 0));
                editor.apply();
                imageView.setImageResource((pref.getBoolean("SOUND", true) ? R.drawable.audio : R.drawable.noaudio));
                try {
                    if (mediaPlayer.isPlaying() && !pref.getBoolean("SOUND", true)) {
                        mediaPlayer.pause();
                    } else if (!mediaPlayer.isPlaying() && pref.getBoolean("SOUND", true)) {
                        mediaPlayer.start();
                    }
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        });
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
        imageView = findViewById(R.id.settings);
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
                finish();
                break;
            case R.id.two:
                Intent intent2 = new Intent(this, TwoPlayersActivity.class);
                startActivity(intent2);
                finish();
                break;
            case R.id.three:
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
                break;
            case R.id.four:
                Intent intent3 = new Intent(this, HowToPlayActivity.class);
                startActivity(intent3);
                break;
        }

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
}