package com.application.abdur_rohman.dokter_lele;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;
import com.beardedhen.androidbootstrap.BootstrapButton;

public class G21 extends AppCompatActivity {
    protected Toolbar toolbar;
    protected BootstrapButton opsi_ya;
    protected BootstrapButton opsi_tidak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Mensetting tampilan yand digunakan pada kelas ini
        setContentView(R.layout.info_gejala);
        BootstrapButton kode_gejala = (BootstrapButton) findViewById(R.id.bootstrapButtonGejala);
        kode_gejala.setText("G21");
        BootstrapButton pertanyaan = (BootstrapButton) findViewById(R.id.bootstrapButtonPertanyaan);
        pertanyaan.setText(R.string.pg21);
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
                        Intent pertanyaan_selanjutnya = new Intent(G21.this, G22.class);
                        startActivity(pertanyaan_selanjutnya);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });
        opsi_tidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.gejala_tidak:
                        //Mengganti ke pertanyaan lainnya
                        Toast.makeText(G21.this, getString(R.string.kembali_ke_awal), Toast.LENGTH_LONG).show();
                        Intent mengganti_pertanyaan = new Intent(G21.this, G03.class);
                        mengganti_pertanyaan.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(mengganti_pertanyaan);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}