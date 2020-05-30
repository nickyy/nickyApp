package com.example.android.nickyapp;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    Button button;
    private static final String TAG = "Main2Activity";
    private Tracker tracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        /* Analytics */
        AnalyticsApp application = (AnalyticsApp) getApplication();
        tracker = application.getDefaultTracker();

        tracker.setScreenName("screen - page 2");
        tracker.send(new HitBuilders.ScreenViewBuilder()
                .setCustomDimension(1, getString(R.string.app_name))
                .build());
        Log.d(TAG, "*** Setting CD1 value to: " + getString(R.string.app_name));
        /* END Analytics */

        onButtonClick();
    }

    public void onButtonClick(){
        button = findViewById(R.id.button_page1);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent myIntent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(myIntent);
            }
        });
    }

}
