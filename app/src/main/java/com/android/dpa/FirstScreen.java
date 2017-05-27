package com.android.dpa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstScreen extends AppCompatActivity {
    Button but_tasks;
    Button but_buy;
    Button but_profile;
    Button but_about;
    Button but_recommend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        but_tasks=(Button)findViewById(R.id.button_tasks);
        but_buy=(Button)findViewById(R.id.button_buy);
        but_profile=(Button)findViewById(R.id.button_profile);
        but_about=(Button)findViewById(R.id.button_about);
        but_recommend= (Button) findViewById(R.id.button_recommend);

        but_tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imain = new Intent(FirstScreen.this,MainActivity.class);
                startActivity(imain);
            }


        });
        //
        but_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ibuy = new Intent(FirstScreen.this,ItemList.class);
                startActivity(ibuy);
            }


        });
        //
        but_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iprofile = new Intent(FirstScreen.this,UserSchedule.class);
                startActivity(iprofile);
            }


        });
        //
        but_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iabout = new Intent(FirstScreen.this,MapsKiPrathamKriya.class);
                startActivity(iabout);
            }


        });
        //
        but_recommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iabout = new Intent(FirstScreen.this,Recommend.class);
                startActivity(iabout);
            }


        });



    }
}
