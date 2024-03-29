package View;

import DAO.Usuarios;
import DAO.Pacientes;
import DB_Connect.Comunica_Banco;
import Models.Usuario;
import Util.Validator;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Janela_Recepcao_Cadastrar extends javax.swing.JFrame {
    
    Comunica_Banco db = new Comunica_Banco();
    Usuarios u = new Usuarios(); // instancia o model para usuarios
    Pacientes p = new Pacientes();
    private Connection con;

    public Janela_Recepcao_Cadastrar() {
        initComponents();
        txtNome.setDocument(new Validator(30));
        txtCPF.setDocument(new Validator(11));
        txtTelefone.setDocument(new Validator(15));
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pHeader = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblCpf = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        lblAtd = new javax.swing.JLabel();
        jCBatd = new javax.swing.JComboBox<>();
        lblMedicoAtd = new javax.swing.JLabel();
        jCBmedico = new javax.swing.JComboBox();
        txtTelefone = new javax.swing.JTextField();
        txtCPF = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        bCadastrar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hospital Misericordia");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Img/5724972_building_healthcare_hospital_medical_nursing_icon.png")).getImage());
        setResizable(false);
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
        lblTitulo.setText("-----Cadastrar Paciente-----");
        pHeader.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, -1, -1));

        getContentPane().add(pHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        lblData.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblData.setForeground(new java.awt.Color(255, 255, 255));
        lblData.setText("jLabel1");
        jPanel2.add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 400, 50));

        lblNome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNome.setText("Nome: ");
        getContentPane().add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        lblCpf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCpf.setText("CPF: ");
        getContentPane().add(lblCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        lblTelefone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTelefone.setText("Telefone: ");
        getContentPane().add(lblTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        lblAtd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAtd.setText("Atendimento: ");
        getContentPane().add(lblAtd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jCBatd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCBatd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Catarata", "Retina", "Glaucoma" }));
        getContentPane().add(jCBatd, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, -1));

        lblMedicoAtd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMedicoAtd.setText("Medico para atender: ");
        getContentPane().add(lblMedicoAtd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jCBmedico.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCBmedico.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jCBmedicoAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        getContentPane().add(jCBmedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, -1));

        txtTelefone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 90, -1));

        txtCPF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 90, -1));

        txtNome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 90, -1));

        bCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bCadastrar.setText("Cadastrar");
        bCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(bCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 100, 30));

        bCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(bCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        status();
        setarData();
    }//GEN-LAST:event_formWindowActivated

    private void jCBmedicoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jCBmedicoAncestorAdded
        // TODO add your handling code here:
        ArrayList<Models.Usuario> listaMedico = u.getAllMedicos();
        
        jCBmedico.removeAll(); //Remove qualquer item dentro do combo box
        for (Models.Usuario m : listaMedico) { // Percorre a lista
            jCBmedico.addItem(m); // Adiciona o nome do medico na lista
        }
        
    }//GEN-LAST:event_jCBmedicoAncestorAdded

    private void bCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarActionPerformed
        // TODO add your handling code here:
        Models.Usuario medico = new Usuario();
        String atd = jCBatd.getSelectedItem().toString();
        System.out.println(atd);
        medico = (Models.Usuario) jCBmedico.getSelectedItem();
        String resultado = p.cadastrarPaciente(txtNome.getText(), txtCPF.getText(), txtTelefone.getText(), atd, medico);
        if (resultado.equals("realizado")) {
            JOptionPane.showMessageDialog(this, "Cadastro do paciente realizado com sucesso!");
            txtNome.setText("");
            txtCPF.setText("");
            txtTelefone.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Preencha TODOS os campos para realizar o cadastro!");
        }
    }//GEN-LAST:event_bCadastrarActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        // TODO add your handling code here:
        txtNome.setText("");
        txtCPF.setText("");
        txtTelefone.setText("");
    }//GEN-LAST:event_bCancelarActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela_Recepcao_Cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Janela_Recepcao_Cadastrar().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCadastrar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JComboBox<String> jCBatd;
    private javax.swing.JComboBox jCBmedico;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAtd;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblMedicoAtd;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pHeader;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
