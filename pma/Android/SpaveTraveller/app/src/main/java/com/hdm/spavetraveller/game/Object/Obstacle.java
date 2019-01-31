package com.hdm.spavetraveller.game.Object;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.hdm.spavetraveller.R;
import com.hdm.spavetraveller.game.Data;


/**
 * Class Obstacle to create enemies
 */
public class Obstacle implements GameObject {

    private Bitmap obstacle;
    private int speed;
    private int startY = -40 - (int) (Math.random()*1000);
    private int x;
    private int y = startY;

    private Paint paint;


    private Rect collision;

    //Class constructor
    public Obstacle (Context context){
        obstacle = BitmapFactory.decodeResource(context.getResources(), R.drawable.asteroid);
        collision = new Rect(x, y, obstacle.getWidth(), obstacle.getHeight());
        x = (int) (Math.random()* (Data.SCREEN_WIDTH  - obstacle.getWidth()));

    }

    @Override
    public void update() {
        y = y + speed;

        collision.left = x;
        collision.top = y;
        collision.right = x + obstacle.getWidth();
        collision.bottom = y + obstacle.getHeight();

    }


    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(
                obstacle,
                x,
                y,
                paint);

    }

    /**
     * Method for respawning
     */
    public void respawn() {
        x = 1+(int)(Math.random()*(Data.SCREEN_WIDTH ));
        if(x>(obstacle.getWidth()*3)){
            x = x - obstacle.getWidth();
        }
        y = -40-(int)(Math.random()*1000);
    }

    //setter and getter
    public void setObstacle(Bitmap obstacle) {
        this.obstacle = obstacle;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getY() {
        return y;
    }
    public Rect getCollision() {
        return collision;
    }

}
