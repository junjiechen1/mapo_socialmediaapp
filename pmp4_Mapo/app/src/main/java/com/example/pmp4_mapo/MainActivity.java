package com.example.pmp4_mapo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


 private ImageView loginbutton;
 private ImageView signupbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signupbutton =(ImageView) findViewById(R.id.Signupbutton);
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensignuppage();
            }
        });

        loginbutton =(ImageView) findViewById(R.id.Loginbutton);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openloginpage();
            }
        });


    }

    public void openloginpage(){
        Intent intent = new Intent(this,logIn.class);
        startActivity(intent);
    }
    public void opensignuppage(){
        Intent intent = new Intent(this,appPage.class);
        startActivity(intent);
    }


}