package com.example.homegym;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class HOME_WORKOUT extends AppCompatActivity {
    ImageButton JJ;
    ImageButton AC;
    ImageButton CS;
    ImageButton P;
    ImageButton PU;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_workout);
        JJ = findViewById(R.id.imgBtnJJ);
        AC = findViewById(R.id.imgBtnAC);
        CS = findViewById(R.id.imgBtnCS);
        P = findViewById(R.id.imgBtnP);
        PU = findViewById(R.id.imgBtnPU);
/*
        jumpingJack();
        abdonimalCrunches();
        cobraStrech();
        plank();
        pushUps();
        */
    }

    public void jumpingJack(View view) {
        JJ.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentJJ = new Intent(HOME_WORKOUT.this, JumpingJack.class);
                        startActivity(intentJJ);
                    }
                }
        );
    }

    public void abdominalCrunches(View view) {
        AC.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentAC = new Intent(HOME_WORKOUT.this, AbdominalCrunches.class);
                        startActivity(intentAC);
                    }
                }
        );
    }

    public void cobraStrech(View view) {
        CS.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentCS = new Intent(HOME_WORKOUT.this, CobraStrech.class);
                        startActivity(intentCS);
                    }
                }
        );
    }

    public void plank(View view) {
        P.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentP = new Intent(HOME_WORKOUT.this, Plank.class);
                        startActivity(intentP);
                    }
                }
        );
    }

    public void pushUps(View view) {
        PU.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentPU = new Intent(HOME_WORKOUT.this, PushUps.class);
                        startActivity(intentPU);
                    }
                }
        );
    }
}
