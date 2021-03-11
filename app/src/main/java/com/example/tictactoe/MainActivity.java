package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
public static MediaPlayer game_bacground_music;
float previous_media_volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game_bacground_music = MediaPlayer.create(this,R.raw.game_background_music);
    }

    @Override
    protected void onResume() {
        super.onResume();
        final SharedPreferences preferences = getSharedPreferences("SETTINGS", Context.MODE_PRIVATE);
        game_bacground_music.start();

        // Setting Previous Preferences
        if(preferences.getBoolean("isChecked",true)){
            previous_media_volume = (float) preferences.getInt("mediaVolume",100)/100;
            game_bacground_music.setVolume(previous_media_volume, previous_media_volume);
        }
        else{
            game_bacground_music.setVolume(0.0f,0.0f);
        }

        game_bacground_music.setLooping(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        game_bacground_music.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        game_bacground_music.stop();
        game_bacground_music.release();
    }

    public void onGamePlay(View v) {
    Intent play = new Intent(MainActivity.this,Play_Activity.class);
    startActivity(play);
    }

    public void onGameSettings(View v) {
        Intent settings = new Intent( MainActivity.this,Settings_Activity.class);
        settings.putExtra("navigatedBy","gameSettings");
        startActivity(settings);
    }
}