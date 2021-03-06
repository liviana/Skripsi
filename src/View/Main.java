/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Main_Controller;

/**
 *
 * @author Muhamad Junaedi
 */
public class Main extends javax.swing.JFrame {
    Login login;
    Main_Controller cbt;
    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
    }

    public Main(String login) {
        initComponents();
        cbt = new Main_Controller(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        DataAnggota = new javax.swing.JMenuItem();
        DataSimpan = new javax.swing.JMenuItem();
        DataPinjam = new javax.swing.JCheckBoxMenuItem();
        jMenu5 = new javax.swing.JMenu();
        inputAnggota = new javax.swing.JMenuItem();
        inputSimpan = new javax.swing.JMenuItem();
        InputPinjam = new javax.swing.JCheckBoxMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        jMenu2.setText("File");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu4.setText("DATA KOPERASI");

        DataAnggota.setText("Data Anggota");
        DataAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataAnggotaActionPerformed(evt);
            }
        });
        jMenu4.add(DataAnggota);

        DataSimpan.setText("Data Simpan");
        DataSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataSimpanActionPerformed(evt);
            }
        });
        jMenu4.add(DataSimpan);

        DataPinjam.setText("Data Pinjaman");
        DataPinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataPinjamActionPerformed(evt);
            }
        });
        jMenu4.add(DataPinjam);

        jMenuBar2.add(jMenu4);

        jMenu5.setText("FORM INPUT");

        inputAnggota.setText("Input Data Anggota");
        inputAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputAnggotaActionPerformed(evt);
            }
        });
        jMenu5.add(inputAnggota);

        inputSimpan.setText("Input Data Simpan");
        inputSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputSimpanActionPerformed(evt);
            }
        });
        jMenu5.add(inputSimpan);

        InputPinjam.setText("Input Data  Pnjaman");
        InputPinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputPinjamActionPerformed(evt);
            }
        });
        jMenu5.add(InputPinjam);

        jMenuBar2.add(jMenu5);

        jMenu7.setText("MENCETAK DATA");

        jMenuItem1.setText("Cetak Data");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem1);

        jMenuBar2.add(jMenu7);

        jMenu6.setText("LOGOUT");

        jMenuItem5.setText("Logout");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem5);

        jMenuItem6.setText("Keluar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem6);

        jMenuBar2.add(jMenu6);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 807, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DataAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataAnggotaActionPerformed
        cbt.anggota();
    }//GEN-LAST:event_DataAnggotaActionPerformed

    private void DataSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataSimpanActionPerformed
        cbt.simpan();
    }//GEN-LAST:event_DataSimpanActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        cbt.logout();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        cbt.keluar();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void inputAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputAnggotaActionPerformed
        cbt.FormAnggota();
    }//GEN-LAST:event_inputAnggotaActionPerformed

    private void inputSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputSimpanActionPerformed
        cbt.FormSimpan();
    }//GEN-LAST:event_inputSimpanActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        cbt.CetakData();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void InputPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputPinjamActionPerformed
        cbt.FormPinjam();
    }//GEN-LAST:event_InputPinjamActionPerformed

    private void DataPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataPinjamActionPerformed
        cbt.Pinjam();
    }//GEN-LAST:event_DataPinjamActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem DataAnggota;
    private javax.swing.JCheckBoxMenuItem DataPinjam;
    private javax.swing.JMenuItem DataSimpan;
    private javax.swing.JCheckBoxMenuItem InputPinjam;
    private javax.swing.JMenuItem inputAnggota;
    private javax.swing.JMenuItem inputSimpan;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    // End of variables declaration//GEN-END:variables
}
