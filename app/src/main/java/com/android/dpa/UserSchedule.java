package com.android.dpa;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class UserSchedule extends AppCompatActivity {
    FloatingActionButton bmon;
    FloatingActionButton btue;
    FloatingActionButton bwed;
    FloatingActionButton bthu;
    FloatingActionButton bfri;
    FloatingActionButton bsat;
    FloatingActionButton bsun;
    ListView listview_mon;
    ListView listview_tue;
    ListView listview_wed;
    ListView listview_thu;
    ListView listview_fri;
    ListView listview_sat;
    ListView listview_sun;

    final algo_db algoDb = new algo_db(this);

    List<String> list = new ArrayList<String>();

    private ScheduleDb myDb = new ScheduleDb(this);
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_schedule);

        bmon=(FloatingActionButton)findViewById(R.id.bt_mon);
        btue=(FloatingActionButton)findViewById(R.id.bt_tue);
        bwed=(FloatingActionButton)findViewById(R.id.bt_wed);
        bthu=(FloatingActionButton)findViewById(R.id.bt_thu);
        bfri=(FloatingActionButton)findViewById(R.id.bt_fri);
        bsat=(FloatingActionButton)findViewById(R.id.bt_sat);
        bsun=(FloatingActionButton)findViewById(R.id.bt_sun);


        populateListview_mon("monday");
        populateListview_tue("tuesday");
        populateListview_wed("wednesday");
        populateListview_thu("thursday");
        populateListview_fri("friday");
        populateListview_sat("saturday");
        populateListview_sun("sunday");
        

