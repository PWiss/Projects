package com.hdm.spavetraveller.game.Object;


import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.hdm.spavetraveller.GameActivity;
import com.hdm.spavetraveller.R;
import com.hdm.spavetraveller.game.Data;

import java.util.ArrayList;

/**
 * Class that oversees the GameObjects
 */
public class ObjectManager {
    private GameActivity gA = new GameActivity();

    //initial objects
    private Background background;
    private ArrayList<Asteroid> asteroids;
    private ArrayList<Enemy> enemies;
    private Player player;

    private int asteroidCount = 3;
    private int enemyCount = 1;
    private int maxEnemy = 50;
    private int newEnemy;

    //score and live
    public int score = 0;
    public int life = 3;


    /**
     * constructor
     * @param context
     */
    public ObjectManager(Context context) {

        gA = (GameActivity) context;
        background = new Background(context);
        changeBackground(context);
        player = new Player(context);


        asteroids = new ArrayList<>();
        for (int i = 0; i < asteroidCount; i++) {
            asteroids.add(new Asteroid(context));
            asteroids.get(i).respawn();

        }
        enemies = new ArrayList<>();
        for (int i = 0; i < maxEnemy; i++) {
            enemies.add(new Enemy(context));
            enemies.get(i).respawn();

        }

    }

    /**
     * Method to play sound and reducing life
     */
    private void hit(){
        gA.createExploSound();
        life -=1;
    }

    /**
     * Method for checking which background is chosen and than draw it
     * @param context
     */
    private void changeBackground(Context context){
        String bg = gA.getBackground();
        if(bg.equalsIgnoreCase("1")){
            background.setBackground(BitmapFactory.decodeResource(context.getResources(), R.drawable.background_game1 ));
        }else if (bg.equalsIgnoreCase("2")){
            background.setBackground(BitmapFactory.decodeResource(context.getResources(), R.drawable.background_game2 ));
        }else {
            background.setBackground(BitmapFactory.decodeResource(context.getResources(), R.drawable.background_game3 ));
        }

    }


    /**
     * get all Game objects update and control live, score, respawn
     */
    public void update() {

        background.update();
        player.update();

        for (int i = 0; i < asteroidCount; i++) {
            asteroids.get(i).update();



            //if collision occurs with player
            if (Rect.intersects(player.getCollision(), asteroids.get(i).getCollision())) {
                //moving asteroid to the Top
                asteroids.get(i).respawn();
                hit();

                if (life <= 0){
                    gA.onGameOver(score);
                }

            }
            if(asteroids.get(i).getY() >= (Data.SCREEN_HEIGHT + 40) ){
                asteroids.get(i).respawn();
                score +=1;
            }
        }


        for (int i = 0; i < enemyCount; i++) {
            enemies.get(i).update();


            //if collision occurs with player
            if (Rect.intersects(player.getCollision(), enemies.get(i).getCollision())) {
                //moving enemy outside the Top
                enemies.get(i).respawn();
                hit();
                if (life <= 0){
                    gA.onGameOver(score);
                }

            }
            if(enemies.get(i).getY() >= (Data.SCREEN_HEIGHT + 40) ){
                enemies.get(i).respawn();
                score +=3;
                newEnemy++;

                if (newEnemy >=5){
                    enemyCount++;
                    newEnemy=0;
                }
            }
        }

    }


    /**
     * get alle GameObject draw methods
     * @param canvas
     */
    public void draw(Canvas canvas){


        background.draw(canvas);
        player.draw(canvas);
        for (int i = 0; i < asteroidCount; i++) {
            asteroids.get(i).draw(canvas);
        }
        for (int i = 0; i < enemyCount; i++) {
            enemies.get(i).draw(canvas);
        }
    }

}
