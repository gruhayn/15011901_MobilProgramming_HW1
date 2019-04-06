package com.example.mobilodev1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.mobilodev1.Adapter.DersAdapter;
import com.example.mobilodev1.Entity.Ders;
import com.example.mobilodev1.Listener.DersListener;

import java.util.ArrayList;

public class DersListesi extends AppCompatActivity {
    private RecyclerView rv;
    private ArrayList<Ders> dersler;
    private DersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ders_listesi);
        rv = findViewById(R.id.rv);

        setData();

        adapter = new DersAdapter(dersler, new DersListener() {
            @Override
            public void onClick(View view, int i) {

                Log.d("Ders Listesi", "onClick: "+dersler.get(1).toString());
                Intent intent = new Intent(getApplicationContext(),DersBilgisi.class);
                intent.putExtra("Ad",dersler.get(i).getAd());
                intent.putExtra("Kod",dersler.get(i).getKod());
                intent.putExtra("AlanOgrSay",Integer.toString(dersler.get(i).getAlanOgrSayi()));
                intent.putExtra("Not",Float.toString(dersler.get(i).getNot()));
                startActivity(intent);

            }
        });
        RecyclerView.LayoutManager lm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(lm);
        rv.setAdapter(adapter);
    }

    public void setData(){
        dersler = new ArrayList<>();
        dersler.add(new Ders("Mobil Programlamaya Giriş","BLM3520",65,80));
        dersler.add(new Ders("Alt Seviye Programlama","BLM2021",45,10));
        dersler.add(new Ders("Ayrık Matematik","BLM2521",73,81));
        dersler.add(new Ders("Seminer","BLM2051",64,48));
        dersler.add(new Ders("Hesaplama Kuramı","BLM3322",74,37));
        dersler.add(new Ders("Veritabanı Yönetimi","BLM2520",65,85));
        dersler.add(new Ders("Mesleki Hukuk ve Etik","BLM3241",47,92));
        dersler.add(new Ders("Gömülü Sistemler","BLM3521",38,73));

    }
}
