package com.example.mike.android;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Enter extends AppCompatActivity implements android.view.View.OnClickListener {

    private static final String TAG = "myLogs";
    UserToData UToDb;

    Button btnEnter, btnReg;
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        UToDb = new UserToData(this);

        btnEnter = (Button) findViewById(R.id.btnEnter);
        btnReg = (Button) findViewById(R.id.btnReg);

        email = (EditText) findViewById(R.id.Login);
        password = (EditText) findViewById(R.id.Password);

        btnEnter.setOnClickListener(this);
        btnReg.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view == findViewById(R.id.btnEnter)) {

            try {
                User user = new User();
                user.Login = email.getText().toString();
                user.Password = password.getText().toString();

                boolean Answer = UToDb.CheckUserFromBase(user.Login, user.Password);
                Log.d(TAG, String.valueOf(Answer));
                if (Answer == true) {
                    //Переход на Меню
                    Intent intObj = new Intent(this, Menu.class);
                    startActivity(intObj);
                }
            } catch (RuntimeException e) {
                //Log.d(TAG, "Я тут");
                Toast.makeText(this, "Неверно введен логин или пароль", Toast.LENGTH_SHORT).show();
            }
        }
        if (view == findViewById(R.id.btnReg)) {
            //Переход на форму регистрации
            Intent intObj = new Intent(this, Registration.class);
            startActivity(intObj);
        }
    }
}