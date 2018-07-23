
package ar.com.smartprice.views;

import javax.swing.JTextField;

/**
 *
 * @author Andres
 */
public final class OffererLoggedPanel extends javax.swing.JPanel {

    
    public OffererLoggedPanel() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupChangeUser = new javax.swing.ButtonGroup();
        btnLogout = new javax.swing.JButton();
        btnProfile = new javax.swing.JButton();
        btnpreciosyprod = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblusername = new javax.swing.JLabel();

        setBackground(new java.awt.Color(75, 82, 97));

        btnLogout.setBackground(new java.awt.Color(0, 171, 170));
        btnLogout.setForeground(new java.awt.Color(236, 241, 245));
        btnLogout.setText("Cerrar Sesion");
        btnLogout.setBorder(null);
        btnLogout.setFocusPainted(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnProfile.setBackground(new java.awt.Color(0, 171, 170));
        btnProfile.setForeground(new java.awt.Color(236, 241, 245));
        btnProfile.setText("Perfil");
        btnProfile.setBorder(null);
        btnProfile.setFocusPainted(false);

        btnpreciosyprod.setBackground(new java.awt.Color(0, 171, 170));
        btnpreciosyprod.setForeground(new java.awt.Color(236, 241, 245));
        btnpreciosyprod.setText("Precios y Productos");
        btnpreciosyprod.setBorder(null);
        btnpreciosyprod.setFocusPainted(false);
        btnpreciosyprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpreciosyprodActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        lblusername.setForeground(new java.awt.Color(236, 241, 245));
        lblusername.setText("jLabel2");
        lblusername.setAlignmentX(0.5F);
        lblusername.setAutoscrolls(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnpreciosyprod, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblusername, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblusername)
                .addGap(72, 72, 72)
                .addComponent(btnProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnpreciosyprod, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnpreciosyprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpreciosyprodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnpreciosyprodActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnLogout;
    public javax.swing.JButton btnProfile;
    public javax.swing.JButton btnpreciosyprod;
    private javax.swing.ButtonGroup buttonGroupChangeUser;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel lblusername;
    // End of variables declaration//GEN-END:variables

}
