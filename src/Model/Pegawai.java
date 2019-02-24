package Model;

public abstract class Pegawai {
    private String idPegawai;
    private String namaPegawai;
    private double salary;
    private static int jumPegawai = 0;
    
    public Pegawai(String namaPegawai, double salary) {
        jumPegawai++;
        this.idPegawai = "EMP-" + jumPegawai;
        this.namaPegawai = namaPegawai;
        this.salary = salary;
    }

    public Pegawai(String idPegawai, String namaPegawai, double salary) {
        this.idPegawai = idPegawai;
        this.namaPegawai = namaPegawai;
        this.salary = salary;
    }

    public String getNamaPegawai() {
        return namaPegawai;
    }

    public void setNamaPegawai(String namaPegawai) {
        this.namaPegawai = namaPegawai;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getIdPegawai() {
        return idPegawai;
    }
    
    public abstract void setFinalSalary();
}
