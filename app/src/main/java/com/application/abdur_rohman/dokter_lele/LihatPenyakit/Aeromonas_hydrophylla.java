package com.application.abdur_rohman.dokter_lele.LihatPenyakit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.application.abdur_rohman.dokter_lele.R;

public class Aeromonas_hydrophylla extends AppCompatActivity {
    protected Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_penyakit);
        setTitle(R.string.p02);
        TextView textViewPenjelasan = (BootstrapButton) findViewById(R.id.textViewPenjelasan);
        TextView textViewGejala = (BootstrapButton) findViewById(R.id.textViewGejala);
        TextView textViewPenyebab = (BootstrapButton) findViewById(R.id.textViewPenyebab);
        TextView textViewPencegahan = (BootstrapButton) findViewById(R.id.textViewPencegahan);
        TextView textViewPengobatan = (BootstrapButton) findViewById(R.id.textViewPengobatan);
        textViewPenjelasan.setText(R.string.penjelasan02);
        textViewGejala.setText(R.string.gejala02);
        textViewPenyebab.setText(R.string.penyebab_bakteri);
        textViewPencegahan.setText(R.string.pencegahan02);
        textViewPengobatan.setText(R.string.pengobatan02);
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
