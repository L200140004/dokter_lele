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

public class DaftarPenyakitMiripKeempat extends AppCompatActivity {
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
                Intent telah_selesai = new Intent(DaftarPenyakitMiripKeempat.this, MainMenu.class);
                startActivity(telah_selesai);
            }
        });
        ArrayList<RincianPenyakit> listData = perolehData();
        //Inisialisasi listVeiwData
        final ListView listViewData = (ListView) findViewById(R.id.daftar_penyakit);
        AdapterDaftarPenyakit adapter = new AdapterDaftarPenyakit(this, listData);
        //Mensetting adapter pada Adapter ListView
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
                Intent intent = new Intent(DaftarPenyakitMiripKeempat.this, InfoPenyakitMirip.class);
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
                R.string.p07,
                R.string.penjelasan07,
                R.string.gejala07,
                R.string.serangan_jamur,
                R.string.pencegahan07,
                R.string.pengobatan07,
                7);
        dataView.add(data);
        return dataView;
    }
}