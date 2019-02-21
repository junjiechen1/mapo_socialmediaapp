package com.parse.starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainChatPage extends AppCompatActivity {
/*
    ArrayList<String> users = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chat_page);
        /*
        ListView userlistview = (ListView)findViewById(R.id.userlist);
        users.add("jun");
        users.add("jake");

        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,users);
        userlistview.setAdapter(arrayAdapter);
        */
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
