package com.example.mike.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Registration extends AppCompatActivity implements android.view.View.OnClickListener {

    private static final String TAG = "myLogs";
    UserToData UToDb;

    Button Btnreg, BtnShow, BtnDelete;
    EditText email, password, fio, phone;

    private int _UserId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        UToDb = new UserToData(this);

        int mCount = UToDb.getItemCount();
        Log.d(TAG, "Количество записей в базе:" + mCount);
        UToDb.close();

        Btnreg = (Button) findViewById(R.id.btnReg);
        BtnShow = (Button) findViewById(R.id.show);
        BtnDelete = (Button) findViewById(R.id.Delete);

        email = (EditText) findViewById(R.id.EMail);
        password = (EditText) findViewById(R.id.Password);
        fio = (EditText) findViewById(R.id.FIO);
        phone = (EditText) findViewById(R.id.Phone);

        Btnreg.setOnClickListener(this);
        BtnShow.setOnClickListener(this);

        /*_UserId = 0;
        Intent intent = getIntent();
        _UserId = intent.getIntExtra("User_Id", 0);
        UserRepo repo = new UserRepo(this);
        User user = new User();
        user = repo.getUserById(_UserId);

        email.setText(String.valueOf(user.Login));
        password.setText(String.valueOf(user.Password));
        fio.setText(String.valueOf(user.FIO));
        phone.setText(String.valueOf(user.Phone));*/
    }

    public void onClick(View view) {
        if (view == findViewById(R.id.btnReg)) {
            User user = new User();

            user.Login = email.getText().toString();
            user.Password = password.getText().toString();
            user.FIO = fio.getText().toString();
            user.Phone = phone.getText().toString();
            user.IdUser = _UserId;

            if (_UserId == 0) {
                _UserId = UToDb.SetDataUser(user);

                Toast.makeText(this, String.valueOf(_UserId), Toast.LENGTH_SHORT).show();

                //Вернуться обратно на enter
                Intent intObj = new Intent(this, Enter.class);
                startActivity(intObj);
            }
        }

        if (view == findViewById(R.id.show)) {
            User user = UToDb.getUserById(2);
            Log.d(TAG, "----Объект User----");
            Log.d(TAG, String.valueOf( user.IdUser));
            Log.d(TAG, user.Login.toString());
            Log.d(TAG, user.Password.toString());
            Log.d(TAG, user.FIO.toString());
            Log.d(TAG, user.Phone.toString());
        }

            //ArrayList<HashMap<String, String>> arrayList = ;
            /*Toast.makeText(this, "HI", Toast.LENGTH_SHORT).show();
        }
            /*String catName = "";
            for (int i = 0; i < arrayList.size(); i++) {
                catName = catName + arrayList.get(i) + " ";
            }

            Toast.makeText(this, catName, Toast.LENGTH_SHORT).show();*/

            /*ListAdapter adapter = new SimpleAdapter(this, arrayList, R.layout.activity_registration,
                    new String[]{"ID", "Login", "Password", "FIO", "Phone"},
                    new int[]{
                            arrayList.get(0).values()});

            Table.setAdapter(adapter);*/

        //Toast.makeText(this, , Toast.LENGTH_SHORT).show();

        if (view == findViewById(R.id.Delete)) {
            UToDb.DeleteAllData(this);
        }
    }
}