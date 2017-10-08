package com.example.mike.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class UserToData {

    private static final String TAG = "myLogs";

    private DatabaseHelper dbHelper;
    Context context;
    Cursor cursor;
    SQLiteDatabase db;

    public UserToData(Context context) {
        this.context = context;
        dbHelper = new DatabaseHelper(context);
    }

    public int SetDataUser(User User) {
        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(User.KEY_login, User.Login);
        values.put(User.KEY_password, User.Password);
        values.put(User.KEY_fio, User.FIO);
        values.put(User.KEY_password, User.Password);

        // Inserting Row
        long User_Id = db.insert(User.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) User_Id;
    }

    public void update(User User) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(User.KEY_login, User.Login);
        values.put(User.KEY_password, User.Password);
        values.put(User.KEY_fio, User.FIO);
        values.put(User.KEY_password, User.Password);

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(User.TABLE, values, User.KEY_ID + "= ?", new String[]{String.valueOf(User.IdUser)});
        db.close(); // Closing database connection
    }

    public void delete(int User_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(User.TABLE, User.KEY_ID + "= ?", new String[]{String.valueOf(User_Id)});
        db.close(); // Closing database connection
    }

    public int getItemCount() {
        db = dbHelper.getReadableDatabase();

        cursor = db.query(User.TABLE, null, null, null, null, null, null);
        int cnt = cursor.getCount();
        cursor.close();

        return cnt;
    }

    public User getUserById(int Id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT  " +
                User.KEY_ID + "," +
                User.KEY_login + "," +
                User.KEY_password + "," +
                User.KEY_fio  +
                //User.KEY_phone +
                " FROM " + User.TABLE
                + " WHERE " +
                User.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount = 0;
        User user = new User();

        cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(Id)});

        Log.d(TAG, "Дошел");

        if (cursor.moveToFirst()) {
            do {
                user.IdUser = cursor.getInt(cursor.getColumnIndex(user.KEY_ID));
                user.Login = cursor.getString(cursor.getColumnIndex(user.KEY_login));
                user.Password = cursor.getString(cursor.getColumnIndex(user.KEY_password));
                user.FIO = cursor.getString(cursor.getColumnIndex(user.KEY_fio));
                //user.Phone = cursor.getString(cursor.getColumnIndex(user.KEY_phone));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return user;
    }

    public void DeleteAllData(Context context) {
        dbHelper.DeleteAllData(context);
    }

    public void close() {
        dbHelper.close();
        db.close();
    }
}

    /**




}

/*public ArrayList<HashMap<String, String>> getUserList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT  " +
                User.KEY_ID + "," +
                User.KEY_login + "," +
                User.KEY_password + "," +
                User.KEY_fio + "," +
                User.KEY_phone +
                " FROM " + User.TABLE;

        //User user = new User();
        ArrayList<HashMap<String, String>> userList = new ArrayList<HashMap<String, String>>();

        Log.d(TAG, "Работает!");
        Cursor cursor = db.rawQuery(selectQuery,null);
        Log.d(TAG, "Работает2!");
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> user = new HashMap<String, String>();
                user.put("id", cursor.getString(cursor.getColumnIndex(User.KEY_ID)));
                user.put("login", cursor.getString(cursor.getColumnIndex(User.KEY_login)));
                userList.add(user);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return userList;
    }*/