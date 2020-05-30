package com.example.android.nickyapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class FirstFragment extends Fragment {

    private static final String TAG = "FirstFragment";
    private Tracker tracker;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        /* Analytics */
        AnalyticsApp application = (AnalyticsApp) getActivity().getApplication();
        tracker = application.getDefaultTracker();
        tracker.setScreenName("screen - fragment 1");
        tracker.send(new HitBuilders.ScreenViewBuilder()
            .setCustomDimension(1, getString(R.string.first_fragment_label))
            .build());
        Log.d(TAG, "*** Screenview: " + getString(R.string.frag1));
        /* END Analytics */

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            /* Analytics */
            tracker.send(new HitBuilders.EventBuilder()
                .setCategory("button")
                .setAction("click")
                .setLabel(getString(R.string.frag2))
                .build());
            Log.d(TAG, "*** Clicked: " + getString(R.string.frag2));
            /* END Analytics */

            NavHostFragment.findNavController(FirstFragment.this)
                .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}
