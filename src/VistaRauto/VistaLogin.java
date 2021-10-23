/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaRauto;

import ControladorRauto.ControladorLogin;
import com.sun.awt.AWTUtilities;


public class VistaLogin extends javax.swing.JFrame {

   
   
    public VistaLogin() {
        initComponents();
       
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        
        
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_user = new javax.swing.JTextField();
        txt_pass = new javax.swing.JPasswordField();
        checkviewpass = new javax.swing.JCheckBox();
        btn_enter = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bienvenido A RentaAutos");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(206, 189, 136));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bienvenido a CheckList-RAuto ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));
        jPanel1.add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 120, 30));
        jPanel1.add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 120, 30));

        checkviewpass.setOpaque(false);
        jPanel1.add(checkviewpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 20, 10));

        btn_enter.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_enter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenRauto/pass.png"))); // NOI18N
        btn_enter.setText("Ingresar");
        jPanel1.add(btn_enter, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 140, 40));

        btn_salir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenRauto/salir.png"))); // NOI18N
        btn_salir.setText("Salir");
        jPanel1.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 140, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_enter;
    public javax.swing.JButton btn_salir;
    public javax.swing.JCheckBox checkviewpass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPasswordField txt_pass;
    public javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
