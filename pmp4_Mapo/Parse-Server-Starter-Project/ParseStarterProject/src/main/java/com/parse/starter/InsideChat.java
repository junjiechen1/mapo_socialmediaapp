package com.parse.starter;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

public class InsideChat extends AppCompatActivity {

    String activeUser = "";
    ArrayList<String> messages = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    public void backtomainchat(View view){
        Intent intent = new Intent(this,MainChatPage.class);
        startActivity(intent);
    }
    public void SendMessage(View view){

        final EditText chatEditText = (EditText) findViewById(R.id.ChateditText);
        final ParseObject message = new ParseObject("Message");
        final String messageContent = chatEditText.getText().toString();
        message.put("sender", ParseUser.getCurrentUser().getUsername());
        message.put("recipient",activeUser);
        message.put("message",messageContent);
        chatEditText.setText("");

        message.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e ==null){
                    messages.add(messageContent);
                    arrayAdapter.notifyDataSetChanged();
                }
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_chat);
        Intent intent = getIntent();
        activeUser = intent.getStringExtra("username");
        setTitle(activeUser);
        final ListView chatListview = (ListView) findViewById(R.id.chatListView);
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,messages);
        chatListview.setAdapter(arrayAdapter);
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {



                ParseQuery<ParseObject> query1 = new ParseQuery<ParseObject>("Message");
                query1.whereEqualTo("sender",ParseUser.getCurrentUser().getUsername());
                query1.whereEqualTo("recipient",activeUser);


                ParseQuery<ParseObject> query2 = new ParseQuery<ParseObject>("Message");
                query2.whereEqualTo("recipient",ParseUser.getCurrentUser().getUsername());
                query2.whereEqualTo("sender",activeUser);

                List<ParseQuery<ParseObject>> queries  = new ArrayList<ParseQuery<ParseObject>>();
                queries.add(query1);
                queries.add(query2);
                //1 or 2
                ParseQuery<ParseObject> query = ParseQuery.or(queries);
                query.orderByAscending("createdAt");
                query.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {
                        if(e == null){
                            if(objects.size()> 0 ){
                                messages.clear();
                                for (ParseObject message: objects){

                                    String messageContent = message.getString("message");

                                    // if not user
                                    if(!message.getString("sender").equals(ParseUser.getCurrentUser().getUsername())){
                                        messageContent = activeUser+": \n" + messageContent;


                                    }
                                    else{
                                        messageContent =  ParseUser.getCurrentUser().getUsername()+": \n"+messageContent;

                                    }
                                    messages.add(messageContent);
                                }

                                // notifie update
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                    }
                });
                handler.postDelayed(this,1000);

            }

            };
        handler.post(runnable);
        }


}
