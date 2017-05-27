package com.android.dpa;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
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

public class ModifyItems extends AppCompatActivity {
    Button bt;
    EditText et_deadline;
    TextView seek;
    EditText name;
    Spinner type;
    SeekBar seekbar;
    List<String> list = new ArrayList<String>();
    private ItemDb myDb = new ItemDb(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);


        name = (EditText) findViewById(R.id.iet_name);
        et_deadline = (EditText) findViewById(R.id.et_date);
        seekbar = (SeekBar) findViewById(R.id.editseek);
        seek = (TextView) findViewById(R.id.itv_seekBar);
        bt = (Button) findViewById(R.id.bt_done);
        type = (Spinner) findViewById(R.id.sp_type);

        final String reference = getIntent().getExtras().getString("reference1");
        Log.d("reference",reference);


        Cursor cursor = myDb.getDetails(reference);

        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0));
                list.add(cursor.getString(1));
                list.add(cursor.getString(2));
                list.add(cursor.getString(3));

            } while (cursor.moveToNext());
        }

        name.setText(list.get(0).toString());
        seekbar.setProgress(Integer.valueOf(list.get(1)));
        et_deadline.setText(list.get(2).toString());
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
        categories1.add("Pharmacy");
        categories1.add("Restaurants");
        categories1.add("Hospitals");
        categories1.add("Bakery");
        categories1.add("Clothing");
        categories1.add("Shopping Mall");
        categories1.add("Electronics");
        categories1.add("ATM");
        categories1.add("Bank");




        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories1);

        // Drop down layout style - list view with radio button
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        type.setAdapter(dataAdapter1);

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
        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                myDb.updateData(name.getText().toString(),seekbar.getProgress(),et_deadline.getText().toString(),type.getSelectedItem().toString(),reference);
                Intent i=new Intent(ModifyItems.this,ItemList.class);
                startActivity(i);
                finish();
            }
        });






    }
}
