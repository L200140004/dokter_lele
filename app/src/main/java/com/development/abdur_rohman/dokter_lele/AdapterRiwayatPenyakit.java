package com.development.abdur_rohman.dokter_lele;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.development.abdur_rohman.dokter_lele.basis.RiwayatPenyakit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdapterRiwayatPenyakit extends RecyclerView.Adapter<AdapterRiwayatPenyakit.MyViewHolder> {

    private Context context;
    private List<RiwayatPenyakit> notesList;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.detail_riwayat, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AdapterRiwayatPenyakit.MyViewHolder holder, int position) {
        RiwayatPenyakit penyakit = notesList.get(position);

        holder.riwayat_penyakit.setText(penyakit.getRiwayat_penyakit());

        // Displaying dot from HTML character code
        holder.dot.setText(Html.fromHtml("&#8226;"));

        // Formatting and displaying timestamp
        holder.timestamp.setText(formatDate(penyakit.getTanggal()));
    }

    private String formatDate(String tanggal) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(tanggal);
            SimpleDateFormat fmtOut = new SimpleDateFormat("d MMMM yyyy");
            return fmtOut.format(date);
        } catch (ParseException e) {

        }
        return "";
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView riwayat_penyakit;
        public TextView dot;
        public TextView timestamp;

        public MyViewHolder(View view) {
            super(view);
            riwayat_penyakit = view.findViewById(R.id.riwayat);
            dot = view.findViewById(R.id.titik);
            timestamp = view.findViewById(R.id.tanggal);
        }
    }

    public AdapterRiwayatPenyakit(Context context, List<RiwayatPenyakit> notesList){
        this.context = context;
        this.notesList = notesList;
    }
}
