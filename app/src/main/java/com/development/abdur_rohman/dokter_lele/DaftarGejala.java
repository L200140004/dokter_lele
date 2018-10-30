package com.development.abdur_rohman.dokter_lele;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import com.development.abdur_rohman.dokter_lele.LihatPenyakit.RincianGejala;
import java.util.ArrayList;

public class DaftarGejala extends AppCompatActivity {
    //Inisialisasi variabel, termasuk tipe data Array
    protected Toolbar toolbar;
    protected ListView daftar_gejala;
    ArrayList<RincianGejala> dataView;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_gejala_penyakit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ArrayList<RincianGejala> listData = perolehData();
        //Menginisialisasi variabel daftar_gejala
        daftar_gejala = findViewById(R.id.daftar_gejala);
        AdapterGejala adapterGejala = new AdapterGejala(this, listData);
        //Mensetting adapater pada listView dengan variabel data_gejala
        daftar_gejala.setAdapter(adapterGejala);
    }

    private ArrayList<RincianGejala> perolehData() {
        dataView = new ArrayList<RincianGejala>();
        RincianGejala data;
        data = new RincianGejala(1, R.string.g01);
        dataView.add(data);
        data = new RincianGejala(2, R.string.g02);
        dataView.add(data);
        data = new RincianGejala(3, R.string.g03);
        dataView.add(data);
        data = new RincianGejala(4, R.string.g04);
        dataView.add(data);
        data = new RincianGejala(5, R.string.g05);
        dataView.add(data);
        data = new RincianGejala(6, R.string.g06);
        dataView.add(data);
        data = new RincianGejala(7, R.string.g07);
        dataView.add(data);
        data = new RincianGejala(8, R.string.g08);
        dataView.add(data);
        data = new RincianGejala(9, R.string.g09);
        dataView.add(data);
        data = new RincianGejala(10, R.string.g10);
        dataView.add(data);
        data = new RincianGejala(11, R.string.g11);
        dataView.add(data);
        data = new RincianGejala(12, R.string.g12);
        dataView.add(data);
        data = new RincianGejala(13, R.string.g13);
        dataView.add(data);
        data = new RincianGejala(14, R.string.g14);
        dataView.add(data);
        data = new RincianGejala(15, R.string.g15);
        dataView.add(data);
        data = new RincianGejala(16, R.string.g16);
        dataView.add(data);
        data = new RincianGejala(17, R.string.g17);
        dataView.add(data);
        data = new RincianGejala(18, R.string.g18);
        dataView.add(data);
        data = new RincianGejala(19, R.string.g19);
        dataView.add(data);
        data = new RincianGejala(20, R.string.g20);
        dataView.add(data);
        data = new RincianGejala(21, R.string.g21);
        dataView.add(data);
        data = new RincianGejala(22, R.string.g22);
        dataView.add(data);

        return dataView;
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