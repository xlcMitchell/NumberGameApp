package com.example.numbergameapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UserInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_input);

        EditText userName = findViewById(R.id.userNameInputET);
        Button playBtn = findViewById(R.id.playNumberGameButton);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame(userName);
            }
        });

    }

    private void startGame(EditText text){
        String userName = text.getText().toString();
        if(userName.isEmpty()){
            // user has not entered the name
            Toast.makeText(getApplicationContext(),
                    "Enter you name to start the Game!", Toast.LENGTH_LONG).show();
        } else {
            // Start the MainActivity to play game

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            //value is transferred to the main activity via the key we made in the string files..
            intent.putExtra(getResources().getString(R.string.user_name_key), userName);
            startActivity(intent);
        }
    }
}