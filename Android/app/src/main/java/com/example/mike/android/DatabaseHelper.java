package com.example.mike.android;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4;
    private static String DATABASE_NAME = "DBAndroid.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Тут мы создаем все необходимые нам таблицы

        String CREATE_TABLE_USER = "CREATE TABLE " + User.TABLE + "("
                + User.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + User.KEY_login + " TEXT, "
                + User.KEY_password + " TEXT, "
                + User.KEY_fio + " TEXT, "
                + User.KEY_phone + "TEXT)";

        db.execSQL(CREATE_TABLE_USER);
        Log.d("myLogs", "Таблица создана");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed - заменяет старую таблицу, но стирает в ней все данные
        db.execSQL("DROP TABLE IF EXISTS " + User.TABLE);

        // Создание новых таблиц
        onCreate(db);
    }

    public void DeleteAllData(Context context) {
        context.deleteDatabase(DATABASE_NAME);
    }
}

/*
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

}
    /*public Cursor query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
        return myDataBase.query("EMP_TABLE", null, null, null, null, null, null);
    }
}*/

    /*public int SetDataUser(int IdUser, String Login, String Password) {
        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Student.KEY_age, student.age);
        values.put(Student.KEY_email, student.email);
        values.put(Student.KEY_name, student.name);

        // Inserting Row
        long student_Id = db.insert(Student.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) student_Id;
    }*/

    /*public void delete(int student_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(Student.TABLE, Student.KEY_ID + "= ?", new String[]{String.valueOf(student_Id)});
        db.close(); // Closing database connection
    }

    public void update(Student student) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Student.KEY_age, student.age);
        values.put(Student.KEY_email, student.email);
        values.put(Student.KEY_name, student.name);

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(Student.TABLE, values, Student.KEY_ID + "= ?", new String[]{String.valueOf(student.student_ID)});
        db.close(); // Closing database connection
    }*/

    /*public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if (dbExist) {
        } else {
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    private void copyDataBase() throws IOException {
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[10];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }*/