package com.dsproject.gondum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        img = findViewById(R.id.img);
        img.animate().alpha(1f).setDuration(5000);
        Toast.makeText(this, "Click anywhere to continue...", Toast.LENGTH_LONG).show();
    }

    public void click(View view) {

        startActivity(new Intent(this, MainMenuActivity.class));
        finish();

    }
}
