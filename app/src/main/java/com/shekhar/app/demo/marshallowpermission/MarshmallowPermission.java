package com.shekhar.app.demo.marshallowpermission;

import android.Manifest;
import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.view.View;

public class MarshmallowPermission {

    Activity context;
    private View mLayout;
    private static final int PERMISSION_REQUEST_INTERNET = 0;
    private static final int PERMISSION_REQUEST_CALENDAR = 1;

    public MarshmallowPermission(Activity context, View mLayout) {
        this.context = context;
        this.mLayout = mLayout;
    }

    public void requestInternetPermission() {

        // Permission has not been granted and must be requested.
        if (ActivityCompat.shouldShowRequestPermissionRationale(context,
                Manifest.permission.INTERNET)) {

            // Provide an additional rationale to the user if the permission was not granted
            // and the user would benefit from additional context for the use of the permission.
            // Display a SnackBar with a button to request the missing permission.
            Snackbar.make(mLayout, "Internet access is required to open browser.",
                    Snackbar.LENGTH_INDEFINITE).setAction("OK", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Request the permission
                    ActivityCompat.requestPermissions(context,
                            new String[]{Manifest.permission.INTERNET},
                            PERMISSION_REQUEST_INTERNET);
                }
            }).show();

        } else {
            Snackbar.make(mLayout,
                    "Permission is not available. Requesting Internet permission.",
                    Snackbar.LENGTH_SHORT).show();
            // Request the permission. The result will be received in onRequestPermissionResult().
            ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.INTERNET},
                    PERMISSION_REQUEST_INTERNET);
        }
    }

    public void requestPermissionCalendar() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(context,
                Manifest.permission.WRITE_CALENDAR)) {

            // Provide an additional rationale to the user if the permission was not granted
            // and the user would benefit from additional context for the use of the permission.
            // Display a SnackBar with a button to request the missing permission.

            Snackbar.make(mLayout, "Calendar access is required ",
                    Snackbar.LENGTH_INDEFINITE).setAction("OK", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Request the permission
                    ActivityCompat.requestPermissions(context,
                            new String[]{Manifest.permission.WRITE_CALENDAR},
                            PERMISSION_REQUEST_CALENDAR);
                }
            }).show();

        } else {
            Snackbar.make(mLayout,
                    "Permission is not available. Requesting calendar permission.",
                    Snackbar.LENGTH_SHORT).show();
            // Request the permission. The result will be received in onRequestPermissionResult().
            ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.WRITE_CALENDAR},
                    PERMISSION_REQUEST_CALENDAR);
        }
    }
}