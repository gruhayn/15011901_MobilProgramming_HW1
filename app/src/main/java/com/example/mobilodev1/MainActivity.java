package com.example.mobilodev1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText kullanici_adi;
    private EditText password;
    private Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kullanici_adi = findViewById(R.id.kullanici_adi);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);
    }


    public void login(View view) {
        String uname = kullanici_adi.getText().toString();
        String pword = password.getText().toString();
        if(uname.equals("admin")){
            if(pword.equals("password")){
                Intent intent = new Intent(this,FormEkrani.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(this, "Hatalı Şifre!", Toast.LENGTH_LONG).show();
                password.setText("");
            }
        }
        else{
            Toast.makeText(this, "Hatalı Kullanıcı adı!", Toast.LENGTH_LONG).show();
            kullanici_adi.setText("");
            password.setText("");
        }
    }
}
