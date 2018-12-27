package com.dsproject.gondum;

import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class OnePlayersActivity extends AppCompatActivity {
    ImageView imageView2_1;
    ImageView imageView2_2;
    ImageView imageView2_3;
    ImageView imageView2_4;
    ImageView imageView2_5;
    ImageView imageView2_6;
    ImageView imageView2_7;
    ImageView imageView2_8;
    ImageView imageView2_9;
    ImageView imageView2_10;
    ImageView imageView2_11;
    ImageView imageView2_12;
    ImageView imageView2_13;
    ImageView imageView2_14;
    ImageView imageView2_15;
    ImageView imageView2_16;
    ImageView imageView2_17;
    ImageView imageView2_18;
    ImageView imageView2_19;
    ImageView imageView2_20;
    ImageView imageView2_21;
    ImageView imageView2_22;
    ImageView imageView2_23;
    ImageView imageView2_24;
    TextView men_blue;
    TextView men_red;
    TextView men_blue_trash;
    TextView men_red_trash;
    Typeface typeface;

    int x;
    int y;
    int z;

    Game game = new Game();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_players);
        init();
        changeStatusBarColor();
        changeFont();
        men_red.setText(NumberToPersian.toPersianNumber("12"));
        men_blue.setText(NumberToPersian.toPersianNumber("12"));
        men_blue_trash.setText(NumberToPersian.toPersianNumber("0"));
        men_red_trash.setText(NumberToPersian.toPersianNumber("0"));
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        }
    }

    void init() {
        imageView2_1 = findViewById(R.id.image2_1);
        imageView2_2 = findViewById(R.id.image2_2);
        imageView2_3 = findViewById(R.id.image2_3);
        imageView2_4 = findViewById(R.id.image2_4);
        imageView2_5 = findViewById(R.id.image2_5);
        imageView2_6 = findViewById(R.id.image2_6);
        imageView2_7 = findViewById(R.id.image2_7);
        imageView2_8 = findViewById(R.id.image2_8);
        imageView2_9 = findViewById(R.id.image2_9);
        imageView2_10 = findViewById(R.id.image2_10);
        imageView2_11 = findViewById(R.id.image2_11);
        imageView2_12 = findViewById(R.id.image2_12);
        imageView2_13 = findViewById(R.id.image2_13);
        imageView2_14 = findViewById(R.id.image2_14);
        imageView2_15 = findViewById(R.id.image2_15);
        imageView2_16 = findViewById(R.id.image2_16);
        imageView2_17 = findViewById(R.id.image2_17);
        imageView2_18 = findViewById(R.id.image2_18);
        imageView2_19 = findViewById(R.id.image2_19);
        imageView2_20 = findViewById(R.id.image2_20);
        imageView2_21 = findViewById(R.id.image2_21);
        imageView2_22 = findViewById(R.id.image2_22);
        imageView2_23 = findViewById(R.id.image2_23);
        imageView2_24 = findViewById(R.id.image2_24);
        men_blue = findViewById(R.id.blue_men_2);
        men_red = findViewById(R.id.red_men_2);
        men_blue_trash = findViewById(R.id.blue_men_trash_2);
        men_red_trash = findViewById(R.id.red_men_trash_2);
        typeface = Typeface.createFromAsset(getResources().getAssets(), "iransansweb.ttf");
    }

    void changeFont() {
        men_blue.setTypeface(typeface);
        men_red.setTypeface(typeface);
        men_blue_trash.setTypeface(typeface);
        men_red_trash.setTypeface(typeface);
    }

    public void playTurn(int x, int y, int z){
        if(game.turn==1){
            if(game.red.phase==1){
                game.setup(x, y, z);
            } else if (game.red.phase==2){
                if(this.x != -1 && this.y != -1 && this.z != -1){
                    game.move(this.x, this.x, this.x, x, y, z);
                    this.x = -1;
                    this.y = -1;
                    this.z = -1;
                } else {
                    this.x = x;
                    this.y = y;
                    this.z = z;
                }
            } else {
                if(this.x != -1 && this.y != -1 && this.z != -1){
                    game.fly(this.x, this.x, this.x, x, y, z);
                    this.x = -1;
                    this.y = -1;
                    this.z = -1;
                } else {
                    this.x = x;
                    this.y = y;
                    this.z = z;
                }
            }
        }
    }

    public void onClick1(View view) {
        switch (view.getId()) {
            case R.id.image2_1:
                imageView2_1.setImageResource(R.drawable.red);
                playTurn(0, 0, 0);
                break;
            case R.id.image2_2:
                imageView2_2.setImageResource(R.drawable.blue);
                playTurn(0, 1, 0);
                break;
            case R.id.image2_3:
                imageView2_3.setImageResource(R.drawable.red);
                playTurn(0, 2, 0);
                break;
            case R.id.image2_4:
                imageView2_4.setImageResource(R.drawable.red);
                playTurn(0, 0, 1);
                break;
            case R.id.image2_5:
                imageView2_5.setImageResource(R.drawable.red);
                playTurn(0, 1, 1);
                break;
            case R.id.image2_6:
                imageView2_6.setImageResource(R.drawable.red);
                playTurn(0, 2, 1);
                break;
            case R.id.image2_7:
                imageView2_7.setImageResource(R.drawable.red);
                playTurn(0, 0, 2);
                break;
            case R.id.image2_8:
                imageView2_8.setImageResource(R.drawable.red);
                playTurn(0, 1, 2);
                break;
            case R.id.image2_9:
                imageView2_9.setImageResource(R.drawable.red);
                playTurn(0, 2, 2);
                break;
            case R.id.image2_10:
                imageView2_10.setImageResource(R.drawable.red);
                playTurn(1, 0, 0);
                break;
            case R.id.image2_11:
                imageView2_11.setImageResource(R.drawable.red);
                playTurn(1, 0, 1);
                break;
            case R.id.image2_12:
                imageView2_12.setImageResource(R.drawable.red);
                playTurn(1, 0, 2);
                break;
            case R.id.image2_13:
                imageView2_13.setImageResource(R.drawable.red);
                playTurn(1, 2, 0);
                break;
            case R.id.image2_14:
                imageView2_14.setImageResource(R.drawable.red);
                playTurn(1, 2, 1);
                break;
            case R.id.image2_15:
                imageView2_15.setImageResource(R.drawable.red);
                playTurn(1, 2, 2);
                break;
            case R.id.image2_16:
                imageView2_16.setImageResource(R.drawable.red);
                playTurn(2, 0, 2);
                break;
            case R.id.image2_17:
                imageView2_17.setImageResource(R.drawable.red);
                playTurn(2, 1, 2);
                break;
            case R.id.image2_18:
                imageView2_18.setImageResource(R.drawable.red);
                playTurn(2, 2, 2);
                break;
            case R.id.image2_19:
                imageView2_19.setImageResource(R.drawable.red);
                playTurn(2, 0, 1);
                break;
            case R.id.image2_20:
                imageView2_20.setImageResource(R.drawable.red);
                playTurn(2, 1, 1);
                break;
            case R.id.image2_21:
                imageView2_21.setImageResource(R.drawable.red);
                playTurn(2, 2, 1);
                break;
            case R.id.image2_22:
                imageView2_22.setImageResource(R.drawable.red);
                playTurn(2, 0, 0);
                break;
            case R.id.image2_23:
                imageView2_23.setImageResource(R.drawable.red);
                playTurn(2, 1, 0);
                break;
            case R.id.image2_24:
                imageView2_24.setImageResource(R.drawable.red);
                playTurn(2, 2, 0);
                break;
        }
    }
}