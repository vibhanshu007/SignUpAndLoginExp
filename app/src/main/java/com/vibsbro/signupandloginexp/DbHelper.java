package com.vibsbro.signupandloginexp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by root on 9/12/16.
 */

public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "singup_login.db";
    public static final String DB_USER_TABLE = "user";
    public static final String DB_COL_NAME = "_name";
    public static final String DB_COL_EMAIL = "email";
    public static final String DB_COL_PASSWORD = "password";
    public static final int DB_VERSION = 1;

    public static final String CREATE_TABLE_USERS = "CREATE TABLE" + DB_USER_TABLE + "(" + DB_COL_NAME +
            "INTEGER PRIVATE KEY AUTOINCREMENT," + DB_COL_EMAIL + "TEXT" + DB_COL_PASSWORD + "TEXT";

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_USERS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
