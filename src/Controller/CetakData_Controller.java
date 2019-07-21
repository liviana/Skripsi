/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Koneksi.*;
import Model.*;
import View.CetakData;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Muhamad Junaedi
 */
public class CetakData_Controller {
    Connection conn=new Koneksi().connect();
    CetakData cetak;
    Model model;
    SimpleDateFormat date;
    public CetakData_Controller(CetakData cetak) {
        this.cetak=cetak;
    }
    
    //constant
    private String dari(){
        date = new SimpleDateFormat("yyyy-MM-dd");
        String d_dari = date.format(cetak.txtd_dari.getDate());        
        return d_dari;
    }
    private String sampai(){
        date = new SimpleDateFormat("yyyy-MM-dd");
        String d_sampai = date.format(cetak.txtd_sampai.getDate());        
        return d_sampai;
    }
    //constant
    
    //Logic
    public void Laporan(){
        String laporan = cetak.cbLaporan.getSelectedItem().toString();
        switch(laporan){
            case "Pilih Laporan":
                JOptionPane.showMessageDialog(null, "Pilih Laporan.");              
                break;
            case "Laporan Data Anggota":
                DataAnggota();
                break;
            case "Laporan Data Simpan":
                DataSimpan();
                break;    
            case "Laporan Data Pinjaman":
                DataPinjam();
                break;    
            default:
                DataKoperasi();
                break;
        }
            
    }
    //Logic
    
    
    
    //Cetak
    private void DataAnggota(){
        model=new Model();
        Models models = new Models();
        try {
            java.sql.Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(model.tableAnggota());
            JasperPrint jasperPrint;
            HashMap hash = new HashMap();
            hash.put("d_dari",dari());
            hash.put("d_sampai",sampai());
            hash.put("tgl_sekarang",models.getToday());
            JRResultSetDataSource jrRS = new JRResultSetDataSource (rs);
            String filename= System.getProperty("user.dir")+"/src/iReport/CetakAnggota.jrxml";            
            JasperReport jasperReport = JasperCompileManager.compileReport(filename);
            jasperPrint = JasperFillManager.fillReport(jasperReport,hash, jrRS);
            JRViewer aViewer = new JRViewer(jasperPrint);                  
            JDialog viewer = new JDialog(); 	
            viewer.setTitle(".: Data Anggota :.");             
            viewer.setAlwaysOnTop(true);
            viewer.getContentPane().add(aViewer);                  
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();     
            viewer.setBounds(0,0,screenSize.width, screenSize.height);
            viewer.setVisible(true);              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Laporan gak ada "+e);
        }
    }
    private void DataSimpan(){
        model=new Model();
        Models models = new Models();
        try {
            java.sql.Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(model.cetakSimpan(dari(),sampai()));
            HashMap hash = new HashMap();
            hash.put("d_dari",dari());
            hash.put("d_sampai",sampai());
            hash.put("tgl_sekarang",models.getToday());
            JasperPrint jasperPrint;       
            JRResultSetDataSource jrRS = new JRResultSetDataSource (rs);
            String filename= System.getProperty("user.dir")+"/src/iReport/CetakDataSimpan.jrxml";            
            JasperReport jasperReport = JasperCompileManager.compileReport(filename);
            jasperPrint = JasperFillManager.fillReport(jasperReport,hash, jrRS);
            JRViewer aViewer = new JRViewer(jasperPrint);                  
            JDialog viewer = new JDialog(); 	
            viewer.setTitle(".: Data Simpan Pinjam :.");             
            viewer.setAlwaysOnTop(true);
            viewer.getContentPane().add(aViewer);                  
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();     
            viewer.setBounds(0,0,screenSize.width, screenSize.height);
            viewer.setVisible(true);              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Laporan gak ada "+e);
        }
    }
    private void DataPinjam(){
        model=new Model();
        Models models= new Models();
        try {
            java.sql.Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT a.*,b.* FROM data_pinjaman a JOIN data_anggota b ON a.No_anggota=b.No_anggota");
            HashMap hash = new HashMap();
            hash.put("tgl_sekarang",models.getToday());
            //hash.put("d_sampai",sampai());
            JasperPrint jasperPrint;       
            JRResultSetDataSource jrRS = new JRResultSetDataSource (rs);
            String filename= System.getProperty("user.dir")+"/src/iReport/CetakDataPinjam.jrxml";            
            JasperReport jasperReport = JasperCompileManager.compileReport(filename);
            jasperPrint = JasperFillManager.fillReport(jasperReport,hash, jrRS);
            JRViewer aViewer = new JRViewer(jasperPrint);                  
            JDialog viewer = new JDialog(); 	
            viewer.setTitle(".: Data Simpan Pinjam :.");             
            viewer.setAlwaysOnTop(true);
            viewer.getContentPane().add(aViewer);                  
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();     
            viewer.setBounds(0,0,screenSize.width, screenSize.height);
            viewer.setVisible(true);              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Laporan gak ada "+e);
        }
    }
    private void DataKoperasi(){
        model=new Model();
        Models models= new Models();
        try {
            java.sql.Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT a.*,b.*,c.* FROM data_anggota a JOIN data_pinjaman b ON a.No_anggota=b.No_anggota JOIN data_simpan c ON a.No_anggota=c.No_anggota");
            HashMap hash = new HashMap();
            hash.put("tgl_sekarang",models.getToday());
            //hash.put("d_sampai",sampai());
            JasperPrint jasperPrint;       
            JRResultSetDataSource jrRS = new JRResultSetDataSource (rs);
            String filename= System.getProperty("user.dir")+"/src/iReport/DataKoperasi.jrxml";            
            JasperReport jasperReport = JasperCompileManager.compileReport(filename);
            jasperPrint = JasperFillManager.fillReport(jasperReport,hash, jrRS);
            JRViewer aViewer = new JRViewer(jasperPrint);                  
            JDialog viewer = new JDialog(); 	
            viewer.setTitle(".: Data Simpan Pinjam :.");             
            viewer.setAlwaysOnTop(true);
            viewer.getContentPane().add(aViewer);                  
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();     
            viewer.setBounds(0,0,screenSize.width, screenSize.height);
            viewer.setVisible(true);              
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Laporan gak ada "+e);
        }
    }
    //Cetak
}
