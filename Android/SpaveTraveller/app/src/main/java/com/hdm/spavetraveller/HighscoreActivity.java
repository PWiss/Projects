package com.hdm.spavetraveller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Highscore Activity
 */
public class HighscoreActivity extends AppCompatActivity {

    ListView lw_score;
    int lastScore;
    int best1, best2, best3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        lw_score = findViewById(R.id.lw_score);

        /**
         * load old High score
         */
        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        lastScore = preferences.getInt("lastScore", 0);
        best1 = preferences.getInt("best1", 0);
        best2 = preferences.getInt("best2", 0);
        best3 = preferences.getInt("best3", 0);


        /**
         * replaces High score
         */
        if (lastScore>best3){
            best3=lastScore;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best3", best3);
            editor.apply();
        }

        if (lastScore>best2){
            int temp=best2;
            best2=lastScore;
            best3=temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best3", best3);
            editor.putInt("best2", best2);
            editor.apply();
        }

        if (lastScore>best1){
            int temp=best1;
            best1=lastScore;
            best2=temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best2", best2);
            editor.putInt("best1", best1);
            editor.apply();
        }

        /**
         * displays High score in ArrayList
         */
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("Current: "+lastScore);
        arrayList.add("");
        arrayList.add("First place: "+best1);
        arrayList.add("Second place: "+best2);
        arrayList.add("Third place 3: "+best3);

        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        lw_score.setAdapter(arrayAdapter );

    }

    /**
     * back to MainActivity
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }

}
