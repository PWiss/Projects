package com.hdm.spavetraveller.game.Object;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.hdm.spavetraveller.R;

/*
Class for the enemy Object
 */
public class Enemy extends Obstacle {

    //Class constructor
    public Enemy(Context context){
        super(context);

        setObstacle(BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy));
        setSpeed(10);
    }



}
