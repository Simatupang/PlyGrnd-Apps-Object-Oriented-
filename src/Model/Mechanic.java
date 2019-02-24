package Model;

import java.util.*;

public class Mechanic extends Pegawai {
    private List<Wahana> fixedWahana = new ArrayList();
    
    public Mechanic(String namaPegawai, double salary) {
        super(namaPegawai, salary);
    }
    
    public Mechanic(String idPegawai, String namaPegawai, double salary) {
        super(idPegawai, namaPegawai, salary);
    }

    @Override
    public void setFinalSalary() {
        double finSalary = fixedWahana.size()*(super.getSalary()/10);
        super.setSalary(super.getSalary()+finSalary);
    }
    
}