/*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);
*/

        bmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), AddSchedule.class);
                i.putExtra("reference1", "monday");
                startActivity(i);

            }
        });

        btue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), AddSchedule.class);
                i.putExtra("reference1", "tuesday");
                startActivity(i);

            }
        });

        bwed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), AddSchedule.class);
                i.putExtra("reference1", "wednesday");
                startActivity(i);

            }
        });

        bthu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), AddSchedule.class);
                i.putExtra("reference1", "thursday");
                startActivity(i);

            }
        });

        bfri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), AddSchedule.class);
                i.putExtra("reference1", "friday");
                startActivity(i);

            }
        });

        bsat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), AddSchedule.class);
                i.putExtra("reference1", "saturday");
                startActivity(i);

            }
        });

        bsun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), AddSchedule.class);
                i.putExtra("reference1", "sunday");
                startActivity(i);

            }
        });
    }


    public void populateListview_mon(String day)
    {
        Cursor cursor=myDb.getData2(day);
        //
        String[] fromFieldNames=new String[]{ScheduleDb.NAME,ScheduleDb.START,ScheduleDb.END,ScheduleDb.ID};
        int[] findViewId=new int[]{R.id.tv_name,R.id.tv_start,R.id.tv_end,R.id.id};
        SimpleCursorAdapter myAdapter=new SimpleCursorAdapter(getBaseContext(),R.layout.list_schedule2,cursor,fromFieldNames,findViewId,0);
        listview_mon = (ListView)findViewById(R.id.lv_monday);
        listview_mon.setAdapter(myAdapter);

    }


    public void populateListview_tue(String day)
    {
        Cursor cursor=myDb.getData2(day);
        String[] fromFieldNames=new String[]{ScheduleDb.NAME,ScheduleDb.START,ScheduleDb.END,ScheduleDb.ID};
        int[] findViewId=new int[]{R.id.tv_name,R.id.tv_start,R.id.tv_end,R.id.id};
        SimpleCursorAdapter myAdapter=new SimpleCursorAdapter(getBaseContext(),R.layout.list_schedule2,cursor,fromFieldNames,findViewId,0);
        listview_tue = (ListView)findViewById(R.id.lv_tuesday);
        listview_tue.setAdapter(myAdapter);

    }


    public void populateListview_wed(String day)
    {
        Cursor cursor=myDb.getData2(day);
        String[] fromFieldNames=new String[]{ScheduleDb.NAME,ScheduleDb.START,ScheduleDb.END,ScheduleDb.ID};
        int[] findViewId=new int[]{R.id.tv_name,R.id.tv_start,R.id.tv_end,R.id.id};
        SimpleCursorAdapter myAdapter=new SimpleCursorAdapter(getBaseContext(),R.layout.list_schedule2,cursor,fromFieldNames,findViewId,0);
        listview_wed = (ListView)findViewById(R.id.lv_wednesday);
        listview_wed.setAdapter(myAdapter);

    }


    public void populateListview_thu(String day)
    {
        Cursor cursor=myDb.getData2(day);
        String[] fromFieldNames=new String[]{ScheduleDb.NAME,ScheduleDb.START,ScheduleDb.END,ScheduleDb.ID};
        int[] findViewId=new int[]{R.id.tv_name,R.id.tv_start,R.id.tv_end,R.id.id};
        SimpleCursorAdapter myAdapter=new SimpleCursorAdapter(getBaseContext(),R.layout.list_schedule2,cursor,fromFieldNames,findViewId,0);
        listview_thu = (ListView)findViewById(R.id.lv_thursday);
        listview_thu.setAdapter(myAdapter);

    }


    public void populateListview_fri(String day)
    {
        Cursor cursor=myDb.getData2(day);
        String[] fromFieldNames=new String[]{ScheduleDb.NAME,ScheduleDb.START,ScheduleDb.END,ScheduleDb.ID};
        int[] findViewId=new int[]{R.id.tv_name,R.id.tv_start,R.id.tv_end,R.id.id};
        SimpleCursorAdapter myAdapter=new SimpleCursorAdapter(getBaseContext(),R.layout.list_schedule2,cursor,fromFieldNames,findViewId,0);
        listview_fri = (ListView)findViewById(R.id.lv_friday);
        listview_fri.setAdapter(myAdapter);

    }


    public void populateListview_sat(String day)
    {
        Cursor cursor=myDb.getData2(day);
        String[] fromFieldNames=new String[]{ScheduleDb.NAME,ScheduleDb.START,ScheduleDb.END,ScheduleDb.ID};
        int[] findViewId=new int[]{R.id.tv_name,R.id.tv_start,R.id.tv_end,R.id.id};
        SimpleCursorAdapter myAdapter=new SimpleCursorAdapter(getBaseContext(),R.layout.list_schedule2,cursor,fromFieldNames,findViewId,0);
        listview_sat = (ListView)findViewById(R.id.lv_saturday);
        listview_sat.setAdapter(myAdapter);

    }


    public void populateListview_sun(String day)
    {
        Cursor cursor=myDb.getData2(day);
        String[] fromFieldNames=new String[]{ScheduleDb.NAME,ScheduleDb.START,ScheduleDb.END,ScheduleDb.ID};
        int[] findViewId=new int[]{R.id.tv_name,R.id.tv_start,R.id.tv_end,R.id.id};
        SimpleCursorAdapter myAdapter=new SimpleCursorAdapter(getBaseContext(),R.layout.list_schedule2,cursor,fromFieldNames,findViewId,0);
        listview_sun = (ListView)findViewById(R.id.lv_sunday);
        listview_sun.setAdapter(myAdapter);

    }


    public void deleteTask(View view) {
        View parent = (View) view.getParent();
        TextView taskTextView = (TextView) parent.findViewById(R.id.id);
        String task = String.valueOf(taskTextView.getText());
        SQLiteDatabase db = myDb.getWritableDatabase();
        Cursor cursor=myDb.getData4(Integer.parseInt(task));

        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0));
                list.add(cursor.getString(1));
                list.add(cursor.getString(2));
                list.add(cursor.getString(3));
                list.add(cursor.getString(4));
            } while (cursor.moveToNext());
        }


        db.delete(ScheduleDb.TABLE_NAME,
                ScheduleDb.ID + " = ?",
                new String[]{task});



        String din = list.get(2).toString();
        Log.d("\n din ",din);
        String start = list.get(3).toString();
        Log.d("\n start ",start);

        String end = list.get(4).toString();
        Log.d("\n end ",end);

        algoDb.delete(din,Integer.parseInt(start),Integer.parseInt(end));


        db.close();



        populateListview_mon("monday");
        populateListview_tue("tuesday");
        populateListview_wed("wednesday");
        populateListview_thu("thursday");
        populateListview_fri("friday");
        populateListview_sat("saturday");
        populateListview_sun("sunday");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Event Handling for Individual menu item selected
     * Identify single menu item by it's id
     * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        auth = FirebaseAuth.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        switch (item.getItemId())
        {
            case R.id.menu_signout:
                // Single menu item is selected do something
                // Ex: launching new activity/screen or show alert message
                auth.signOut();
                startActivity(new Intent(UserSchedule.this, SigninActivity.class));
                finish();

                return true;




            case R.id.menu_deleteaccount:
                if (user != null) {
                    user.delete()
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(UserSchedule.this, "Your profile is deleted:( Create a account now!", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(UserSchedule.this, SignupActivity.class));
                                        finish();

                                    } else {
                                        Toast.makeText(UserSchedule.this, "Failed to delete your account!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }

                return true;

            case(R.id.add):

                Intent i=new Intent(this,AddItems.class);
                startActivity(i);
                finish();

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public AdapterView getListView() {
        return listview_mon;
    }

}
