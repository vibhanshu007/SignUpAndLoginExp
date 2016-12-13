package com.vibsbro.signupandloginexp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by root on 9/12/16.
 */

public class DbHelper extends SQLiteOpenHelper {
    public static final String TAG = DbHelper.class.getSimpleName();
    public static final String DB_NAME = "singup_login.db";
    public static final String DB_USER_TABLE = "user";
    public static final String DB_COL_NAME = "name";
    public static final String DB_COL_EMAIL = "email";
    public static final String DB_COL_PASSWORD = "password";
    public static final int DB_VERSION = 1;
    public static final String CREATE_TABLE_USERS = "CREATE TABLE " + DB_USER_TABLE + "(" + DB_COL_NAME +
            " INTEGER PRIMARY KEY AUTOINCREMENT," + DB_COL_EMAIL + " TEXT," + DB_COL_PASSWORD + " TEXT );";
    private static DbHelper dbHelper;

    public DbHelper(Context context)

    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static DbHelper getInstance(Context context){
        if (null ==dbHelper){
            dbHelper=new DbHelper(context);
        }
        return dbHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_USERS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addUser(String email, String password){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DB_COL_EMAIL,email);
        values.put(DB_COL_PASSWORD,password);

        long id = db.insert(DB_USER_TABLE,null,values);
        db.close();
        Log.d(TAG,"userInsert" +id);

    }

    public boolean getUser(String email,String pass){

        String selectQueary = "select * from " + DB_USER_TABLE + " where " + DB_COL_EMAIL + "=" + "'"
                + email + "'" +  " and " + DB_COL_PASSWORD + "=" + "'" +pass+ "';";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQueary,null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){

            return true;
        }
        cursor.close();
        db.close();
        return false;
    }

}
