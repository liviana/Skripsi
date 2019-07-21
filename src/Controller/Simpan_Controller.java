/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Data_Simpan;
import View.TampilSimpan;
import Model.*;
import Koneksi.*;
import View.Data_Pinjaman;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Muhamad Junaedi
 */
public class Simpan_Controller {
    Model model;
    DefaultTableModel tabModel;
    Connection conn=new Koneksi().connect();
    TampilSimpan tampil;
    String ID="";

    public Simpan_Controller(TampilSimpan tampil) {
        this.tampil=tampil;
    }
    public void kembali(){
        tampil.dispose();
    }
    public void tambahSimpan(){
        Data_Simpan simpan=new Data_Simpan();
        simpan.setVisible(true);
        tampil.dispose();
    }
    
    public void tableClicked(){
        int bar = tampil.tblSimpan.getSelectedRow();
        ID=tabModel.getValueAt(bar, 0).toString();
    }
    
    public void editSimpanan(){
        if (ID.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Silahkan Pilih Data Yang Ingin Di Edit");
        }else{
            Data_Simpan simpan=new Data_Simpan(ID);
            simpan.setVisible(true);
            tampil.dispose();
        }
    }
    //table
    public void DeleteSimpan(){
        Model model = new Model();
        try {
            PreparedStatement ps = conn.prepareStatement(model.deleteSimpan(ID));
            ps.executeUpdate();
            tableSimpan();
            JOptionPane.showMessageDialog(null,"Data Table Berhasil Terhapus");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void tableSimpan(){
        model=new Model();
        Object[] Baris = {"ID","Nomor Anggota","Nama Anggota","Tanggal Simpan","Simpanan Wajib","Simpanan Pokok","Simpanan Sukarela","Total"};
        tabModel= new DefaultTableModel(null,Baris);
        tampil.tblSimpan.setModel(tabModel);
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(model.tableSimpan());
            while(hasil.next()){
                String ID = hasil.getString("kd_simpan");
                String no = hasil.getString("no_anggota");
                String nama = hasil.getString("nm_anggota");
                String tgl = hasil.getString("tgl_simpan");
                String pokok = hasil.getString("simpanan_pokok");
                String wajib = hasil.getString("simpanan_wajib");
                String sukarela = hasil.getString("simpanan_sukarela");
                String total = hasil.getString("total");                
                String[] data = {ID,no,nama,tgl,wajib,pokok,sukarela,total};
                tabModel.addRow(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        };
        
    }
}
