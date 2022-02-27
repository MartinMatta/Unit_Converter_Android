package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        setContentView(R.layout.activity_about);

        TextView aboutVersionText = (TextView) findViewById(R.id.aboutVersionText);
        LinearLayout share = (LinearLayout) findViewById(R.id.share);
        LinearLayout rate = (LinearLayout) findViewById(R.id.rate);

        String versionName = " " + BuildConfig.VERSION_NAME;

        aboutVersionText.setText(getString(R.string.text_title) + versionName);

        share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Share Unit converter app");
                intent.putExtra(Intent.EXTRA_TEXT, "http://UnitConverterApp..com");
                startActivity(Intent.createChooser(intent, "Share URL"));

            }
        });

        rate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });
    }
}