package com.application.abdur_rohman.dokter_lele;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.application.abdur_rohman.dokter_lele.basis.RiwayatPenyakit;
import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "dokter_lele_db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(RiwayatPenyakit.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + RiwayatPenyakit.NAMA_TABEL);
        onCreate(db);
    }

    public long insertRiwayatPenyakit(String riwayat_penyakit){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RiwayatPenyakit.KOLOM_PENYAKIT, riwayat_penyakit);
        long id = db.insert(RiwayatPenyakit.KOLOM_PENYAKIT, null, values);
        db.close();
        return id;
    }

    public RiwayatPenyakit getRiwayatPenyakit(long id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(RiwayatPenyakit.NAMA_TABEL,
                new String[]{RiwayatPenyakit.KOLOM_ID, RiwayatPenyakit.KOLOM_PENYAKIT, RiwayatPenyakit.KOLOM_TANGGAL},
                RiwayatPenyakit.KOLOM_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        RiwayatPenyakit riwayatPenyakit = new RiwayatPenyakit(
                cursor.getInt(cursor.getColumnIndex(RiwayatPenyakit.KOLOM_ID)),
                cursor.getString(cursor.getColumnIndex(RiwayatPenyakit.KOLOM_PENYAKIT)),
                cursor.getString(cursor.getColumnIndex(RiwayatPenyakit.KOLOM_TANGGAL)));
        cursor.close();
        return riwayatPenyakit;
    }

    public List<RiwayatPenyakit> getAllPenyakit(){
        List<RiwayatPenyakit> penyakits = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + RiwayatPenyakit.NAMA_TABEL;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()){
            do {
                RiwayatPenyakit riwayatPenyakit = new RiwayatPenyakit();
                    riwayatPenyakit.setId(cursor.getInt(cursor.getColumnIndex(RiwayatPenyakit.KOLOM_ID)));
                    riwayatPenyakit.setRiwayat_penyakit(cursor.getString(cursor.getColumnIndex(RiwayatPenyakit.KOLOM_PENYAKIT)));
                    riwayatPenyakit.setTanggal(cursor.getString(cursor.getColumnIndex(RiwayatPenyakit.KOLOM_TANGGAL)));
                penyakits.add(riwayatPenyakit);
            } while (cursor.moveToNext());
        }
        db.close();
        return penyakits;
    }

    public int getRiwayatPenyakitCount() {
        String countQuery = "SELECT * FROM " + RiwayatPenyakit.NAMA_TABEL;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public void deleteRiwayatPenyakit(RiwayatPenyakit penyakit) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(RiwayatPenyakit.NAMA_TABEL, RiwayatPenyakit.KOLOM_ID + " = ?",
                new String[]{String.valueOf(penyakit.getId())});
        db.close();
    }

    public String getRiwayat(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(RiwayatPenyakit.NAMA_TABEL,
                new String[]{RiwayatPenyakit.KOLOM_ID, RiwayatPenyakit.KOLOM_PENYAKIT, RiwayatPenyakit.KOLOM_TANGGAL},
                RiwayatPenyakit.KOLOM_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        String penyakit = cursor.getString(cursor.getColumnIndex(RiwayatPenyakit.KOLOM_PENYAKIT));
        return penyakit;
    }
}