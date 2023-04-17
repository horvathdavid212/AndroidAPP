package com.horvath.david.beadando;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_adatbazis extends AppCompatActivity {


    DatabaseHelper myDb;
    Button btn_felvisz,btn_lekerdez,btn_modosit,btn_torol;
    EditText text_nev,text_varos,text_utcaHsz,text_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adatbazis);

        myDb = new DatabaseHelper(this);
        btn_felvisz=(Button) findViewById(R.id.btn_felvisz);
        btn_lekerdez=(Button) findViewById(R.id.btn_lekerdez);
        btn_modosit=(Button) findViewById(R.id.btn_modosit);
        btn_torol=(Button) findViewById(R.id.btn_torol);


        text_nev=(EditText) findViewById(R.id.editTextNev);
        text_varos=(EditText) findViewById(R.id.editTextVaros);
        text_utcaHsz=(EditText) findViewById(R.id.editTextUtcaHsz);
        text_ID=(EditText)findViewById(R.id.editTextID);



        btn_felvisz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean felveve =  myDb.adatFelvesz(text_nev.getText().toString(),text_varos.getText().toString(),text_utcaHsz.getText().toString());

                if(felveve == true){
                    Toast.makeText(activity_adatbazis.this, "Adatok felvéve", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(activity_adatbazis.this, "Nem lett felvéve", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btn_lekerdez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor cur = myDb.lekerdezes();

                if(cur.getCount() == 0){
                    showMessage("Error","Nem található adat");
                    return;
                }

                StringBuffer buffer = new StringBuffer();

                while (cur.moveToNext()){

                    buffer.append("ID: "+ cur.getString(0)+"\n");
                    buffer.append("Név: "+ cur.getString(1)+"\n");
                    buffer.append("Város: "+ cur.getString(2)+"\n");
                    buffer.append("Utca, házszám: "+ cur.getString(3)+"\n");

                }

                showMessage("Data",buffer.toString());

            }
        });

        btn_modosit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean modositva= myDb.adatModositas(text_ID.getText().toString(),text_nev.getText().toString(),
                        text_varos.getText().toString(),text_utcaHsz.getText().toString());

                if(modositva == true){
                    Toast.makeText(activity_adatbazis.this, "Adatok módosítva", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(activity_adatbazis.this, "Adatok nem lettek módosítva", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btn_torol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int sorTorol = myDb.deleteData(text_ID.getText().toString());

                if(sorTorol>0){
                    Toast.makeText(activity_adatbazis.this, "Törölve!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(activity_adatbazis.this, "Nem lett törölve.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void showMessage(String title, String Message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }

}