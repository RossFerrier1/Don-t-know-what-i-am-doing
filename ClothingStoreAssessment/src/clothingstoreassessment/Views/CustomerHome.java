/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clothingstoreassessment.Views;

import clothingstoreassessment.Customer;
import clothingstoreassessment.DBManager;

/**
 *
 * @author 30207193
 */
public class CustomerHome extends javax.swing.JFrame {
  private Customer loggedInCustomer;
    /**
     * Creates new form CustomerHome
     */
    public CustomerHome(Customer customerIn) {
        loggedInCustomer = customerIn;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGreeting = new javax.swing.JLabel();
        btnMyOrders = new javax.swing.JButton();
        btnEditInfo = new javax.swing.JButton();
        btnBrowse = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        BtnUnregister = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblGreeting.setText("jLabel1");

        btnMyOrders.setText("view my orders");
        btnMyOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyOrdersActionPerformed(evt);
            }
        });

        btnEditInfo.setText("Edit Details");
        btnEditInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditInfoActionPerformed(evt);
            }
        });

        btnBrowse.setText("Browse Products");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        btnLogOut.setText("LOG OUT");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        BtnUnregister.setText("Unregister from shop");
        BtnUnregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUnregisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(lblGreeting))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnUnregister)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnMyOrders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEditInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBrowse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblGreeting)
                .addGap(36, 36, 36)
                .addComponent(btnBrowse)
                .addGap(18, 18, 18)
                .addComponent(btnMyOrders)
                .addGap(18, 18, 18)
                .addComponent(btnEditInfo)
                .addGap(18, 18, 18)
                .addComponent(BtnUnregister)
                .addGap(11, 11, 11)
                .addComponent(btnLogOut)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMyOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyOrdersActionPerformed
        EditCustomerDetails editCustomer = new EditCustomerDetails(loggedInCustomer);
        this.dispose();
        editCustomer.setVisible(true);
    }//GEN-LAST:event_btnMyOrdersActionPerformed

    private void btnEditInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditInfoActionPerformed
        DBManager db = new DBManager();
        db.deleteCustomer(loggedInCustomer);

        MainMenu mainMenu = new MainMenu();
        this.dispose();
        mainMenu.setVisible(true);
    }//GEN-LAST:event_btnEditInfoActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        ViewProducts viewProducts = new ViewProducts(loggedInCustomer);
        this.dispose();
        viewProducts.setVisible(true);
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        MainMenu mainMenu = new MainMenu();
        this.dispose();
        mainMenu.setVisible(true);
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void BtnUnregisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUnregisterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnUnregisterActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            //    new CustomerHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnUnregister;
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnEditInfo;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnMyOrders;
    private javax.swing.JLabel lblGreeting;
    // End of variables declaration//GEN-END:variables
}
