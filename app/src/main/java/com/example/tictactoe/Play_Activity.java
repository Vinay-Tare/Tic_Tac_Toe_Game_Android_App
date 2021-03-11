package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Play_Activity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9, bPauseOrReplay,bMainMenu;
    TextView tv_turnOf;
    int turn;
    boolean gameOver;
    String turnOf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_);

         b1 = (Button) findViewById(R.id.button1);
         b2 = (Button) findViewById(R.id.button2);
         b4 = (Button) findViewById(R.id.button4);
         b3 = (Button) findViewById(R.id.button3);
         b5 = (Button) findViewById(R.id.button5);
         b6 = (Button) findViewById(R.id.button6);
         b7 = (Button) findViewById(R.id.button7);
         b8 = (Button) findViewById(R.id.button8);
         b9 = (Button) findViewById(R.id.button9);
         bPauseOrReplay = (Button) findViewById(R.id.button_PauseOrReplay);
         bMainMenu = (Button) findViewById(R.id.button_MainMenu);
         tv_turnOf = (TextView) findViewById(R.id.textView_turnOf);
         turnOf = "X";
         turn = 1;
         gameOver = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        MainActivity.game_bacground_music.start();
        MainActivity.game_bacground_music.setLooping(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.game_bacground_music.pause();
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case (R.id.button1): {
                b1.setText(turnOf);
                b1.setEnabled(false);
                b1.setTextColor(Color.parseColor("#E65100"));
                break;
            }
            case (R.id.button2): {
                b2.setText(turnOf);
                b2.setEnabled(false);
                b2.setTextColor(Color.parseColor("#E65100"));
                break;
            }
            case (R.id.button3): {
                b3.setText(turnOf);
                b3.setEnabled(false);
                b3.setTextColor(Color.parseColor("#E65100"));
                break;
            }
            case (R.id.button4): {
                b4.setText(turnOf);
                b4.setEnabled(false);
                b4.setTextColor(Color.parseColor("#E65100"));
                break;
            }
            case (R.id.button5): {
                b5.setText(turnOf);
                b5.setEnabled(false);
                b5.setTextColor(Color.parseColor("#E65100"));
                break;
            }
            case (R.id.button6): {
                b6.setText(turnOf);
                b6.setEnabled(false);
                b6.setTextColor(Color.parseColor("#E65100"));
                break;
            }
            case (R.id.button7): {
                b7.setText(turnOf);
                b7.setEnabled(false);
                b7.setTextColor(Color.parseColor("#E65100"));
                break;
            }
            case (R.id.button8): {
                b8.setText(turnOf);
                b8.setEnabled(false);
                b8.setTextColor(Color.parseColor("#E65100"));
                break;
            }
            case (R.id.button9): {
                b9.setText(turnOf);
                b9.setEnabled(false);
                b9.setTextColor(Color.parseColor("#E65100"));
                break;
            }
        }
        
        if ((b1.getText() == b2.getText() && b1.getText() == b3.getText())
                || (b4.getText() == b5.getText() && b4.getText() == b6.getText())
                || (b7.getText() == b8.getText() && b7.getText() == b9.getText())
                || (b1.getText() == b4.getText() && b1.getText() == b7.getText())
                || (b2.getText() == b5.getText() && b2.getText() == b8.getText())
                || (b3.getText() == b6.getText() && b3.getText() == b9.getText())
                || (b1.getText() == b5.getText() && b1.getText() == b9.getText())
                || (b3.getText() == b5.getText() && b3.getText() == b7.getText())) {
            tv_turnOf.setTextColor(Color.parseColor("#ED4242"));
            tv_turnOf.setText(turnOf + " Won The Game !!");
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
            gameOver = true;
            bPauseOrReplay.setText("Replay");
            bPauseOrReplay.setBackgroundColor(Color.parseColor("#FF4040"));
            bMainMenu.setBackgroundColor(Color.parseColor("#FF4040"));

            if(b1.getText() == b2.getText() && b1.getText() == b3.getText()){
                b1.setBackgroundColor(Color.parseColor("#FFD600"));
                b2.setBackgroundColor(Color.parseColor("#FFD600"));
                b3.setBackgroundColor(Color.parseColor("#FFD600"));
            }
            else if(b4.getText() == b5.getText() && b4.getText() == b6.getText()){
                b4.setBackgroundColor(Color.parseColor("#FFD600"));
                b5.setBackgroundColor(Color.parseColor("#FFD600"));
                b6.setBackgroundColor(Color.parseColor("#FFD600"));
            }
            else if(b7.getText() == b8.getText() && b7.getText() == b9.getText()){
                b7.setBackgroundColor(Color.parseColor("#FFD600"));
                b8.setBackgroundColor(Color.parseColor("#FFD600"));
                b9.setBackgroundColor(Color.parseColor("#FFD600"));
            }
            else if(b1.getText() == b4.getText() && b1.getText() == b7.getText()){
                b1.setBackgroundColor(Color.parseColor("#FFD600"));
                b4.setBackgroundColor(Color.parseColor("#FFD600"));
                b7.setBackgroundColor(Color.parseColor("#FFD600"));
            }
            else if(b2.getText() == b5.getText() && b2.getText() == b8.getText()){
                b2.setBackgroundColor(Color.parseColor("#FFD600"));
                b5.setBackgroundColor(Color.parseColor("#FFD600"));
                b8.setBackgroundColor(Color.parseColor("#FFD600"));
            }
            else if(b3.getText() == b6.getText() && b3.getText() == b9.getText()){
                b3.setBackgroundColor(Color.parseColor("#FFD600"));
                b6.setBackgroundColor(Color.parseColor("#FFD600"));
                b9.setBackgroundColor(Color.parseColor("#FFD600"));
            }
            else if(b1.getText() == b5.getText() && b1.getText() == b9.getText()){
                b1.setBackgroundColor(Color.parseColor("#FFD600"));
                b5.setBackgroundColor(Color.parseColor("#FFD600"));
                b9.setBackgroundColor(Color.parseColor("#FFD600"));
            }
            else if(b3.getText() == b5.getText() && b3.getText() == b7.getText()){
                b3.setBackgroundColor(Color.parseColor("#FFD600"));
                b5.setBackgroundColor(Color.parseColor("#FFD600"));
                b7.setBackgroundColor(Color.parseColor("#FFD600"));
            }

        }

        else if(turn==9){
            tv_turnOf.setTextColor(Color.parseColor("#ED4242"));
            tv_turnOf.setText("It's A Tie");
            bPauseOrReplay.setText("Replay");
            bPauseOrReplay.setBackgroundColor(Color.parseColor("#FF4040"));
            bMainMenu.setBackgroundColor(Color.parseColor("#FF4040"));
            gameOver = true;
        }

        else {
            turn++;
            if (turn % 2 == 0) turnOf = "O";
            else turnOf = "X";
            tv_turnOf.setText(turnOf + "'s Turn :");
        }
    }

    public void onMainMenu(View v){
        finish();
    }
    public void onPauseOrReplay(View v){
        if(gameOver) {
            Intent replay = new Intent(this, Play_Activity.class);
            startActivity(replay);
            finish();
        }
        else {
            Intent pause =new Intent(this,Settings_Activity.class);
            pause.putExtra("navigatedBy","gamePaused");
            startActivity(pause);
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),"To Go Back Use The Main Menu Button",Toast.LENGTH_SHORT).show();
    }
}