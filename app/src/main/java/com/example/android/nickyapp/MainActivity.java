package com.example.android.nickyapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class MainActivity extends AppCompatActivity {

    Button button;
    private static final String TAG = "MainActivity";
    private Tracker tracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Analytics */
        AnalyticsApp application = (AnalyticsApp) getApplication();
        tracker = application.getDefaultTracker();

        tracker.setScreenName("screen - page 1");
        tracker.send(new HitBuilders.ScreenViewBuilder()
                .setCustomDimension(1, getString(R.string.app_name))
                .build());
        Log.d(TAG, "*** Setting CD1 value to: " + getString(R.string.app_name));
        /* END Analytics */

        onButtonClick();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            /* Analytics */
            tracker.send(new HitBuilders.EventBuilder()
                    .setCustomMetric(1,1)
                    .setCategory("menu")
                    .setAction("click")
                    .setLabel(getString(R.string.action_settings))
                    .build());
            Log.d(TAG, "*** Event");
            /* END Analytics */

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onButtonClick(){
        button = findViewById(R.id.button_page2);
        button.setOnClickListener(new View.OnClickListener(){
        @Override
            public void onClick(View arg0){
                Intent myIntent = new Intent(getBaseContext(), Main2Activity.class);
                startActivity(myIntent);
            }
        });
    }
}
