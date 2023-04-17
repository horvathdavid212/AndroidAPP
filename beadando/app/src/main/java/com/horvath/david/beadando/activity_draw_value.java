package com.horvath.david.beadando;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class activity_draw_value extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_value);

        Button button1, button2;
        final RelativeLayout relativeLayout;
        button1 = findViewById(R.id.btnSzin1);
        button2 = findViewById(R.id.btnSzin2);

        relativeLayout = findViewById(R.id.relativ);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relativeLayout.setBackgroundResource(R.color.kek);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relativeLayout.setBackgroundResource(R.color.zold);
            }
        });
    }

    int i=0;
    public void kepValtas(View view){
        ImageView image = (ImageView) findViewById(R.id.kutyaImage);
        i=i+1;
        if(i>4) i=1;
        switch (i){
            case 1: image.setImageResource(R.drawable.kutyus2); break;
            case 2: image.setImageResource(R.drawable.kutyus3); break;
            case 3: image.setImageResource(R.drawable.kutyus4); break;
            case 4: image.setImageResource(R.drawable.kutyus); break;
        }

    }
}