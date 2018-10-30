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

public class DaftarPenyakitMiripKelima extends AppCompatActivity {
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
                Intent telah_selesai = new Intent(DaftarPenyakitMiripKelima.this, MainMenu.class);
                startActivity(telah_selesai);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
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
                //Menampilkan info penyakit
                Intent intent = new Intent(DaftarPenyakitMiripKelima.this, InfoPenyakitMirip.class);
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
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        super.onBackPressed();
    }

    private ArrayList<RincianPenyakit> perolehData(){
        dataView = new ArrayList<RincianPenyakit>();
        RincianPenyakit data;
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