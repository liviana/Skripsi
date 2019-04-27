/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Muhamad Junaedi
 */
public class Model {
    public String Login(String username, String password){
        String sql="select * from admin where username ='"+username+"' and password ='"+password+"'";
        return sql;
    }
    public String cariAnggota(String no){
        String sql="SELECT * FROM data_anggota where no_anggota = '"+no+"'";
        return sql;
    }
    public String cariAnggotaNm(String nama){
        String sql="SELECT * FROM data_anggota where nm_anggota = '"+nama+"'";
        return sql;
    }
    //Insert
    public String SaveAnggota(){
        String sql="INSERT INTO data_anggota VALUE (?,?,?,?,?,?,?,?,?)";
        return sql;
    }
    public String SaveDataSimpan(){
        String sql = "INSERT INTO data_simpan (tgl_simpan,simpanan_pokok,simpanan_wajib,simpanan_sukarela,total,no_anggota) VALUES (?,?,?,?,?,?)";
        return sql;
    }
    //Table
    public String tableAnggota(){
        String sql="SELECT * FROM data_anggota ORDER BY no_anggota ASC";
        return sql;
    }
    public String tableSimpan(){
        String sql="SELECT a.no_anggota,a.nm_anggota,b.kd_simpan,b.tgl_simpan,b.simpanan_wajib,b.simpanan_pokok,b.simpanan_sukarela,b.total "
                + "FROM data_anggota a JOIN data_simpan b ON a.no_anggota=b.no_anggota ORDER BY kd_simpan asc";
        return sql;
    }
    //Cetak
    public String cetakSimpan(String dari,String sampai){
        String sql="SELECT a.no_anggota,a.nm_anggota,b.kd_simpan,b.tgl_simpan,b.simpanan_wajib,b.simpanan_pokok,b.simpanan_sukarela,b.total "
                + "FROM data_anggota a JOIN data_simpan b ON a.no_anggota=b.no_anggota where b.tgl_simpan between '"+dari+"' and '"+sampai+"' ORDER BY b.kd_simpan ASC";
        return sql;
    }
    public String SimpanPinjam(){
        String sql="INSERT INTO data_pinjaman (No_Anggota,total_pinjam,angsuran,angsuran_ke,tenor,sisa_angsur) VALUE (?,?,?,?,?,?)";
        return sql;
    }
    
}
