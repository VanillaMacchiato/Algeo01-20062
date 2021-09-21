package alingeo.matriks.ui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rifqi
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form SwingUI
     */
    public Main() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        Background = new javax.swing.JPanel();
        SidePanel = new javax.swing.JPanel();
        MenuLabel = new javax.swing.JLabel();
        SideMenu = new javax.swing.JPanel();
        SPLLabel = new javax.swing.JLabel();
        SPLGaussJordan = new javax.swing.JRadioButton();
        SPLMatriksBalikan = new javax.swing.JRadioButton();
        SPLCrammer = new javax.swing.JRadioButton();
        DeterminanLabel = new javax.swing.JLabel();
        DeterminanKofaktor = new javax.swing.JRadioButton();
        DeterminanOBE = new javax.swing.JRadioButton();
        InversLabel = new javax.swing.JLabel();
        InversGaussJordan = new javax.swing.JRadioButton();
        InversAdjoint = new javax.swing.JRadioButton();
        ProblemSolverLabel = new javax.swing.JLabel();
        Interpolasi = new javax.swing.JRadioButton();
        Regresi = new javax.swing.JRadioButton();
        ExitButton = new javax.swing.JButton();
        SPLMatriksBalikan1 = new javax.swing.JRadioButton();
        LayeredPane = new javax.swing.JLayeredPane();
        PanelSPLGaussJordan = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 600));

        Background.setPreferredSize(new java.awt.Dimension(600, 460));

        SidePanel.setBackground(new java.awt.Color(153, 153, 153));

        MenuLabel.setBackground(new java.awt.Color(255, 255, 255));
        MenuLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuLabel.setText("MENU");

        SideMenu.setBackground(new java.awt.Color(204, 204, 204));

        SPLLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        SPLLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SPLLabel.setText("SPL");

        SPLGaussJordan.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(SPLGaussJordan);
        SPLGaussJordan.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        SPLGaussJordan.setLabel("Metode Gauss Jordan");
        SPLGaussJordan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPLGaussJordanActionPerformed(evt);
            }
        });

        SPLMatriksBalikan.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(SPLMatriksBalikan);
        SPLMatriksBalikan.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        SPLMatriksBalikan.setLabel("Metode Matriks Balikan");

        SPLCrammer.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(SPLCrammer);
        SPLCrammer.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        SPLCrammer.setLabel("Metode Crammer");

        DeterminanLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        DeterminanLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DeterminanLabel.setText("Determinan");

        DeterminanKofaktor.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(DeterminanKofaktor);
        DeterminanKofaktor.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        DeterminanKofaktor.setText("Ekspansi Kofaktor");
        DeterminanKofaktor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeterminanKofaktorActionPerformed(evt);
            }
        });

        DeterminanOBE.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(DeterminanOBE);
        DeterminanOBE.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        DeterminanOBE.setText("Metode OBE");
        DeterminanOBE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeterminanOBEActionPerformed(evt);
            }
        });

        InversLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        InversLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        InversLabel.setText("Invers");

        InversGaussJordan.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(InversGaussJordan);
        InversGaussJordan.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        InversGaussJordan.setText("Metode Gauss-Jordan");
        InversGaussJordan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InversGaussJordanActionPerformed(evt);
            }
        });

        InversAdjoint.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(InversAdjoint);
        InversAdjoint.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        InversAdjoint.setText("Metode Adjoint");
        InversAdjoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InversAdjointActionPerformed(evt);
            }
        });

        ProblemSolverLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        ProblemSolverLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProblemSolverLabel.setText("Problem Solver");

        Interpolasi.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(Interpolasi);
        Interpolasi.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        Interpolasi.setText("Interpolasi");
        Interpolasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InterpolasiActionPerformed(evt);
            }
        });

        Regresi.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(Regresi);
        Regresi.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        Regresi.setText("Regresi");
        Regresi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresiActionPerformed(evt);
            }
        });

        ExitButton.setBackground(new java.awt.Color(153, 153, 153));
        ExitButton.setLabel("EXIT");

        SPLMatriksBalikan1.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(SPLMatriksBalikan1);
        SPLMatriksBalikan1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        SPLMatriksBalikan1.setText("Metode Gauss");
        SPLMatriksBalikan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPLMatriksBalikan1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SideMenuLayout = new javax.swing.GroupLayout(SideMenu);
        SideMenu.setLayout(SideMenuLayout);
        SideMenuLayout.setHorizontalGroup(
            SideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SPLLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SideMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SPLMatriksBalikan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(SPLGaussJordan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SPLCrammer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeterminanKofaktor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeterminanOBE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeterminanLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(InversGaussJordan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(InversAdjoint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(InversLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Interpolasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Regresi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProblemSolverLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SPLMatriksBalikan1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(ExitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SideMenuLayout.setVerticalGroup(
            SideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SideMenuLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(SPLLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SPLMatriksBalikan1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SPLGaussJordan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SPLMatriksBalikan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SPLCrammer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeterminanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeterminanKofaktor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeterminanOBE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InversLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InversGaussJordan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InversAdjoint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProblemSolverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Interpolasi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Regresi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
        SidePanel.setLayout(SidePanelLayout);
        SidePanelLayout.setHorizontalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SideMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(MenuLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SidePanelLayout.setVerticalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SidePanelLayout.createSequentialGroup()
                .addComponent(MenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SideMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LayeredPane.setBackground(new java.awt.Color(204, 204, 204));

        PanelSPLGaussJordan.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout PanelSPLGaussJordanLayout = new javax.swing.GroupLayout(PanelSPLGaussJordan);
        PanelSPLGaussJordan.setLayout(PanelSPLGaussJordanLayout);
        PanelSPLGaussJordanLayout.setHorizontalGroup(
            PanelSPLGaussJordanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );
        PanelSPLGaussJordanLayout.setVerticalGroup(
            PanelSPLGaussJordanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );

        LayeredPane.setLayer(PanelSPLGaussJordan, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout LayeredPaneLayout = new javax.swing.GroupLayout(LayeredPane);
        LayeredPane.setLayout(LayeredPaneLayout);
        LayeredPaneLayout.setHorizontalGroup(
            LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LayeredPaneLayout.createSequentialGroup()
                .addComponent(PanelSPLGaussJordan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        LayeredPaneLayout.setVerticalGroup(
            LayeredPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LayeredPaneLayout.createSequentialGroup()
                .addComponent(PanelSPLGaussJordan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LayeredPane))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(LayeredPane, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SidePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(Background, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeterminanOBEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeterminanOBEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeterminanOBEActionPerformed

    private void InversAdjointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InversAdjointActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InversAdjointActionPerformed

    private void InversGaussJordanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InversGaussJordanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InversGaussJordanActionPerformed

    private void RegresiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegresiActionPerformed

    private void InterpolasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InterpolasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InterpolasiActionPerformed

    private void DeterminanKofaktorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeterminanKofaktorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeterminanKofaktorActionPerformed

    private void SPLGaussJordanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPLGaussJordanActionPerformed
        // TODO add your handling code here:
        System.out.println("SPLGaussJordan");
    }//GEN-LAST:event_SPLGaussJordanActionPerformed

    private void SPLMatriksBalikan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPLMatriksBalikan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SPLMatriksBalikan1ActionPerformed

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JRadioButton DeterminanKofaktor;
    private javax.swing.JLabel DeterminanLabel;
    private javax.swing.JRadioButton DeterminanOBE;
    private javax.swing.JButton ExitButton;
    private javax.swing.JRadioButton Interpolasi;
    private javax.swing.JRadioButton InversAdjoint;
    private javax.swing.JRadioButton InversGaussJordan;
    private javax.swing.JLabel InversLabel;
    private javax.swing.JLayeredPane LayeredPane;
    private javax.swing.JLabel MenuLabel;
    private javax.swing.JPanel PanelSPLGaussJordan;
    private javax.swing.JLabel ProblemSolverLabel;
    private javax.swing.JRadioButton Regresi;
    private javax.swing.JRadioButton SPLCrammer;
    private javax.swing.JRadioButton SPLGaussJordan;
    private javax.swing.JLabel SPLLabel;
    private javax.swing.JRadioButton SPLMatriksBalikan;
    private javax.swing.JRadioButton SPLMatriksBalikan1;
    private javax.swing.JPanel SideMenu;
    private javax.swing.JPanel SidePanel;
    private javax.swing.ButtonGroup buttonGroup1;
    // End of variables declaration//GEN-END:variables
}