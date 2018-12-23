package tufts.shma.Diet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DietDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Food.db";
    public static final String TABLE_NAME = "food_table";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "CALORIES";
    public static final String COL_3 = "FAT";
    public static final String COL_4 = "CHOLESTEROL";
    public static final String COL_5 = "SODIUM";

    public DietDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (NAME TEXT,CALORIES TEXT, FAT TEXT, CHOLESTEROL TEXT, SODIUM TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String calories, String fat, String cholesterol, String sodium) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,calories);
        contentValues.put(COL_3,fat);
        contentValues.put(COL_4,cholesterol);
        contentValues.put(COL_5,sodium);
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



    public boolean updateData(String name, String calories, String fat, String cholesterol, String sodium) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,calories);
        contentValues.put(COL_3,fat);
        contentValues.put(COL_4,cholesterol);
        contentValues.put(COL_5,sodium);
        db.update(TABLE_NAME, contentValues, "Name = ?",new String[] { name });
        return true;
    }

    public Integer deleteData (String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "Name = ?",new String[] { name });
    }

}