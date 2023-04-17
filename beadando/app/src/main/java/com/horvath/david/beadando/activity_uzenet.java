package com.horvath.david.beadando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class activity_uzenet extends AppCompatActivity {
    public static final String EXTRA_VALASZ = "valasz";
    private EditText valasz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uzenet);

        valasz = findViewById(R.id.editText_valasz);
        Intent intent = getIntent();
        String message = intent.getStringExtra(activity_expimpIntent.EXTRA_UZENET);
        TextView textView = findViewById(R.id.text_uzenet);
        textView.setText(message);
    }

    public void visszaValasz(View view) {
        String reply = valasz.getText().toString();
        Intent valaszIntent = new Intent();
        valaszIntent.putExtra(EXTRA_VALASZ, reply);
        setResult(RESULT_OK,valaszIntent);
        finish();
    }
}