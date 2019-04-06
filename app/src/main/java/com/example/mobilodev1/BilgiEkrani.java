package com.example.mobilodev1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class BilgiEkrani extends AppCompatActivity {

    private TextView ad,soyad,tel,tc,email;
    private Button call,send_email,list;
    private ImageView image;
    private SharedPreferences sharedprefs;
    private static final String MyPREFERENCES = "MyPrefs" ;
    private static final String Name = "nameKey";
    private static final String Surname = "surnameKey";
    private static final String Phone = "phoneKey";
    private static final String Email = "emailKey";
    private static final String TC = "tcKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilgi_ekrani);
        ad = findViewById(R.id.name);
        soyad = findViewById(R.id.surname);
        tel = findViewById(R.id.tel);
        tc = findViewById(R.id.tc_no);
        email = findViewById(R.id.email);
        image = findViewById(R.id.imageView);
        sharedprefs = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        ad.setText(sharedprefs.getString(Name,"Ad"));
        soyad.setText(sharedprefs.getString(Surname,"Soyad"));
        tel.setText(sharedprefs.getString(Phone,"Tel"));
        tc.setText(sharedprefs.getString(TC,"TC No"));
        email.setText(sharedprefs.getString(Email,"Email"));
        Uri uriOfImage = Uri.parse(sharedprefs.getString("resim","/"));
        Bitmap bitmap = null;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uriOfImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Bitmap bitmap = BitmapFactory.decodeFile(pathToPicture);
        image.setImageBitmap(bitmap);

    }

    public void call(View view) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+tel.getText().toString()));
        startActivity(callIntent);
    }

    public void sendEmail(View view) {
        String TO = email.getText().toString();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Email", "sent");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this,
                    "There is no email client installed.", Toast.LENGTH_LONG).show();
        }
    }

    public void dersListele(View view) {
        Intent intent = new Intent(this, DersListesi.class);
        startActivity(intent);
    }
}
