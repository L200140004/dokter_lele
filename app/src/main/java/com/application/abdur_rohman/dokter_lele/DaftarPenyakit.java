package com.application.abdur_rohman.dokter_lele;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class DaftarPenyakit extends AppCompatActivity {
    //Inisialisasi variabel termasuk membuat Array integer
    protected Toolbar toolbar;
    ArrayList<RincianPenyakit> dataView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        //Menghubungkan dengan layout yang digunakan
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_penyakit_ikan_lele);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Inisialisasi listData
        ArrayList<RincianPenyakit> listData = perolehData();
        final ListView listViewData = (ListView) findViewById(R.id.daftar_penyakit);
        //Inisialisasi adapter
        AdapterDaftarPenyakit adapter = new AdapterDaftarPenyakit(this, listData);
        //Mensetting adapter untuk Adapter pada ListView
        listViewData.setAdapter(adapter);
        //Memberikan aksi setelah item pada ListView diklik
        listViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Inisialisasi berupa objek dengan mendapatkan posisi item pada listView
                Object terpilih = listViewData.getItemAtPosition(position);
                //Mengambil data pada item yang dipilih
                RincianPenyakit rincian = (RincianPenyakit) terpilih;
                //Menampilkan info penyakit
                Intent intent = new Intent(DaftarPenyakit.this, InfoPenyakit.class);
                Bundle data = new Bundle();
                //Menambahkan data pada infoPenyakit
                data.putInt("Kode_Dan_Nama_Penyakit", rincian.perolehkode_dan_nama_penyakit());
                data.putInt("Penjelasan", rincian.perolehpenjelasan());
                data.putInt("Gejala",rincian.perolehgejala());
                data.putInt("Penyebab", rincian.perolehpenyebab());
                data.putInt("Cara_Pencegahan", rincian.perolehcara_pencegahan());
                data.putInt("Cara_Pengobatan", rincian.perolehcara_pengobatan());
                data.putInt("Id_Penyakit", rincian.perolehidPenyakit());
                intent.putExtras(data);
                startActivityForResult(intent, 1);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
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

    //Data ArrayList yang dipakai untuk infoPenyakit
    private ArrayList<RincianPenyakit> perolehData(){
        dataView = new ArrayList<RincianPenyakit>();
        RincianPenyakit data;
        data = new RincianPenyakit(
                R.string.p01,
                R.string.penjelasan01,
                R.string.gejala01,
                R.string.penyebab_bakteri,
                R.string.pencegahan01,
                R.string.pengobatan01,
                1);
        dataView.add(data);
        data = new RincianPenyakit(
                R.string.p02,
                R.string.penjelasan02,
                R.string.gejala02,
                R.string.penyebab_bakteri,
                R.string.pencegahan02,
                R.string.pengobatan02,
                2);
        dataView.add(data);
        data = new RincianPenyakit(
                R.string.p03,
                R.string.penjelasan03,
                R.string.gejala03,
                R.string.penyebab_bakteri,
                R.string.pencegahan03,
                R.string.pengobatan03,
                3);
        dataView.add(data);
        data = new RincianPenyakit(
                R.string.p04,
                R.string.penjelasan04,
                R.string.gejala04,
                R.string.penyebab_bakteri,
                R.string.pencegahan04,
                R.string.pengobatan04,
                4);
        dataView.add(data);
        data = new RincianPenyakit(
                R.string.p05,
                R.string.penjelasan05,
                R.string.gejala05,
                R.string.penyebab_bakteri,
                R.string.pencegahan05,
                R.string.pengobatan05,
                5);
        dataView.add(data);
        data = new RincianPenyakit(
                R.string.p06,
                R.string.penjelasan06,
                R.string.gejala06,
                R.string.penyebab_bakteri,
                R.string.pencegahan06,
                R.string.pengobatan06,
                6);
        dataView.add(data);
        data = new RincianPenyakit(
                R.string.p07,
                R.string.penjelasan07,
                R.string.gejala07,
                R.string.serangan_jamur,
                R.string.pencegahan07,
                R.string.pengobatan07,
                7);
        dataView.add(data);
        data = new RincianPenyakit(
                R.string.p08,
                R.string.penjelasan08,
                R.string.gejala08,
                R.string.penyebab_parasit,
                R.string.pencegahan08,
                R.string.pengobatan08,
                8);
        dataView.add(data);
        data = new RincianPenyakit(
                R.string.p09,
                R.string.penjelasan09,
                R.string.gejala09,
                R.string.penyebab_parasit,
                R.string.pencegahan09,
                R.string.pengobatan09,
                9);
        dataView.add(data);
        data = new RincianPenyakit(
                R.string.p10,
                R.string.penjelasan10,
                R.string.gejala10,
                R.string.penyebab_parasit,
                R.string.pencegahan10,
                R.string.pengobatan10,
                10);
        dataView.add(data);
        data = new RincianPenyakit(
                R.string.p11,
                R.string.penjelasan11,
                R.string.gejala11,
                R.string.penyebab_parasit,
                R.string.pencegahan11,
                R.string.pengobatan11,
                11);
        dataView.add(data);
        return dataView;
    }
}