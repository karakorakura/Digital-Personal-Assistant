package com.android.dpa;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AddItems extends AppCompatActivity {

    Button bt;
    EditText et_deadline;
    TextView seek;
    EditText name;
    Spinner type;
    SeekBar seekbar;
    List<String> list = new ArrayList<String>();
    final ItemDb myDb = new ItemDb(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);

        bt = (Button) findViewById(R.id.bt_done);
        name = (EditText) findViewById(R.id.iet_name);
        et_deadline = (EditText) findViewById(R.id.et_date);
       seek = (TextView) findViewById(R.id.itv_seekBar);
        seekbar = (SeekBar) findViewById(R.id.editseek);
        type = (Spinner) findViewById(R.id.sp_type);

        et_deadline.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int inType = et_deadline.getInputType(); // backup the input type
                et_deadline.setInputType(InputType.TYPE_NULL); // disable soft input
                et_deadline.onTouchEvent(event); // call native handler
                et_deadline.setInputType(inType); // restore input type
                return true; // consume touch event
            }
        });
        et_deadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePicker datePicker = new DatePicker(v);
                android.app.FragmentTransaction fte = getFragmentManager().beginTransaction();
                datePicker.show(fte, "DATE PICKER");


            }
        });


        if(seekbar.getProgress()==0)
            seek.setText("I dont care");
        else if(seekbar.getProgress()==1)
            seek.setText("Not so important");
        else
            seek.setText("Very important");
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progres = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progres = progress;
                if(progres==0)
                    seek.setText("I dont care");
                else if(progres==1)
                    seek.setText("Not so important");
                else
                    seek.setText("Very important");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        List<String> categories1 = new ArrayList<String>();
        categories1.add("Grocery");
        categories1.add("Bakery");
        categories1.add("Clothing");
        categories1.add("Pharmacy");

        categories1.add("Doctor");


        categories1.add("Shopping Mall");
        categories1.add("Electronics");
        categories1.add("ATM");
        categories1.add("Temples");
        categories1.add("Restaurants");



        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories1);

        // Drop down layout style - list view with radio button
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        type.setAdapter(dataAdapter1);
        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int priority = seekbar.getProgress();

                String p = String.valueOf(priority);


                if (name.getText().toString().trim().equals("") || name.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter the Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean result = myDb.insertData(name.getText().toString(), priority, et_deadline.getText().toString(), type.getSelectedItem().toString());

                if (result) {
                    Intent i=new Intent(AddItems.this,ItemList.class);
                    startActivity(i);
                    finish();

                } else
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
