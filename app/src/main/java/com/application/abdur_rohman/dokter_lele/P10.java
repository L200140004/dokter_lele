package com.application.abdur_rohman.dokter_lele;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.application.abdur_rohman.dokter_lele.basis.RiwayatPenyakit;
import com.beardedhen.androidbootstrap.BootstrapButton;

import java.util.ArrayList;
import java.util.List;

public class P10 extends AppCompatActivity {

    public List<RiwayatPenyakit> list_penyakit = new ArrayList<>();
    final DatabaseHelper db = new DatabaseHelper(this);

    private void simpanRiwayat(String penyakit){
        long id = db.insertRiwayatPenyakit(penyakit);
        RiwayatPenyakit n = db.getRiwayatPenyakit(id);
        list_penyakit.add(0, n);
        list_penyakit.clear();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.penyakit);
        //Menginisialisasi variabel dengan menghubungkan widget pada layout info_penyakit.xml berdasarakn id namenya
        TextView textViewPenjelasan = (TextView) findViewById(R.id.textViewPenjelasan);
        TextView textViewPenyebab = (TextView) findViewById(R.id.textViewPenyebab);
        TextView textViewPencegahan = (TextView) findViewById(R.id.textViewPencegahan);
        TextView textViewPengobatan = (TextView) findViewById(R.id.textViewPengobatan);
        BootstrapButton selesai = (BootstrapButton) findViewById(R.id.penyakit_selesai);
        selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), R.string.diagnosa_selesai,
                        Toast.LENGTH_SHORT).show();
                Intent telah_selesai = new Intent(P10.this, MainMenu.class);
                simpanRiwayat("Trematoda");
                startActivity(telah_selesai);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        setTitle(R.string.p10);
        textViewPenjelasan.setText(R.string.penjelasan10);
        textViewPenyebab.setText(R.string.penyebab_parasit);
        textViewPencegahan.setText(R.string.pencegahan10);
        textViewPengobatan.setText(R.string.pengobatan10);
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