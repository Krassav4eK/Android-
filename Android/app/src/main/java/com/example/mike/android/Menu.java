package com.example.mike.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    private static final String TAG = "myLogs";
    UserToData UToDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toast.makeText(this, "Добро Пожаловать", Toast.LENGTH_SHORT).show();
    }
}