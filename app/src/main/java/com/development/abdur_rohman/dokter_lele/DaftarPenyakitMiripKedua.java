package com.development.abdur_rohman.dokter_lele;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.beardedhen.androidbootstrap.BootstrapButton;

import java.util.ArrayList;

public class DaftarPenyakitMiripKedua extends AppCompatActivity {
    //Inisialisasi variabel termasuk membuat Array integer
    protected Toolbar toolbar;
    ArrayList<RincianPenyakit> dataView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Menghubungkan dengan layout yang digunakan
        super.onCreate(savedInstanceState);
        setContentView(R.layout.penyakit_mirip);
        //Inisialisasi BootstrapButton selesai
        BootstrapButton selesai = (BootstrapButton) findViewById(R.id.penyakit_selesai);
        selesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), R.string.diagnosa_selesai,
                        Toast.LENGTH_SHORT).show();
                Intent telah_selesai = new Intent(DaftarPenyakitMiripKedua.this, MainMenu.class);
                startActivity(telah_selesai);
            }
        });
        //Inisialisasi listData
        ArrayList<RincianPenyakit> listData = perolehData();
        final ListView listViewData = (ListView) findViewById(R.id.daftar_penyakit);
        //Inisialisasi adapter
        AdapterDaftarPenyakit adapter = new AdapterDaftarPenyakit(this, listData);
        //Mensetting adapter untuk Adapter pada ListView
        listViewData.setAdapter(adapter);
        //Memberikan aksi setelah data pada ListView diklik
        listViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Inisialisasi berupa objek dengan mendapatkan posisi item pada listView
                Object terpilih = listViewData.getItemAtPosition(position);
                //Mengambil data pada item yang dipilih
                RincianPenyakit rincian = (RincianPenyakit) terpilih;
                //Menampilkan pesan ketika user memilih data pada listView
                Toast.makeText(getBaseContext(), "Penyakit " + rincian.perolehkode_dan_nama_penyakit(),
                        Toast.LENGTH_SHORT).show();
                //Menampilkan info penyakit
                Intent intent = new Intent(DaftarPenyakitMiripKedua.this, InfoPenyakitMirip.class);
                Bundle data = new Bundle();
                //Menambahkan data pada infoPenyakit
                data.putInt("Kode_Dan_Nama_Penyakit", rincian.perolehkode_dan_nama_penyakit());
                data.putInt("Penjelasan", rincian.perolehpenjelasan());
                data.putInt("Gejala", rincian.perolehgejala());
                data.putInt("Penyebab", rincian.perolehpenyebab());
                data.putInt("Cara_Pencegahan", rincian.perolehcara_pencegahan());
                data.putInt("Cara_Pengobatan", rincian.perolehcara_pengobatan());
                data.putInt("Id_Penyakit", rincian.perolehidPenyakit());
                intent.putExtras(data);
                startActivityForResult(intent, 1);
            }
        });
    }
    private ArrayList<RincianPenyakit> perolehData(){
        dataView = new ArrayList<RincianPenyakit>();
        RincianPenyakit data;
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
                R.string.p10,
                R.string.penjelasan10,
                R.string.gejala10,
                R.string.penyebab_parasit,
                R.string.pencegahan10,
                R.string.pengobatan10,
                10);
        dataView.add(data);
        return dataView;
    }
}