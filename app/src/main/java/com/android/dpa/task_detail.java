package com.android.dpa;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class task_detail extends AppCompatActivity {

    private task_db myDb = new task_db(this);
    TextView name;
    TextView date;
    TextView time;
    TextView priority;
    TextView progress;
    ProgressBar pbar;

    TextView hours;
    CheckBox cmon;
    CheckBox ctue;
    CheckBox cwed;
    CheckBox cthu;
    CheckBox cfri;
    CheckBox csat;
    CheckBox csun;

    public static final String TAG ="check";


    List<String> list = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        String reference = getIntent().getExtras().getString("reference");

        name = (TextView) findViewById(R.id.name);
        date = (TextView) findViewById(R.id.dead);
        time = (TextView) findViewById(R.id.deadtime);
        priority = (TextView) findViewById(R.id.priority);
        progress = (TextView) findViewById(R.id.progress);
        pbar = (ProgressBar) findViewById(R.id.pbar);

        hours = (TextView) findViewById(R.id.tv_hours);
        cmon = (CheckBox) findViewById(R.id.monday);
        ctue = (CheckBox) findViewById(R.id.tuesday);
        cwed = (CheckBox) findViewById(R.id.wednesday);
        cthu = (CheckBox) findViewById(R.id.thursday);
        cfri = (CheckBox) findViewById(R.id.friday);
        csat = (CheckBox) findViewById(R.id.saturday);
        csun = (CheckBox) findViewById(R.id.sunday);

        Cursor cursor = myDb.getDetails(reference);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0));
                list.add(cursor.getString(1));
                list.add(cursor.getString(2));
                list.add(cursor.getString(3));
                list.add(cursor.getString(4));
                list.add(cursor.getString(5));

                list.add(cursor.getString(6));
                list.add(cursor.getString(7));
                list.add(cursor.getString(8));
                list.add(cursor.getString(9));
                list.add(cursor.getString(10));
                list.add(cursor.getString(11));
                list.add(cursor.getString(12));
                list.add(cursor.getString(13));

            } while (cursor.moveToNext());
        }



        name.setFocusable(true);
        name.setEnabled(true);
        name.setClickable(true);
        name.setFocusableInTouchMode(true);

       name.setText(list.get(0).toString());
        priority.setText(list.get(1).toString());
        date.setText(list.get(2).toString());
        time.setText(list.get(3).toString());
        progress.setText(list.get(4).toString());
        int n = Integer.parseInt(list.get(4));

        hours.setText(list.get(6).toString());
        String temp ;
        temp = list.get(7).toString();
        if(temp.equals("1")) {cmon.setChecked(true);}
        else { cmon.setChecked(false);}

        //
        //cmon.setChecked(true);
        //
        Log.d(TAG, "mon"+temp+"  \n ");
        temp = list.get(8).toString();
        Log.d(TAG, "tue"+temp+"  \n ");


        if(temp.equals("1")) {ctue.setChecked(true);}
        else { ctue.setChecked(false);}

        temp = list.get(9).toString();

        Log.d(TAG, "wed"+temp+"  \n ");

        if(temp.equals("1")) {cwed.setChecked(true);}
        else { cwed.setChecked(false);}

        temp = list.get(10).toString();
        if(temp.equals("1")) {cthu.setChecked(true);}
        else { cthu.setChecked(false);}

        temp = list.get(11).toString();
        if(temp.equals("1")) {cfri.setChecked(true);}
        else { cfri.setChecked(false);}

        temp = list.get(12).toString();
        if(temp.equals("1")) {csat.setChecked(true);}
        else { csat.setChecked(false);}

        temp = list.get(13).toString();
        if(temp.equals("1")) {csun.setChecked(true);}
        else { csun.setChecked(false);}


        pbar.setProgress(n);
        pbar.isShown();


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

        String data = list.get(5).toString() ;
        switch (item.getItemId())
        {
            case R.id.edit:

                Intent i = new Intent(getApplicationContext(), edit_details.class);
                i.putExtra("reference1", data);
                startActivity(i);


                return true;





            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
