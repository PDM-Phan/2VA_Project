package View;

import DAO.Pacientes;
import DAO.Status;
import DB_Connect.Comunica_Banco;
import Models.Paciente;
import Util.Validator;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Janela_Recepcao_Excluir extends javax.swing.JFrame {
    Comunica_Banco db = new Comunica_Banco();
    Pacientes p = new Pacientes();
    Status s = new Status();
    private Connection con;
    /**
     * Creates new form Janela_Recepcao_Atualizar
     */
    public Janela_Recepcao_Excluir() {
        initComponents();
        txtPesquisa.setDocument(new Validator(30));
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
            System.out.println("janela_Pricnipal.Status: " + e);
        }
    }
    
    private void setarData() {
        Date data = new Date(); // Recebe data do sistema
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL); //responsavel para formatar a data
        lblData.setText(formatador.format(data));// Altera o texto da Label para a data
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pHeader = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblPesquisar = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        bPesquisa = new javax.swing.JButton();
        lblOBS = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        txtAtd = new javax.swing.JTextField();
        lblAtd = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        txtCPF = new javax.swing.JTextField();
        bCancelar = new javax.swing.JButton();
        bExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pHeader.setBackground(new java.awt.Color(0, 153, 153));
        pHeader.setPreferredSize(new java.awt.Dimension(400, 50));
        pHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("-----Excluir Paciente-----");
        pHeader.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(pHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        lblPesquisar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPesquisar.setText("Pesquisar Paciente: ");
        getContentPane().add(lblPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txtPesquisa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(txtPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 110, -1));

        bPesquisa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bPesquisa.setText("Pesquisar");
        bPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPesquisaActionPerformed(evt);
            }
        });
        getContentPane().add(bPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, -1, -1));

        lblOBS.setText("(Digite o nome do paciente)");
        getContentPane().add(lblOBS, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, -1));

        lblCPF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCPF.setText("CPF: ");
        getContentPane().add(lblCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        txtAtd.setEditable(false);
        txtAtd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtAtd, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 90, -1));

        lblAtd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAtd.setText("Atendimento: ");
        getContentPane().add(lblAtd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        lblData.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblData.setForeground(new java.awt.Color(255, 255, 255));
        lblData.setText("jLabel1");
        jPanel2.add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 400, 50));

        txtCPF.setEditable(false);
        txtCPF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 90, -1));

        bCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(bCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, -1, -1));

        bExcluir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bExcluir.setText("Excluir");
        bExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(bExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPesquisaActionPerformed
        // Pesquisar paciente
        Paciente paciente = p.getPacienteString(txtPesquisa.getText());

        if (paciente.getNome() != null) {
            JOptionPane.showMessageDialog(this, "Paciente encontrado.");
            // Preenche os campos para excluir
            txtCPF.setText(paciente.getCpf());
            txtAtd.setText(paciente.getTipo_atd());
        } else {
            JOptionPane.showMessageDialog(this, "Houve um erro, verifique o nome do paciente.");
            txtCPF.setText("");
            txtAtd.setText("");
        }
    }//GEN-LAST:event_bPesquisaActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        status();
        setarData();
    }//GEN-LAST:event_formWindowActivated

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        // TODO add your handling code here:
        txtPesquisa.setText("");
        txtCPF.setText("");
        txtAtd.setText("");
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExcluirActionPerformed
        // TODO add your handling code here:
        String statusPaciente = p.deletePaciente(txtPesquisa.getText());
        
        if (statusPaciente.equals("falha")) {
            JOptionPane.showMessageDialog(this, "Houve um problema tente novamente.");
            txtPesquisa.setText("");
            txtCPF.setText("");
            txtAtd.setText("");
        } else {
            String statusATD = s.deleteStatus_atd(txtCPF.getText());
            if (statusATD.equals("falha")) {
                JOptionPane.showMessageDialog(this, "Houve um problema tente novamente.");
                txtPesquisa.setText("");
                txtCPF.setText("");
                txtAtd.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Paciente excluido das tabelas com sucesso!");
                txtPesquisa.setText("");
                txtCPF.setText("");
                txtAtd.setText("");
            }
        }
    }//GEN-LAST:event_bExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(Janela_Recepcao_Excluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela_Recepcao_Excluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela_Recepcao_Excluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela_Recepcao_Excluir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Janela_Recepcao_Excluir().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bExcluir;
    private javax.swing.JButton bPesquisa;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAtd;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblOBS;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pHeader;
    private javax.swing.JTextField txtAtd;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
