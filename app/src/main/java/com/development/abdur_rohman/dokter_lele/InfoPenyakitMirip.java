package com.development.abdur_rohman.dokter_lele;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class InfoPenyakitMirip extends AppCompatActivity {
    //Inisialisasi variabel
    protected Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_penyakit);
        //Menginisialisasi variabel dengan menghubungkan widget pada layout info_penyakit_mirip berdasarakn id namenya
        TextView textViewPenjelasan = (TextView) findViewById(R.id.textViewPenjelasan);
        TextView textViewGejala = (TextView) findViewById(R.id.textViewGejala);
        TextView textViewPenyebab = (TextView) findViewById(R.id.textViewPenyebab);
        TextView textViewPencegahan = (TextView) findViewById(R.id.textViewPencegahan);
        TextView textViewPengobatan = (TextView) findViewById(R.id.textViewPengobatan);
        //Memperoleh data dari arrayList dengan kata kunci pada DaftarPenyakit
        Bundle data = getIntent().getExtras();
        int kode_dan_nama_penyakit = data.getInt("Kode_Dan_Nama_Penyakit");
        int gejala = data.getInt("Gejala");
        int penjelasan = data.getInt("Penjelasan");
        int penyebab = data.getInt("Penyebab");
        int cara_pencegahan = data.getInt("Cara_Pencegahan");
        int cara_pengobatan = data.getInt("Cara_Pengobatan");
        int idPenyakit = data.getInt("Id_Penyakit");
        //Mensetting isi dari widget dengan data ArrayList
        setTitle(kode_dan_nama_penyakit);
        textViewPenjelasan.setText(penjelasan);
        textViewGejala.setText(gejala);
        textViewPenyebab.setText(penyebab);
        textViewPencegahan.setText(cara_pencegahan);
        textViewPengobatan.setText(cara_pengobatan);
    }
}