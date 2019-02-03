package com.hdm.spavetraveller.game.Object;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.hdm.spavetraveller.R;

/**
 * Class for the background
 */
public class Background implements GameObject {

    private Bitmap background;
    private int backgroundY1;
    private int backgroundY2;
    private int x = 0;

    private Paint paint;

    //Class constructor
    public Background(Context context){
        background = BitmapFactory.decodeResource(context.getResources(), R.drawable.background_game1);
        backgroundY1 = 0;
        backgroundY2 = 0-background.getHeight();

    }
    //setter
    public void setBackground(Bitmap background) {
        this.background = background;
    }

    @Override
    public void update() {
        backgroundY1+=1;
        backgroundY2+=1;
        if(backgroundY1 > background.getHeight()){
            backgroundY1 = -background.getHeight()+40;
        }
        if(backgroundY2 > background.getHeight()){
            backgroundY2 = -background.getHeight()+40;
        }

    }

    @Override
    public void draw(Canvas canvas) {

        canvas.drawBitmap(
                background,
                x,
                backgroundY1,
                paint);
        canvas.drawBitmap(
                background,
                x,
                backgroundY2,
                paint);


    }
}
