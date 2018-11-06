package com.application.abdur_rohman.dokter_lele;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.application.abdur_rohman.dokter_lele.LihatPenyakit.Aeromonas_hydrophylla;
import com.application.abdur_rohman.dokter_lele.LihatPenyakit.Aeromonas_punctata;
import com.application.abdur_rohman.dokter_lele.LihatPenyakit.Bintik_putih;
import com.application.abdur_rohman.dokter_lele.LihatPenyakit.Columnaris;
import com.application.abdur_rohman.dokter_lele.LihatPenyakit.Edwardsiella;
import com.application.abdur_rohman.dokter_lele.LihatPenyakit.Gatal;
import com.application.abdur_rohman.dokter_lele.LihatPenyakit.Jamur_putih;
import com.application.abdur_rohman.dokter_lele.LihatPenyakit.Lernea_sp;
import com.application.abdur_rohman.dokter_lele.LihatPenyakit.Pseudomonas_hydrophylla;
import com.application.abdur_rohman.dokter_lele.LihatPenyakit.Trematoda;
import com.application.abdur_rohman.dokter_lele.LihatPenyakit.Tuberculosis;
import com.application.abdur_rohman.dokter_lele.basis.RecyclerTouchListener;
import com.application.abdur_rohman.dokter_lele.basis.RiwayatPenyakit;
import java.util.ArrayList;
import java.util.List;

public class RiwayatPenyakiIkanLele extends AppCompatActivity{
    public static AdapterRiwayatPenyakit mAdapter;
    public static List<RiwayatPenyakit> list_penyakit = new ArrayList<>();
    private RecyclerView recyclerView;
    public TextView noNotesView;
    public DatabaseHelper db;
    private Toolbar toolbar;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar_riwayat_penyakit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.recycler_view);
        noNotesView = findViewById(R.id.riwayat_penyakit_kosong);
        db = new DatabaseHelper(this);
        list_penyakit.clear();
        list_penyakit.addAll(db.getAllPenyakit());
        mAdapter = new AdapterRiwayatPenyakit(this, list_penyakit);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.VERTICAL, 8));
        recyclerView.setAdapter(mAdapter);
        toggleEmptyNotes();
        mAdapter.notifyDataSetChanged();

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                showActionsDialog(position);
            }

            @Override
            public void onLongClick(View view, int position) {
                showActionsDialog(position);
            }
        }));
    }

    private void showActionsDialog(final int position) {
        CharSequence colors[] = new CharSequence[]{"View", "Delete"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose an action on this item!");
        builder.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0){
                    if (list_penyakit.get(position).getRiwayat_penyakit().equals("Pseudomonas hydrophylla")){
                        Intent penyakit = new Intent(getApplicationContext(), Pseudomonas_hydrophylla.class);
                        startActivity(penyakit);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    } else if (list_penyakit.get(position).getRiwayat_penyakit().equals("Aeromonas hydrophylla")){
                        Intent penyakit = new Intent(getApplicationContext(), Aeromonas_hydrophylla.class);
                        startActivity(penyakit);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    } else if (list_penyakit.get(position).getRiwayat_penyakit().equals("Aeromonas punctata")){
                        Intent penyakit = new Intent(getApplicationContext(), Aeromonas_punctata.class);
                        startActivity(penyakit);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    } else if (list_penyakit.get(position).getRiwayat_penyakit().equals("Columnaris")){
                        Intent penyakit = new Intent(getApplicationContext(), Columnaris.class);
                        startActivity(penyakit);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    } else if (list_penyakit.get(position).getRiwayat_penyakit().equals("Edwardsiella")){
                        Intent penyakit = new Intent(getApplicationContext(), Edwardsiella.class);
                        startActivity(penyakit);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    } else if (list_penyakit.get(position).getRiwayat_penyakit().equals("Tuberculosis")){
                        Intent penyakit = new Intent(getApplicationContext(), Tuberculosis.class);
                        startActivity(penyakit);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    } else if (list_penyakit.get(position).getRiwayat_penyakit().equals("Jamur putih")){
                        Intent penyakit = new Intent(getApplicationContext(), Jamur_putih.class);
                        startActivity(penyakit);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    } else if (list_penyakit.get(position).getRiwayat_penyakit().equals("Bintik Putih (White spot)")){
                        Intent penyakit = new Intent(getApplicationContext(), Bintik_putih.class);
                        startActivity(penyakit);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    } else if (list_penyakit.get(position).getRiwayat_penyakit().equals("Gatal")){
                        Intent penyakit = new Intent(getApplicationContext(), Gatal.class);
                        startActivity(penyakit);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    } else if (list_penyakit.get(position).getRiwayat_penyakit().equals("Trematoda")){
                        Intent penyakit = new Intent(getApplicationContext(), Trematoda.class);
                        startActivity(penyakit);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    } else if (list_penyakit.get(position).getRiwayat_penyakit().equals("Lernea sp.")){
                        Intent penyakit = new Intent(getApplicationContext(), Lernea_sp.class);
                        startActivity(penyakit);
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    } else {
                        Toast.makeText(getApplicationContext(),R.string.halaman_kosong, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    deleteRiwayatPenyakit(position);
                }
            }
        });
        builder.show();
    }

    private void deleteRiwayatPenyakit(int position){
        db.deleteRiwayatPenyakit(list_penyakit.get(position));
        list_penyakit.remove(position);
        mAdapter.notifyItemRemoved(position);
        toggleEmptyNotes();
    }

    private void toggleEmptyNotes(){
        if (db.getRiwayatPenyakitCount() > 0) {
            noNotesView.setVisibility(View.INVISIBLE);
        } else {
            noNotesView.setVisibility(View.VISIBLE);
        }
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
