package com.android.dpa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class algo_db extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="algo.db";
    public static final String TABLE_NAME="algo_table";
    public static final String HOURS="hours";
    public static final String MON="mon";
    public static final String TUE="tue";
    public static final String WED="wed";
    public static final String THU="thu";
    public static final String FRI="fri";
    public static final String SAT="sat";
    public static final String SUN="sun";





    public algo_db(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("\n DAtabase "," created database ");

        db.execSQL("create table " + TABLE_NAME + "(" + HOURS + " INT," + MON + " INT ," + TUE + " INT ," + WED + " INT ," + THU + " INT," + FRI + " INT," + SAT + " INT," + SUN + " INT);");
        for (int i=1;i<=24;i++){
            db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(" + i + ",0,0,0,0,0,0,0);");
        }
        /*
        insertData(0, 0);
        insertData(1,0);
        insertData(2,0);
        insertData(3,0);
        insertData(4,0);
        insertData(5,0);
        insertData(6,0);
        insertData(7,0);
        insertData(8,0);
        insertData(9,0);
        insertData(10,0);
        insertData(11,0);
        insertData(12,0);
        insertData(13,0);
        insertData(14,0);
        insertData(15,0);
        insertData(16,0);
        insertData(17,0);
        insertData(18,0);
        insertData(19,0);
        insertData(20,0);
        insertData(21,0);
        insertData(22,0);
        insertData(23,0);
        insertData(24,0);
        */
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + DATABASE_NAME+"."+TABLE_NAME+" ;");
        onCreate(db);
    }

    public boolean insertData(int hour, int day)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(HOURS,hour);
        cv.put(MON,day);
        cv.put(TUE,day);
        cv.put(WED,day);
        cv.put(THU,day);
        cv.put(FRI,day);
        cv.put(SAT,day);
        cv.put(SUN,day);
        for (int i=0;i<=24;i++){
        db.execSQL("INSERT INTO " + TABLE_NAME + " VALUES(" + i + ",0,0,0,0,0,0,0);");
    }

        long result=db.insert(TABLE_NAME, null, cv);

        if(result==-1)
            return false;
        else
            return true;
    }

    public boolean update(String day,int start, int end)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Log.d("\n in algo update ", day);
        int i;
        if(day.equals("monday"))
        {
            for (i = start;i<=end;i++)
            {
                db.execSQL( "UPDATE " +TABLE_NAME+ " SET " +MON+ "= mon + 1 where " +HOURS+ "=" +i+";");

            }
        }

        if(day.equals("tuesday"))
        {
            for (i = start;i<=end;i++)
            {
                db.execSQL( "UPDATE " +TABLE_NAME+ " SET " +TUE+ "= tue + 1 where " +HOURS+ "=" +i+";");

            }
        }


        if(day.equals("wednesday"))
        {
            Log.d("\n in wed",String.valueOf(start));
            for (i = start;i<=end;i++)
            {
                db.execSQL( "UPDATE " +TABLE_NAME+ " SET " +WED+ "= wed + 1 where " +HOURS+ "=" +i+" ");
                Log.d(" \n i update wed ",String.valueOf(i));

            }
        }

        if(day.equals("thursday"))
        {
            for (i = start;i<=end;i++)
            {
                db.execSQL( "UPDATE " +TABLE_NAME+ " SET " +THU+ " = thu + 1 where " +HOURS+ " = " +i+" ");
                Log.d(" \n i update thu ",String.valueOf(i));
            }
        }

        if(day.equals("friday"))
        {
            for (i = start;i<=end;i++)
            {
                db.execSQL( "UPDATE " +TABLE_NAME+ " SET " +FRI+ " = fri + 1 where " +HOURS+ "=" +i+" ");

            }
        }

        if(day.equals("saturday"))
            {
            for (i = start;i<=end;i++)
            {
                db.execSQL( "UPDATE " +TABLE_NAME+ " SET " +SAT+ "= sat + 1 where " +HOURS+ "=" +i+";");

            }
        }

        if(day.equals("sunday"))
        {
            for (i = start;i<=end;i++)
            {
                db.execSQL( "UPDATE " +TABLE_NAME+ " SET " +SUN+ "= sun + 1 where " +HOURS+ "=" +i+";");

            }
        }

        return true;
    }


    public void delete(String day,int start, int end)
    {
        int i;
        SQLiteDatabase db = this.getWritableDatabase();
        if(day.equals("monday"))
        {
            for (i = start;i<=end;i++)
            {
                db.execSQL( "UPDATE " +TABLE_NAME+ " SET " +MON+ "= mon - 1 where " +HOURS+ "=" +i+";");

            }
        }

        if(day.equals("tuesday"))
        {
            for (i = start;i<=end;i++)
            {
                db.execSQL( "UPDATE " +TABLE_NAME+ " SET " +TUE+ "= tue - 1 where " +HOURS+ "=" +i+";");

            }
        }


        if(day.equals("wednesday"))
        {
            for (i = start;i<=end;i++)
            {
                db.execSQL( "UPDATE " +TABLE_NAME+ " SET " +WED+ "= wed - 1 where " +HOURS+ "=" +i+";");

            }
        }

        if(day.equals("thursday"))
        {
            for (i = start;i<=end;i++)
            {
                db.execSQL( "UPDATE " +TABLE_NAME+ " SET " +THU+ "= thu - 1 where " +HOURS+ "=" +i+";");

            }
        }

        if(day.equals("friday"))
        {
            for (i = start;i<=end;i++)
            {
                db.execSQL( "UPDATE " +TABLE_NAME+ " SET " +FRI+ "= fri - 1 where " +HOURS+ "=" +i+";");

            }
        }

        if(day.equals("saturday"))
        {
            for (i = start;i<=end;i++)
            {
                db.execSQL( "UPDATE " +TABLE_NAME+ " SET " +SAT+ "= sat - 1 where " +HOURS+ "=" +i+";");

            }
        }

        if(day.equals("sunday"))
        {
            for (i = start;i<=end;i++)
            {
                db.execSQL( "UPDATE " +TABLE_NAME+ " SET " +SUN+ "= sun - 1 where " +HOURS+ "=" +i+";");

            }
        }


    }



    public Cursor getData(String day)
    {
        SQLiteDatabase db=this.getWritableDatabase();
       Cursor res = null;

        if(day.equals("Monday"))
        {
             res=db.rawQuery("select count(*) from  (Select * from algo_table where mon = 0)",null);
        }

        if(day.equals("Tuesday"))
        {
            res=db.rawQuery("select count(*) from  (Select * from algo_table where tue = 0)",null);
        }


        if(day.equals("Wednesday"))
        {
            res=db.rawQuery("select count(*) from  (Select * from algo_table where wed = 0)",null);
        }

        if(day.equals("Thursday"))
        {
            Log.d("\n in count athhu", " ");
            res=db.rawQuery("select count(*) from (Select * from algo_table where thu = 0)",null);
        }

        if(day.equals("Friday"))
        {
            res=db.rawQuery("select count(*) from (Select * from algo_table where fri = 0)",null);
        }

        if(day.equals("Saturday"))
        {
            res=db.rawQuery("select count(*) from  (Select * from algo_table where sat = 0)",null);
        }

        if(day.equals("Sunday"))
        {
            res=db.rawQuery("select count(*) from  (Select * from algo_table where sun = 0)",null);
        }

        return  res;
    }
}
