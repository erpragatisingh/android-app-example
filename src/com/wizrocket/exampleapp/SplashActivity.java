package com.wizrocket.exampleapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.wizrocket.android.sdk.WizRocketAPI;
import com.wizrocket.android.sdk.exceptions.WizRocketException;

public class SplashActivity extends Activity {
    private WizRocketAPI wr = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        try {
            wr = WizRocketAPI.getInstance(getApplicationContext());
        } catch (WizRocketException e) {
            e.printStackTrace();
        }
        assert wr != null;

        // Read key value pairs from an incoming notification
        try {
            Bundle extras = getIntent().getExtras();
            for (String key : extras.keySet()) {
                Log.i("Sample App", "key = " + key + "; value = " + extras.get(key).toString());
            }
        } catch (Exception e) {
            // Ignore
        }

        Handler h = new Handler(Looper.getMainLooper());
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(i);
                finish();
            }
        }, 1000);
    }
}
