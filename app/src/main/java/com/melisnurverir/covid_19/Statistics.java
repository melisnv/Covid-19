package com.melisnurverir.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Statistics extends AppCompatActivity {

    ImageView back_to_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        back_to_main = findViewById(R.id.img_back);

        back_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Statistics.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}