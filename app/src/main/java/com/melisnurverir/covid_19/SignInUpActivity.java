package com.melisnurverir.covid_19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInUpActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    EditText email_text, password_text;

    Button sign_up,sign_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_up);

        firebaseAuth = FirebaseAuth.getInstance(); // initializing the FirebaseAuth instance

        email_text = findViewById(R.id.email_text);
        password_text = findViewById(R.id.password_text);

        sign_in = findViewById(R.id.signInButton);
        sign_up = findViewById(R.id.signUpButton);

        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if (firebaseUser != null){
            Intent i = new Intent(SignInUpActivity.this,ShareStoryActivity.class);
            startActivity(i);
            //finish();
        }
    }

    public void signInMethod(View view) {

        String email = email_text.getText().toString();
        String password = password_text.getText().toString();

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Intent i = new Intent(SignInUpActivity.this,ShareStoryActivity.class);
                startActivity(i);
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignInUpActivity.this, e.getLocalizedMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void signUpMethod(View view){

        String email = email_text.getText().toString();
        String password = password_text.getText().toString();

        if (email.equals("") || password.equals("")){
            Toast.makeText(this, "Please enter your user information!", Toast.LENGTH_SHORT).show();
        }
        else {
            //Toast.makeText(this, "You've done it gurllll", Toast.LENGTH_SHORT).show();
            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Toast.makeText(SignInUpActivity.this, "User Created", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(SignInUpActivity.this,ShareStoryActivity.class);
                    startActivity(i);
                    finish();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(SignInUpActivity.this,e.getLocalizedMessage().toString(),Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}