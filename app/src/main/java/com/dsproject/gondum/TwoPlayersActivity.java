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



    int x = -1;
    int y;
    int z;
    ImageView img;
    boolean matched = false;
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


    }

    public Result selectNode(int x, int y, int z, ImageView img) {
        Result res = new Result();
        if (this.matched) {//For deletion the opponent piece
            res.succ = game.delete(x, y, z);
            if (res.succ) {
                this.matched = false;
                res.turn=0;
                game.nextTurn();
            }
        } else if (game.turn == 1) {
            if (game.red.phase == 1) {
                res.succ = game.insert(x, y, z);
                this.matched = game.evaluate(x, y, z);
                res.turn = game.turn;
                if (!this.matched) game.nextTurn();
                res.x = x;
                res.y = y;
                res.z = z;
                res.phase = 1;
            } else if (game.red.phase == 2) {
                res.phase = game.red.phase;
                if (this.x != -1) {
                    res.succ = game.move(this.x, this.y, this.z, x, y, z);
                    this.matched = game.evaluate(x, y, z);
                    res.turn = game.turn;
                    if (!this.matched) game.nextTurn();
                    if (res.succ) this.x = -1;
                    res.x = this.x;
                    res.y = this.y;
                    res.z = this.z;
                } else {
                    res.succ = false;
                    if(game.board[x][y][z] == 1){
                        this.x = x;
                        this.y = y;
                        this.z = z;
                        this.img = img;
                    }
                }
            } else {
                res.phase = game.red.phase;
                if (this.x != -1) {
                    res.succ = game.fly(this.x, this.y, this.z, x, y, z);
                    this.matched = game.evaluate(x, y, z);
                    if (!this.matched) game.nextTurn();
                    res.x = this.x;
                    res.y = this.y;
                    res.z = this.z;
                    res.turn = game.turn;
                    this.x = -1;
                } else {
                    res.succ = false;
                    this.x = x;
                    this.y = y;
                    this.z = z;
                    this.img = img;
                }
            }
        } else {
            if (game.blue.phase == 1) {
                res.succ = game.insert(x, y, z);
                this.matched = game.evaluate(x, y, z);
                res.turn = game.turn;
                if (!this.matched) game.nextTurn();
                res.x = x;
                res.y = y;
                res.z = z;
                res.phase = 1;
            } else if (game.blue.phase == 2) {
                res.phase = game.blue.phase;
                if (this.x != -1) {
                    res.succ = game.move(this.x, this.y, this.z, x, y, z);
                    this.matched = game.evaluate(x, y, z);
                    res.turn = game.turn;
                    if (!this.matched) game.nextTurn();
                    if (res.succ) this.x = -1;
                    res.x = this.x;
                    res.y = this.y;
                    res.z = this.z;
                } else {
                    res.succ = false;
                    if(game.board[x][y][z] == 2){
                        this.x = x;
                        this.y = y;
                        this.z = z;
                        this.img = img;
                    }
                }
            } else {
                res.phase = game.blue.phase;
                if (this.x != -1) {
                    res.succ = game.fly(this.x, this.y, this.z, x, y, z);
                    this.matched = game.evaluate(x, y, z);
                    if (!this.matched) game.nextTurn();
                    res.x = this.x;
                    res.y = this.y;
                    res.z = this.z;
                    res.turn = game.turn;
                    this.x = -1;
                } else {
                    res.succ = false;
                    this.x = x;
                    this.y = y;
                    this.z = z;
                    this.img = img;
                }
            }
        }
        if(res.succ){
            men_red.setText(NumberToPersian.toPersianNumber(String.valueOf(game.red.menCount)));
            men_red_trash.setText(NumberToPersian.toPersianNumber(String.valueOf(12-(game.red.menCount+game.red.menInBoardCount))));
            men_blue.setText(NumberToPersian.toPersianNumber(String.valueOf(game.blue.menCount)));
            men_blue_trash.setText(NumberToPersian.toPersianNumber(String.valueOf(12-(game.blue.menCount+game.blue.menInBoardCount))));
            changeFont();
        }
        return  res;
    }

    private void image1Listener() {
        Result res;
        res = selectNode(0, 0, 0, imageView2_1);
        if (res.succ) {
            imageView2_1.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);
            }
        }
    }

    private void image2Listener() {
        Result res;
        res = selectNode(0, 1, 0, imageView2_2);
        if (res.succ) {
            imageView2_2.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image3Listener() {
        Result res;
        res = selectNode(0, 2, 0, imageView2_3);
        if (res.succ) {
            imageView2_3.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image4Listener() {
        Result res;
        res = selectNode(0, 0, 1, imageView2_4);
        if (res.succ) {
            imageView2_4.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image5Listener() {
        Result res;
        res = selectNode(0, 1, 1, imageView2_5);
        if (res.succ) {
            imageView2_5.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image6Listener() {
        Result res;
        res = selectNode(0, 2, 1, imageView2_6);
        if (res.succ) {
            imageView2_6.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image7Listener() {
        Result res;
        res = selectNode(0, 0, 2, imageView2_7);
        if (res.succ) {
            imageView2_7.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image8Listener() {
        Result res;
        res = selectNode(0, 1, 2, imageView2_8);
        if (res.succ) {
            imageView2_8.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image9Listener() {
        Result res;
        res = selectNode(0, 2, 2, imageView2_9);
        if (res.succ) {
            imageView2_9.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image10Listener() {
        Result res;
        res = selectNode(1, 0, 0, imageView2_10);
        if (res.succ) {
            imageView2_10.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image11Listener() {
        Result res;
        res = selectNode(1, 0, 1, imageView2_11);
        if (res.succ) {
            imageView2_11.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image12Listener() {
        Result res;
        res = selectNode(1, 0, 2, imageView2_12);
        if (res.succ) {
            imageView2_12.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image13Listener() {
        Result res;
        res = selectNode(1, 2, 0, imageView2_13);
        if (res.succ) {
            imageView2_13.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image14Listener() {
        Result res;
        res = selectNode(1, 2, 1, imageView2_14);
        if (res.succ) {
            imageView2_14.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image15Listener() {
        Result res;
        res = selectNode(1, 2, 2, imageView2_15);
        if (res.succ) {
            imageView2_15.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image16Listener() {
        Result res;
        res = selectNode(2, 0, 2, imageView2_16);
        if (res.succ) {
            imageView2_16.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image17Listener() {
        Result res;
        res = selectNode(2, 1, 2, imageView2_17);
        if (res.succ) {
            imageView2_17.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image18Listener() {
        Result res;
        res = selectNode(2, 2, 2, imageView2_18);
        if (res.succ) {
            imageView2_18.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image19Listener() {
        Result res;
        res = selectNode(2, 0, 1, imageView2_19);
        if (res.succ) {
            imageView2_19.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image20Listener() {
        Result res;
        res = selectNode(2, 1, 1, imageView2_20);
        if (res.succ) {
            imageView2_20.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image21Listener() {
        Result res;
        res = selectNode(2, 2, 1, imageView2_21);
        if (res.succ) {
            imageView2_21.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image22Listener() {
        Result res;
        res = selectNode(2, 0, 0, imageView2_22);
        if (res.succ) {
            imageView2_22.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image23Listener() {
        Result res;
        res = selectNode(2, 1, 0, imageView2_23);
        if (res.succ) {
            imageView2_23.setImageResource(res.turn == 0 ? 0 : res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image24Listener() {
        Result res;
        res = selectNode(2, 2, 0, imageView2_24);
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

    @Override
    public void onBackPressed() {
        game.gameReset();
        finish();
        super.onBackPressed();
    }
}