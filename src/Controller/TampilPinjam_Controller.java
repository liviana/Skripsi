/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Koneksi.Koneksi;
import Model.Model;
import View.Data_Pinjaman;
import View.Data_Simpan;
import View.TampilPinjam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LIVIANA FEBRIYANTI
 */
public class TampilPinjam_Controller {
    Connection conn = new Koneksi().connect();
    TampilPinjam pinjam;
    DefaultTableModel tabModel;
    Model model;
    String ID;
    
    
    public TampilPinjam_Controller(TampilPinjam pinjam) {
        this.pinjam=pinjam;
    }
    
    public void kembali(){
        pinjam.dispose();
    }
    public void tambahPinjaman(){
        Data_Pinjaman pinjaman=new Data_Pinjaman();
        pinjaman.setVisible(true);
        pinjam.dispose();
    }
    
    public void editPinjaman(){
        if (ID.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Silahkan Pilih Data Yang Ingin Di Edit");
        }else{
            Data_Pinjaman pinjaman=new Data_Pinjaman(ID);
            pinjaman.setVisible(true);
            pinjam.dispose();
        }
    }
    
    public void deleteData(){
        model=new Model();
        String sql = model.deletePinjam(ID);
        try {
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Berhasil Terhapus");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void tableClicked(){
        int bar = pinjam.TblPinjam.getSelectedRow();
        ID=tabModel.getValueAt(bar, 0).toString();
    }
    
    public void Table(){
        model=new Model();
        Object[] Baris = {"ID","Nomor Anggota","Nama Anggota","Total Pinjaman","Angsuran","Angsuran Ke","Sisa Angsuran","Tenor"};
        tabModel= new DefaultTableModel(null,Baris);
        pinjam.TblPinjam.setModel(tabModel);
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(model.TampilPinjam());
            while(hasil.next()){
                String ID = hasil.getString("id");
                String no = hasil.getString("no_anggota");
                String nama = hasil.getString("nm_anggota");
                String total = hasil.getString("total_pinjaman");
                String angsuran = hasil.getString("angsuran");
                String angsuranke = hasil.getString("angsuran_ke");
                String tenor = hasil.getString("sisa_angsur");
                String sisa = hasil.getString("tenor");
                String[] data = {ID,no,nama,total,angsuran,angsuranke,sisa,tenor};
                tabModel.addRow(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
