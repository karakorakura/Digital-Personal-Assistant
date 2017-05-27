package com.android.dpa;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Recommend extends AppCompatActivity {

    int free1 = 0;
    ListView listview;
    TextView left1;
    TextView left2;
    TextView left3;
    TextView left4;
    TextView free;
    private task_db myDb = new task_db(this);
    private algo_db algoDb = new algo_db(this);
    List<String> list1 = new ArrayList<String>();
    List<String> list2 = new ArrayList<String>();
    List<String> list3 = new ArrayList<String>();
    List<String> list4 = new ArrayList<String>();
    List<String> list5 = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String din = sdf.format(d);





        Log.d("\naaj ka din",din);

        left1 = (TextView) findViewById(R.id.tv_left1);
        left2 = (TextView) findViewById(R.id.tv_left2);
        left3 = (TextView) findViewById(R.id.tv_left3);
        left4 = (TextView) findViewById(R.id.tv_left4);
        free = (TextView) findViewById(R.id.recommend_hours_tv);

        listview = (ListView) findViewById(R.id.lv_recommend);

        Cursor cursor = myDb.getRecommend(din);






        String[] fromFieldNames=new String[]{task_db.COL1,task_db.COL3,task_db.COL6};
        int[] findViewId=new int[]{R.id.recommend_name_tv,R.id.recommend_date_tv,R.id.recommend_id};
        SimpleCursorAdapter myAdapter=new SimpleCursorAdapter(getBaseContext(),R.layout.recommend_list_item,cursor,fromFieldNames,findViewId,0);

        listview.setAdapter(myAdapter);

        Cursor c1 =  myDb.get1(din);
        Cursor c2 =  myDb.get2(din);
        Cursor c3 =  myDb.get3(din);
        Cursor c4 =  myDb.get4(din);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                View parent1 = (View) view.getParent();
                TextView taskTextView = (TextView) view.findViewById(R.id.recommend_id);
                String task = String.valueOf(taskTextView.getText().toString());
                Intent i = new Intent(getApplicationContext(), task_detail.class);
                i.putExtra("reference", task);
                startActivity(i);
            }
        });




        if (c1.moveToFirst()) {
            do {
                list1.add(c1.getString(0));
                list1.add(c1.getString(1));
                list1.add(c1.getString(2));
                list1.add(c1.getString(3));
                list1.add(c1.getString(4));
                list1.add(c1.getString(5));
                list1.add(c1.getString(6));
                list1.add(c1.getString(7));

            } while (c1.moveToNext());
        }
        Log.d("\nproggggggggggggggggggg",list1.get(5));

        int progress1 =Integer.parseInt(list1.get(5));


        int  hour1 = Integer.parseInt(list1.get(7));
        Log.d("\nhour ",list1.get(7));

        int left11 = (100 - progress1) * hour1 / 100;

        left1.setText( String.valueOf(left11));



        ////////////////////////////////


        if (c2.moveToFirst()) {
            do {
                list2.add(c2.getString(0));
                list2.add(c2.getString(1));
                list2.add(c2.getString(2));
                list2.add(c2.getString(3));
                list2.add(c2.getString(4));
                list2.add(c2.getString(5));
                list2.add(c2.getString(6));
                list2.add(c2.getString(7));

            } while (c2.moveToNext());
        }

        int progress2 =Integer.parseInt(list2.get(5));
        int  hour2 = Integer.parseInt(list2.get(7));

        int left22 = (100 - progress2) * hour2 / 100;

        left2.setText(String.valueOf(left22));

        /////////////////////////////////////////


        if (c3.moveToFirst()) {
            do {
                list3.add(c3.getString(0));
                list3.add(c3.getString(1));
                list3.add(c3.getString(2));
                list3.add(c3.getString(3));
                list3.add(c3.getString(4));
                list3.add(c3.getString(5));
                list3.add(c3.getString(6));
                list3.add(c3.getString(7));

            } while (c3.moveToNext());
        }

        int progress3 =Integer.parseInt(list3.get(5));
        int  hour3= Integer.parseInt(list3.get(7));

        int left33= (100 - progress3) * hour3/ 100;

        left3.setText(String.valueOf(left33));

        /////////////////////////////


        if (c4.moveToFirst()) {
            do {
                list4.add(c4.getString(0));
                list4.add(c4.getString(1));
                list4.add(c4.getString(2));
                list4.add(c4.getString(3));
                list4.add(c4.getString(4));
                list4.add(c4.getString(5));
                list4.add(c4.getString(6));
                list4.add(c4.getString(7));

            } while (c4.moveToNext());
        }

        int progress4 =Integer.parseInt(list4.get(5));
        int  hour4= Integer.parseInt(list4.get(7));

        int left44= (100 - progress4) * hour4/ 100;

        left4.setText(String.valueOf(left44));

        Cursor cr = algoDb.getData(din);




        if (cr.moveToFirst()) {

            do {
                list5.add(cr.getString(0));


            } while (cr.moveToNext());
        }

        Log.d("\n aaj de free ghante",list5.get(0));


       free.setText(list5.get(0));

        //free.setText("08");

    }
}
