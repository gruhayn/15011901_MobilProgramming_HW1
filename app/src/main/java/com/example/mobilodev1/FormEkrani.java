package com.example.mobilodev1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class FormEkrani extends AppCompatActivity {
    //TODO : sekil ekleme
    private EditText ad,soyad,email,tc_no,tel;
    private Button temizle,kaydet,resim;
    private SharedPreferences sharedpreferences;
    private static final String MyPREFERENCES = "MyPrefs" ;
    private static final String Name = "nameKey";
    private static final String Surname = "surnameKey";
    private static final String Phone = "phoneKey";
    private static final String Email = "emailKey";
    private static final String TC = "tcKey";
    private Uri imageUri ;

    public FormEkrani() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_ekrani);

        ad = findViewById(R.id.name);
        soyad = findViewById(R.id.surname);
        email = findViewById(R.id.email);
        tc_no = findViewById(R.id.tc_no);
        tel = findViewById(R.id.tel);

        temizle = findViewById(R.id.btn_temizle);
        kaydet = findViewById(R.id.btn_kaydet);
        resim = findViewById(R.id.btn_resim);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

    }

    public void kaydet(View view) {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Name, ad.getText().toString());
        editor.putString(Surname, soyad.getText().toString());
        editor.putString(Phone,tel.getText().toString());
        editor.putString(Email, email.getText().toString());
        editor.putString(TC, tc_no.getText().toString());
        editor.putString("resim", imageUri.toString());
        editor.commit();
        Intent intent = new Intent(this, BilgiEkrani.class);
        startActivity(intent);
    }

    public void temizle(View view) {
        ad.setText("");
        soyad.setText("");
        email.setText("");
        tc_no.setText("");
        tel.setText("");
    }
    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);


        if (resultCode == RESULT_OK) {
            try {
                imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                //final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
            } catch (FileNotFoundException e) {
                //Toast.makeText(PostImage.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        }else {
            //Toast.makeText(PostImage.this, "You haven't picked Image", Toast.LENGTH_LONG).show();
        }
    }
    public void resim_sec(View view) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, 1);
    }
}
