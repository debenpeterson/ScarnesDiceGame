package com.example.scarnesdice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int overall = 0;
    int turnScore = 0;
    int cpuOverall = 0;
    int cpuTurnscore = 0;

    Random ran = new Random();

    public void reset(){ //will reset game
        final TextView text = findViewById(R.id.textScore);
        final TextView text2 = findViewById(R.id.cpuScore);
        final TextView text3 = findViewById(R.id.winText);

        overall = 0;
        turnScore = 0;
        cpuOverall = 0;
        cpuTurnscore = 0;


        text.setText("Your Score: " + overall);
        text2.setText("CPU Score: " + cpuOverall);
        text3.setText("");

    }
    public void checkWin(){
        final TextView text = findViewById(R.id.winText);
        if(overall >= 100){
            text.setText("YOU WON");
        }
        if(cpuOverall >= 100){
            text.setText("YOU LOSE");
        }

    }
    public void cpuTurn(){
        final Button button = findViewById(R.id.button_roll);
        final Button button2 = findViewById(R.id.button_roll);
        final Button button3 = findViewById(R.id.button_roll);
        final TextView text = findViewById(R.id.cpuScore);

        button.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);

        int rollTimes = ran.nextInt(6) + 1;


        for(int i=0; i <= rollTimes; i++) {
            int diceValue = ran.nextInt(6);
            diceValue++;
            Log.i("cpurandom", diceValue + "");

            ImageView diceNumber = (ImageView) findViewById(R.id.imageView);

            if (diceValue == 1) {
                diceNumber.setImageResource(R.drawable.dice1);
                cpuTurnscore = 0;
                break;
            } else if (diceValue == 2) {
                diceNumber.setImageResource(R.drawable.dice2);
                cpuTurnscore +=diceValue;
            } else if (diceValue == 3) {
                diceNumber.setImageResource(R.drawable.dice3);
                cpuTurnscore +=diceValue;
            } else if (diceValue == 4) {
                diceNumber.setImageResource(R.drawable.dice4);
                cpuTurnscore +=diceValue;
            } else if (diceValue == 5) {
                diceNumber.setImageResource(R.drawable.dice5);
                cpuTurnscore +=diceValue;
            } else {
                diceNumber.setImageResource(R.drawable.dice6);
                cpuTurnscore +=diceValue;
            }

        }

        cpuOverall += cpuTurnscore;
        Log.i("cpuscore", cpuOverall + "");

        text.setText("CPU Score: " + cpuOverall);

        checkWin();

        button.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView text = findViewById(R.id.textScore);
        final Button button = findViewById(R.id.button_roll);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                int diceValue = ran.nextInt(6);
                diceValue++;
                Log.i("random", diceValue + "");

                ImageView diceNumber = (ImageView) findViewById(R.id.imageView);

                if (diceValue == 1) {
                    diceNumber.setImageResource(R.drawable.dice1);
                    turnScore = 0;
                    cpuTurn();
                } else if (diceValue == 2) {
                    diceNumber.setImageResource(R.drawable.dice2);
                    turnScore = turnScore + diceValue;
                } else if (diceValue == 3) {
                    diceNumber.setImageResource(R.drawable.dice3);
                    turnScore = turnScore + diceValue;
                } else if (diceValue == 4) {
                    diceNumber.setImageResource(R.drawable.dice4);
                    turnScore = turnScore + diceValue;
                } else if (diceValue == 5) {
                    diceNumber.setImageResource(R.drawable.dice5);
                    turnScore = turnScore + diceValue;
                } else {
                    diceNumber.setImageResource(R.drawable.dice6);
                    turnScore = turnScore + diceValue;
                }
            }
        });
        final Button button2 = findViewById(R.id.button_pass);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                overall += turnScore;
                turnScore = 0;
                text.setText("Your Score: " + overall);
                checkWin();
                cpuTurn();


            }
        });
        final Button button3 = findViewById(R.id.button_reset);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
               reset();

            }
        });
    }
}
