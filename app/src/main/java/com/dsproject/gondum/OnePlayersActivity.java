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

import com.dsproject.gondum.AI.Machine;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;

public class OnePlayersActivity extends AppCompatActivity {
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
    Dialog dialog;
    MediaPlayer mediaPlayer;
    SharedPreferences pref;
    GifImageView gify;
    Button exit;
    Button menu;
    Button restart;
    TextView turn_red;

    int x = -1;
    int y;
    int z;
    ImageView img;
    boolean matched = false;
    Game game = new Game();
    Machine machine;

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
        pref = getSharedPreferences("myprefs", MODE_PRIVATE);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image1Listener();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image2Listener();
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image3Listener();
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image4Listener();
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image5Listener();
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image6Listener();
            }
        });
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image7Listener();
            }
        });
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image8Listener();
            }
        });
        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image9Listener();
            }
        });
        imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image10Listener();
            }
        });
        imageView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image11Listener();
            }
        });
        imageView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image12Listener();
            }
        });
        imageView13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image13Listener();
            }
        });
        imageView14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image14Listener();
            }
        });
        imageView15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image15Listener();
            }
        });
        imageView16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image16Listener();
            }
        });
        imageView17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image17Listener();
            }
        });
        imageView18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image18Listener();
            }
        });
        imageView19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image19Listener();
            }
        });
        imageView20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image20Listener();
            }
        });
        imageView21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image21Listener();
            }
        });
        imageView22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image22Listener();
            }
        });
        imageView23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image23Listener();
            }
        });
        imageView24.setOnClickListener(new View.OnClickListener() {
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
                Intent intent = new Intent(OnePlayersActivity.this, MainMenuActivity.class);
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
        turn_red.setText("نوبت منه");
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

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        }
    }

    void init() {
        dialog = new Dialog(this);
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
        turn_red = findViewById(R.id.red_turn1);
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
    }

    private void shakeItBaby() {
        if (Build.VERSION.SDK_INT >= 26) {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(150, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            ((Vibrator) getSystemService(VIBRATOR_SERVICE)).vibrate(150);
        }
    }

    private void image1Listener() {
        Result res;
        changeText();
        res = selectNode(0, 0, 0, imageView1);
        changeText();
        if (res.succ) {
            imageView1.setImageResource(res.turn == 0 ? 0 : R.drawable.red);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
            if (!matched) machineSelectNode();
        }
    }

    private void image2Listener() {
        Result res;
        changeText();
        res = selectNode(0, 1, 0, imageView2);
        changeText();
        if (res.succ) {
            imageView2.setImageResource(res.turn == 0 ? 0 : R.drawable.red);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
            if (!matched) machineSelectNode();
        }
    }

    private void image3Listener() {
        Result res;
        changeText();
        res = selectNode(0, 2, 0, imageView3);
        changeText();
        if (res.succ) {
            imageView3.setImageResource(res.turn == 0 ? 0 : R.drawable.red);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
            if (!matched) machineSelectNode();
        }
    }

    private void image4Listener() {
        Result res;
        changeText();
        res = selectNode(0, 0, 1, imageView4);
        changeText();
        if (res.succ) {
            imageView4.setImageResource(res.turn == 0 ? 0 : R.drawable.red);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
            if (!matched) machineSelectNode();
        }
    }

    private void image5Listener() {
        Result res;
        changeText();
        res = selectNode(0, 1, 1, imageView5);
        changeText();
        if (res.succ) {
            imageView5.setImageResource(res.turn == 0 ? 0 : R.drawable.red);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
            if (!matched) machineSelectNode();
        }
    }

    private void image6Listener() {
        Result res;
        changeText();
        res = selectNode(0, 2, 1, imageView6);
        changeText();
        if (res.succ) {
            imageView6.setImageResource(res.turn == 0 ? 0 : R.drawable.red);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
            if (!matched) machineSelectNode();
        }
    }

    private void image7Listener() {
        Result res;
        changeText();
        res = selectNode(0, 0, 2, imageView7);
        changeText();
        if (res.succ) {
            imageView7.setImageResource(res.turn == 0 ? 0 : R.drawable.red);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
            if (!matched) machineSelectNode();
        }
    }

    private void image8Listener() {
        Result res;
        changeText();
        res = selectNode(0, 1, 2, imageView8);
        changeText();
        if (res.succ) {
            imageView8.setImageResource(res.turn == 0 ? 0 : R.drawable.red);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
            if (!matched) machineSelectNode();
        }
    }

    private void image9Listener() {
        Result res;
        changeText();
        res = selectNode(0, 2, 2, imageView9);
        changeText();
        if (res.succ) {
            imageView9.setImageResource(res.turn == 0 ? 0 : R.drawable.red);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
            if (!matched) machineSelectNode();
        }
    }

    private void image10Listener() {
        Result res;
        changeText();
        res = selectNode(1, 0, 0, imageView10);
        changeText();
        if (res.succ) {
            imageView10.setImageResource(res.turn == 0 ? 0 : R.drawable.red);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
            if (!matched) machineSelectNode();
        }
    }

    private void image11Listener() {
        Result res;
        changeText();
        res = selectNode(1, 0, 1, imageView11);
        changeText();
        if (res.succ) {
            imageView11.setImageResource(res.turn == 0 ? 0 : R.drawable.red);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
            if (!matched) machineSelectNode();
        }
    }

    private void image12Listener() {
        Result res;
        changeText();
        res = selectNode(1, 0, 2, imageView12);
        changeText();
        if (res.succ) {
            imageView12.setImageResource(res.turn == 0 ? 0 : R.drawable.red);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
            if (!matched) machineSelectNode();
        }
    }

    private void image13Listener() {
        Result res;
        changeText();
        res = selectNode(1, 2, 2, imageView13);
        changeText();
        if (res.succ) {
            imageView13.setImageResource(res.turn == 0 ? 0 : R.drawable.red);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
            if (!matched) machineSelectNode();
        }
    }

    private void image14Listener() {
        Result res;
        changeText();
        res = selectNode(1, 2, 1, imageView14);
        changeText();
        if (res.succ) {
            imageView14.setImageResource(res.turn == 0 ? 0 : R.drawable.red);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
            if (!matched) machineSelectNode();
        }
    }

    private void image15Listener() {
        Result res;
        changeText();
        res = selectNode(1, 2, 0, imageView15);
        changeText();
        if (res.succ) {
            imageView15.setImageResource(res.turn == 0 ? 0 : R.drawable.red);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
            if (!matched) machineSelectNode();
        }
    }

    private void image16Listener() {
        Result res;
        changeText();
        res = selectNode(2, 0, 2, imageView16);
        changeText();
        if (res.succ) {
            imageView16.setImageResource(res.turn == 0 ? 0 : R.drawable.red);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
            if (!matched) machineSelectNode();
        }
    }

    private void image17Listener() {
        Result res;
        changeText();
        res = selectNode(2, 1, 2, imageView17);
        changeText();
        if (res.succ) {
            imageView17.setImageResource(res.turn == 0 ? 0 : R.drawable.red);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
            if (!matched) machineSelectNode();
        }
    }

    private void image18Listener() {
        Result res;
        changeText();
        res = selectNode(2, 2, 2, imageView18);
        changeText();
        if (res.succ) {
            imageView18.setImageResource(res.turn == 0 ? 0 : R.drawable.red);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
            if (!matched) machineSelectNode();
        }
    }

    private void image19Listener() {
        Result res;
        res = selectNode(2, 0, 1, imageView19);
        if (res.succ) {
            imageView19.setImageResource(res.turn == 0 ? 0 : R.drawable.red);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
            if (!matched) machineSelectNode();
        }
    }

    private void image20Listener() {
        Result res;
        changeText();
        res = selectNode(2, 1, 1, imageView20);
        changeText();
        if (res.succ) {
            imageView20.setImageResource(res.turn == 0 ? 0 : R.drawable.red);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
            if (!matched) machineSelectNode();
        }
    }

    private void image21Listener() {
        Result res;
        changeText();
        res = selectNode(2, 2, 1, imageView21);
        changeText();
        if (res.succ) {
            imageView21.setImageResource(res.turn == 0 ? 0 : R.drawable.red);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
            if (!matched) machineSelectNode();
        }
    }

    private void image22Listener() {
        Result res;
        changeText();
        res = selectNode(2, 0, 0, imageView22);
        changeText();
        if (res.succ) {
            imageView22.setImageResource(res.turn == 0 ? 0 : R.drawable.red);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
            if (!matched) machineSelectNode();
        }
    }

    private void image23Listener() {
        Result res;
        changeText();
        res = selectNode(2, 1, 0, imageView23);
        changeText();
        if (res.succ) {
            imageView23.setImageResource(res.turn == 0 ? 0 : R.drawable.red);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
            if (!matched) machineSelectNode();
        }
    }

    private void image24Listener() {
        Result res;
        changeText();
        res = selectNode(2, 2, 0, imageView24);
        changeText();
        if (res.succ) {
            imageView24.setImageResource(res.turn == 0 ? 0 : R.drawable.red);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
            if (!matched) machineSelectNode();
        }
    }

    @Override
    public void onBackPressed() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
        game.gameBackEndReset();
        startActivity(new Intent(this, MainMenuActivity.class));
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

    //----------------------------------------------------

    public Result selectNode(int x, int y, int z, ImageView img) {
        Result res = new Result();
        Log.i("turn", ""+game.turn);
        if (this.matched) {//For deletion the opponent piece
            res.succ = game.delete(x, y, z);
            Log.i("delete", String.valueOf(this.matched));
            if (res.succ) {
                this.matched = false;
                res.turn = 0;
                game.nextTurn();
            }
        } else {
            if (game.red.phase == 1) {
                res.succ = game.insert(x, y, z);
                if (res.succ) {
                    this.matched = game.evaluate(x, y, z);
                    res.turn = game.turn;
                    if (this.matched) shakeItBaby();
                    else game.nextTurn();
                    res.x = x;
                    res.y = y;
                    res.z = z;
                    res.phase = 1;
                }
            } else if (game.red.phase == 2) {
                res.phase = game.red.phase;
                Log.i("redmove", "entered");
                if (this.x != -1 && game.board[x][y][z] == 0) {
                    res.succ = game.move(this.x, this.y, this.z, x, y, z);
                    if (res.succ) {
                        this.matched = game.evaluate(x, y, z);
                        res.turn = game.turn;
                        if (this.matched) shakeItBaby();
                        else game.nextTurn();
                        this.x = -1;
                        res.x = this.x;
                        res.y = this.y;
                        res.z = this.z;
                    }
                } else {
                    res.succ = false;
                    if (game.board[x][y][z] == 1) {
                        if (this.x != -1) this.img.setImageResource(R.drawable.red);
                        this.x = x;
                        this.y = y;
                        this.z = z;
                        this.img = img;
                        img.setImageResource(R.drawable.yellow);
                    }
                }
            } else {
                Log.i("redfly", "entered x1:" + this.x + " y1: " + this.y + " z1: " + this.z
                        + " x2: " + x + " Y2: " + y + " Z2 : " + z);
                res.phase = game.red.phase;
                if (this.x != -1) {
                    res.succ = game.fly(this.x, this.y, this.z, x, y, z);
                    if (res.succ) {
                        this.matched = game.evaluate(x, y, z);
                        res.turn = game.turn;
                        if (this.matched) shakeItBaby();
                        else game.nextTurn();
                        res.x = this.x;
                        res.y = this.y;
                        res.z = this.z;
                        this.x = -1;
                    }
                } else {
                    res.succ = false;
                    if (game.board[x][y][z] == 1) {
                        if (this.x != -1) this.img.setImageResource(R.drawable.red);
                        this.x = x;
                        this.y = y;
                        this.z = z;
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

    public void machineSelectNode() {
        Log.i("turn", ""+game.turn);
        changeText();
        if (game.gameState() == 0) {
            machine = new Machine(game.board, game.red, game.blue);
            int[][][] board = machine.decision();
            int[] x = new int[3];
            int[] y = new int[3];
            int[] z = new int[3];
            x[1] = -1;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) {
                        continue;
                }
                    for (int k = 0; k < 3; k++) {
                        if (game.board[i][j][k] != board[i][j][k]) {
                            if (game.board[i][j][k] == 0) {
                                Log.i("Delete Issue" ,"0");
                                x[0] = i;
                                y[0] = j;
                                z[0] = k;
                            } else if (game.board[i][j][k] == 1) {
                                Log.i("Delete Issue" ,"1");
                                x[1] = i;
                                y[1] = j;
                                z[1] = k;
                                game.red.menInBoardCount--;
                                if (game.red.menInBoardCount == 3 && game.red.menCount == 0) game.red.phase = 3;
                            } else {
                                Log.i("Delete Issue" ,"2");
                                x[2] = i;
                                y[2] = j;
                                z[2] = k;
                            }
                        }
                    }
                }
            }

            imageView1.setImageResource(board[0][0][0] == 0 ? 0 : board[0][0][0] == 1 ? R.drawable.red : R.drawable.blue);
            imageView2.setImageResource(board[0][1][0] == 0 ? 0 : board[0][1][0] == 1 ? R.drawable.red : R.drawable.blue);
            imageView3.setImageResource(board[0][2][0] == 0 ? 0 : board[0][2][0] == 1 ? R.drawable.red : R.drawable.blue);
            imageView4.setImageResource(board[0][0][1] == 0 ? 0 : board[0][0][1] == 1 ? R.drawable.red : R.drawable.blue);
            imageView5.setImageResource(board[0][1][1] == 0 ? 0 : board[0][1][1] == 1 ? R.drawable.red : R.drawable.blue);
            imageView6.setImageResource(board[0][2][1] == 0 ? 0 : board[0][2][1] == 1 ? R.drawable.red : R.drawable.blue);
            imageView7.setImageResource(board[0][0][2] == 0 ? 0 : board[0][0][2] == 1 ? R.drawable.red : R.drawable.blue);
            imageView8.setImageResource(board[0][1][2] == 0 ? 0 : board[0][1][2] == 1 ? R.drawable.red : R.drawable.blue);
            imageView9.setImageResource(board[0][2][2] == 0 ? 0 : board[0][2][2] == 1 ? R.drawable.red : R.drawable.blue);
            imageView10.setImageResource(board[1][0][0] == 0 ? 0 : board[1][0][0] == 1 ? R.drawable.red : R.drawable.blue);
            imageView11.setImageResource(board[1][0][1] == 0 ? 0 : board[1][0][1] == 1 ? R.drawable.red : R.drawable.blue);
            imageView12.setImageResource(board[1][0][2] == 0 ? 0 : board[1][0][2] == 1 ? R.drawable.red : R.drawable.blue);
            imageView13.setImageResource(board[1][2][2] == 0 ? 0 : board[1][2][2] == 1 ? R.drawable.red : R.drawable.blue);
            imageView14.setImageResource(board[1][2][1] == 0 ? 0 : board[1][2][1] == 1 ? R.drawable.red : R.drawable.blue);
            imageView15.setImageResource(board[1][2][0] == 0 ? 0 : board[1][2][0] == 1 ? R.drawable.red : R.drawable.blue);
            imageView16.setImageResource(board[2][0][2] == 0 ? 0 : board[2][0][2] == 1 ? R.drawable.red : R.drawable.blue);
            imageView17.setImageResource(board[2][1][2] == 0 ? 0 : board[2][1][2] == 1 ? R.drawable.red : R.drawable.blue);
            imageView18.setImageResource(board[2][2][2] == 0 ? 0 : board[2][2][2] == 1 ? R.drawable.red : R.drawable.blue);
            imageView19.setImageResource(board[2][0][1] == 0 ? 0 : board[2][0][1] == 1 ? R.drawable.red : R.drawable.blue);
            imageView20.setImageResource(board[2][1][1] == 0 ? 0 : board[2][1][1] == 1 ? R.drawable.red : R.drawable.blue);
            imageView21.setImageResource(board[2][2][1] == 0 ? 0 : board[2][2][1] == 1 ? R.drawable.red : R.drawable.blue);
            imageView22.setImageResource(board[2][0][0] == 0 ? 0 : board[2][0][0] == 1 ? R.drawable.red : R.drawable.blue);
            imageView23.setImageResource(board[2][1][0] == 0 ? 0 : board[2][1][0] == 1 ? R.drawable.red : R.drawable.blue);
            imageView24.setImageResource(board[2][2][0] == 0 ? 0 : board[2][2][0] == 1 ? R.drawable.red : R.drawable.blue);

            if (game.blue.phase == 1) {
                game.blue.menCount--;
                game.blue.menInBoardCount++;
                game.blue.phase = game.blue.menCount > 0 ? 1 : game.blue.menInBoardCount > 3 ? 2 : 3;
            }

            game.board = board;

            if (game.gameState() != 0) {
                if (game.gameState() == 1) {
                    gify.setImageResource(R.drawable.redbot);
                } else {
                    gify.setImageResource(R.drawable.bluebot);
                }
                dialog.setCancelable(false);
                dialog.show();
            } else {
                game.nextTurn();
            }

            men_red.setText(NumberToPersian.toPersianNumber(String.valueOf(game.red.menCount)));
            men_red_trash.setText(NumberToPersian.toPersianNumber(String.valueOf(12 - (game.red.menCount + game.red.menInBoardCount))));
            men_blue.setText(NumberToPersian.toPersianNumber(String.valueOf(game.blue.menCount)));
            men_blue_trash.setText(NumberToPersian.toPersianNumber(String.valueOf(12 - (game.blue.menCount + game.blue.menInBoardCount))));
        }
        changeText();
    }

    public void changeText() {
        if (game.turn == 1) {
            if (this.matched) {
                turn_red.setText("مهره رقیبت رو حذف کن");
            } else {
                turn_red.setText("نوبت منه");
            }
        } else if (game.turn == 2) {
            turn_red.setText("منتظرباش");
        }
    }
    public void GameFrontEndReset() {
        imageView1.setImageResource(0);
        imageView2.setImageResource(0);
        imageView3.setImageResource(0);
        imageView4.setImageResource(0);
        imageView5.setImageResource(0);
        imageView6.setImageResource(0);
        imageView7.setImageResource(0);
        imageView8.setImageResource(0);
        imageView9.setImageResource(0);
        imageView10.setImageResource(0);
        imageView11.setImageResource(0);
        imageView12.setImageResource(0);
        imageView13.setImageResource(0);
        imageView14.setImageResource(0);
        imageView15.setImageResource(0);
        imageView16.setImageResource(0);
        imageView17.setImageResource(0);
        imageView18.setImageResource(0);
        imageView19.setImageResource(0);
        imageView20.setImageResource(0);
        imageView21.setImageResource(0);
        imageView22.setImageResource(0);
        imageView23.setImageResource(0);
        imageView24.setImageResource(0);

        turn_red.setText("نوبت منه");
        men_red_trash.setText("0");
        men_blue_trash.setText("0");
        men_blue.setText("12");
        men_red.setText("12");

    }
}