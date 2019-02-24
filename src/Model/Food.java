package Model;

import java.util.*;

public class Food extends Toko {
    private List<String> Menu;

    public Food(String namaToko, List<String> Menu) {
        super(namaToko);
        this.Menu = Menu;
    }
    
    public Food(String namaToko) {
        super(namaToko);
    }
    
    public void addMenu(String f) {
        Menu.add(f);
    }
    
    @Override
    public String toString() {
        String s = "Menu : \n";
        for(String m: Menu) {
            s += "- "+m+"\n";
        }
        return s;
    }
}
