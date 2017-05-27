package com.android.dpa;

/**
 * Created by super star on 14-Nov-16.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by stark on 11/10/2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ItemDb extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="item.db";
    public static final String TABLE_NAME="item_table";
    public static final String NAME="name";
    public static final String PRIORITY="priority";
    public static final String DEADLINE="deadline";
    public static final String ITEM_TYPE="item_type";
    public static final String ID="id";

    public ItemDb(Context context) {
        super(context, DATABASE_NAME, null, 1);

        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        db.execSQL("create table " + TABLE_NAME + "(" + NAME + " TEXT," + PRIORITY + " int ," + DEADLINE + " TEXT ,"+ITEM_TYPE+" TEXT," + ID + " integer primary key autoincrement);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name,int priority,String deadline,String type)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(NAME,name );
        cv.put(PRIORITY,priority);
        cv.put(DEADLINE,deadline);
        cv.put(ITEM_TYPE,type);



        long result=db.insert(TABLE_NAME, null, cv);

        if(result==-1)
            return false;
        else
            return true;
    }

    public Cursor getData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" order by id desc",null);
        return res;
    }

    public boolean updateData(String name,int priority,String deadline,String type, String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(NAME,name);
        cv.put(PRIORITY,priority );
        cv.put(DEADLINE,deadline );
        cv.put(ITEM_TYPE,type );
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

