package com.parse.starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainChatPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chat_page);

    }
    public void maplocation(View view){
        Intent intent = new Intent(this,Mainmap.class);
        startActivity(intent);
    }
    public void Profilelocation(View view){
        Intent intent = new Intent(this,Mainprofile.class);
        startActivity(intent);
    }
}
