/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Koneksi.Koneksi;
import Model.*;
import View.Data_Anggota;
import View.TampilAnggota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Muhamad Junaedi
 */
public class DAnggota_Controller {
    Data_Anggota anggota;
    Model model;
    Connection conn = new Koneksi().connect();
    
    public DAnggota_Controller(Data_Anggota anggota) {
        this.anggota=anggota;
    }
    public void kembali(){
        anggota.dispose();
    }
    private String getTanggal(){      
        String hari=anggota.cbTanggal.getSelectedItem().toString();
        String Bulan=anggota.cbBulan.getSelectedItem().toString();
        if(Bulan=="Januari"){
            Bulan="01";
        }else if(Bulan=="Februari"){
            Bulan="02";
        }else if(Bulan=="Maret"){
            Bulan="03";
        }else if(Bulan=="April"){
            Bulan="04";
        }else if(Bulan=="Mei"){
            Bulan="05";
        }else if(Bulan=="Juni"){
            Bulan="06";
        }else if(Bulan=="Juli"){
            Bulan="07";
        }else if(Bulan=="Agustus"){
            Bulan="08";
        }else if(Bulan=="September"){
            Bulan="09";
        }else if(Bulan=="Oktober"){
            Bulan="10";
        }else if(Bulan=="November"){
            Bulan="11";
        }else if(Bulan=="Desember"){
            Bulan="12";
        }
        String tahun=anggota.cbTahun.getSelectedItem().toString();
        String tanggal=tahun+"-"+Bulan+"-"+hari;
        return tanggal;
    }
    private String getJK(){
        anggota.radLaki.setActionCommand("Laki-laki");
        anggota.radPerempuan.setActionCommand("Perempuan");
        String JK = (anggota.JKGroup.getSelection().getActionCommand());
        return JK;
    }
    private String getTanggalSekarang(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date dtBaru = new java.util.Date();
        String tgl = sdf.format(dtBaru);
        return tgl;
    }
    public void checkAnggota(int id){
        model=new Model();
        try {
            java.sql.Statement st= conn.createStatement();
            ResultSet rss= st.executeQuery(model.cariAnggota(anggota.tfnomor.getText()));
            if (rss.next()) {
                if (id>0) {
                    InputData(id);
                }else{
                    JOptionPane.showMessageDialog(null,"No Anggota Telah Digunakan");
                }
            }else{
                InputData(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void InputData(int id){
        if (id>0) {
            UpdateAnggota(id);
        }else if(id<=0){
            SaveAnggota();
        }
    }
    public void UpdateAnggota(int id){
        model=new Model();
        try {
            PreparedStatement ps = conn.prepareStatement(model.editAnggota(String.valueOf(id)));
            ps.setString(1,anggota.tfnama.getText());
            ps.setString(2,anggota.tfTTL.getText());
            ps.setString(3,getTanggal());
            ps.setString(4,getJK());
            ps.setString(5,anggota.tfAlamat.getText());
            ps.setString(6,anggota.tfTlp.getText());
            ps.setString(7,anggota.tfDivisi.getText());
            ps.setString(8,getTanggalSekarang());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Anggota Berhasil Terdaftar");
            TampilAnggota tampil=new TampilAnggota();
            tampil.setVisible(true);
            anggota.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void SaveAnggota(){
        model=new Model();
        try {
            PreparedStatement ps = conn.prepareStatement(model.SaveAnggota());
            ps.setString(1,anggota.tfnomor.getText());
            ps.setString(2,anggota.tfnama.getText());
            ps.setString(3,anggota.tfTTL.getText());
            ps.setString(4,getTanggal());
            ps.setString(5,getJK());
            ps.setString(6,anggota.tfAlamat.getText());
            ps.setString(7,anggota.tfTlp.getText());
            ps.setString(8,anggota.tfDivisi.getText());
            ps.setString(9,getTanggalSekarang());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Anggota Berhasil Terdaftar");
            TampilAnggota tampil=new TampilAnggota();
            tampil.setVisible(true);
            anggota.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getDataEdit(String id){
        model=new Model();
        anggota.btnSimpan.setText("Update");
        try {
            java.sql.Statement st = conn.createStatement();
            ResultSet rss = st.executeQuery(model.getEditAnggota(id));
            if (rss.next()) {
                anggota.tfnomor.setText(rss.getString("no_anggota"));
                anggota.tfnama.setText(rss.getString("nm_anggota"));
                anggota.tfTTL.setText(rss.getString("tempat_lahir"));
                anggota.tfAlamat.setText(rss.getString("alamat"));
                anggota.tfTlp.setText(rss.getString("no_tlp"));
                anggota.tfDivisi.setText(rss.getString("divisi"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
