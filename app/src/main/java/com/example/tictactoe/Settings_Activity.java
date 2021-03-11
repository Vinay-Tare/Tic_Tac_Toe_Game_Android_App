 package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

 public class Settings_Activity extends AppCompatActivity {
     SeekBar seekBar_Volume;
     Button resumeButtom,showCredits;
     TextView titleBar,tvCredits;
     ToggleButton toggleButton_Sound;
     LinearLayout layout;
     int picked_volume,previous_volume;
     float media_volume;
     boolean previousState;
     String navigatedBy;
     boolean buttonShowOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_);
        Intent previousActivity = getIntent();

        buttonShowOn =false;
        seekBar_Volume = (SeekBar) findViewById(R.id.seekBar_Volume);
        toggleButton_Sound = (ToggleButton) findViewById(R.id.toggleButton_Sound);
        resumeButtom =(Button) findViewById(R.id.button_Resume);
        showCredits = (Button) findViewById(R.id.button_showCredits);
        titleBar = (TextView) findViewById(R.id.textView_titleBar);
        tvCredits = (TextView) findViewById(R.id.textView_credits);
        layout = (LinearLayout) findViewById(R.id.layout);

        navigatedBy = previousActivity.getStringExtra("navigatedBy");
        if(navigatedBy.equals("gamePaused")) {
            titleBar.setText("Game Paused");
            resumeButtom.setText("Resume Game");
            showCredits.setVisibility(View.GONE);
            tvCredits.setVisibility(View.GONE);
            layout.setBackgroundColor(Color.parseColor("#1976D2"));
        }
        else if (navigatedBy.equals("gameSettings")){
            titleBar.setText("Settings");
            resumeButtom.setText("Go Back To  Main Menu");
            showCredits.setVisibility(View.VISIBLE);
            tvCredits.setVisibility(View.GONE);
        }

        final SharedPreferences preferences = getSharedPreferences("SETTINGS", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();
        previous_volume = preferences.getInt("mediaVolume",100);
        previousState =preferences.getBoolean("isChecked",true);

        // Setting Previous Preferences
        if(previousState) {
            media_volume = (float) previous_volume/100;
            seekBar_Volume.setProgress(previous_volume);
            MainActivity.game_bacground_music.setVolume(media_volume,media_volume);
            toggleButton_Sound.setChecked(previousState);
            toggleButton_Sound.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_volume_up_24,0,0,0);
        }
        else {
            seekBar_Volume.setProgress(0);
            MainActivity.game_bacground_music.setVolume(0.0f,0.0f);
            seekBar_Volume.setEnabled(false);
            toggleButton_Sound.setChecked(previousState);
            toggleButton_Sound.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_volume_off_24,0,0,0);
        }

        seekBar_Volume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                picked_volume = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                media_volume = (float)picked_volume/100;
                MainActivity.game_bacground_music.setVolume(media_volume,media_volume);
                editor.putInt("mediaVolume",picked_volume);
                editor.commit();
            }
        });

        toggleButton_Sound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                media_volume = (float) preferences.getInt("mediaVolume",100)/100;
                if(b){
                    MainActivity.game_bacground_music.setVolume(media_volume,media_volume);
                    seekBar_Volume.setProgress(preferences.getInt("mediaVolume",100));
                    seekBar_Volume.setEnabled(true);
                    toggleButton_Sound.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_volume_up_24,0,0,0);
                }
                else {
                    MainActivity.game_bacground_music.setVolume(0.0f,0.0f);
                    seekBar_Volume.setProgress(0);
                    seekBar_Volume.setEnabled(false);
                    toggleButton_Sound.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_baseline_volume_off_24,0,0,0);
                }
                editor.putBoolean("isChecked",b);
                editor.commit();
            }
        });
    }

    public void onGameResume (View v){
        finish();
    }

    public void onShowCredits(View v){
        if(!buttonShowOn) {
            buttonShowOn = true;
            tvCredits.setVisibility(View.VISIBLE);
        }
        else{
            buttonShowOn = false;
            tvCredits.setVisibility(View.GONE);
        }
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
}