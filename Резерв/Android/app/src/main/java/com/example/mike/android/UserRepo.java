package com.example.mike.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;

public class UserRepo {

    private DatabaseHelper dbHelper;

    public UserRepo(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public int insert(User User) {
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

    public void delete(int User_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(User.TABLE, User.KEY_ID + "= ?", new String[]{String.valueOf(User_Id)});
        db.close(); // Closing database connection
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

    public ArrayList<HashMap<String, String>> getStudentList() {
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

        Cursor cursor = db.rawQuery(selectQuery, null);
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
    }

    public User getUserById(int Id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "SELECT  " +
                User.KEY_ID + "," +
                User.KEY_login + "," +
                User.KEY_password + "," +
                User.KEY_fio + "," +
                User.KEY_phone +
                " FROM " + User.TABLE
                + " WHERE " +
                User.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount = 0;
        User user = new User();

        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(Id)});

        if (cursor.moveToFirst()) {
            do {
                user.IdUser = cursor.getInt(cursor.getColumnIndex(user.KEY_ID));
                user.Login = cursor.getString(cursor.getColumnIndex(user.KEY_login));
                user.Password = cursor.getString(cursor.getColumnIndex(user.KEY_password));
                user.FIO = cursor.getString(cursor.getColumnIndex(user.KEY_fio));
                user.Phone = cursor.getString(cursor.getColumnIndex(user.KEY_phone));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return user;
    }
}