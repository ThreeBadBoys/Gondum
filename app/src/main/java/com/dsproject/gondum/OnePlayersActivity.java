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
    ImageView img;
    boolean matched = false;
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


    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
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

    public Result selectNode(int x, int y, int z, ImageView img) {
        Result res = new Result();
        if (this.matched) {
            res.succ = game.delete(x, y, z);
            if (res.succ) {
                this.matched = false;
                img.setImageResource(0);
            }
            return res;
        } else if (game.turn == 1) {
            if (game.red.phase == 1) {
                res.succ = game.insert(x, y, z);
                this.matched = game.evaluate(x, y, z);
                if (!this.matched) game.nextTurn();
                res.x = x;
                res.y = y;
                res.z = z;
                res.phase = 1;
                res.turn = game.turn;
                return res;
            } else if (game.red.phase == 2) {
                res.phase = game.red.phase;
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
                    this.img = img;
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
                    this.img = img;
                    return res;
                }
            }
        } else {
            if (game.blue.phase == 1) {
                res.succ = game.insert(x, y, z);
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
                    this.img = img;
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
                    this.img = img;
                    return res;
                }
            }
        }
    }

    private void image1Listener() {
        Result res;

        res = selectNode(0, 0, 0, imageView1);
        if (res.succ) {
            imageView1.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image2Listener() {
        Result res;
        res = selectNode(0, 1, 0, imageView2);
        if (res.succ) {
            imageView2.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image3Listener() {
        Result res;
        res = selectNode(0, 2, 0, imageView3);
        if (res.succ) {
            imageView3.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image4Listener() {
        Result res;
        res = selectNode(0, 0, 1, imageView4);
        if (res.succ) {
            imageView4.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image5Listener() {
        Result res;
        res = selectNode(0, 1, 1, imageView5);
        if (res.succ) {
            imageView5.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image6Listener() {
        Result res;
        res = selectNode(0, 2, 1, imageView6);
        if (res.succ) {
            imageView6.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image7Listener() {
        Result res;
        res = selectNode(0, 0, 2, imageView7);
        if (res.succ) {
            imageView7.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image8Listener() {
        Result res;
        res = selectNode(0, 1, 2, imageView8);
        if (res.succ) {
            imageView8.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image9Listener() {
        Result res;
        res = selectNode(0, 2, 2, imageView9);
        if (res.succ) {
            imageView9.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image10Listener() {
        Result res;
        res = selectNode(1, 0, 0, imageView10);
        if (res.succ) {
            imageView10.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image11Listener() {
        Result res;
        res = selectNode(1, 0, 1, imageView11);
        if (res.succ) {
            imageView11.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image12Listener() {
        Result res;
        res = selectNode(1, 0, 2, imageView12);
        if (res.succ) {
            imageView12.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image13Listener() {
        Result res;
        res = selectNode(1, 2, 0, imageView13);
        if (res.succ) {
            imageView13.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image14Listener() {
        Result res;
        res = selectNode(1, 2, 1, imageView14);
        if (res.succ) {
            imageView14.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image15Listener() {
        Result res;
        res = selectNode(1, 2, 2, imageView15);
        if (res.succ) {
            imageView15.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image16Listener() {
        Result res;
        res = selectNode(2, 0, 2, imageView16);
        if (res.succ) {
            imageView16.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image17Listener() {
        Result res;
        res = selectNode(2, 1, 2, imageView17);
        if (res.succ) {
            imageView17.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image18Listener() {
        Result res;
        res = selectNode(2, 2, 2, imageView18);
        if (res.succ) {
            imageView18.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image19Listener() {
        Result res;
        res = selectNode(2, 0, 1, imageView19);
        if (res.succ) {
            imageView19.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image20Listener() {
        Result res;
        res = selectNode(2, 1, 1, imageView20);
        if (res.succ) {
            imageView20.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image21Listener() {
        Result res;
        res = selectNode(2, 2, 1, imageView21);
        if (res.succ) {
            imageView21.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image22Listener() {
        Result res;
        res = selectNode(2, 0, 0, imageView22);
        if (res.succ) {
            imageView22.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image23Listener() {
        Result res;
        res = selectNode(2, 1, 0, imageView23);
        if (res.succ) {
            imageView23.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    private void image24Listener() {
        Result res;
        res = selectNode(2, 2, 0, imageView24);
        if (res.succ) {
            imageView24.setImageResource(res.turn == 1 ? R.drawable.red : R.drawable.blue);
            if (res.phase > 1) {
                this.img.setImageResource(0);

            }
        }
    }

    @Override
    public void onBackPressed() {
        game.gameReset();
        finish();
        super.onBackPressed();
    }
}