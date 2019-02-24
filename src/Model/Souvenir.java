package Model;

import java.util.List;

public class Souvenir extends Toko {
    private List<String> Goods;

    public Souvenir(String namaToko) {
        super(namaToko);
    }
    
    public void addGoods(String s) {
        Goods.add(s);
    }
    
    @Override
    public String toString() {
        String s = "Barang yang dijual: \n";
        for(String g: Goods) {
            s += "- "+g+"\n";
        }
        return s;
    }
}
