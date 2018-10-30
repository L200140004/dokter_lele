package com.development.abdur_rohman.dokter_lele;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class P02_SplashScreen extends AppCompatActivity {
    //Inisialisasi variabel
    private static int duration = 1500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Mensetting layout class ini dengan splashscreen.xml
        setContentView(R.layout.splashscreen_penyakit);
        //Menginisialisasi variabel proses
        TextView proses = (TextView) findViewById(R.id.splashscreen);
        //Membuat handler dan akan menuju ke P02 jika SplashScren selesai
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), P02.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
                Toast.makeText(getApplicationContext(),R.string.hasil_diagnosa,
                        Toast.LENGTH_SHORT).show();
            }
        }, duration); //1500 = 1.5 detik
    }
}