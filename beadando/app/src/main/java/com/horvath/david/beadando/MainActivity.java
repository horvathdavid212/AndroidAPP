package com.horvath.david.beadando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_expimpIntent_INDIT = findViewById(R.id.btn_expimpIntent);
        btn_expimpIntent_INDIT.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),activity_expimpIntent.class);
            startActivity(intent);
        });

        Button btn_PortraitLandscape_INDIT = findViewById(R.id.btn_PortraitLandscape);
        btn_PortraitLandscape_INDIT.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),activity_layouts.class);
            startActivity(intent);
        });

        Button btn_DrawableValues_INDIT = findViewById(R.id.btn_DrawableValues);
        btn_DrawableValues_INDIT.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),activity_draw_value.class);
            startActivity(intent);
        });

        Button btn_adatbazis_INDIT = findViewById(R.id.btn_adatbazis);
        btn_adatbazis_INDIT.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),activity_adatbazis.class);
            startActivity(intent);
        });

        Button btn_fragment_INDIT = findViewById(R.id.btn_fragmentek);
        btn_fragment_INDIT.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),activity_fragment.class);
            startActivity(intent);
        });
    }
}