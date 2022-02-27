package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private final Constants constants = new Constants();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        setContentView(R.layout.activity_main);

        ImageView aboutImage = (ImageView) findViewById(R.id.aboutImg);
        CardView lengthCard = (CardView) findViewById(R.id.cardviewLength);


        CardView cardView [] = new CardView[12];

        for(int i = 0; i < constants.CARDVIEW_ID.length; i++){
            String id = constants.CARDVIEW_ID[i];
            int resID = getResources().getIdentifier(id,"id", this.getPackageName());
            cardView[i] = (CardView) findViewById(resID);
        }

        for (int i = 0; i < constants.CARDVIEW_ID.length; i++) {
            int finalI = i;
            cardView[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, ConvertActivity.class);
                    intent.putExtra("type", constants.CARDVIEW_ID[finalI]);
                    startActivity(intent);
                }
            });

        }

        aboutImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

        //lengthCard.setOnClickListener(new View.OnClickListener() {
            //public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, ConvertActivity.class);
                //startActivity(intent);
            //}
        //});

    }
}