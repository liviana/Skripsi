/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.*;
import View.Data_Pinjaman;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import Koneksi.*;
import View.TampilPinjam;
import java.sql.ResultSet;
/**
 *
 * @author LIVIANA FEBRIYANTI
 */
public class DPinjaman_Controller {
    Model model;
    Connection conn=new Koneksi().connect();
    Data_Pinjaman pinjam;
    
    public DPinjaman_Controller(Data_Pinjaman pinjam) {
       this.pinjam=pinjam;
    }
    
    public void Input(int id){
        JOptionPane.showMessageDialog(null,String.valueOf(id));
        if (id>0) {
            update(String.valueOf(id));
        }else if(id<=0){
            simpan();
        }
    }
    public void update(String id){
        model=new Model();
        try {
            PreparedStatement ps= conn.prepareStatement(model.editPinjaman(id));
            ps.setString(1,pinjam.tfNoAnggota.getText().toString());
            ps.setString(2,pinjam.tfTotalPinjam.getText().toString());
            ps.setString(3,pinjam.tfAngsuran.getText().toString());
            ps.setString(4,pinjam.tfAngsurKe.getText().toString());
            ps.setString(5,pinjam.tfTenor.getText().toString());
            ps.setString(6,pinjam.tfSisa.getText().toString());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Pinjam Berhasil Diupdate");
            TampilPinjam tampil=new TampilPinjam();
            tampil.setVisible(true);
            pinjam.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void simpan(){
        model=new Model();
        try {
            PreparedStatement ps= conn.prepareStatement(model.SimpanPinjam());
            ps.setString(1,pinjam.tfNoAnggota.getText().toString());
            ps.setString(2,pinjam.tfTotalPinjam.getText().toString());
            ps.setString(3,pinjam.tfAngsuran.getText().toString());
            ps.setString(4,pinjam.tfAngsurKe.getText().toString());
            ps.setString(5,pinjam.tfTenor.getText().toString());
            ps.setString(6,pinjam.tfSisa.getText().toString());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Data Pinjam Berhasil Diisi");
            TampilPinjam tampil=new TampilPinjam();
            tampil.setVisible(true);
            pinjam.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void editData(String id){
        model=new Model();
        pinjam.btnSimpan.setText("Update");
        String sql = model.getEditPinjaman(id);
        try {
            java.sql.Statement st = conn.createStatement();
            ResultSet rss= st.executeQuery(sql);
            if (rss.next()) {
                pinjam.tfNoAnggota.setText(rss.getString("no_anggota"));
                pinjam.tfNmAnggota.setText(rss.getString("nm_anggota"));
                pinjam.tfTotalPinjam.setText(rss.getString("total_pinjaman"));
                pinjam.tfAngsuran.setText(rss.getString("angsuran"));
                pinjam.tfAngsurKe.setText(rss.getString("angsuran_ke"));
                pinjam.tfTenor.setText(rss.getString("tenor"));
                pinjam.tfSisa.setText(rss.getString("sisa_angsur"));
            }else{
                JOptionPane.showMessageDialog(null,"Nomor Anggota Tidak Ditemukan");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void CheckNomor(){
        model=new Model();
        String nama = pinjam.tfNmAnggota.getText().toString();
        String nomor = pinjam.tfNoAnggota.getText().toString();
        String sql = model.cariAnggota(nomor);
        try {
            java.sql.Statement st = conn.createStatement();
            ResultSet rss = st.executeQuery(sql);
            if(rss.next()){
                pinjam.tfNmAnggota.setText(rss.getString("nm_anggota"));
            }else{
                JOptionPane.showMessageDialog(null,"Nomor Anggota Tidak Ditemukan");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void CheckNama(){
        model=new Model();
        String nama = pinjam.tfNmAnggota.getText().toString();
        String sql = model.cariAnggotaNm(nama);
        try {
            java.sql.Statement st = conn.createStatement();
            ResultSet rss = st.executeQuery(sql);
            if(rss.next()){
                pinjam.tfNoAnggota.setText(rss.getString("no_anggota"));
            }else{
                JOptionPane.showMessageDialog(null,"Nama Anggota Tidak Ditemukan");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void kembali(){
        pinjam.dispose();
    }
    public void hitung(){
        int TotalPinjam = Integer.parseInt(pinjam.tfTotalPinjam.getText().toString());
        int Angsuran = Integer.parseInt(pinjam.tfAngsuran.getText().toString());
        int AngsuranKe = Integer.parseInt(pinjam.tfAngsurKe.getText().toString());
        int SisaAngsuran = TotalPinjam-(Angsuran*AngsuranKe);
        pinjam.tfSisa.setText(String.valueOf(SisaAngsuran));
    }
}
