package com.melisnurverir.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    ImageView flags;
    Spinner spinner;
    Button stat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        flags = findViewById(R.id.flag);
        stat = findViewById(R.id.stat);

        spinner.setAdapter(new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,
                CountryData.countryNames));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                flags.setImageResource(CountryData.countryFlags[spinner.getSelectedItemPosition()]);
                final Intent intent;
                switch (position){
                    case 1:
                        intent = new Intent(MainActivity.this,TurkeyData.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this,GermanyData.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this,ItalyData.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this,FranceData.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(MainActivity.this,GreeceData.class);
                        startActivity(intent);
                        break;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Statistics.class);
                startActivity(i);
            }
        });
    }
}