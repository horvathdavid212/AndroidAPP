package com.horvath.david.beadando;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class activity_adat_fogad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adat_fogad);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String username = bundle.getString("username",null);
            TextView textView = findViewById(R.id.textViewUser);
            textView.setText("Üdvözlet, "+username);
        }
    }
}