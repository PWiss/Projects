package com.hdm.spavetraveller;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.hdm.spavetraveller.game.Data;
import com.hdm.spavetraveller.game.GameView;

/**
 * Game Activity
 */
public class GameActivity extends Activity {
    private MediaPlayer crashS, backgroundS;
    private GameView gameView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initializing Sound
        crashS = MediaPlayer.create(this, R.raw.explo);
        backgroundS = MediaPlayer.create(this, R.raw.song);
        backgroundS.setLooping(true);

        //Initializing game view object
        gameView = new GameView(this);

        //Transfer width and height from display to the Data Class
        Data.SCREEN_WIDTH = Resources.getSystem().getDisplayMetrics().widthPixels;
        Data.SCREEN_HEIGHT = Resources.getSystem().getDisplayMetrics().heightPixels;

        //adding it to contentview
        setContentView(gameView);

        if (checkSong()==true) {
            playBackgroundSound();
        }

    }

    /**
     * Method for creating background music
     */
    public void playBackgroundSound() {
        if (backgroundS != null && !backgroundS.isPlaying()) {
            try {
                backgroundS.start();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method for creating explosion sound
     */
    public void createExploSound() {
        if(checkSound()==true) {
            crashS = MediaPlayer.create(this, R.raw.explo);
            crashS.start();
        }
    }


    //pausing the game when activity is paused
    @Override
    protected void onPause() {
        super.onPause();
        gameView.pauseThread();
        backgroundS.pause();

    }

    //running the game when activity is resumed
    @Override
    protected void onResume() {
        super.onResume();
        gameView.resumeThread();

        if (checkSong()==true) {
            backgroundS.start();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        gameView.pauseThread();
        backgroundS.release();
    }

    /**
     * Method to get the points at the end of the game to the highscore
     * @param score
     */
    public void onGameOver(int score) {
        SharedPreferences preferences = getSharedPreferences("PREFS" , 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("lastScore", score);
        editor.apply();

        Intent theNextIntent = new Intent(getApplicationContext(), HighscoreActivity.class);
        startActivity(theNextIntent);
        this.finish();
    }

    /**
     * Methode to check what background is chosen
     * @return
     */
    public String getBackground(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        return (sharedPreferences.getString("key_background","1"));
    }

    /**
     * Methode to check if music is enabled
     * @return
     */
    public boolean checkSong(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        return (sharedPreferences.getBoolean("enable_music",false));
    }

    /**
     * Methode to check if sound is enebled
     * @return
     */
    public boolean checkSound(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        return (sharedPreferences.getBoolean("enable_sound",false));
    }



}
