package com.android.dpa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddSchedule extends AppCompatActivity {
EditText etname;
    Spinner etstart;
    Spinner etend;
    EditText day;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_schedule);
        etname=(EditText)findViewById(R.id.et_name);
        etstart=(Spinner)findViewById(R.id.sp_start);
        etend=(Spinner)findViewById(R.id.sp_end);
        bt=(Button)findViewById(R.id.bt_done);

        final String reference = getIntent().getExtras().getString("reference1");
        List<String> list = new ArrayList<String>();
        final ScheduleDb myDb = new ScheduleDb(this);
        final algo_db algoDb = new algo_db(this);

        List<String> categories1 = new ArrayList<String>();
        categories1.add("0");
        categories1.add("1");
        categories1.add("2");
        categories1.add("3");
        categories1.add("4");
        categories1.add("5");
        categories1.add("6");
        categories1.add("7");
        categories1.add("8");
        categories1.add("9");
        categories1.add("10");
        categories1.add("11");
        categories1.add("12");
        categories1.add("13");
        categories1.add("14");
        categories1.add("15");
        categories1.add("16");
        categories1.add("17");
        categories1.add("18");
        categories1.add("19");
        categories1.add("20");
        categories1.add("21");
        categories1.add("22");
        categories1.add("23");
        categories1.add("24");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories1);

        // Drop down layout style - list view with radio button
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        etstart.setAdapter(dataAdapter1);
        etend.setAdapter(dataAdapter1);



        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                if (etname.getText().toString().trim().equals("") || etname.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter the Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean result = myDb.insertData(etname.getText().toString(),reference.toString(), etstart.getSelectedItem().toString(),etend.getSelectedItem().toString());

                if (result) {

                    boolean result2 = algoDb.update(reference.toString(),Integer.parseInt(etstart.getSelectedItem().toString()),Integer.parseInt(etend.getSelectedItem().toString()));
                    Intent i=new Intent(AddSchedule.this,UserSchedule.class);
                    Log.d("\n if mein jaa ra hai "," true");

                    startActivity(i);
                    finish();

                } else
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
            }
        });





    }
}
