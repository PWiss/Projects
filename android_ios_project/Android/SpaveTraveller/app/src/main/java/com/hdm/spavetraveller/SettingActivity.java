package com.hdm.spavetraveller;


import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Class for Setting
 */
public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Load setting fragment
        getFragmentManager().beginTransaction().replace(android.R.id.content,
                new MainSettingsFragment()).commit();

    }

    /**
     * Get Resource from xml file
     */
    public  static class MainSettingsFragment extends PreferenceFragment {
        @Override
        public  void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }

}
