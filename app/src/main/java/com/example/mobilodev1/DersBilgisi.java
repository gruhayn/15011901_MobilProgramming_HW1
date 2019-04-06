package com.example.mobilodev1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DersBilgisi extends AppCompatActivity {

    private TextView ad;
    private TextView kod;
    private TextView ogrSay;
    private TextView not;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ders_bilgisi);
        ad = findViewById(R.id.nameDers);
        kod = findViewById(R.id.kod);
        ogrSay = findViewById(R.id.ogrSay);
        not = findViewById(R.id.not);
        Intent in = getIntent();
        ad.setText(in.getStringExtra("Ad"));
        kod.setText(in.getStringExtra("Kod"));
        not.setText(in.getStringExtra("Not"));
        ogrSay.setText(in.getStringExtra("AlanOgrSay"));
    }
}
