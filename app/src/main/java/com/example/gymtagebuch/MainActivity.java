package com.example.gymtagebuch;

import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    private TextView timerText;
    private Button buttonStart;
    private boolean timerRunning;
    private CountDownTimer countDownTimer;
    private long timeLeft = 600000; //10 mins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerText = findViewById(R.id.timer_text);
        buttonStart = findViewById(R.id.button_start);
        buttonStart.setText("START");

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStop();
            }
        });
        updateTimer();
    }

    public void startStop(){
        if (timerRunning = true) {
            startTimer();
        } else{
            stopTimer();
        }
    }

    public void startTimer() {
        timerRunning = true;
       countDownTimer = new CountDownTimer(timeLeft, 1000) {
           @Override
           public void onTick(long l) {
               timeLeft = l;
               updateTimer();
           }

           @Override
           public void onFinish() {

           }
       }.start();
       buttonStart.setText("PAUSE");

    }

    public void stopTimer() {
        timerRunning = false;
        countDownTimer.cancel();
        buttonStart.setText("START");
    }
    public void updateTimer(){
        int minutes = (int)timeLeft / 60000;
        int seconds = (int)timeLeft % 60000 / 1000;

        String timeLefttext;

        timeLefttext = "" + minutes;
        timeLefttext += ":";
        if (seconds <10) timeLefttext += "0";
        timeLefttext += seconds;

        timerText.setText(timeLefttext);
    }

}
