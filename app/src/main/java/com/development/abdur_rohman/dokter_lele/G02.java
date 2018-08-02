package com.development.abdur_rohman.dokter_lele;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.beardedhen.androidbootstrap.BootstrapButton;

public class G02 extends AppCompatActivity {
    protected Toolbar toolbar;
    protected BootstrapButton opsi_ya;
    protected BootstrapButton opsi_tidak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Mensetting tampilan yand digunakan pada kelas ini
        setContentView(R.layout.info_gejala);
        BootstrapButton kode_gejala = (BootstrapButton) findViewById(R.id.bootstrapButtonGejala);
        kode_gejala.setText("G02");
        BootstrapButton pertanyaan = (BootstrapButton) findViewById(R.id.bootstrapButtonPertanyaan);
        pertanyaan.setText(R.string.pg02);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Menyambungkan variabel dengan id pada layout
        opsi_ya = findViewById(R.id.gejala_benar);
        opsi_tidak = findViewById(R.id.gejala_tidak);
        //Membuat aksi klik pada tombol
        opsi_ya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.gejala_benar:
                        //Mengubungkan ke pertanyaan selanjutnya
                        Intent pertanyaan_selanjutnya = new Intent(G02.this, G01.class);
                        startActivity(pertanyaan_selanjutnya);
                }
            }
        });
        opsi_tidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.gejala_tidak:
                        //Mengganti ke pertanyaan lainnya
                        Intent mengganti_pertanyaan = new Intent(G02.this, G05_1.class);
                        startActivity(mengganti_pertanyaan);
                }
            }
        });
    }
}