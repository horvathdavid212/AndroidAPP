package com.horvath.david.beadando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activity_expimpIntent extends AppCompatActivity {

    public static final int uzenet_kerelem = 1;
    private TextView fejlecText;
    private TextView valaszText;

    public static final String EXTRA_UZENET = "uzenet";

    private EditText uzenetText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expimp_intent);
        uzenetText = findViewById(R.id.textUzenet);
        fejlecText = findViewById(R.id.text_header_reply);
        valaszText = findViewById(R.id.text_message_reply);
        init();


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent adat) {
        super.onActivityResult(requestCode, resultCode, adat);
        if (requestCode == uzenet_kerelem) {
            if (resultCode == RESULT_OK) {
                String reply = adat.getStringExtra(activity_uzenet.EXTRA_VALASZ);
                fejlecText.setVisibility(View.VISIBLE);
                valaszText.setText(reply);
                valaszText.setVisibility(View.VISIBLE);
            }
        }
    }

    public void meghivUzenetActivity(View view) {
        Intent intent = new Intent(this, activity_uzenet.class);
        String message = uzenetText.getText().toString();
        intent.putExtra(EXTRA_UZENET, message);
        startActivityForResult(intent, uzenet_kerelem);
    }



    private void hiv(){
        Uri szam = Uri.parse("tel:+36 30 1234567");
        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(szam);
        startActivity(i);
    }

    private void openUrl(){
        Uri url = Uri.parse("https://google.com");
        Intent i = new Intent(Intent.ACTION_VIEW,url);
        startActivity(i);
    }

    private void SMS(){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, "Hogy vagy?");
        startActivity(i);
    }

    private void init(){
        Button btnDial = findViewById(R.id.btnDial);
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hiv();
            }
        });

        Button btnURL = findViewById(R.id.btnURL);
        btnURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUrl();
            }
        });

        Button btnSMS = findViewById(R.id.btnSMS);
        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SMS();
            }
        });

        Button btnStartActivity = findViewById(R.id.btnStartActivity);
        btnStartActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),activity_masikExpIntent.class);
                startActivity(intent);
            }
        });

        Button btn_adatKuldes = findViewById(R.id.btn_adatKuldes);
        btn_adatKuldes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),activity_adat_fogad.class);
                intent.putExtra("username","admin");
                startActivity(intent);
            }
        });


    }
}