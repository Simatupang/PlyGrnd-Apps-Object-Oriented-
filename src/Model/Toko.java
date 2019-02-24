package Model;

public abstract class Toko {
    private String namaToko;

    public Toko(String namaToko) {
        this.namaToko = namaToko;
    }
    
    public String getNamaToko() {
        return namaToko;
    }

    public void setNamaToko(String namaToko) {
        this.namaToko = namaToko;
    }
    
    
}
