package Model;

public class Operator extends Pegawai {
    private Wahana wahana;
    
    public Operator(String nama, double salary) {
        super(nama,salary);
    }
    
    public Operator(String idPegawai, String nama, double salary) {
        super(idPegawai,nama,salary);
    }

    @Override
    public void setFinalSalary() {
        super.setSalary(super.getSalary());
    }
}
