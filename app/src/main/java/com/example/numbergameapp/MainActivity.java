package com.example.numbergameapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnNumber1, btnNumber2;
    private int num1, num2;
    private TextView tvScore;
    private int score = 0;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNumber1 = findViewById(R.id.btnNumber1);
        btnNumber2 = findViewById(R.id.btnNumber2);
        tvScore = findViewById(R.id.tvScore);

        random = new Random();

        // Start with random numbers
        setNewNumbers();

        // Handle button 1 click
        btnNumber1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkWinner(btnNumber1);
                setNewNumbers();
            }
        });

        // Handle button 2 click
        btnNumber2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkWinner(btnNumber2);
                setNewNumbers();
            }
        });
    }

    private void setNewNumbers(){
        num1 = random.nextInt(100) + 1;
        num2 = random.nextInt(100) + 1;
        btnNumber1.setText(String.valueOf(num1));
        btnNumber2.setText(String.valueOf(num2));
    }

    private void checkWinner(View v){
        if(v.getId() == R.id.btnNumber1){
         score += (num1 > num2) ? 5 : -5;
        }

        if(v.getId() == R.id.btnNumber2){
            score += (num2 > num1) ? 5 : -5;
        }
        tvScore.setText(String.valueOf(score));
    }

}