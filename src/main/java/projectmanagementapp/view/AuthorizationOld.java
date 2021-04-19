/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectmanagementapp.view;


import java.awt.event.KeyEvent;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import projectmanagementapp.controller.EmployeeProcessor;
import projectmanagementapp.model.Employee;

/**
 *
 * @author Korisnik
 */
public class AuthorizationOld extends javax.swing.JFrame {


    public AuthorizationOld() {
        initComponents();
        setTitle(Application.HEADER_APP);
        txtEmail.setText("antonio.blatancic21@gmail.com");
        pswPassword.setText("antonio21");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        pswPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edunova");

        jLabel2.setText("Email");

        jLabel3.setText("Lozinka");

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });

        pswPassword.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        pswPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pswPasswordKeyReleased(evt);
            }
        });

        btnLogin.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnLogin.setText("Prijava");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtEmail)
                    .addComponent(pswPassword)
                    .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(29, 29, 29)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pswPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER 
                && !txtEmail.getText().isEmpty()){
           pswPassword.requestFocus();
        }
    }//GEN-LAST:event_txtEmailKeyReleased

    private void pswPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pswPasswordKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_ENTER &&
                pswPassword.getPassword().length>0){
            logIn();
        }
    }//GEN-LAST:event_pswPasswordKeyReleased

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        logIn();
    }//GEN-LAST:event_btnLoginActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField pswPassword;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables

    private void logIn() {
        
        
        
        if(txtEmail.getText().isEmpty()){
            handleIssue(txtEmail, "Email required");
         //   JOptionPane.showMessageDialog(rootPane, "Email required");
         //   txtEmail.requestFocus();
            return;
        }
        
        try {
            InternetAddress email=new InternetAddress(txtEmail.getText());
            email.validate();
        } catch (AddressException e) {
            handleIssue(txtEmail, "Invalid email");
            //JOptionPane.showMessageDialog(rootPane, "Invalid email");
           // txtEmail.requestFocus();
            return;
        }
        
      
        if(pswPassword.getPassword().length==0){
            handleIssue(pswPassword, "Password required");
           // JOptionPane.showMessageDialog(rootPane, "Password required");
          //  pswLozinka.requestFocus();
            return;
        }
        
        // znam kako je postavljen email i loznika
        EmployeeProcessor oo = new EmployeeProcessor();
        Employee e = oo.authorization(txtEmail.getText(), pswPassword.getPassword());
        
        if(e==null){
            handleIssue(pswPassword, "Email and password invalid");
            return;
        }
        
        // imamo problem primjene objekta pod ingerencijom Hibernate
        // jer automatski sprema u bazu -  it will be saved automatically.
        // https://stackoverflow.com/questions/30955910/if-i-modify-a-hibernate-entity-after-doing-a-save-when-i-commit-would-the-chan
        // o.setLozinka(null);
        Application.user=e;
        //new Izbornik().setVisible(true);
        dispose();
        
    }
    
    private void handleIssue(JComponent component, String message){
        component.requestFocus();
        JOptionPane.showMessageDialog(rootPane, message);
    }
}
