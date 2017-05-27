package com.android.dpa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by super star on 30-Nov-16.
 */

public class Busy extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="busy.db";
    public static final String TABLE_NAME="busy_table";
    public static final String COL1="monday";
    public static final String COL2="tuesday";
    public static final String COL3="wednesday";
    public static final String COL4="thursday";
    public static final String COL5="friday";
    public static final String COL6="saturday";
    public static final String COL7="sunday";
    public static final String COL8="id";

    public Busy(Context context) {
        super(context, DATABASE_NAME, null, 1); // version

        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        db.execSQL("create table " + TABLE_NAME + "(" + COL1 + " INT," + COL2 + " int ," + COL3 + " INT," + COL4 + " INT,"
                + COL5 + " INT," + COL6 + " INT ,"+COL7+" int , "+COL8+" integer primary key autoincrement);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE " + DATABASE_NAME+"."+TABLE_NAME+" ;");
        onCreate(db);
    }


}
