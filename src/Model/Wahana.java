package Model;

public class Wahana {
    private String namaWahana;
    private String deskripsi;
    private int kapasitas;
    private int durasi; //in seconds
    private int minTinggiBadan;

    public Wahana(String namaWahana, String deskripsi, int kapasitas, int durasi, int minTinggiBadan) {
        this.namaWahana = namaWahana;
        this.deskripsi = deskripsi;
        this.kapasitas = kapasitas;
        this.durasi = durasi;
        this.minTinggiBadan = minTinggiBadan;
    }
    
    public void setNamaWahana(String nama) {
        this.namaWahana = nama;
    }
    
    public String getNamaWahana() {
        return this.namaWahana;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    
    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public int getDurasi() {
        return durasi;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }

    public int getMinTinggiBadan() {
        return minTinggiBadan;
    }

    public void setMinTinggiBadan(int minTinggiBadan) {
        this.minTinggiBadan = minTinggiBadan;
    }

    @Override
    public String toString() {
        return "Nama Wahana : " + namaWahana 
                + "\nDeskripsi : " + deskripsi 
                + "\nKapasitas : " + kapasitas 
                + "\nDurasi : " + durasi 
                + "\nTinggi Badan Minimal : " + minTinggiBadan+"\n";
    }
}
