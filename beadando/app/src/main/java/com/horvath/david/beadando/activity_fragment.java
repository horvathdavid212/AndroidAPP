package com.horvath.david.beadando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class activity_fragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        Button btn_adat_atadasa_fragmentnek = findViewById(R.id.btn_adat_atadasa_fragmentnek);

        btn_adat_atadasa_fragmentnek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText_callback_adat = findViewById(R.id.editText_callback_adat);
                Bundle bundle = new Bundle();
                bundle.putString("adat",editText_callback_adat.getText().toString());
                fragment_adat_fogad fragment1 = new fragment_adat_fogad();
                fragment1.setArguments(bundle);
                getSupportFragmentManager().beginTransaction()
                        .add(android.R.id.content,fragment1)
                        .addToBackStack(null)
                        .commit();
            }
        });


    }
    public static void showToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}