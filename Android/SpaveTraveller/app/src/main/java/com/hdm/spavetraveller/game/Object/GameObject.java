package com.hdm.spavetraveller.game.Object;

import android.graphics.Canvas;

/**
 * Interface for all no background Game Objects
 */
public interface GameObject {
    public void update();
    public void draw(Canvas canvas);

}
