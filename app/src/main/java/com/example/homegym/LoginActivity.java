package com.example.homegym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    Database myDB;
    public EditText username;
    public EditText password;
    static LinkedHashMap<String,String> map = new LinkedHashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        myDB = new Database(this);
        username = findViewById(R.id.editText_username);
        password = findViewById(R.id.editText_password);
    }

    public void Login(View view) {
        map = myDB.verifyData();
        String usernameValue = username.getText().toString();
        String passwordValue = password.getText().toString();
        if(usernameValue.equals("") || passwordValue.equals("")) {
            Toast.makeText(LoginActivity.this,"Fill all the Blanks",Toast.LENGTH_SHORT).show();
        }
        else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if(map.containsKey(usernameValue) && Objects.requireNonNull(map.get(usernameValue)).equals(passwordValue)) {
                Toast.makeText(LoginActivity.this,"Successfully Login!!",Toast.LENGTH_SHORT).show();
                Intent intentLogin = new Intent(LoginActivity.this,HOME_WORKOUT.class);
                startActivity(intentLogin);
            }
            else {
                Toast.makeText(LoginActivity.this,"Invalid Username or Password",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void SignUp(View view) {
        Intent intentSignup = new Intent(LoginActivity.this,Signup.class);
        startActivity(intentSignup);

    }

    public void Skip(View view) {
        Intent intentSkip = new Intent(LoginActivity.this,HOME_WORKOUT.class);
        startActivity(intentSkip);

    }
}
