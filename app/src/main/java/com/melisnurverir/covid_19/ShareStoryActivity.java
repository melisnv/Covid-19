package com.melisnurverir.covid_19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class ShareStoryActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.options_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.share){
            Intent shareIntent = new Intent(ShareStoryActivity.this,UploadActivity.class);
            startActivity(shareIntent);
        }
        else if (item.getItemId() == R.id.signout){
            firebaseAuth.signOut();

            Intent backMainIntent = new Intent(ShareStoryActivity.this,MainActivity.class);
            startActivity(backMainIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_story);

        firebaseAuth = FirebaseAuth.getInstance();

    }
}