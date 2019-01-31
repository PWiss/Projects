package com.hdm.spavetraveller.game.Object;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import com.hdm.spavetraveller.R;


/**
 * Class for the Asteroid Object
 */
public class Asteroid extends Obstacle {

    //Class constructor
    public Asteroid(Context context){
        super(context);
        setObstacle(BitmapFactory.decodeResource(context.getResources(), R.drawable.asteroid));
        setSpeed(5);


    }


}
