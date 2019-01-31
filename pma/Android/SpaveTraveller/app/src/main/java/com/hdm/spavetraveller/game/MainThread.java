package com.hdm.spavetraveller.game;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Main Thread Class
 */
public class MainThread extends Thread {
    public  static final int MAX_FPS = 60;
    private  double averageFPS;
    private SurfaceHolder surfaceHolder;
    private GameView gameView;
    private boolean running;
    public static Canvas canvas;

    public  void setRunning(boolean running) {
        this.running = running;
    }
    //Class constructor
    public MainThread(SurfaceHolder surfaceHolder, GameView gameView) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gameView = gameView;
    }

    @Override
    public void run(){
        long startTime;
        long timeMillis;
        long waitTime;
        int frameCount = 0;
        long totalTime = 0;
        long targetTime = 1000/MAX_FPS;

        while (running) {
            startTime = System.currentTimeMillis();
            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.gameView.update();
                    this.gameView.draw(canvas);
                }
            }catch(Exception e) {
                e.printStackTrace();
            }finally {
                if(canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {e.printStackTrace();}
                }
            }
            timeMillis = (System.currentTimeMillis() - startTime);
            waitTime = targetTime - timeMillis;
            try {
                if(waitTime > 0){
                    sleep(waitTime);
                }else {
                    sleep(5);
                }

            }catch (Exception e) {e.printStackTrace();}

//            totalTime += System.nanoTime() - startTime;
//            frameCount++;
//            if(frameCount == MAX_FPS) {
//                averageFPS =1000/((totalTime/frameCount)/1000000);
//                frameCount = 0;
//                totalTime = 0;
//                System.out.println(averageFPS);
//            }
        }
    }
}
