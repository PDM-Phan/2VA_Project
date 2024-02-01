package View;

import DAO.Status;
import DAO.Usuarios;
import DAO.Paciente;
import DB_Connect.Comunica_Banco;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Janela_Medico extends javax.swing.JFrame {
    
    
    Paciente p = new Paciente(); // instancia o model de pacientes
    Usuarios u = new Usuarios(); // instancia o model para usuarios
    Status s = new Status(); // instancia o model para status
    Comunica_Banco db = new Comunica_Banco();
    private Connection con;
    
    public Janela_Medico() {
        initComponents();
        geraLista();
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
            System.out.println("Janela_Medico.status(): " + e);
        }
        }
    
    private void setarData() {
        Date data = new Date(); // Recebe data do sistema
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL); //responsavel para formatar a data
        lblData.setText(formatador.format(data)); // Altera o texto da Label para a data
    }

    
    private void geraLista() {
        ArrayList<Models.Paciente> pct = p.filtraPacientes(); // Pega a lista de todos os pacientes do medico logado
        DefaultTableModel tabelaPacientes = (DefaultTableModel) tblPacientes.getModel(); //Traz as caracteristicas da tabela para a variavel
        
        for (Models.Paciente paciente : pct) { // Percorre todas os pacientes da lista
            Object[] obj = new Object[] {
                paciente.getId(),
                paciente.getNome(),
                s.getTipoAtd(paciente.getCpf()), //Função para pegar o tipo de atendimento diretamente da tabela baseado no cpf do paciente
                s.getStatusAtd(paciente.getCpf()) //Função para pegar o status do paciente diretamente da tabela baseado no cpf do paciente
            };
            tabelaPacientes.addRow(obj); // Adciona o paciente na tabela
        }
    }
    
    private void resetStatusAtd() {
        setStatusAtd("Aguardando atendimento");
    
    }
     
    private void setStatusAtd(String atd) {
        int linhaSelecionada = tblPacientes.getSelectedRow(); // pega a linha selecionada
        String idPacienteSTR = tblPacientes.getValueAt(linhaSelecionada, 0).toString(); //Pega o valor da celula em string
        int idPacienteINT = Integer.parseInt(idPacienteSTR); // Transforma a string ID em INT
        String nomePaciente = tblPacientes.getValueAt(linhaSelecionada, 1).toString();
        String tipoATDPaciente = tblPacientes.getValueAt(linhaSelecionada, 2).toString();
        String statusPaciente = tblPacientes.getValueAt(linhaSelecionada, 3).toString();  
        String nAtd = verificaStatusPaciente(atd); // Chama a funçao para verificar o status
        
        if (nAtd.equals("invalido")) {
            // Se invalido, muda a linha para repetir o processo
            linhaSelecionada = -2;
        } else {
            statusPaciente = nAtd; // atualiza o status do paciente = (Em atendimento / Alta confirmada)
        }

        switch (linhaSelecionada) {
            case -1 -> JOptionPane.showMessageDialog(this, "Nenhum paciente selecionado."); // Auto explicativo
            case -2 -> JOptionPane.showMessageDialog(this, "Ação invalida."); // Retornou status "invalido"
            default -> {
                if (tblPacientes.getSelectedRowCount() == 1) {
                    // se apenas uma linha for selecionada, entao execute
                    DefaultTableModel tabelaPacientes = (DefaultTableModel) tblPacientes.getModel(); //Traz as caracteristicas da tabela para a variavel
                    tabelaPacientes.setValueAt(idPacienteINT, linhaSelecionada, 0);
                    tabelaPacientes.setValueAt(nomePaciente, linhaSelecionada, 1);
                    tabelaPacientes.setValueAt(tipoATDPaciente, linhaSelecionada, 2);
                    tabelaPacientes.setValueAt(statusPaciente, linhaSelecionada, 3);
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Selecione apenas um paciente.");
                }   ;
            }
        }
        
    }
    
    private String verificaStatusPaciente(String atd) {
        int linhaSelecionada = tblPacientes.getSelectedRow(); // pega a linha selecionada
        String statusPaciente = tblPacientes.getValueAt(linhaSelecionada, 3).toString(); // Pega o valor da coluna desejada
        
        if (statusPaciente.equals("Aguardando Atendimento")) { // verifica se o status esta "Aguardando Atendimento"
            if(atd.equals("Atender")) { // Verifica se esta tentando atender
                // se sim, vai mudar o status de "Aguardando Atendimento" para "Em atendimento"
                statusPaciente = "Em atendimento";
            } else {
                statusPaciente = "invalido";
            }
        } else { // Se o status nao é "Aguardando Atendimento", significa que ou esta "Em atendimento" ou "Alta confirmada"
            if (statusPaciente.equals("Em atendimento")) { // verifica o status atual
                if (atd.equals("Dar alta")) { // So pode dar alta se estiver em atendimento, senao é invalida a ação
                    statusPaciente = "Alta confirmada";
                } else {
                    statusPaciente = "invalido";
                }
            } else { // Se nao for nenhuma das opçoes significa que esta com o status "Alta confirmada", não permitindo alterar o status do paciente
                statusPaciente = "invalido";
            }
        };
        return statusPaciente; // retorna o status

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jComboBox1 = new javax.swing.JComboBox<>();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        footer = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        bAtender = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPacientes = new javax.swing.JTable();
        bAlta = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        bConfig = new javax.swing.JMenu();
        bLogoff = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hospital Misericordia");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Img/5724972_building_healthcare_hospital_medical_nursing_icon.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        footer.setBackground(new java.awt.Color(0, 153, 153));
        footer.setPreferredSize(new java.awt.Dimension(613, 44));

        lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/dboff.png"))); // NOI18N

        lblData.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblData.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout footerLayout = new javax.swing.GroupLayout(footer);
        footer.setLayout(footerLayout);
        footerLayout.setHorizontalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 537, Short.MAX_VALUE)
                .addComponent(lblStatus)
                .addGap(15, 15, 15))
        );
        footerLayout.setVerticalGroup(
            footerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblStatus)
                .addGap(16, 16, 16))
            .addGroup(footerLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblData)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 590, 46));

        bAtender.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bAtender.setText("Atender");
        bAtender.setBorderPainted(false);
        bAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtenderActionPerformed(evt);
            }
        });
        getContentPane().add(bAtender, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        tblPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do Paciente", "Tipo de atendimento", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPacientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tblPacientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 590, 190));

        bAlta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bAlta.setText("Dar alta");
        bAlta.setBorderPainted(false);
        bAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAltaActionPerformed(evt);
            }
        });
        getContentPane().add(bAlta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));

        bConfig.setText("Configurações");

        bLogoff.setText("Logoff");
        bLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLogoffActionPerformed(evt);
            }
        });
        bConfig.add(bLogoff);

        jMenuBar1.add(bConfig);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        this.status();
        this.setarData();
    }//GEN-LAST:event_formWindowActivated

    private void bLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLogoffActionPerformed
        // TODO add your handling code here:
        u.changeStatusOff();
        Janela_Principal jm = new Janela_Principal();
        this.dispose();
        jm.setVisible(true);
    }//GEN-LAST:event_bLogoffActionPerformed

    private void bAtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtenderActionPerformed
        // TODO add your handling code here:
        setStatusAtd(bAtender.getText());
    }//GEN-LAST:event_bAtenderActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        u.changeStatusOff();
        
    }//GEN-LAST:event_formWindowClosing

    private void bAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAltaActionPerformed
        // TODO add your handling code here:
        setStatusAtd(bAlta.getText());
    }//GEN-LAST:event_bAltaActionPerformed

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
            java.util.logging.Logger.getLogger(Janela_Medico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Janela_Medico().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAlta;
    private javax.swing.JButton bAtender;
    private javax.swing.JMenu bConfig;
    private javax.swing.JMenuItem bLogoff;
    private javax.swing.JPanel footer;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTable tblPacientes;
    // End of variables declaration//GEN-END:variables
}
