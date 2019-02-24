package Controller;

import Model.Toko;
import Model.Souvenir;
import Model.Wahana;
import Model.Operator;
import Model.Pegawai;
import Model.Manager;
import Model.Application;
import Model.Food;
import Model.Application;
import View.AMP;
import View.PegawaiAdder;
import View.TokoAdder;
import View.WahanaAdder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class Handler implements ActionListener {
    private Application model;
    private AMP view;
    private PegawaiAdder viewPgw;
    private TokoAdder viewToko;
    private WahanaAdder viewWhn;
    
    public Handler() {
        model = new Application();
        view = new AMP();
        viewPgw = new PegawaiAdder();
        viewToko = new TokoAdder();
        viewWhn = new WahanaAdder();
        view.setVisible(true);
        
        view.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        try {
            if (source.equals(view.getBtnAddWhn())) {
                WahanaAdder wa = new WahanaAdder();
                wa.setVisible(true);
                if(source.equals(viewWhn.getStatusBut1())) {
                    String namaWahana = viewWhn.getTfWahana();
                    String deskripsi = viewWhn.getTxDesc();
                    int kapasitas = viewWhn.getTfKapasitas();
                    int durasi = viewWhn.getSpDurasi();
                    int minTB = viewWhn.getTfTB();
                    model.editWahana(namaWahana, deskripsi, kapasitas, durasi, minTB);
                    view.reset();
                }
                
                
            } 
        } catch (Exception e) {
            view.reset();
        }
    }
    
}
