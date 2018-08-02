package com.development.abdur_rohman.dokter_lele.basis;

public class RiwayatPenyakit {

    public static final String NAMA_TABEL = "riwayat_penyakit";
    public static final String KOLOM_ID = "id";
    public static final String KOLOM_PENYAKIT = "riwayat_penyakit";
    public static final String KOLOM_TANGGAL = "tanggal";

    private int id;
    private String riwayat_penyakit;
    private String tanggal;

    public static final String CREATE_TABLE = "CREATE TABLE " + NAMA_TABEL + " (" +
            KOLOM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            KOLOM_PENYAKIT + " TEXT," +
            KOLOM_TANGGAL + " DATETIME DEFAULT CURRENT_TIMESTAMP" + ")";


    public RiwayatPenyakit(){

    }

    public RiwayatPenyakit(int id, String riwayat_penyakit, String tanggal){
        this.id = id;
        this.riwayat_penyakit = riwayat_penyakit;
        this.tanggal = tanggal;
    }

    public int getId(){
        return id;
    }
    public String getRiwayat_penyakit() {
        return riwayat_penyakit;
    }
    public void setRiwayat_penyakit(String riwayat_penyakit){
        this.riwayat_penyakit = riwayat_penyakit;
    }
    public String getTanggal() {
        return tanggal;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
