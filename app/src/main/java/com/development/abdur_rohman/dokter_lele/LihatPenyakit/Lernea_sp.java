package com.development.abdur_rohman.dokter_lele.LihatPenyakit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.development.abdur_rohman.dokter_lele.R;

public class Lernea_sp extends AppCompatActivity {
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
        setTitle(R.string.p11);
        textViewPenjelasan.setText(R.string.penjelasan11);
        textViewPenyebab.setText(R.string.penyebab_parasit);
        textViewPencegahan.setText(R.string.pencegahan11);
        textViewPengobatan.setText(R.string.pengobatan11);
        textViewGejala.setText(R.string.gejala11);
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
