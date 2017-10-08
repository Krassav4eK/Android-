package com.example.mike.android;

public class User {

    public int IdUser;
    public String Login;
    public String Password;
    public String FIO;
    public String Phone;

    /*public User(int IdUser, String Login, String Password, String FIO, String Phone) {
        this.IdUser = IdUser;
        this.Login = Login;
        this.Password = Password;
        this.FIO = FIO;
        this.Phone = Phone;
    }*/

    // Название таблицы
    public static final String TABLE = "User";

    // Название столбцов
    public static final String KEY_ID = "id";
    public static final String KEY_login = "login";
    public static final String KEY_password = "password";
    public static final String KEY_fio = "fio";
    public static final String KEY_phone = "phone";
}