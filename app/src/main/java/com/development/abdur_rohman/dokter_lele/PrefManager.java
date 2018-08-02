package com.development.abdur_rohman.dokter_lele;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String NAMA_PREF = "dokter_lele";

    private static final String PERTAMA_KALI = "pertamaKali";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(NAMA_PREF, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(PERTAMA_KALI, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(PERTAMA_KALI, true);
    }

}

