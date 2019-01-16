package com.dsproject.gondum;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class TwoPlayersActivity extends AppCompatActivity {
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
    TextView turn_red;
    TextView turn_blue;
    Typeface typeface;

    int x = -1;
    int y;
    int z;
    ImageView img;
    boolean matched = false;
    Game game = new Game();

    Dialog dialog;
    MediaPlayer mediaPlayer;
    SharedPreferences pref;
    GifImageView gify;
    Button exit;
    Button menu;
    Button restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_players_layout);
        init();
        changeStatusBarColor();
        changeFont();
        men_red.setText(NumberToPersian.toPersianNumber("12"));
        men_blue.setText(NumberToPersian.toPersianNumber("12"));
        turn_blue.setText("منتظر باش");
        turn_red.setText("نوبت منه");
        men_blue_trash.setText(NumberToPersian.toPersianNumber("0"));
        men_red_trash.setText(NumberToPersian.toPersianNumber("0"));

        pref = getSharedPreferences("myprefs", MODE_PRIVATE);

        imageView2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image1Listener();
            }
        });
        imageView2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image2Listener();
            }
        });
        imageView2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image3Listener();
            }
        });
        imageView2_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image4Listener();
            }
        });
        imageView2_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image5Listener();
            }
        });
        imageView2_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image6Listener();
            }
        });
        imageView2_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image7Listener();
            }
        });
        imageView2_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image8Listener();
            }
        });
        imageView2_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image9Listener();
            }
        });
        imageView2_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image10Listener();
            }
        });
        imageView2_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image11Listener();
            }
        });
        imageView2_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image12Listener();
            }
        });
        imageView2_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image13Listener();
            }
        });
        imageView2_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image14Listener();
            }
        });
        imageView2_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image15Listener();
            }
        });
        imageView2_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image16Listener();
            }
        });
        imageView2_17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image17Listener();
            }
        });
        imageView2_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image18Listener();
            }
        });
        imageView2_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image19Listener();
            }
        });
        imageView2_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image20Listener();
            }
        });
        imageView2_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image21Listener();
            }
        });
        imageView2_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image22Listener();
            }
        });
        imageView2_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image23Listener();
            }
        });
        imageView2_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image24Listener();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                startActivity(intent);
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
                Intent intent = new Intent(TwoPlayersActivity.this, MainMenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                game.gameBackEndReset();
                GameFrontEndReset();
                dialog.dismiss();
            }
        });

        avoidStatusBarChange();
        mediaPlayer = MediaPlayer.create(this, R.raw.best);
        if (pref.getBoolean("SOUND", true)) {
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.release();
    }

    private void image1Listener() {
        Result res;
        changeText();
        res = selectNode(0, 0, 0, imageView2_1);
        changeText();
        if (res.succ) {
            imageView2_1.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
        }
    }

    private void image2Listener() {
        Result res;
        changeText();
        res = selectNode(0, 1, 0, imageView2_2);
        changeText();
        if (res.succ) {
            imageView2_2.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
        }
    }

    private void image3Listener() {
        Result res;
        changeText();
        res = selectNode(0, 2, 0, imageView2_3);
        changeText();
        if (res.succ) {
            imageView2_3.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
        }
    }

    private void image4Listener() {
        Result res;
        changeText();
        res = selectNode(0, 0, 1, imageView2_4);
        changeText();
        if (res.succ) {
            imageView2_4.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
        }
    }

    private void image5Listener() {
        Result res;
        changeText();
        res = selectNode(0, 1, 1, imageView2_5);
        changeText();
        if (res.succ) {
            imageView2_5.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
        }
    }

    private void image6Listener() {
        Result res;
        changeText();
        res = selectNode(0, 2, 1, imageView2_6);
        changeText();
        if (res.succ) {
            imageView2_6.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
        }
    }

    private void image7Listener() {
        Result res;
        changeText();
        res = selectNode(0, 0, 2, imageView2_7);
        changeText();
        if (res.succ) {
            imageView2_7.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
        }
    }

    private void image8Listener() {
        Result res;
        changeText();
        res = selectNode(0, 1, 2, imageView2_8);
        changeText();
        if (res.succ) {
            imageView2_8.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
        }
    }

    private void image9Listener() {
        Result res;
        changeText();
        res = selectNode(0, 2, 2, imageView2_9);
        changeText();
        if (res.succ) {
            imageView2_9.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
        }
    }

    private void image10Listener() {
        Result res;
        changeText();
        res = selectNode(1, 0, 0, imageView2_10);
        changeText();
        if (res.succ) {
            imageView2_10.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
        }
    }

    private void image11Listener() {
        Result res;
        changeText();
        res = selectNode(1, 0, 1, imageView2_11);
        changeText();
        if (res.succ) {
            imageView2_11.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
        }
    }

    private void image12Listener() {
        Result res;
        changeText();
        res = selectNode(1, 0, 2, imageView2_12);
        changeText();
        if (res.succ) {
            imageView2_12.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
        }
    }

    private void image13Listener() {
        Result res;
        changeText();
        res = selectNode(1, 2, 2, imageView2_13);
        changeText();
        if (res.succ) {
            imageView2_13.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
        }
    }

    private void image14Listener() {
        Result res;
        changeText();
        res = selectNode(1, 2, 1, imageView2_14);
        changeText();
        if (res.succ) {
            imageView2_14.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
        }
    }

    private void image15Listener() {
        Result res;
        changeText();
        res = selectNode(1, 2, 0, imageView2_15);
        changeText();
        if (res.succ) {
            imageView2_15.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
        }
    }

    private void image16Listener() {
        Result res;
        changeText();
        res = selectNode(2, 0, 2, imageView2_16);
        changeText();
        if (res.succ) {
            imageView2_16.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
        }
    }

    private void image17Listener() {
        Result res;
        changeText();
        res = selectNode(2, 1, 2, imageView2_17);
        changeText();
        if (res.succ) {
            imageView2_17.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
        }
    }

    private void image18Listener() {
        Result res;
        changeText();
        res = selectNode(2, 2, 2, imageView2_18);
        changeText();
        if (res.succ) {
            imageView2_18.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
        }
    }

    private void image19Listener() {
        Result res;
        changeText();
        res = selectNode(2, 0, 1, imageView2_19);
        changeText();
        if (res.succ) {
            imageView2_19.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
        }
    }

    private void image20Listener() {
        Result res;
        changeText();
        res = selectNode(2, 1, 1, imageView2_20);
        changeText();
        if (res.succ) {
            imageView2_20.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
        }
    }

    private void image21Listener() {
        Result res;
        changeText();
        res = selectNode(2, 2, 1, imageView2_21);
        changeText();
        if (res.succ) {
            imageView2_21.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
        }
    }

    private void image22Listener() {
        Result res;
        changeText();
        res = selectNode(2, 0, 0, imageView2_22);
        changeText();
        if (res.succ) {
            imageView2_22.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
        }
    }

    private void image23Listener() {
        changeText();
        Result res = selectNode(2, 1, 0, imageView2_23);
        changeText();
        if (res.succ) {
            imageView2_23.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
        }
    }

    private void image24Listener() {
        changeText();
        Result res = selectNode(2, 2, 0, imageView2_24);
        changeText();
        if (res.succ) {
            imageView2_24.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
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
        turn_blue = findViewById(R.id.blue_turn);
        turn_red = findViewById(R.id.red_turn);
        typeface = Typeface.createFromAsset(getResources().getAssets(), "iransansweb.ttf");
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_layout);
        gify = dialog.findViewById(R.id.gify);
        exit = dialog.findViewById(R.id.exit);
        menu = dialog.findViewById(R.id.main_menu);
        restart = dialog.findViewById(R.id.restart);

    }

    void changeFont() {
        men_blue.setTypeface(typeface);
        men_red.setTypeface(typeface);
        men_blue_trash.setTypeface(typeface);
        men_red_trash.setTypeface(typeface);
        turn_blue.setTypeface(typeface);
        turn_red.setTypeface(typeface);
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        }
    }

    public void changeText() {
        if (game.turn == 1) {
            if (this.matched) {
                turn_red.setText("مهره رفیقت رو حذف کن");
                turn_blue.setText("منتظرباش");
            } else {
                turn_red.setText("نوبت منه");
                turn_blue.setText("منتظرباش");
            }
        } else if (game.turn == 2) {
            if (this.matched) {
                turn_blue.setText("مهره رفیقت رو حذف کن");
                turn_red.setText("منتظرباش");
            } else {
                turn_blue.setText("نوبت منه");
                turn_red.setText("منتظرباش");
            }
        }
    }

    public void GameFrontEndReset() {
        imageView2_1.setImageResource(0);
        imageView2_2.setImageResource(0);
        imageView2_3.setImageResource(0);
        imageView2_4.setImageResource(0);
        imageView2_5.setImageResource(0);
        imageView2_6.setImageResource(0);
        imageView2_7.setImageResource(0);
        imageView2_8.setImageResource(0);
        imageView2_9.setImageResource(0);
        imageView2_10.setImageResource(0);
        imageView2_11.setImageResource(0);
        imageView2_12.setImageResource(0);
        imageView2_13.setImageResource(0);
        imageView2_14.setImageResource(0);
        imageView2_15.setImageResource(0);
        imageView2_16.setImageResource(0);
        imageView2_17.setImageResource(0);
        imageView2_18.setImageResource(0);
        imageView2_19.setImageResource(0);
        imageView2_20.setImageResource(0);
        imageView2_21.setImageResource(0);
        imageView2_22.setImageResource(0);
        imageView2_23.setImageResource(0);
        imageView2_24.setImageResource(0);

        turn_red.setText("نوبت منه");
        turn_blue.setText("منتظرباش");
        men_red_trash.setText("0");
        men_blue_trash.setText("0");
        men_blue.setText("12");
        men_red.setText("12");

    }

    private void shakeItBaby() {
        if (Build.VERSION.SDK_INT >= 26) {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(150, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(150);
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainMenuActivity.class));
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
        game.gameBackEndReset();
        finish();
        super.onBackPressed();
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
//-----------------------------------------------------
    public Result selectNode(int X, int Y, int Z, ImageView img) {
        Result res = new Result();
        if (this.matched) {//For deletion the opponent piece
            res.succ = game.delete(X, Y, Z);
            Log.i("delete", String.valueOf(this.matched));
            if (res.succ) {
                this.matched = false;
                res.turn = 0;
                game.nextTurn();
            }
        } else if (game.turn == 1) {
            if (game.red.phase == 1) {
                res.succ = game.insert(X, Y, Z);
                if (res.succ) {
                    this.matched = game.evaluate(X, Y, Z);
                    res.turn = game.turn;
                    if (this.matched) shakeItBaby(); else game.nextTurn();
                    res.x = X;
                    res.y = Y;
                    res.z = Z;
                    res.phase = 1;
                }
            } else if (game.red.phase == 2) {
                res.phase = game.red.phase;
                Log.i("redmove", "entered");
                if (this.x != -1 && game.board[X][Y][Z] == 0) {
                    res.succ = game.move(this.x, this.y, this.z, X, Y, Z);
                    if (res.succ) {
                        this.matched = game.evaluate(X, Y, Z);
                        res.turn = game.turn;
                        if (this.matched) shakeItBaby(); else game.nextTurn();
                        if (res.succ) this.x = -1;
                        res.x = this.x;
                        res.y = this.y;
                        res.z = this.z;
                    }
                } else {
                    res.succ = false;
                    if (game.board[X][Y][Z] == 1) {
                        if (this.x != -1) this.img.setImageResource(R.drawable.red);
                        this.x = X;
                        this.y = Y;
                        this.z = Z;
                        this.img = img;
                        img.setImageResource(R.drawable.yellow);
                    }
                }
            } else {
                Log.i("redfly", "entered x1:" + this.x + " y1: " + this.y + " z1: " + this.z
                        + " x2: " + X + " Y2: " + Y + " Z2 : " + Z);
                res.phase = game.red.phase;
                if (this.x != -1) {
                    Log.i("redfly", "1");

                    res.succ = game.fly(this.x, this.y, this.z, X, Y, Z);
                    if (res.succ) {
                        this.matched = game.evaluate(X, Y, Z);
                        res.turn = game.turn;
                        if (this.matched) shakeItBaby(); else game.nextTurn();
                        res.x = this.x;
                        res.y = this.y;
                        res.z = this.z;
                        this.x = -1;
                    }
                } else {
                    Log.i("redfly", "2");
                    res.succ = false;
                    if (game.board[X][Y][Z] == 1) {
                        if (this.x != -1) this.img.setImageResource(R.drawable.red);
                        this.x = X;
                        this.y = Y;
                        this.z = Z;
                        this.img = img;
                        img.setImageResource(R.drawable.yellow);
                    }
                }
            }
        } else {
            if (game.blue.phase == 1) {
                res.succ = game.insert(X, Y, Z);
                if (res.succ) {
                    this.matched = game.evaluate(X, Y, Z);
                    if (this.matched) shakeItBaby();
                    res.turn = game.turn;
                    if (!this.matched) game.nextTurn();
                    res.x = X;
                    res.y = Y;
                    res.z = Z;
                    res.phase = 1;
                }
            } else if (game.blue.phase == 2) {
                res.phase = game.blue.phase;
                Log.i("bluemove", "entered");
                if (this.x != -1 && game.board[X][Y][Z] == 0) {
                    res.succ = game.move(this.x, this.y, this.z, X, Y, Z);
                    if (res.succ) {
                        this.matched = game.evaluate(X, Y, Z);
                        if (this.matched) shakeItBaby();
                        res.turn = game.turn;
                        if (!this.matched) game.nextTurn();
                        if (res.succ) this.x = -1;
                        res.x = this.x;
                        res.y = this.y;
                        res.z = this.z;

                    }
                } else {
                    res.succ = false;
                    if (game.board[X][Y][Z] == 2) {
                        if (this.x != -1) this.img.setImageResource(R.drawable.blue);
                        this.x = X;
                        this.y = Y;
                        this.z = Z;
                        this.img = img;
                        img.setImageResource(R.drawable.yellow);
                    }
                }
            } else {
                Log.i("bluefly", "entered x1:" + this.x + " y1: " + this.y + " z1: " + this.z
                        + " x2: " + X + " Y2: " + Y + " Z2 : " + Z);
                res.phase = game.blue.phase;
                if (this.x != -1 && game.board[X][Y][Z] == 0) {
                    Log.i("bluefly", "1");
                    res.succ = game.fly(this.x, this.y, this.z, X, Y, Z);
                    if (res.succ) {
                        this.matched = game.evaluate(X, Y, Z);
                        if (this.matched) shakeItBaby();
                        res.turn = game.turn;
                        if (!this.matched) game.nextTurn();
                        res.x = this.x;
                        res.y = this.y;
                        res.z = this.z;
                        this.x = -1;
                    }
                } else {

                    Log.i("bluefly", "2");
                    res.succ = false;
                    if (game.board[X][Y][Z] == 2) {
                        if (this.x != -1) this.img.setImageResource(R.drawable.blue);
                        this.x = X;
                        this.y = Y;
                        this.z = Z;
                        this.img = img;
                        img.setImageResource(R.drawable.yellow);
                    }
                }
            }
        }
        if (res.succ) {
            men_red.setText(NumberToPersian.toPersianNumber(String.valueOf(game.red.menCount)));
            men_red_trash.setText(NumberToPersian.toPersianNumber(String.valueOf(12 - (game.red.menCount + game.red.menInBoardCount))));
            men_blue.setText(NumberToPersian.toPersianNumber(String.valueOf(game.blue.menCount)));
            men_blue_trash.setText(NumberToPersian.toPersianNumber(String.valueOf(12 - (game.blue.menCount + game.blue.menInBoardCount))));

        }
        if (game.gameState() != 0) {

            if (game.gameState() == 1) {
                gify.setImageResource(R.drawable.redbot);
            } else {
                gify.setImageResource(R.drawable.bluebot);
            }
            dialog.setCancelable(false);
            dialog.show();
        }

        return res;
    }
}
