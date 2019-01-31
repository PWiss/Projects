package com.hdm.spavetraveller.game.Object;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.hdm.spavetraveller.R;
import com.hdm.spavetraveller.game.Data;

/**
 * Player Class and Player Controlls
 */
public class Player implements SensorEventListener, GameObject   {


    //Sensor
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    //Bitmap to get character from image
    private Bitmap player;

    //coordinates
    private float x;
    private float mSensorX;
    private float y;
    private Paint paint;

    private Rect collision;


    /**
     * constructor
     */
    public Player(Context context) {
        //Getting bitmap from drawable resource
        player = BitmapFactory.decodeResource(context.getResources(), R.drawable.player);

        //getting sensor for Controlls
        mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_GAME);



        //player center
        float playerCenterX = x + player.getWidth()/2;
        float playerCenterY = y + player.getHeight()/2; //not in use for now

        //player Collision
        collision = new Rect((int)x, (int) y, player.getWidth(), player.getHeight());

        //starting position for the player
        x = getScreenWidth()/2 + (playerCenterX - player.getWidth());
        y = getScreenHeight()/4*3;


    }


    /**
     * Method to update coordinate of character
     */
    @Override
    public void update(){
        //stop player from leaving the screen
        if(x <= 0) {
            x=0;
        }

        if(x >= (Data.SCREEN_WIDTH- player.getWidth())) {
            x = Data.SCREEN_WIDTH- player.getWidth();



        } x = x - (mSensorX);

        //fill infos in collision Rect
        collision.left = (int)x + (player.getWidth()/4);;
        collision.top = (int)y+ (player.getHeight()/4);
        collision.right = (int)x + (player.getWidth()/4*3);
        collision.bottom = (int)y + (player.getHeight()/4*3);

        }

    /**
     * Draw Player
     * @param canvas
     */
    @Override
        public void draw(Canvas canvas){
            canvas.drawBitmap(
                    player,
                    x,
                    y,
                    paint);
        }





    /**
     * Controlls (change when device moves)
     * @param event
     */
    @Override
    public void onSensorChanged(SensorEvent event) {
        mSensorX = event.values[0]*3;


    }

    /**
     * Not in use
     * @param sensor
     * @param accuracy
     */
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //no need

    }
    //Getters
    public Rect getCollision(){
        return collision;
    }
    //getter for screen high and width
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }
}
