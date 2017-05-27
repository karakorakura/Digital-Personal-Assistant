package com.android.dpa;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by Rohit_Semwal on 09-11-2016.
 */
public class TimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    EditText et1;

    public TimePicker(View v1) {
        et1=(EditText)v1;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        Calendar c=Calendar.getInstance();
        int hour=c.get(Calendar.HOUR);
        int min=c.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(),this,hour,min,false);
    }

    @Override
    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
        String value1=pad(hourOfDay)+" : "+pad(minute);
        et1.setText(value1);
    }

    private static String pad(int dispatch) {
        if (dispatch >= 10)
            return String.valueOf(dispatch);
        else
            return "0" + String.valueOf(dispatch);}

}
