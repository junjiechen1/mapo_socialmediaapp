package com.example.pmp4_mapo;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class logIn extends AppCompatActivity {

    private ImageView backbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        backbutton =(ImageView) findViewById(R.id.loginbackbutton);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmainpage();
            }
        });
    }
    public void openmainpage(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
