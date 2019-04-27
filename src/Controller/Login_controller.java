/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Koneksi.*;
import View.Login;
import Model.*;
import View.Main;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Muhamad Junaedi
 */
public class Login_controller {
    Model model;
    Login login;
    Connection conn= new Koneksi().connect();
    
    public Login_controller(Login login) {
       this.login=login;
    }
    
    public void loginAction(){
        model = new Model();
        try {
            java.sql.Statement st=conn.createStatement();
            ResultSet rss= st.executeQuery(model.Login(login.tfuser.getText(), login.tfpass.getText().toString()));
            if (rss.next()) {
                String Login=rss.getString("username");
                Main mn=new Main(Login);
                mn.setVisible(true);
                login.dispose();
            }else{
                JOptionPane.showMessageDialog(login,"Username atau Password Salah");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
}
