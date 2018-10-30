package com.development.abdur_rohman.dokter_lele;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.development.abdur_rohman.dokter_lele.basis.RiwayatPenyakit;
import com.beardedhen.androidbootstrap.BootstrapButton;
import java.util.ArrayList;
import java.util.List;

public class P01 extends AppCompatActivity {

    public List<RiwayatPenyakit> list_penyakit = new ArrayList<>();
    final DatabaseHelper db = new DatabaseHelper(this);

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
        //Menambahkan aksi setelah tombol selesai diklik
        selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), R.string.diagnosa_selesai,
                        Toast.LENGTH_SHORT).show();
                simpanRiwayat("Pseudomonas hydrophylla");
                Intent telah_selesai = new Intent(P01.this, MainMenu.class);
                startActivity(telah_selesai);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        //Mensetting isi dari TextView
        setTitle(R.string.p01);
        textViewPenjelasan.setText(R.string.penjelasan01);
        textViewPenyebab.setText(R.string.penyebab_bakteri);
        textViewPencegahan.setText(R.string.pencegahan01);
        textViewPengobatan.setText(R.string.pengobatan01);
    }

    private void simpanRiwayat(String penyakit){
        long id = db.insertRiwayatPenyakit(penyakit);
        RiwayatPenyakit n = db.getRiwayatPenyakit(id);
        list_penyakit.add(0, n);
        list_penyakit.clear();
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