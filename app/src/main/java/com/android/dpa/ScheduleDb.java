package com.android.dpa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by super star on 16-Nov-16.
 */

public class ScheduleDb extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="schedule.db";
    public static final String TABLE_NAME="schedule_table";
    public static final String NAME="name";
    public static final String DAY="day";
    public static final String START="start";
    public static final String END="end";
    public static final String ID="id";

    public ScheduleDb(Context context) {
        super(context, DATABASE_NAME, null, 1);

        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        db.execSQL("create table " + TABLE_NAME + "(" + NAME + " TEXT," + DAY + " TEXT ," + START + " TEXT ," + END + " TEXT ," + ID + " integer primary key autoincrement);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String day, String start, String end)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(NAME,name );
        cv.put(DAY,day);
        cv.put(START,start);
        cv.put(END,end);



        long result=db.insert(TABLE_NAME, null, cv);

        if(result==-1)
            return false;
        else
            return true;
    }

    public Cursor getData(String day)
    {
        Log.d("day ",day);
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" order by id desc",null);
        return res;
    }

    public Cursor getData2(String day)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select rowid _id, * from "+TABLE_NAME+" where day = "+"'"+day+"'"+" ",null);
        return res;
    }


    public Cursor getData4(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select rowid _id, * from "+TABLE_NAME+" where id = "+id+" ;",null);
        return res;
    }


    public boolean updateData(String name,String day,String start, String end, String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(NAME,name);
        cv.put(DAY,day);
        cv.put(START,start);
        cv.put(END,end);
        cv.put(ID,id );



        db.update(TABLE_NAME, cv, "id=?", new String[]{id});
        return true;
    }

    public void Deleteitem(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE id="+id;
        db.execSQL(query);
    }

    public Cursor getDetails(String comp)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from " + TABLE_NAME + " where id= '"+comp+"'",null);
        return res;
    }

}
