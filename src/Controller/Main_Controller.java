/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.CetakData;
import View.Data_Anggota;
import View.Data_Pinjaman;
import View.Data_Simpan;
import View.Login;
import View.Main;
import View.TampilAnggota;
import View.TampilSimpan;

/**
 *
 * @author Muhamad Junaedi
 */
public class Main_Controller {
    Main main;

    public Main_Controller(Main main) {
       this.main = main;
    }
    //Logout
    public void logout(){
        Login login=new Login();
        login.setVisible(true);
        main.dispose();
    }
    public void keluar(){
        main.dispose();
    }
    //Tampilkan
    public void anggota(){
        TampilAnggota tampil= new TampilAnggota();
        tampil.setVisible(true);
    }
    public void simpan(){
        TampilSimpan simpan= new TampilSimpan();
        simpan.setVisible(true);
    }
    //Form
    public void FormAnggota(){
        Data_Anggota anggota=new Data_Anggota();
        anggota.setVisible(true);
    }
    public void FormSimpan(){
        Data_Simpan simpan=new Data_Simpan();
        simpan.setVisible(true);
    }
    public void FormPinjam(){
        Data_Pinjaman pinjam=new Data_Pinjaman();
        pinjam.setVisible(true);
    }
    //Cetak
    public void CetakData(){
        CetakData cetak=new CetakData();
        cetak.setVisible(true);
    }
}
