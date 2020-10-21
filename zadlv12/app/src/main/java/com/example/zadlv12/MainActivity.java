package com.example.zadlv12;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.util.Calendar;

import static android.Manifest.permission.CALL_PHONE;


public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    private FloatingActionButton fabDate, fabMap, fabWeb, fabWifi, fabMain, fabCall;
    private boolean isFabOpen = false;
    private TextView dateText;
    private static final String number = "061 123 456";
    private static final int CALL_PHONE = 3;
    private static final String query = new String();
    private static final Uri geoLocation = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        fabCall = findViewById ( R.id.fab_call );
        fabDate = findViewById ( R.id.fab_date );
        fabWifi = findViewById ( R.id.fab_wifi );
        fabMain = findViewById ( R.id.fab_main );
        fabWeb = findViewById ( R.id.fab_web );
        fabMap = findViewById ( R.id.fab_map );


        setMyFabs();
    }



    private void setMyFabs() {
        fabMain.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFabOpen) {
                    closeMenu();
                } else {
                    openMenu();
                }
            }
        });
        fabMap.setOnClickListener (new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View view) {
                if (isFabOpen) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(geoLocation);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                } else {
                    openMenu ();
                }
            }
        });

        fabCall.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFabOpen) {
                    fabCall.setOnClickListener ( new View.OnClickListener () {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Intent.ACTION_DIAL);
                            intent.setData( Uri.parse("tel:" + number));
                            startActivity(intent);
                        }
                    } );
                } else {
                    closeMenu ();
                }
            }
        });
        fabWeb.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFabOpen) {
                    Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    intent.putExtra( SearchManager.QUERY, query);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }else {
                    openMenu();
                }
            }
        });
        fabWifi.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFabOpen) {
                    Intent intent = new Intent( Settings.ACTION_WIFI_SETTINGS);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                } else {
                    openMenu();
                }
            }
        });
        fabDate.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFabOpen) {
                    fabDate.setOnClickListener ( new View.OnClickListener () {
                        public void onClick(View v) {
                            DialogFragment newFragment = new DatePickerFragment();
                            newFragment.show(getSupportFragmentManager(), "datePicker");

                        }
                    } );

                } else {
                    openMenu();
                }
            }
        });

    }
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = "month/day/year: " + (month+1) + "/" + dayOfMonth + "/" + year;
        dateText.setText(date);
    }
    /*public void onDateSet(DatePicker view, int year, int month, int dayOfMonth){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(currentDateString);
    }*/

    private void openMenu() {
        isFabOpen = true;

        fabMain.animate ().rotation ( 135 );
        fabCall.setVisibility ( View.VISIBLE );
        fabCall.animate ().translationY ( -210 ).rotation ( 0 );

        fabDate.setVisibility ( View.VISIBLE );
        fabDate.animate ().translationX (31 ).rotation ( 0 );

        fabWifi.setVisibility ( View.VISIBLE );
        fabWifi.animate ().translationY ( -360 ).rotation ( 0 );

        fabMap.setVisibility ( View.VISIBLE );
        fabMap.animate ().translationX ( -210 ).rotation ( 0 );

        fabWeb.setVisibility ( View.VISIBLE );
        fabWeb.animate ().translationX ( -360 ).rotation ( 0 );
    }

    private void closeMenu() {
        isFabOpen = false;

        fabMain.animate ().rotation ( 0 );
        fabMap.animate ().translationX ( 0 ).rotation ( 90 );
        fabMap.setVisibility ( View.INVISIBLE );

        fabDate.animate ().translationY ( 0 ).rotation ( 90 );
        fabDate.setVisibility ( View.INVISIBLE );

        fabCall.animate ().translationY ( 0 ).rotation ( 90 );
        fabCall.setVisibility ( View.INVISIBLE );

        fabWifi.animate ().translationX ( 0 ).rotation ( 90 );
        fabWifi.setVisibility ( View.INVISIBLE );

        fabWeb.setVisibility ( View.INVISIBLE );
        fabWeb.animate ().translationX ( 0 ).rotation ( 90 );


    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
