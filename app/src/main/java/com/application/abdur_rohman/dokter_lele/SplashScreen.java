package com.application.abdur_rohman.dokter_lele;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    //Inisialisasi variabel
    protected ImageView asSplash;
    private static int duration = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Mensetting layout class ini dengan splashscreen.xml
        setContentView(R.layout.splashscreen);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(SplashScreen.this, R.color.colorPrimaryDark));
        }
        //Menginisialisasi variabel asSplash dengan menghubungkan dengan id yang bernama asSplash
        asSplash = (ImageView) findViewById(R.id.asSplash);
        //Membuat handler dan akan menuju ke MainActivity jika SplashScren selesai
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        }, duration); //2000 = 2 detik
    }
}