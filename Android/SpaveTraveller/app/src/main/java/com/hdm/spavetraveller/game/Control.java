package com.hdm.spavetraveller.game;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.hdm.spavetraveller.game.Object.Player;

/**
 * not in use for now :(
 */
//public class Control extends Activity implements SensorEventListener {
//    //Sensor
//    private Sensor mySensor;
//    private SensorManager SM;
//    private float moveX;
//
//    public Control() {
//        SM = (SensorManager) getSystemService(SENSOR_SERVICE);
//        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_GAME);
//    }
//
//    @Override
//    public void onSensorChanged(SensorEvent sensorEvent) {
//        Intent intent = new Intent(this, Player.class);
//
//        moveX = sensorEvent.values[0]*3;
//
//
//
//    }
//
//    @Override
//    public void onAccuracyChanged(Sensor sensor, int i) {
//        //Not used
//    }
//
//    public float getMove() {
//        return moveX;
//    }
//}
