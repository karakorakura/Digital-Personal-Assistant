package com.android.dpa;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class DatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    EditText tv;
    public DatePicker(View view)
    {
        tv=(EditText) view;
    }
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        final Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),this,year,month,day);
    }
    @Override
    public void onDateSet(android.widget.DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        String value=year+"-"+pad((monthOfYear+1))+"-"+pad(dayOfMonth);
        tv.setText(value);
    }

    private static String pad(int dispatch) {
        if (dispatch >= 10)
            return String.valueOf(dispatch);
        else
            return "0" + String.valueOf(dispatch);}

}
