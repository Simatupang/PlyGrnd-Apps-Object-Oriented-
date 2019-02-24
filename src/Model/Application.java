package Model;

import java.util.*;

public class Application {
    private List<Wahana> listWahana = new ArrayList();
    private List<Pengunjung> listPengunjung = new ArrayList();
    private List<Food> listFood = new ArrayList();
    private List<Souvenir> listSouvenir = new ArrayList();
    private List<Manager> listManager = new ArrayList();
    private List<Operator> listOperator = new ArrayList();
    private List<Mechanic> listMechanic = new ArrayList();
    Database db;

    public Application() {
        db = new Database();
        db.connect();
        listWahana = db.loadWahana();
        listPengunjung = db.loadPengunjung();
        listFood = db.loadFood();
        listSouvenir = db.loadSouvenir();
        listManager = db.loadManager();
        listOperator = db.loadOperator();
        listMechanic = db.loadMechanic();
    }
    
    public void addWahana(String namaWahana, String deskripsi, int kapasitas, int durasi, int minTinggiBadan) {
        if (getWahana(namaWahana) != null) {
            throw new IllegalArgumentException("Wahana sudah terdaftar!");
        }
        Wahana w = new Wahana(namaWahana,deskripsi,kapasitas,durasi,minTinggiBadan);
        listWahana.add(w);
        db.saveWahana(w);
    }
    
    public Wahana getWahana(String namaWahana) {
        for(Wahana w : listWahana) {
            if(w.getNamaWahana().equals(namaWahana)) {
                return w;
            }
        }
        return null;
    }
    
    public void hapusWahana(String namaWahana) {
        boolean found = false;
        Wahana w = null;
        for (Wahana wh : listWahana) {
            if(wh.getNamaWahana().equals(namaWahana)) {
                found = true;
                w = wh;
            }
        }
        if(found) {
            db.deleteWahana(namaWahana);
            listWahana.remove(w);
        } else {
            throw new IllegalArgumentException("Wahana tidak terdaftar");
        }
    }
    
    public void editWahana(String namaWahana, String deskripsi, int kapasitas, int durasi, int minTinggiBadan) {
        Wahana w = new Wahana(namaWahana,deskripsi,kapasitas,durasi,minTinggiBadan);        
        db.UpdateWahana(w, namaWahana);
        listWahana = db.loadWahana();
    }
    
    public String viewWahana() {
        String s = "";
        for(Wahana w:listWahana) {
            s += w.toString();
        } return s;
    }
    
    public Pegawai getPegawai(String idPegawai) {
        for(Manager mg:listManager) {
            if(mg.getIdPegawai().equals(idPegawai)) return mg;
        } for(Operator o:listOperator) {
            if(o.getIdPegawai().equals(idPegawai)) return o;
        } for(Mechanic m:listMechanic) {
            if(m.getIdPegawai().equals(idPegawai)) return m;
        } return null;
    }
    
    public void addManager(String idPegawai, String namaPegawai, double salary, int tunjangan) {
        if (getPegawai(idPegawai) != null) {
            throw new IllegalArgumentException("Pegawai sudah terdaftar!");
        }
        Manager mg = new Manager(idPegawai,namaPegawai,salary);
        listManager.add(mg);
        db.saveManager(mg);
    }
    
    public void addMechanic(String idPegawai, String namaPegawai, double salary, int tunjangan) {
        if (getPegawai(idPegawai) != null) {
            throw new IllegalArgumentException("Pegawai sudah terdaftar!");
        }
        Mechanic m = new Mechanic(idPegawai,namaPegawai,salary);
        listMechanic.add(m);
        db.saveMechanic(m);
    }
    
    public void addOperator(String idPegawai, String namaPegawai, double salary, int tunjangan) {
        if (getPegawai(idPegawai) != null) {
            throw new IllegalArgumentException("Pegawai sudah terdaftar!");
        }
        Operator o = new Operator(idPegawai,namaPegawai,salary);
        listOperator.add(o);
        db.saveOperator(o);
    }
    
    public void hapusPegawai(String idPegawai) {
        boolean found = false;
        Manager mg = null;
        Operator o = null;
        Mechanic m = null;
        for (Manager mn:listManager) {
            if(mn.getIdPegawai().equals(idPegawai)) {
                found = true;
                mg = mn;
            }
        }
        for (Operator op:listOperator) {
            if(op.getIdPegawai().equals(idPegawai)) {
                found = true;
                o = op;
            }
        }
        for (Mechanic mc:listMechanic) {
            if(mc.getIdPegawai().equals(idPegawai)) {
                found = true;
                m = mc;
            }
        }
        if(found) {
            if(mg != null) {
                db.deleteManager(idPegawai);
                listManager.remove(mg);
            } else if(o != null) {
                db.deleteOperator(idPegawai);
                listOperator.remove(o);
            } else {
                db.deleteMechanic(idPegawai);
                listMechanic.remove(m);
            }
        } else {
            throw new IllegalArgumentException("Pegawai tidak terdaftar");
        }
    }
    
    public void editPegawai(String idPegawai, String namaPegawai, double salary) {
        Manager mg = null;
        Operator o = null;
        Mechanic m = null;
        if(getPegawai(idPegawai).getClass().equals(mg)) {
            mg = new Manager(idPegawai,namaPegawai,salary);
            db.UpdateManager(mg, idPegawai);
            listManager = db.loadManager();
        } else if(getPegawai(idPegawai).getClass().equals(o)) {
            o = new Operator(idPegawai,namaPegawai,salary);
            db.UpdateOperator(o, idPegawai);
            listOperator = db.loadOperator();
        } else {
            m = new Mechanic(idPegawai,namaPegawai,salary);
            db.UpdateMechanic(m, idPegawai);
            listMechanic = db.loadMechanic();
        }
    }
}
