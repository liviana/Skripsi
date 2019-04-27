/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Koneksi.Koneksi;
import Model.Model;
import View.Data_Anggota;
import View.TampilAnggota;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Liviana
 */
public class Anggota_Controller {
    TampilAnggota tampil;
    Model model;
    DefaultTableModel tabModel;
    Connection conn = new Koneksi().connect();
    
    public Anggota_Controller(TampilAnggota tampil) {
        this.tampil = tampil;
    }
    public void kembali(){    
        tampil.dispose();
    }
    public void tambahAnggota(){
        Data_Anggota anggota=new Data_Anggota();
        anggota.setVisible(true);
        tampil.dispose();
    }
    //table
    public void dataTable(){
        model=new Model();
        Object[] Baris = {"Nomor Anggota","Nama Anggota","Tempat Tanggal Lahir","Jenis Kelamin","No Telpon","Alamat","Divisi","Tanggal Masuk"};
        tabModel= new DefaultTableModel(null,Baris);
        tampil.tblAnggota.setModel(tabModel);
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(model.tableAnggota());
            while(hasil.next()){
                String no = hasil.getString("no_anggota");
                String nama = hasil.getString("nm_anggota");
                String tempat = hasil.getString("tempat_lahir");
                String tanggal = hasil.getString("tgl_lahir");
                String jk = hasil.getString("jenis_kelamin");
                String alamat = hasil.getString("alamat");
                String telpon = hasil.getString("no_tlp");
                String divisi = hasil.getString("divisi");
                String masuk=hasil.getString("tgl_masuk");                
                String[] data = {no,nama,tempat+","+tanggal,jk,alamat,telpon,divisi,masuk};
                tabModel.addRow(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //table
}
