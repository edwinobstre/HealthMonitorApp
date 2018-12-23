package tufts.shma.StepCounter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class StepDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Step.db";
    public static final String TABLE_NAME = "step_table";
    public static final String COL_1 = "DATE";
    public static final String COL_2 = "STEP";
    public static final String COL_3 = "SLEEP";


    public StepDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (DATE TEXT,STEP TEXT, SLEEP TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String date, String step, String sleep) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, date);
        contentValues.put(COL_2, step);
        contentValues.put(COL_3, sleep);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        db.close();
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }



    public boolean updateData(String date, String step, String sleep) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, date);
        contentValues.put(COL_2, step);
        contentValues.put(COL_3, sleep);
        db.update(TABLE_NAME, contentValues, "Name = ?",new String[] { date });
        return true;
    }

    public Integer deleteData (String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "Name = ?",new String[] { date });
    }

}
