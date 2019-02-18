package com.parse.starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Mainmap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmap);
    }
    public void chatlocation(View view){
        Intent intent = new Intent(this,MainChatPage.class);
        startActivity(intent);
    }
    public void Profilelocation(View view){
        Intent intent = new Intent(this,Mainprofile.class);
        startActivity(intent);
    }
}
