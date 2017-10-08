package com.example.mike.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ForEnter extends AppCompatActivity implements View.OnClickListener{

    Button btnEnter, btnReg;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        btnEnter = (Button) findViewById(R.id.Ok);
        btnEnter.setOnClickListener(this);

        btnReg = (Button) findViewById(R.id.btnReg);
        btnReg.setOnClickListener(this);

        // создаем объект для создания и управления версиями БД
        dbHelper = new DatabaseHelper(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.Ok:

                break;
            case R.id.btnReg:
                //super.onCreate(b);
                setContentView(R.layout.activity_registration);
                break;
        }
    }

    /*public void newScreen(View v) {
        Intent intObj = new Intent(this, Registration.class);
        startActivity(intObj);
    }*/
}