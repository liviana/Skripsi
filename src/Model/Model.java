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
    
    //getEdit Data
    public String getEditAnggota(String no_anggota){
        String sql="SELECT * FROM data_anggota where no_anggota = '"+no_anggota+"'";
        return sql;
    }
    public String getEditPinjaman(String id){
        String sql="SELECT b.id,a.No_Anggota, a.nm_anggota, b.total_pinjaman, b.angsuran, b.angsuran_ke,b.tenor ,b.sisa_angsur FROM data_anggota a JOIN data_pinjaman b ON a.No_anggota=b.No_anggota WHERE b.id = '"+id+"'";
        return sql;
    }
    public String getEditSimpan(String kd_simpan){
        String sql="SELECT * FROM data_simpan where kd_simpan = '"+kd_simpan+"'";
        return sql;
    }
    
    //
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
    //Edit
    public String editAnggota(String noAnggota){
        String sql="UPDATE data_anggota SET nm_anggota = ?,tempat_lahir = ?,tgl_lahir = ?,jenis_kelamin = ?,alamat = ?,no_tlp = ?,divisi = ?,tgl_masuk = ? WHERE no_anggota = '"+noAnggota+"'";
        return sql;
    }
    public String editPinjaman(String id){
        String sql="UPDATE data_pinjaman SET No_anggota = ?,total_pinjaman = ?,angsuran = ?,angsuran_ke = ?,tenor = ?,sisa_angsur = ? WHERE id = '"+id+"'";
        return sql;
    }
    public String editSimpan(String kd_simpan){
        String sql="UPDATE data_simpan SET simpanan_pokok = ?, simpanan_wajib = ?, simpanan_sukarela = ?, total = ?, no_anggota = ? WHERE kd_simpan = '"+kd_simpan+"'";
        return sql;
    }
    
    //Edit
    //Delete
    public String deleteAnggota(String noAnggota){
        String sql="DELETE FROM data_anggota WHERE no_anggota = '"+noAnggota+"'";
        return sql;
    }
    public String deletePinjam(String id){
        String sql="DELETE FROM data_pinjaman WHERE id = '"+id+"'";
        return sql;
    }
    public String deleteSimpan(String kd_simpan){
        String sql="DELETE FROM data_simpan WHERE Kd_simpan = '"+kd_simpan+"'";
        return sql;
    }
    //Delete
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
        String sql="INSERT INTO data_pinjaman (No_Anggota,total_pinjaman,angsuran,angsuran_ke,tenor,sisa_angsur) VALUE (?,?,?,?,?,?)";
        return sql;
    }
    public String TampilPinjam(){
        String sql="SELECT b.id,a.No_Anggota, a.nm_anggota, b.total_pinjaman, b.angsuran, b.angsuran_ke,b.tenor ,b.sisa_angsur FROM data_anggota a JOIN data_pinjaman b ON a.No_anggota=b.No_anggota";
        return sql;
    }
}
