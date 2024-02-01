package View;

import DB_Connect.Comunica_Banco;
import Models.Usuarios;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

public class Janela_Recepcao extends javax.swing.JFrame {

    
    Comunica_Banco db = new Comunica_Banco();
    Usuarios u = new Usuarios(); // instancia o model para usuarios
    private Connection con;
    
    public Janela_Recepcao() {
        initComponents();
    }
    private void status() {

        try {
            con = db.conectar();
            if (con == null) {
                //System.out.println("Erro de conexão");
                lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/dboff.png")));
            } else {
                //System.out.println("Banco conectado");
                lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/dbon.png")));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    private void setarData() {
        Date data = new Date(); // Recebe data do sistema
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL); //responsavel para formatar a data
        lblData.setText(formatador.format(data)); // Altera o texto da Label para a data
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblData = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        bConfig = new javax.swing.JMenu();
        bLogoff = new javax.swing.JMenuItem();
        mAcao = new javax.swing.JMenu();
        bCadastro = new javax.swing.JMenuItem();
        bAtualizar = new javax.swing.JMenuItem();
        bExcluir = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hospital Misericordia");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Img/5724972_building_healthcare_hospital_medical_nursing_icon.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        lblData.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblData.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 457, Short.MAX_VALUE)
                .addComponent(lblStatus)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblData))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblStatus)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 229, 477, -1));

        bConfig.setText("Configuração");

        bLogoff.setText("Logoff");
        bLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLogoffActionPerformed(evt);
            }
        });
        bConfig.add(bLogoff);

        jMenuBar1.add(bConfig);

        mAcao.setText("Ação");

        bCadastro.setText("Cadastrar");
        bCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastroActionPerformed(evt);
            }
        });
        mAcao.add(bCadastro);

        bAtualizar.setText("Atualizar");
        mAcao.add(bAtualizar);

        bExcluir.setText("Excluir");
        mAcao.add(bExcluir);

        jMenuBar1.add(mAcao);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        u.changeStatusOff();
    }//GEN-LAST:event_formWindowClosed

    private void bLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLogoffActionPerformed
        // TODO add your handling code here:
        u.changeStatusOff();
        Janela_Principal jm = new Janela_Principal();
        this.dispose();
        jm.setVisible(true);
    }//GEN-LAST:event_bLogoffActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        this.status();
        this.setarData();
    }//GEN-LAST:event_formWindowActivated

    private void bCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bCadastroActionPerformed

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
            java.util.logging.Logger.getLogger(Janela_Recepcao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela_Recepcao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela_Recepcao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela_Recepcao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Janela_Recepcao().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem bAtualizar;
    private javax.swing.JMenuItem bCadastro;
    private javax.swing.JMenu bConfig;
    private javax.swing.JMenuItem bExcluir;
    private javax.swing.JMenuItem bLogoff;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JMenu mAcao;
    // End of variables declaration//GEN-END:variables
}
