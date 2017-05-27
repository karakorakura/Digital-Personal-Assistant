package com.android.dpa;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class edit_details extends AppCompatActivity {
    Button bt;
    TextView seek;
    EditText name;
    EditText date;
    EditText time;
    Spinner progress;
    SeekBar seekbar;

    EditText hours;
    CheckBox cmon;
    CheckBox ctue;
    CheckBox cwed;
    CheckBox cthu;
    CheckBox cfri;
    CheckBox csat;
    CheckBox csun;

    //
    public static final String TAG=" edit check";

    String vmon="0";
    String vtue="0";
    String vwed="0";
    String vthu="0";
    String vfri="0";
    String vsat="0";
    String vsun="0";

    List<String> list = new ArrayList<String>();
    private task_db myDb = new task_db(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        name = (EditText) findViewById(R.id.et_name);
        date = (EditText) findViewById(R.id.et_date);
        time = (EditText) findViewById(R.id.et_time);
        progress = (Spinner) findViewById(R.id.sp_progress);
        seekbar = (SeekBar) findViewById(R.id.seekBar);
        seek = (TextView) findViewById(R.id.tv_seek);
        bt = (Button) findViewById(R.id.bt_done);
        hours = (EditText) findViewById(R.id.et_hours);
        cmon = (CheckBox) findViewById(R.id.monday);
        ctue = (CheckBox) findViewById(R.id.tuesday);
        cwed = (CheckBox) findViewById(R.id.wednesday);
        cthu = (CheckBox) findViewById(R.id.thursday);
        cfri = (CheckBox) findViewById(R.id.friday);
        csat = (CheckBox) findViewById(R.id.saturday);
        csun = (CheckBox) findViewById(R.id.sunday);




        final String reference = getIntent().getExtras().getString("reference1");


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

        name.setText(list.get(0).toString());
        seekbar.setProgress(Integer.valueOf(list.get(1)));
        date.setText(list.get(2).toString());
        time.setText(list.get(3).toString());


        hours.setText(list.get(6).toString());

        String temp ;
        temp = list.get(7).toString();
        if(temp.equals("1")) {cmon.setChecked(true);vmon="1";}
        else { cmon.setChecked(false);vmon="0";}


        //
        //cmon.setChecked(true);
        //


        temp = list.get(8).toString();
        if(temp.equals("1")) {ctue.setChecked(true);vtue="1";}
        else { ctue.setChecked(false);vtue="0";}

        temp = list.get(9).toString();
        if(temp.equals("1")) {cwed.setChecked(true);vwed="1";}
        else { cwed.setChecked(false);vwed="0";}

        temp = list.get(10).toString();
        if(temp.equals("1")) {cthu.setChecked(true);vthu="1";}
        else { cthu.setChecked(false);vthu="0";}

        temp = list.get(11).toString();
        if(temp.equals("1")) {cfri.setChecked(true);vfri="1";}
        else { cfri.setChecked(false);vfri="0";}

        temp = list.get(12).toString();
        if(temp.equals("1")) {csat.setChecked(true);vsat="1";}
        else { csat.setChecked(false);vsat="0";}

        temp = list.get(13).toString();
        if(temp.equals("1")) {csun.setChecked(true);vsun="1";}
        else { csun.setChecked(false);vsun="0";}





        seek.setText(seekbar.getProgress() + "/" + seekbar.getMax());
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progres = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progres = progress;
                seek.setText(progres + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePicker datePicker = new DatePicker(v);
                android.app.FragmentTransaction fte = getFragmentManager().beginTransaction();
                datePicker.show(fte, "DATE PICKER");
            }
        });
        assert time != null;
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                TimePicker timePicker = new TimePicker(v1);
                android.app.FragmentTransaction fte1 = getFragmentManager().beginTransaction();
                timePicker.show(fte1, "TIME PICKER");
            }
        });
        /////////////////////////////////
