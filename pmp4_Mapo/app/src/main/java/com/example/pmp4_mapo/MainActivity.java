package com.example.pmp4_mapo;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewSignUp;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        buttonRegister = (Button)findViewById(R.id.UserRegister);
        editTextEmail=(EditText)findViewById(R.id.EditTextEmail);
        editTextPassword=(EditText)findViewById(R.id.EditTextPassword);
        textViewSignUp=(TextView)findViewById(R.id.TextViewSignIn);
        progressDialog =new ProgressDialog(this);
        buttonRegister.setOnClickListener(this);
        textViewSignUp.setOnClickListener(this);
    }
    private void registerUser(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        if(TextUtils.isEmpty((email))){
            Toast.makeText(this,"please enter email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"please enter password",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("progressing...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this,"Register successfully",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"try again",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    @Override
    public void onClick(View v) {

        if(v == buttonRegister){
            registerUser();
        }
        if(v == textViewSignUp){

        }
    }
}
