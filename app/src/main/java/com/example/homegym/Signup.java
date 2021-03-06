package com.example.homegym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.homegym.Database;
import com.example.homegym.R;

import java.util.LinkedHashMap;
import java.util.Map;


public class Signup extends AppCompatActivity {
    Database myDB;

    public EditText username;
    public EditText name;
    public EditText email;
    public EditText password;
    public EditText confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDB = new Database(Signup.this);
        setContentView(R.layout.activity_signup);
        name = findViewById(R.id.editTextName);
        email = findViewById(R.id.editTextEmail);
        username = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextPassword);
        confirmPassword = findViewById(R.id.editTextConfirmPassword);
    }

    public void dataInsert(View view) {
        String emails = email.getText().toString();
        String names = name.getText().toString();
        String usernameValue = username.getText().toString();
        String passwordValue = password.getText().toString();
        String confirmPasswordValue = confirmPassword.getText().toString();
        if(emails.equals("")||names.equals("")||usernameValue.equals("") || passwordValue.equals("") || confirmPasswordValue.equals("")) {
            Toast.makeText(Signup.this,"Fill all the Blanks",Toast.LENGTH_SHORT).show();
        }
        else if(!passwordValue.equals(confirmPasswordValue)) {
            password.setText("");
            confirmPassword.setText("");
            Toast.makeText(Signup.this,"Enter same password in both fields",Toast.LENGTH_SHORT).show();
        }
        else {
            myDB.insertData(usernameValue, passwordValue);
            Intent intentPizzazia = new Intent(Signup.this,HOME_WORKOUT.class);
            startActivity(intentPizzazia);
            finish();
        }
    }
}
