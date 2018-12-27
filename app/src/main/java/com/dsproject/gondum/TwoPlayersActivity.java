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

    int x;
    int y;
    int z;
    ImageView Img;

    Game game = new Game();

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

    public Result playTurn(int x, int y, int z, ImageView Img){
        Result res = new Result();
        if(game.turn==1){
            if(game.red.phase==1){
                res.succ = game.setup(x, y, z);
                res.x = x;
                res.y = y;
                res.z = z;
                res.phase = 1;
                res.turn = game.turn;
                return res;
            } else if (game.red.phase==2){
                res.phase = game.red.phase;
                if(this.x != -1){
                    res.succ = game.move(this.x, this.y, this.z, x, y, z);
                    res.x = this.x;
                    res.y = this.y;
                    res.z = this.z;
                    res.turn = game.turn;
                    this.x = -1;
                    return res;
                } else {
                    res.succ=false;
                    this.x = x;
                    this.y = y;
                    this.z = z;
                    this.Img = Img;
                    return res;
                }
            } else {
                res.phase = game.blue.phase;
                if(this.x != -1){
                    res.succ = game.fly(this.x, this.y, this.z, x, y, z);
                    res.x = this.x;
                    res.y = this.y;
                    res.z = this.z;
                    res.turn = game.turn;
                    this.x = -1;
                    return res;
                } else {
                    res.succ=false;
                    this.x = x;
                    this.y = y;
                    this.z = z;
                    this.Img = Img;
                    return res;
                }
            }
        } else {
            if (game.blue.phase == 1) {
                res.succ = game.setup(x, y, z);
                res.x = x;
                res.y = y;
                res.z = z;
                res.phase = 1;
                res.turn = game.turn;
                return res;
            } else if (game.blue.phase == 2) {
                res.phase = game.blue.phase;
                if (this.x != -1) {
                    res.succ = game.move(this.x, this.y, this.z, x, y, z);
                    res.x = this.x;
                    res.y = this.y;
                    res.z = this.z;
                    res.turn = game.turn;
                    this.x = -1;
                    return res;
                } else {
                    res.succ = false;
                    this.x = x;
                    this.y = y;
                    this.z = z;
                    this.Img = Img;
                    return res;
                }
            } else {
                res.phase = game.blue.phase;
                if (this.x != -1) {
                    res.succ = game.fly(this.x, this.y, this.z, x, y, z);
                    res.x = this.x;
                    res.y = this.y;
                    res.z = this.z;
                    res.turn = game.turn;
                    this.x = -1;
                    return res;
                } else {
                    res.succ = false;
                    this.x = x;
                    this.y = y;
                    this.z = z;
                    this.Img = Img;
                    return res;
                }
            }
        }
    }

    public void onClick(View view) {
        Result res = new Result();
        switch (view.getId()) {
            case R.id.image1:
                res = playTurn(0, 0, 0, imageView1);
                if(res.succ){
                    imageView1.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
                    if(res.phase>1){
                        this.Img.setImageResource(0);
                    }
                }
                break;
            case R.id.image2:
                res = playTurn(0, 1, 0, imageView2);
                if(res.succ){
                    imageView2.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
                    if(res.phase>1){
                        this.Img.setImageResource(0);
                    }
                }
                break;
            case R.id.image3:
                res = playTurn(0, 2, 0, imageView3);
                if(res.succ){
                    imageView3.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
                    if(res.phase>1){
                        this.Img.setImageResource(0);
                    }
                }
                break;
            case R.id.image4:
                res = playTurn(0, 0, 1, imageView4);
                if(res.succ){
                    imageView4.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
                    if(res.phase>1){
                        this.Img.setImageResource(0);
                    }
                }
                break;
            case R.id.image5:
                res = playTurn(0, 1, 1, imageView5);
                if(res.succ){
                    imageView5.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
                    if(res.phase>1){
                        this.Img.setImageResource(0);
                    }
                }
                break;
            case R.id.image6:
                res = playTurn(0, 2, 1, imageView6);
                if(res.succ){
                    imageView6.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
                    if(res.phase>1){
                        this.Img.setImageResource(0);
                    }
                }
                break;
            case R.id.image7:
                res = playTurn(0, 0, 2, imageView7);
                if(res.succ){
                    imageView7.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
                    if(res.phase>1){
                        this.Img.setImageResource(0);
                    }
                }
                break;
            case R.id.image8:
                res = playTurn(0, 1, 2, imageView8);
                if(res.succ){
                    imageView8.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
                    if(res.phase>1){
                        this.Img.setImageResource(0);
                    }
                }
                break;
            case R.id.image9:
                res = playTurn(0, 2, 2, imageView9);
                if(res.succ){
                    imageView9.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
                    if(res.phase>1){
                        this.Img.setImageResource(0);
                    }
                }
                break;
            case R.id.image10:
                res = playTurn(1, 0, 0, imageView10);
                if(res.succ){
                    imageView10.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
                    if(res.phase>1){
                        this.Img.setImageResource(0);
                    }
                }
                break;
            case R.id.image11:
                res = playTurn(1, 0, 1, imageView11);
                if(res.succ){
                    imageView11.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
                    if(res.phase>1){
                        this.Img.setImageResource(0);
                    }
                }
                break;
            case R.id.image12:
                res = playTurn(1, 0, 2, imageView12);
                if(res.succ){
                    imageView12.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
                    if(res.phase>1){
                        this.Img.setImageResource(0);
                    }
                }
                break;
            case R.id.image13:
                res = playTurn(1, 2, 0, imageView13);
                if(res.succ){
                    imageView13.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
                    if(res.phase>1){
                        this.Img.setImageResource(0);
                    }
                }
                break;
            case R.id.image14:
                res = playTurn(1, 2, 1, imageView14);
                if(res.succ){
                    imageView14.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
                    if(res.phase>1){
                        this.Img.setImageResource(0);
                    }
                }
                break;
            case R.id.image15:
                res = playTurn(1, 2, 2, imageView15);
                if(res.succ){
                    imageView15.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
                    if(res.phase>1){
                        this.Img.setImageResource(0);
                    }
                }
                break;
            case R.id.image16:
                res = playTurn(2, 0, 2, imageView16);
                if(res.succ){
                    imageView16.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
                    if(res.phase>1){
                        this.Img.setImageResource(0);
                    }
                }
                break;
            case R.id.image2_17:
                res = playTurn(2, 1, 2, imageView17);
                if(res.succ){
                    imageView17.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
                    if(res.phase>1){
                        this.Img.setImageResource(0);
                    }
                }
                break;
            case R.id.image18:
                res = playTurn(2, 2, 0, imageView18);
                if(res.succ){
                    imageView18.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
                    if(res.phase>1){
                        this.Img.setImageResource(0);
                    }
                }
                break;
            case R.id.image19:
                res = playTurn(2, 0, 1, imageView19);
                if(res.succ){
                    imageView19.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
                    if(res.phase>1){
                        this.Img.setImageResource(0);
                    }
                }
                break;
            case R.id.image20:
                res = playTurn(2, 1, 1, imageView20);
                if(res.succ){
                    imageView20.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
                    if(res.phase>1){
                        this.Img.setImageResource(0);
                    }
                }
                break;
            case R.id.image21:
                res = playTurn(2, 2, 1, imageView21);
                if(res.succ){
                    imageView21.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
                    if(res.phase>1){
                        this.Img.setImageResource(0);
                    }
                }
                break;
            case R.id.image22:
                res = playTurn(2, 0, 0, imageView22);
                if(res.succ){
                    imageView22.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
                    if(res.phase>1){
                        this.Img.setImageResource(0);
                    }
                }
                break;
            case R.id.image23:
                res = playTurn(2, 1, 0, imageView23);
                if(res.succ){
                    imageView23.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
                    if(res.phase>1){
                        this.Img.setImageResource(0);
                    }
                }
                break;
            case R.id.image24:
                res = playTurn(2, 2, 0, imageView24);
                if(res.succ){
                    imageView24.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
                    if(res.phase>1){
                        this.Img.setImageResource(0);
                    }
                }
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