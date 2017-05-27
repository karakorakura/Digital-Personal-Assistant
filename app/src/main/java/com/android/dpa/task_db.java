package com.android.dpa;

/**
 * Created by stark on 11/10/2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class task_db extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="task.db";
    public static final String TABLE_NAME="task_table";
    public static final String COL1="name";
    public static final String COL2="priority";
    public static final String COL3="deadline";
    public static final String COL4="deadline_time";
    public static final String COL5="progress";
    public static final String COL6="id";
    public static final String HOURS="et_hours";
    public static final String MON="monday";
    public static final String TUE="tuesday";
    public static final String WED="wednesday";
    public static final String THU="thursday";
    public static final String FRI="friday";
    public static final String SAT="saturday";
    public static final String SUN="sunday";



    public task_db(Context context) {
        super(context, DATABASE_NAME, null, 3); // version

        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        db.execSQL("create table " + TABLE_NAME + "(" + COL1 + " TEXT," + COL2 + " int ," + COL3 + " TEXT," + COL4 + " TEXT,"
                + COL5 + " TEXT," + COL6 + " integer primary key autoincrement ,"+HOURS+" int , "+MON+" TEXT , "+
                TUE+" TEXT , "+WED+" TEXT , "+THU+" TEXT , "+FRI+" TEXT , "+SAT+" TEXT , "+SUN+" TEXT  );");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE " + DATABASE_NAME+"."+TABLE_NAME+" ;");
        onCreate(db);
    }

    public boolean insertData(String name,int priority,String deadline,String deadline_time,String progress, int hours, String mon , String tue, String wed , String thu, String fri, String sat, String sun)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL1,name );
        cv.put(COL2,priority);
        cv.put(COL3,deadline);
        cv.put(COL4, deadline_time);
        cv.put(COL5, progress);
        cv.put(HOURS,hours);
        cv.put(MON,mon);
        cv.put(TUE,tue);
        cv.put(WED,wed);
        cv.put(THU,thu);
        cv.put(FRI,fri);
        cv.put(SAT,sat);
        cv.put(SUN,sun);


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

    public Cursor getRecommend(String day)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = null;

        if(day.equals("Monday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where monday = '1' order by date(deadline) LIMIT 4 ",null);

        }

        if(day.equals("Tuesday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where tuesday = '1' order by date(deadline) LIMIT 4 ",null);


        }

        if(day.equals("Wednesday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where wednesday = 1 order by date(deadline) LIMIT 4 ",null);


        }

        if(day.equals("Thursday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where thursday = 1 order by date(deadline) LIMIT 4 ",null);


        }

        if(day.equals("Friday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where friday = '1' order by date(deadline) LIMIT 4 ",null);


        }

        if(day.equals("Saturday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where saturday = '1' order by date(deadline) LIMIT 4 ",null);


        }

        if(day.equals("Sunday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where sunday = '1' order by date(deadline) LIMIT 4 ",null);


        }

        return res;



    }

    public Cursor get1(String day)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = null;
        Log.d("\n logji reached here ",day);
        if(day.equals("Monday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where monday = '1' order by date(deadline) LIMIT 1  ",null);
            Log.d("\n logji reached here "," in monday ");
        }

        if(day.equals("Tuesday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where tuesday = '1' AND _id = 1 order by date(deadline) LIMIT 1  ",null);
            Log.d("\n logji reached here "," in tuesday ");
        }

        if(day.equals("Wednesday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where wednesday = 1  order by date(deadline) LIMIT 1  ",null);
            Log.d("\n logji reached here "," in wednesda ");
        }

        if(day.equals("Thursday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where thursday = 1 order by date(deadline) LIMIT 1 ",null);
            Log.d("\n logji reached here "," in thursday ");
        }

        if(day.equals("Friday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where friday = '1'  order by date(deadline) LIMIT 1  ",null);
            Log.d("\n logji reached here "," in fridau ");
        }

        if(day.equals("Saturday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where saturday = '1' AND _id = 1 order by date(deadline) LIMIT 1  ",null);
            Log.d("\n logji reached here "," in saturday ");
        }

        if(day.equals("Sunday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where sunday = '1' AND _id = 1 order by date(deadline) LIMIT 1  ",null);
            Log.d("\n logji reached here "," in sunday ");
        }

        return res;



    }

    public Cursor get2(String day)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = null;

        if(day.equals("Monday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where monday = '1'  order by date(deadline) LIMIT 1 OFFSET 1 ",null);
        }

        if(day.equals("Tuesday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where tuesday = '1' order by date(deadline)  LIMIT 1 OFFSET 1 ",null);

        }

        if(day.equals("Wednesday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where wednesday = 1 order by date(deadline)  LIMIT 1 OFFSET 1  ",null);

        }

        if(day.equals("Thursday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where thursday = 1 order by date(deadline)  LIMIT 1 OFFSET 1 ",null);

        }

        if(day.equals("Friday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where friday = '1'  order by date(deadline)   LIMIT 1 OFFSET 1 ",null);

        }

        if(day.equals("Saturday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where saturday = '1' order by date(deadline)   LIMIT 1 OFFSET 1 ",null);

        }

        if(day.equals("Sunday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where sunday = '1'  order by date(deadline)   LIMIT 1 OFFSET 1  ",null);
        }

        return res;



    }

    public Cursor get3(String day)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = null;

        if(day.equals("Monday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where monday = '1' order by date(deadline)   LIMIT 1 OFFSET 2  ",null);
        }

        if(day.equals("Tuesday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where tuesday = '1' order by date(deadline)   LIMIT 1 OFFSET 2 ",null);

        }

        if(day.equals("Wednesday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where wednesday = 1 order by date(deadline)  LIMIT 1 OFFSET 2",null);

        }

        if(day.equals("Thursday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where thursday = 1 order by date(deadline)   LIMIT 1 OFFSET 2",null);

        }

        if(day.equals("Friday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where friday = '1' order by date(deadline)   LIMIT 1 OFFSET 2",null);

        }

        if(day.equals("Saturday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where saturday = '1' order by date(deadline)   LIMIT 1 OFFSET 2",null);

        }

        if(day.equals("Sunday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where sunday = '1' order by date(deadline)   LIMIT 1 OFFSET 2 ",null);
        }

        return res;



    }

    public Cursor get4(String day)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = null;

        if(day.equals("Monday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where monday = '1' order by date(deadline)  LIMIT 1 OFFSET 3 ",null);
        }

        if(day.equals("Tuesday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where tuesday = '1' order by date(deadline) LIMIT 1 OFFSET 3 ",null);

        }

        if(day.equals("Wednesday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where wednesday = '1' order by date(deadline)  LIMIT 1 OFFSET 3  ",null);

        }

        if(day.equals("Thursday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where thursday = 1  order by date(deadline)  LIMIT 1 OFFSET 3 ",null);

        }

        if(day.equals("Friday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where friday = '1' order by date(deadline) LIMIT 1 OFFSET 3 ",null);

        }

        if(day.equals("Saturday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where saturday = '1' order by date(deadline)  LIMIT 1 OFFSET 3 ",null);

        }

        if(day.equals("Sunday")){
            res=db.rawQuery("select rowid _id,* from "+TABLE_NAME+" where sunday = '1'  order by date(deadline) LIMIT 1 OFFSET 3  ",null);
        }

        return res;



    }

    public boolean updateData(String name,int priority,String deadline,String deadline_time,String progress,String id, int hours, String mon , String tue, String wed , String thu, String fri, String sat, String sun)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL1,name);
        cv.put(COL2,priority );
        cv.put(COL3,deadline );
        cv.put(COL4,deadline_time );
        cv.put(COL5,progress );
        cv.put(COL6,id );
        cv.put(HOURS,hours);
        cv.put(MON,mon);
        cv.put(TUE,tue);
        cv.put(WED,wed);
        cv.put(THU,thu);
        cv.put(FRI,fri);
        cv.put(SAT,sat);
        cv.put(SUN,sun);



        db.update(TABLE_NAME, cv, "id=?", new String[]{id});
        return true;
    }

    public void Deleteitem(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM favorite WHERE id="+id;
        db.execSQL(query);
    }

    public Cursor getDetails(String comp)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from task_table where id= '"+comp+"'",null);
        return res;
    }
}

