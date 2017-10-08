package com.example.mike.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Enter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
    }

    public void newScreen(View v) {
        Intent intObj = new Intent(this, Registration.class);
        startActivity(intObj);
    }
}