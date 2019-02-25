package com.parse.starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

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
