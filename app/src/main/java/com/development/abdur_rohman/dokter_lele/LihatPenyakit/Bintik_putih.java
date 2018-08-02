package com.development.abdur_rohman.dokter_lele.LihatPenyakit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.development.abdur_rohman.dokter_lele.R;

public class Bintik_putih extends AppCompatActivity {
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
        setTitle(R.string.p08);
        textViewPenjelasan.setText(R.string.penjelasan08);
        textViewGejala.setText(R.string.gejala08);
        textViewPenyebab.setText(R.string.penyebab_parasit);
        textViewPencegahan.setText(R.string.pencegahan08);
        textViewPengobatan.setText(R.string.pengobatan08);
    }
}