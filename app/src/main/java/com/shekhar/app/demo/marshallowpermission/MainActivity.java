package com.shekhar.app.demo.marshallowpermission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    private static final int PERMISSION_REQUEST_INTERNET = 0;
    private static final int PERMISSION_REQUEST_CALENDAR = 1;

    private View mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLayout = findViewById(R.id.main_layout);

        // Register a listener for the 'Show Internet Preview' button.
        Button internet = (Button) findViewById(R.id.internet);
        Button calendar = (Button) findViewById(R.id.calendar);

        internet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBrowser();
            }
        });
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCalendar();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        // BEGIN_INCLUDE(onRequestPermissionsResult)
        if (requestCode == PERMISSION_REQUEST_INTERNET) {

            // Request for Internet permission.
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission has been granted. Start Internet preview Activity.
                Snackbar.make(mLayout, "Internet permission was granted.",
                        Snackbar.LENGTH_SHORT)
                        .show();
            } else {
                // Permission request was denied.
                Snackbar.make(mLayout, "Internet permission request was denied.",
                        Snackbar.LENGTH_SHORT)
                        .show();
            }
        }

        if (requestCode == PERMISSION_REQUEST_CALENDAR) {
            // Request for Internet permission.
            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission has been granted. Start Internet preview Activity.
                Snackbar.make(mLayout, "Calendar permission was granted.",
                        Snackbar.LENGTH_SHORT)
                        .show();
            } else {
                // Permission request was denied.
                Snackbar.make(mLayout, "Calendar permission request was denied.",
                        Snackbar.LENGTH_SHORT)
                        .show();
            }
        }
        // END_INCLUDE(onRequestPermissionsResult)
    }

    private void showBrowser() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
                == PackageManager.PERMISSION_GRANTED) {

            // Permission is already available, start Internet preview
            Snackbar.make(mLayout,
                    "Internet permission is available",
                    Snackbar.LENGTH_SHORT).show();
        } else {
            new MarshmallowPermission(MainActivity.this, mLayout).requestInternetPermission();
        }
    }

    private void checkCalendar() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_CALENDAR)
                == PackageManager.PERMISSION_GRANTED) {

            // Permission is already available, start Internet preview
            Snackbar.make(mLayout,
                    "Calendar permission is available.",
                    Snackbar.LENGTH_SHORT).show();
        } else {
            new MarshmallowPermission(MainActivity.this, mLayout).requestPermissionCalendar();
        }
    }

}