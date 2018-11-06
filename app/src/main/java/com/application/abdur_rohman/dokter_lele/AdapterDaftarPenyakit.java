package com.application.abdur_rohman.dokter_lele;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class AdapterDaftarPenyakit extends BaseAdapter {
    //Inisialisasi variabel
    private static ArrayList<RincianPenyakit> listData;
    private LayoutInflater layout;
    //Konstruktor
    public AdapterDaftarPenyakit(Context context, ArrayList<RincianPenyakit> results){
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
            view = layout.inflate(R.layout.detail_penyakit, null);
            vd = new ViewData();
            //Inisialisasi TextView
            vd.textViewPenyakit = (TextView) view.findViewById(R.id.textViewPenyakit);
            //Mensetting tampilan text pada ListView
            view.setTag(vd);
        }
        else {
            vd = (ViewData) view.getTag();
        }
        //Menampilkan data kode_dan_nama_penyakit pada listData
        vd.textViewPenyakit.setText(listData.get(position).perolehkode_dan_nama_penyakit());
        return view;
    }
    static class ViewData {
        TextView textViewPenyakit;
    }
}