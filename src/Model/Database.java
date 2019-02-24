package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Database {
    private String server = "jdbc:mysql://localhost/amsmntprk";
    private String dbuser = "root";
    private String dbpasswd = "";
    private Statement statement = null;
    private Connection connection = null;

    public void connect() {
        try {
            connection = DriverManager.getConnection(server, dbuser, dbpasswd);
            statement = connection.createStatement();
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat menyambungkan database!");
        }
    }
    
    //------------------------WAHANA---------------------------
    
    public void saveWahana(Wahana w) {
        try {
            String query = "insert into wahana(namaWahana,deskripsi,kapasitas,durasi,minTinggiBadan) values('"
                    + w.getNamaWahana() + "','"
                    + w.getDeskripsi() + "','"
                    + w.getKapasitas() + "','"
                    + w.getDurasi() + "','"
                    + w.getMinTinggiBadan() +"')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat save wahana!");
        }
    }
    
    public ArrayList<Wahana> loadWahana() {
        try {
            ArrayList<Wahana> daftarWahana = new ArrayList();
            String query = "select * from wahana";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                Wahana w = new Wahana(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                daftarWahana.add(w);
            }
            return daftarWahana;
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat load wahana!");
        }
    }
    
    public void deleteWahana(String namaWahana) {
          try{
              String query = "delete from wahana where namaWahana = '"+namaWahana+"'";
              statement.executeUpdate(query);
          }catch(Exception e){
              throw new IllegalArgumentException("Terjadi kesalahan saat delete wahana!");
          }
    }
    
    public void UpdateWahana(Wahana w, String namaWahana) {
          try{ 
              String query = "update wahana set "
                      +"namaWahana = '"+w.getNamaWahana()
                      +"',deskripsi = '"+w.getDeskripsi()
                      +"',kapasitas = '"+w.getKapasitas()
                      +"',durasi = '"+w.getDurasi()
                      +"',minTinggiBadan = '"+w.getMinTinggiBadan()
                      +"' WHERE namaWahana = '"+namaWahana+"'"; 
              statement.executeUpdate(query);
          }catch(Exception e){
              throw new IllegalArgumentException("Terjadi kesalahan proses update wahana!");
          }
    }
    
    //------------------------PENGUNJUNG---------------------------
    
    public void savePengunjung(Pengunjung p) {
        try {
            String query = "insert into pengunjung(ticketID,status) values('"
                    + p.getTicketID() + "','"
                    + p.getStatus() + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat save pengunjung!");
        }
    }
    
    public ArrayList<Pengunjung> loadPengunjung() {
        try {
            ArrayList<Pengunjung> daftarPengunjung = new ArrayList();
            String query = "select * from pengunjung";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                Pengunjung p = new Pengunjung(rs.getInt(1), rs.getInt(2));
                daftarPengunjung.add(p);
            }
            return daftarPengunjung;
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat load pengunjung!");
        }
    }
    
    public void deletePengunjung(int ticketID) {
          try {
              String query = "delete from wahana where ticketID = '"+ticketID+"'";
              statement.executeUpdate(query);
          } catch (Exception e) {
              throw new IllegalArgumentException("Terjadi kesalahan saat delete pengunjung!");
          }
    }
    
    public void UpdatePengunjung(Pengunjung p, int ticketID) {
          try { 
              String query = "update pengunjung set "
                      +"ticketID = '"+p.getTicketID()
                      +"',status = '"+p.getStatus()
                      +"' WHERE ticketID = '"+ticketID+"'"; 
              statement.executeUpdate(query);
          } catch (Exception e) {
              throw new IllegalArgumentException("Terjadi kesalahan proses update pengunjung!");
          }
    }
    
    //------------------------MANAGER---------------------------
    
    public void saveManager(Manager mg) {
        try {
            String query = "insert into manager(idManager,namaManager,gajiManager,tunjangan) values('"
                    + mg.getIdPegawai() + "','"
                    + mg.getNamaPegawai() + "','"
                    + mg.getSalary() + "','"
                    + mg.getTunjangan() + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat save manager!");
        }
    }
    
    public ArrayList<Manager> loadManager() {
        try {
            ArrayList<Manager> daftarManager = new ArrayList();
            String query = "select * from manager";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                Manager mg = new Manager(rs.getString(1), rs.getString(2),rs.getDouble(3),rs.getInt(4));
                daftarManager.add(mg);
            }
            return daftarManager;
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat load manager!");
        }
    }
    
    public void deleteManager(String idManager) {
          try {
              String query = "delete from manager where idManager = '"+idManager+"'";
              statement.executeUpdate(query);
          } catch (Exception e) {
              throw new IllegalArgumentException("Terjadi kesalahan saat delete pengunjung!");
          }
    }
    
    public void UpdateManager(Manager m, String idManager) {
          try { 
              String query = "update manager set "
                      +"idManager = '"+m.getIdPegawai()
                      +"',namaManager = '"+m.getNamaPegawai()
                      +"',gajiManager = '"+m.getSalary()
                      +"',tunjangan = '"+m.getTunjangan()
                      +"' WHERE idManager = '"+idManager+"'"; 
              statement.executeUpdate(query);
          } catch (Exception e) {
              throw new IllegalArgumentException("Terjadi kesalahan proses update pengunjung!");
          }
    }
    //------------------------MECHANIC---------------------------
    
    public void saveMechanic(Mechanic mc) {
        try {
            String query = "insert into mechanic(idPegawai,namaPegawai,salary) values('"
                    + mc.getIdPegawai() + "','"
                    + mc.getNamaPegawai() + "','"
                    + mc.getSalary() + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat save mechanic!");
        }
    }
    
    public ArrayList<Mechanic> loadMechanic() {
        try {
            ArrayList<Mechanic> daftarMechanic = new ArrayList();
            String query = "select * from mechanic";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                Mechanic mc = new Mechanic(rs.getString(1), rs.getString(2), rs.getDouble(2));
                daftarMechanic.add(mc);
            }
            return daftarMechanic;
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat load mechanic!");
        }
    }
    
    public void deleteMechanic(String idPegawai) {
          try {
              String query = "delete from mechanic where idMechanic = '"+idPegawai+"'";
              statement.executeUpdate(query);
          } catch (Exception e) {
              throw new IllegalArgumentException("Terjadi kesalahan saat delete mechanic!");
          }
    }
    
    public void UpdateMechanic(Mechanic m, String idPegawai) {
          try { 
              String query = "update mechanic set "
                      +"idMechanic = '"+m.getIdPegawai()
                      +"',namaMechanic = '"+m.getNamaPegawai()
                      +"',gajiMechanic = '"+m.getSalary()
                      +"' WHERE idMechanic = '"+idPegawai+"'"; 
              statement.executeUpdate(query);
          } catch (Exception e) {
              throw new IllegalArgumentException("Terjadi kesalahan proses update mechanic!");
          }
    }
    //------------------------OPERATOR---------------------------
    
    public void saveOperator(Operator op) {
        try {
            String query = "insert into operator(idPegawai,nama,salary) values('"
                    + op.getIdPegawai() + "','"
                    + op.getNamaPegawai() + "','"
                    + op.getSalary() + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat save mechanic!");
        }
    }
    
    public ArrayList<Operator> loadOperator() {
        try {
            ArrayList<Operator> daftarOperator = new ArrayList();
            String query = "select * from operator";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                Operator op = new Operator(rs.getString(1), rs.getString(2), rs.getDouble(2));
                daftarOperator.add(op);
            }
            return daftarOperator;
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat load operator!");
        }
    }
    
    public void deleteOperator(String idPegawai) {
          try {
              String query = "delete from mechanic where idOperator = '"+idPegawai+"'";
              statement.executeUpdate(query);
          } catch (Exception e) {
              throw new IllegalArgumentException("Terjadi kesalahan saat delete oeprator!");
          }
    }
    
    public void UpdateOperator(Operator o, String idPegawai) {
          try { 
              String query = "update operator set "
                      +"idOperator = '"+o.getIdPegawai()
                      +"',namaOperator = '"+o.getNamaPegawai()
                      +"',gajiOperator = '"+o.getSalary()
                      +"' WHERE idOperator = '"+idPegawai+"'"; 
              statement.executeUpdate(query);
          } catch (Exception e) {
              throw new IllegalArgumentException("Terjadi kesalahan proses update operator!");
          }
    }
        //------------------------FOOD---------------------------
    
    public void saveFood(Food fd) {
        try {
            String query = "insert into food(namaToko) values('"
                    + fd.getNamaToko() + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat save food!");
        }
    }
    
    public ArrayList<Food> loadFood() {
        try {
            ArrayList<Food> daftarFood = new ArrayList();
            String query = "select * from food";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                Food fd = new Food(rs.getString(1));
                daftarFood.add(fd);
            }
            return daftarFood;
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat load food!");
        }
    }
    
    public void deleteFood(String namaToko) {
          try {
              String query = "delete from food where namaToko = '"+namaToko+"'";
              statement.executeUpdate(query);
          } catch (Exception e) {
              throw new IllegalArgumentException("Terjadi kesalahan saat delete food!");
          }
    }
    
    public void UpdateFood(Food f, String namaToko) {
          try { 
              String query = "update food set "
                      +"namaToko = '"+f.getNamaToko()
                      +"' WHERE namaToko = '"+namaToko+"'"; 
              statement.executeUpdate(query);
          } catch (Exception e) {
              throw new IllegalArgumentException("Terjadi kesalahan proses update food!");
          }
    }
        //------------------------SOUVENIR---------------------------
    
    public void saveSouvenir(Souvenir sv) {
        try {
            String query = "insert into souvenir(namaToko) values('"
                    + sv.getNamaToko() + "')";
            statement.execute(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat save souvenir!");
        }
    }
    
    public ArrayList<Souvenir> loadSouvenir() {
        try {
            ArrayList<Souvenir> daftarSouvenir = new ArrayList();
            String query = "select * from souvenir";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                Souvenir sv = new Souvenir(rs.getString(1));
                daftarSouvenir.add(sv);
            }
            return daftarSouvenir;
        } catch (Exception e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat load souvenir!");
        }
    }
    
    public void deleteSouvenir(String namaToko) {
          try {
              String query = "delete from souevnir where namaToko = '"+namaToko+"'";
              statement.executeUpdate(query);
          } catch (Exception e) {
              throw new IllegalArgumentException("Terjadi kesalahan saat delete souvenir!");
          }
    }
    
    public void UpdateSouvenir(Souvenir s, String namaToko) {
          try { 
              String query = "update souvenir set "
                      +"namaToko = '"+s.getNamaToko()
                      +"' WHERE namaToko = '"+namaToko+"'"; 
              statement.executeUpdate(query);
          } catch (Exception e) {
              throw new IllegalArgumentException("Terjadi kesalahan proses update souvenir!");
          }
    }
}
