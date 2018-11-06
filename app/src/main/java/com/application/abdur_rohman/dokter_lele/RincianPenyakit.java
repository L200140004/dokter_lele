package com.application.abdur_rohman.dokter_lele;

public class RincianPenyakit {
    //Inisialisasi variabel
    private int kode_dan_nama_penyakit;
    private int penjelasan;
    private int gejala;
    private int penyebab;
    private int cara_pencegahan;
    private int cara_pengobatan;
    private int idPenyakit;
    //Konstruktor
    public RincianPenyakit (int kode_dan_nama_penyakit,
                            int penjelasan,
                            int gejala,
                            int penyebab,
                            int cara_pencegahan,
                            int cara_pengobatan,
                            int idPenyakit){
        this.kode_dan_nama_penyakit = kode_dan_nama_penyakit;
        this.penjelasan = penjelasan;
        this.gejala = gejala;
        this.penyebab = penyebab;
        this.cara_pencegahan = cara_pencegahan;
        this.cara_pengobatan = cara_pengobatan;
        this.idPenyakit = idPenyakit;
    }
    //Cara mensplit data pada array
    public int perolehkode_dan_nama_penyakit(){
        return kode_dan_nama_penyakit;
    }
    public int perolehpenjelasan(){
        return penjelasan;
    }
    public int perolehgejala(){
        return gejala;
    }
    public int perolehpenyebab(){
        return penyebab;
    }
    public int perolehcara_pencegahan(){
        return cara_pencegahan;
    }
    public int perolehcara_pengobatan(){
        return cara_pengobatan;
    }
    public int perolehidPenyakit(){
        return idPenyakit;
    }
}