package Model;

import java.util.*;

public class Manager extends Pegawai {
    private int tunjangan = 0; //in percent
    private List<Pegawai> bawahan;
    
    public Manager(String namaPegawai, double salary) {
        super(namaPegawai, salary);
    }
    
    public Manager(String idPegawai, String namaPegawai, double salary) {
        super(idPegawai,namaPegawai, salary);
    }
    
    public Manager(String idPegawai, String namaPegawai, double salary, int tunjangan) {
        super(idPegawai,namaPegawai, salary);
        this.tunjangan = tunjangan;
    }

    public void addBawahan(Pegawai p) {
        bawahan.add(p);
    }

    public int getTunjangan() {
        return tunjangan;
    }
    
    public void setTunjangan() {
        if(bawahan.size() > 5) {
            this.tunjangan = 30;
        } else if(bawahan.size() > 2) {
            this.tunjangan = 20;
        } else {
            this.tunjangan = 10;
        }
    }
    
    @Override
    public void setFinalSalary() {
        if(tunjangan == 0) {
            System.out.println("Subsidy not set.");
        } else {
            double salaryPlus = super.getSalary()*tunjangan;
            super.setSalary(super.getSalary() + salaryPlus);
        }
    }
    
    
}
