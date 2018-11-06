package com.application.abdur_rohman.dokter_lele.LihatPenyakit;

public class RincianGejala {
    private int idGejala;
    private int gejala;

    public RincianGejala (int idGejala,
                          int gejala) {
        this.idGejala = idGejala;
        this.gejala = gejala;
    }

    public int getGejala() {
        return gejala;
    }

    public int getIdGejala() {
        return idGejala;
    }

    public void setGejala(int gejala) {
        this.gejala = gejala;
    }

    public void setIdGejala(int idGejala) {
        this.idGejala = idGejala;
    }
}