/*        cmon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cmon.isChecked()==true){vmon="1";

                    Log.d(TAG, "sdf"+vmon+"  \n ");}
                else {vmon="0";
                    Log.d(TAG, "sdf"+vmon+"  \n ");
                }


            }
        });

        ctue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(ctue.isChecked()==true){vtue="1";

                    Log.d(TAG, "sdf"+vtue+"  \n ");}
                else {vmon="0";
                    Log.d(TAG, "sdf"+vtue+"  \n ");
                }


            }
        });

        cwed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cwed.isChecked()==true){vwed="1";

                    Log.d(TAG, "sdf"+vwed+"  \n ");}
                else {vwed="0";
                    Log.d(TAG, "sdf"+vwed+"  \n ");
                }


            }
        });

        cthu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cthu.isChecked()==true){vthu="1";

                    Log.d(TAG, "sdf"+vthu+"  \n ");}
                else {vmon="0";
                    Log.d(TAG, "sdf"+vthu+"  \n ");
                }


            }
        });

        cfri.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(cfri.isChecked()==true){vfri="1";

                    Log.d(TAG, "sdf"+vfri+"  \n ");}
                else {vmon="0";
                    Log.d(TAG, "sdf"+vfri+"  \n ");
                }


            }
        });

        csat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(csat.isChecked()==true){vsat="1";

                    Log.d(TAG, "sdf"+vsat+"  \n ");}
                else {vmon="0";
                    Log.d(TAG, "sdf"+vsat+"  \n ");
                }


            }
        });

        csun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(csun.isChecked()==true){vsun="1";

                    Log.d(TAG, "sdf"+vsun+"  \n ");}
                else {vsun="0";
                    Log.d(TAG, "sdf"+vsun+"  \n ");
                }


            }
        });

*/

        //
        cmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cmon.isChecked()==true){vmon="1";

                    Log.d(TAG, "sdf"+vmon+"  \n ");}
                else {vmon="0";
                    Log.d(TAG, "sdf"+vmon+"  \n ");
                }

            }
        });

        ctue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ctue.isChecked()==true){vtue="1";

                    Log.d(TAG, "sdf"+vtue+"  \n ");}
                else {vtue="0";
                    Log.d(TAG, "sdf"+vtue+"  \n ");
                }

            }
        });

        cwed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cwed.isChecked()==true){vwed="1";

                    Log.d(TAG, "sdf"+vwed+"  \n ");}
                else {vwed="0";
                    Log.d(TAG, "sdf"+vwed+"  \n ");
                }

            }
        });

        cthu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cthu.isChecked()==true){vthu="1";

                    Log.d(TAG, "sdf"+vthu+"  \n ");}
                else {vthu="0";
                    Log.d(TAG, "sdf"+vthu+"  \n ");
                }

            }
        });

        cfri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cfri.isChecked()==true){vfri="1";

                    Log.d(TAG, "sdf"+vfri+"  \n ");}
                else {vfri="0";
                    Log.d(TAG, "sdf"+vfri+"  \n ");
                }

            }
        });

        csat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(csat.isChecked()==true){vsat="1";

                    Log.d(TAG, "sdf"+vsat+"  \n ");}
                else {vsat="0";
                    Log.d(TAG, "sdf"+vsat+"  \n ");
                }

            }
        });

        csun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(csun.isChecked()==true){vsun="1";

                    Log.d(TAG, "sdf"+vsun+"  \n ");}
                else {vsun="0";
                    Log.d(TAG, "sdf"+vsun+"  \n ");
                }

            }
        });



        List<String> categories1 = new ArrayList<String>();
        categories1.add("0");
        categories1.add("10");
        categories1.add("20");
        categories1.add("30");
        categories1.add("40");
        categories1.add("50");
        categories1.add("60");
        categories1.add("70");
        categories1.add("80");
        categories1.add("90");
        categories1.add("100");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories1);

        // Drop down layout style - list view with radio button
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        progress.setAdapter(dataAdapter1);


        /*
        if(cmon.isChecked()==true){vmon="1";}
        else {vmon="0";}
        if(ctue.isChecked()==true){vtue="1";}
        else {vtue="0";}
        if(cwed.isChecked()==true){vwed="1";}
        else {vwed="0";}
        if(cthu.isChecked()==true){vthu="1";}
        else {vthu="0";}
        if(cfri.isChecked()==true){vfri="1";}
        else {vfri="0";}
        if(csat.isChecked()==true){vsat="1";}
        else {vsat="0";}
        if(csun.isChecked()==true){vsun="1";}
        else {vsun="0";}
*/

        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                myDb.updateData(name.getText().toString(),seekbar.getProgress(),date.getText().toString(),time.getText().toString(),progress.getSelectedItem().toString(),reference,Integer.parseInt(hours.getText().toString()) , vmon, vtue, vwed, vthu, vfri, vsat, vsun);
                Intent i=new Intent(edit_details.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });






    }
}
