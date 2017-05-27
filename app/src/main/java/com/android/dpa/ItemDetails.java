package com.android.dpa;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class ItemDetails extends AppCompatActivity {

    private ItemDb myDb = new ItemDb(this);
    TextView name;
    TextView date;
    TextView priority;
    TextView type;
    Button bt_map;
    String typest;

    List<String> list = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        String reference = getIntent().getExtras().getString("reference");

        name = (TextView) findViewById(R.id.name);
        date = (TextView) findViewById(R.id.dead);
        priority = (TextView) findViewById(R.id.priority);
        type = (TextView) findViewById(R.id.type);
        bt_map=(Button)findViewById(R.id.button_map);




        Cursor cursor = myDb.getDetails(reference);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0));
                list.add(cursor.getString(1));
                list.add(cursor.getString(2));
                list.add(cursor.getString(3));
                list.add(cursor.getString(4));
            } while (cursor.moveToNext());
        }

        typest=list.get(3).toString();

        bt_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map2 = new Intent(ItemDetails.this, MapsKiPrathamKriya.class);
                map2.putExtra("maptype", typest);
                startActivity(map2);

            }
        });


        name.setFocusable(true);
        name.setEnabled(true);
        name.setClickable(true);
        name.setFocusableInTouchMode(true);

        name.setText(list.get(0).toString());
        priority.setText(list.get(1).toString());
        date.setText(list.get(2).toString());
        type.setText(list.get(3).toString());



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.edit_details, menu);
        return true;
    }

    /**
     * Event Handling for Individual menu item selected
     * Identify single menu item by it's id
     * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        String data = list.get(4).toString() ;
        switch (item.getItemId())
        {
            case R.id.edit:

                Intent i = new Intent(getApplicationContext(), ModifyItems.class);
                i.putExtra("reference1", data);
                startActivity(i);


                return true;





            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
