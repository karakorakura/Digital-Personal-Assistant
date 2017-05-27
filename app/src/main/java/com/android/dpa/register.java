package com.android.dpa;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class register extends AppCompatActivity {

    EditText name;
    EditText date;
    EditText time;
    Spinner progress;
    TextView seek;
    SeekBar seekbar;
    Button bt;
    EditText hours;
    CheckBox cmon;
    CheckBox ctue;
    CheckBox cwed;
    CheckBox cthu;
    CheckBox cfri;
    CheckBox csat;
    CheckBox csun;

    public static final String TAG = "checkreg";
    //

    String vmon = "0";
    String vtue = "0";
    String vwed = "0";
    String vthu = "0";
    String vfri = "0";
    String vsat = "0";
    String vsun = "0";


    final task_db myDb = new task_db(this);
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        bt = (Button) findViewById(R.id.bt_done);
        name = (EditText) findViewById(R.id.et_name);
        date = (EditText) findViewById(R.id.et_date);
        time = (EditText) findViewById(R.id.et_time);
        progress = (Spinner) findViewById(R.id.sp_progress);
        seek = (TextView) findViewById(R.id.tv_seek);
        seekbar = (SeekBar) findViewById(R.id.seekBar);
        hours = (EditText) findViewById(R.id.et_hours);
        cmon = (CheckBox) findViewById(R.id.monday);
        ctue = (CheckBox) findViewById(R.id.tuesday);
        cwed = (CheckBox) findViewById(R.id.wednesday);
        cthu = (CheckBox) findViewById(R.id.thursday);
        cfri = (CheckBox) findViewById(R.id.friday);
        csat = (CheckBox) findViewById(R.id.saturday);
        csun = (CheckBox) findViewById(R.id.sunday);


        date.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int inType = date.getInputType(); // backup the input type
                date.setInputType(InputType.TYPE_NULL); // disable soft input
                date.onTouchEvent(event); // call native handler
                date.setInputType(inType); // restore input type
                return true; // consume touch event
            }
        });

        time.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int inType = time.getInputType(); // backup the input type
                time.setInputType(InputType.TYPE_NULL); // disable soft input
                time.onTouchEvent(event); // call native handler
                time.setInputType(inType); // restore input type
                return true; // consume touch event
            }
        });


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePicker datePicker = new DatePicker(v);
                FragmentTransaction fte = getFragmentManager().beginTransaction();
                datePicker.show(fte, "DATE PICKER");
            }
        });
        assert time != null;
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                TimePicker timePicker = new TimePicker(v1);
                FragmentTransaction fte1 = getFragmentManager().beginTransaction();
                timePicker.show(fte1, "TIME PICKER");
            }
        });

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

        //
        cmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cmon.isChecked() == true) {
                    vmon = "1";

                    Log.d(TAG, "sdf" + vmon + "  \n ");
                } else {
                    vmon = "0";
                    Log.d(TAG, "sdf" + vmon + "  \n ");
                }

            }
        });

        ctue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ctue.isChecked() == true) {
                    vtue = "1";

                    Log.d(TAG, "sdf" + vtue + "  \n ");
                } else {
                    vtue = "0";
                    Log.d(TAG, "sdf" + vtue + "  \n ");
                }

            }
        });

        cwed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cwed.isChecked() == true) {
                    vwed = "1";

                    Log.d(TAG, "sdf" + vwed + "  \n ");
                } else {
                    vwed = "0";
                    Log.d(TAG, "sdf" + vwed + "  \n ");
                }

            }
        });

        cthu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cthu.isChecked() == true) {
                    vthu = "1";

                    Log.d(TAG, "sdf" + vthu + "  \n ");
                } else {
                    vthu = "0";
                    Log.d(TAG, "sdf" + vthu + "  \n ");
                }

            }
        });

        cfri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cfri.isChecked() == true) {
                    vfri = "1";

                    Log.d(TAG, "sdf" + vfri + "  \n ");
                } else {
                    vfri = "0";
                    Log.d(TAG, "sdf" + vfri + "  \n ");
                }

            }
        });

        csat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csat.isChecked() == true) {
                    vsat = "1";

                    Log.d(TAG, "sdf" + vsat + "  \n ");
                } else {
                    vsat = "0";
                    Log.d(TAG, "sdf" + vsat + "  \n ");
                }

            }
        });

        csun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (csun.isChecked() == true) {
                    vsun = "1";

                    Log.d(TAG, "sdf" + vsun + "  \n ");
                } else {
                    vsun = "0";
                    Log.d(TAG, "sdf" + vsun + "  \n ");
                }

            }
        });


/*

        if(cmon.isChecked()==true){vmon="1";

            Log.d(TAG, "sdf"+vmon+"  \n ");}
        else {vmon="0";
            Log.d(TAG, "sdf"+vmon+"  \n ");
        }
        if(ctue.isChecked()==true){vtue="1";}
        else {vtue="0";}
        Log.d(TAG, "sdf"+vtue+"  \n ");

        if(cwed.isChecked()==true){vwed="1";}
        else {vwed="0";}

        Log.d(TAG, "sdf"+vwed+"  \n ");
        if(cthu.isChecked()==true){vthu="1";}
        else {vthu="0";}
        if(cfri.isChecked()==true){vfri="1";}
        else {vfri="0";}
        if(csat.isChecked()==true){vsat="1";}
        else {vsat="0";}
        if(csun.isChecked()==true){vsun="1";}
        else {vsun="0";}

*/
        //

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


        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int priority = seekbar.getProgress();

                String p = String.valueOf(priority);


                if (name.getText().toString().trim().equals("") || name.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter the Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean result = myDb.insertData(name.getText().toString(), priority, date.getText().toString(), time.getText().toString(), progress.getSelectedItem().toString(), Integer.parseInt(hours.getText().toString()), vmon.toString(), vtue.toString(), vwed.toString(), vthu.toString(), vfri.toString(), vsat.toString(), vsun.toString());

                if (result) {
                    Intent i = new Intent(register.this, MainActivity.class);
                    startActivity(i);
                    finish();

                } else
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("register Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
