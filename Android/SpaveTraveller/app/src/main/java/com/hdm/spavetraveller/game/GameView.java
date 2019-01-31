package com.hdm.spavetraveller.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.hdm.spavetraveller.game.Object.ObjectManager;

/**
 * Game View Class
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private  MainThread thread;
    private long initTime;


    //the game thread
    private Thread gameThread = null;

    //adding the player and Objects to this class
    private ObjectManager oManager;


    //drawing
    private Paint paint;
    private SurfaceHolder surfaceHolder;


    //Class constructor
    public GameView(Context context) {
        super(context);

        getHolder().addCallback(this);
        thread = new MainThread(getHolder(), this);
        setFocusable(true);



        //initializing ObjectManager
        oManager = new ObjectManager(context);



        //initializing drawing objects
        surfaceHolder = getHolder();
        paint = new Paint();

    }




    /**
     * Method for updating position
     */
    public void update() {
        //all Gameobjects
        oManager.update();

    }
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
            //Drawing objects(player and enemy)
            oManager.draw(canvas);

            //drawing score and life
            paint.setColor(Color.WHITE);
            paint.setTextSize(50);
            canvas.drawText("Score " +Integer.toString(oManager.score),50,80,paint);
            canvas.drawText("Life " +Integer.toString(oManager.life),Data.SCREEN_WIDTH-200,80,paint);





    }
    /**
     * Methods for pausing and starting the Mainthread
      */
    public void pauseThread(){
        thread.setRunning(false);
    }
    public void resumeThread(){
        thread.setRunning(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        thread = new MainThread(getHolder(), this);
        initTime = System.currentTimeMillis();
        thread.setRunning(true);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        thread.setRunning(false);
        while(retry) {
            try {
                thread.join();

            } catch(Exception e) {e.printStackTrace();}
            retry = false;
        }

    }


}
