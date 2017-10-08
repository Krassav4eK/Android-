package com.example.mike.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Enter extends AppCompatActivity implements android.view.View.OnClickListener {

    private static final String TAG = "myLogs";
    UserToData UToDb;

    Button Btnreg, Ok;
    EditText login, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        Btnreg = (Button) findViewById(R.id.btnReg);
        Ok = (Button) findViewById(R.id.Enter);

        Btnreg.setOnClickListener(this);
        Ok.setOnClickListener(this);

        login = (EditText) findViewById(R.id.Login);
        password = (EditText) findViewById(R.id.Password);
    }

    public void onClick(View view) {
        if (view == findViewById(R.id.btnReg)) {
            Intent intObj = new Intent(this, Registration.class);
            startActivity(intObj);
        }

        if (view == findViewById(R.id.Enter)) {
            User user = new User();
            user.Login = login.getText().toString();
            user.Password = password.getText().toString();
            boolean Result = UToDb.CheckUserFromBase(user);
        }
    }
}