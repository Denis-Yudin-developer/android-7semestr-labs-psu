package com.example.android_lab_1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText username;
    private EditText password;
    private TextView attempts;
    private TextView numberOfAttempts;

    int numberOfRemainingLoginAttempts = 5;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.edit_user);
        password = (EditText) findViewById(R.id.edit_password);
        attempts = (TextView) findViewById(R.id.attempts);
        numberOfAttempts = (TextView) findViewById(R.id.number_of_attempts);
        numberOfAttempts.setText(Integer.toString(numberOfRemainingLoginAttempts));

        Toast.makeText(MainActivity.this,
                "Переопределение onCreate у MainActivity", Toast.LENGTH_SHORT).show();
        Log.i("AppLogger", "Переопределение onCreate у MainActivity");


    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("AppLogger", "Переопределение onStop у MainActivity");
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i("AppLogger", "Переопределение onStart у MainActivity");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i("AppLogger", "Переопределение onPause у MainActivity");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i("AppLogger", "Переопределение onResume у MainActivity");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("AppLogger", "Переопределение onRestart у MainActivity");
    }

    @SuppressLint("SetTextI18n")
    public void Login(View view) {

        if (username.getText().toString().equals("anton") &&
                password.getText().toString().equals("anahin")) {
            Toast.makeText(getApplicationContext(), "Вход выполнен!",Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this,TableActivity.class);
            String intentMessage = username.getText().toString();
            intent.putExtra("Lab3", intentMessage);
            startActivity(intent);
        }

        else {
            Toast.makeText(getApplicationContext(), "Неправильные данные!",Toast.LENGTH_SHORT).show();
            numberOfRemainingLoginAttempts--;
            if(numberOfRemainingLoginAttempts == 0)
                finish();

            attempts.setVisibility(View.VISIBLE);
            numberOfAttempts.setVisibility(View.VISIBLE);
            numberOfAttempts.setText(Integer.toString(numberOfRemainingLoginAttempts));

        }
    }
}