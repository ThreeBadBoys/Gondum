package com.dsproject.gondum;

import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class TwoPlayersActivity extends AppCompatActivity {
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    ImageView imageView13;
    ImageView imageView14;
    ImageView imageView15;
    ImageView imageView16;
    ImageView imageView17;
    ImageView imageView18;
    ImageView imageView19;
    ImageView imageView20;
    ImageView imageView21;
    ImageView imageView22;
    ImageView imageView23;
    ImageView imageView24;
    TextView men_blue;
    TextView men_red;
    TextView men_blue_trash;
    TextView men_red_trash;
    Typeface typeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_players_layout);
        init();
        changeStatusBarColor();
        changeFont();
        men_red.setText(NumberToPersian.toPersianNumber("12"));
        men_blue.setText(NumberToPersian.toPersianNumber("12"));
        men_blue_trash.setText(NumberToPersian.toPersianNumber("0"));
        men_red_trash.setText(NumberToPersian.toPersianNumber("0"));

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image1:
                if(imageView1.getDrawable() == null){
                    imageView1.setImageResource(R.drawable.red);
                }else{
                    imageView1.setBackgroundResource(R.drawable.red_border);
                }
                break;
            case R.id.image2:
                imageView2.setImageResource(R.drawable.blue);
                break;
            case R.id.image3:
                imageView3.setImageResource(R.drawable.red);
                break;
            case R.id.image4:
                imageView4.setImageResource(R.drawable.red);
                break;
            case R.id.image5:
                imageView5.setImageResource(R.drawable.red);
                break;
            case R.id.image6:
                imageView6.setImageResource(R.drawable.red);
                break;
            case R.id.image7:
                imageView7.setImageResource(R.drawable.red);
                break;
            case R.id.image8:
                imageView8.setImageResource(R.drawable.red);
                break;
            case R.id.image9:
                imageView9.setImageResource(R.drawable.red);
                break;
            case R.id.image10:
                imageView10.setImageResource(R.drawable.red);
                break;
            case R.id.image11:
                imageView11.setImageResource(R.drawable.red);
                break;
            case R.id.image12:
                imageView12.setImageResource(R.drawable.red);
                break;
            case R.id.image13:
                imageView13.setImageResource(R.drawable.red);
                break;
            case R.id.image14:
                imageView14.setImageResource(R.drawable.red);
                break;
            case R.id.image15:
                imageView15.setImageResource(R.drawable.red);
                break;
            case R.id.image16:
                imageView16.setImageResource(R.drawable.red);
                break;
            case R.id.image17:
                imageView17.setImageResource(R.drawable.red);
                break;
            case R.id.image18:
                imageView18.setImageResource(R.drawable.red);
                break;
            case R.id.image19:
                imageView19.setImageResource(R.drawable.red);
                break;
            case R.id.image20:
                imageView20.setImageResource(R.drawable.red);
                break;
            case R.id.image21:
                imageView21.setImageResource(R.drawable.red);
                break;
            case R.id.image22:
                imageView22.setImageResource(R.drawable.red);
                break;
            case R.id.image23:
                imageView23.setImageResource(R.drawable.red);
                break;
            case R.id.image24:
                imageView24.setImageResource(R.drawable.red);
                break;
        }
    }

    void init() {
        imageView1 = findViewById(R.id.image1);
        imageView2 = findViewById(R.id.image2);
        imageView3 = findViewById(R.id.image3);
        imageView4 = findViewById(R.id.image4);
        imageView5 = findViewById(R.id.image5);
        imageView6 = findViewById(R.id.image6);
        imageView7 = findViewById(R.id.image7);
        imageView8 = findViewById(R.id.image8);
        imageView9 = findViewById(R.id.image9);
        imageView10 = findViewById(R.id.image10);
        imageView11 = findViewById(R.id.image11);
        imageView12 = findViewById(R.id.image12);
        imageView13 = findViewById(R.id.image13);
        imageView14 = findViewById(R.id.image14);
        imageView15 = findViewById(R.id.image15);
        imageView16 = findViewById(R.id.image16);
        imageView17 = findViewById(R.id.image17);
        imageView18 = findViewById(R.id.image18);
        imageView19 = findViewById(R.id.image19);
        imageView20 = findViewById(R.id.image20);
        imageView21 = findViewById(R.id.image21);
        imageView22 = findViewById(R.id.image22);
        imageView23 = findViewById(R.id.image23);
        imageView24 = findViewById(R.id.image24);
        men_blue = findViewById(R.id.blue_men);
        men_red = findViewById(R.id.red_men);
        men_blue_trash = findViewById(R.id.blue_men_trash);
        men_red_trash = findViewById(R.id.red_men_trash);
        typeface = Typeface.createFromAsset(getResources().getAssets(), "iransansweb.ttf");
    }

    void changeFont() {
        men_blue.setTypeface(typeface);
        men_red.setTypeface(typeface);
        men_blue_trash.setTypeface(typeface);
        men_red_trash.setTypeface(typeface);
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        }
    }
}