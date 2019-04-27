/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import Koneksi.*;
import View.Data_Simpan;
import View.TampilAnggota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import Koneksi.*;
/**
 *
 * @author Muhamad Junaedi
 */
public class DSimpan_Controller {
    Data_Simpan simpan;
    Model model;
    Connection conn = new Koneksi().connect();
    
    public DSimpan_Controller(Data_Simpan simpan) {
        this.simpan=simpan;
    }
    public void kembali(){
        simpan.dispose();
    }
    
    //Constant
    private String getTanggalSekarang(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date dtBaru = new java.util.Date();
        String tgl = sdf.format(dtBaru);
        return tgl;
    }
    //Constant
    
    
    
    //Public
    public void checkAnggota(){
        model=new Model();
        try {
            java.sql.Statement st= conn.createStatement();
            ResultSet rss= st.executeQuery(model.cariAnggota(simpan.tfnomor.getText()));
            if (rss.next()) {
                JOptionPane.showMessageDialog(null,"No Anggota Ditemukan\nAnggota Bernama : "+rss.getString("nm_anggota"));
            }else{
                JOptionPane.showMessageDialog(null,"No Anggota Tidak Diketahui");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }  
    public void getTotal(){
        if(simpan.tfsimpokok.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Simpanan Pokok Tidak Boleh Kosong");
        }else if(simpan.tfsimsukarela.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Simpanan Sukarela Tidak Boleh Kosong");
        }else if(simpan.tfsimwajib.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Simpanan Wajib Tidak Boleh Kosong");
        }else{
            int pokok=Integer.parseInt(simpan.tfsimpokok.getText());
            int sukarela=Integer.parseInt(simpan.tfsimsukarela.getText());
            int wajib=Integer.parseInt(simpan.tfsimwajib.getText());
            int total=pokok+sukarela+wajib;
            simpan.tfTotal.setText(String.valueOf(total));
        }
    }
    
    public void SaveSimpan(){
        model=new Model();
        try {
            PreparedStatement ps = conn.prepareStatement(model.SaveDataSimpan());
            ps.setString(1,getTanggalSekarang());
            ps.setString(2,simpan.tfsimpokok.getText());
            ps.setString(3,simpan.tfsimwajib.getText());
            ps.setString(4,simpan.tfsimsukarela.getText());
            ps.setString(5,simpan.tfTotal.getText());
            ps.setString(6,simpan.tfnomor.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Simpan Berhasil Terisi");
            TampilAnggota tampil=new TampilAnggota();
            tampil.setVisible(true);
            simpan.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
