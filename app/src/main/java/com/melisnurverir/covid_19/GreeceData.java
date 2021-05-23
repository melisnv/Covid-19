package com.melisnurverir.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GreeceData extends AppCompatActivity {

    ImageView back_btn;
    TextView details_btn,story_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greece_data);

        back_btn = findViewById(R.id.back_btn);
        details_btn=findViewById(R.id.details_btn);
        story_text = findViewById(R.id.story_text);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GreeceData.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        details_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GreeceData.this, Articles.class);
                startActivity(i);
                finish();
            }
        });

        story_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent storyIntent = new Intent(GreeceData.this, SignInStoryActivity.class);
                startActivity(storyIntent);
                finish();
            }
        });
    }
}