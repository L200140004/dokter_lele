package com.development.abdur_rohman.dokter_lele;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.development.abdur_rohman.dokter_lele.LihatPenyakit.RincianGejala;

import java.util.ArrayList;

public class AdapterGejala extends BaseAdapter {
    //Inisialisasi variabel
    private static ArrayList<RincianGejala> listData;
    private LayoutInflater layout;
    //Konstruktor
    public AdapterGejala(Context context, ArrayList<RincianGejala> results){
        listData = results;
        layout = LayoutInflater.from(context);
    }
    //Mendapatkan jumlah baris
    public int getCount(){
        return listData.size();
    }
    //Mendapatkan item berdasarkan posisi
    public Object getItem(int position){
        return listData.get(position);
    }
    //Mendapatkan id pada item berdasarkan posisi
    public long getItemId(int position){
        return position;
    }
    //Mendapatkan tampilan listView dengan membuat custom layout pada datanya
    public View getView (int position, View view, ViewGroup parent){
        //Inisialisasi variabel
        ViewData vd;
        //Kondisi bila tampilan kosong
        if (view == null){
            //Menampilkan layout detail_penyakit
            view = layout.inflate(R.layout.detail_gejala, null);
            vd = new ViewData();
            //Inisialisasi TextView
            vd.textViewDetailGejala = (TextView) view.findViewById(R.id.textViewDetailGejala);
            //Mensetting tampilan text pada ListView
            view.setTag(vd);
        }
        else {
            vd = (ViewData) view.getTag();
        }
        //Menampilkan data kode_dan_nama_penyakit pada listData
        vd.textViewDetailGejala.setText(listData.get(position).getGejala());
        return view;
    }
    static class ViewData {
        TextView textViewDetailGejala;
    }
}
