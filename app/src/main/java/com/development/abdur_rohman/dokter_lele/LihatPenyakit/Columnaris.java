package com.development.abdur_rohman.dokter_lele.LihatPenyakit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.development.abdur_rohman.dokter_lele.R;

public class Columnaris extends AppCompatActivity {
    protected Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_penyakit);
        TextView textViewPenjelasan = (BootstrapButton) findViewById(R.id.textViewPenjelasan);
        TextView textViewGejala = (BootstrapButton) findViewById(R.id.textViewGejala);
        TextView textViewPenyebab = (BootstrapButton) findViewById(R.id.textViewPenyebab);
        TextView textViewPencegahan = (BootstrapButton) findViewById(R.id.textViewPencegahan);
        TextView textViewPengobatan = (BootstrapButton) findViewById(R.id.textViewPengobatan);
        setTitle(R.string.p04);
        textViewPenjelasan.setText(R.string.penjelasan04);
        textViewPenyebab.setText(R.string.penyebab_bakteri);
        textViewGejala.setText(R.string.gejala04);
        textViewPencegahan.setText(R.string.pencegahan04);
        textViewPengobatan.setText(R.string.pengobatan04);
    }
}