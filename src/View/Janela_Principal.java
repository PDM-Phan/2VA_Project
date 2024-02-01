package View;
import DB_Connect.Comunica_Banco;
import Models.Usuarios;
import Util.Validator;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Janela_Principal extends javax.swing.JFrame {
    //instanciar conexao com o banco de dados
    
    Comunica_Banco db = new Comunica_Banco();
    Usuarios u = new Usuarios(); // instancia o model para usuarios
    private Connection con;
    
    public Janela_Principal() {
        initComponents();
        textLogin.setDocument(new Validator(30));
        textSenha.setDocument(new Validator(30));
        
    }
    
    private void status() {

        try {
            con = db.conectar();
            if (con == null) {
                //System.out.println("Erro de conexão");
                lblStatus1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/dboff.png")));
            } else {
                //System.out.println("Banco conectado");
                lblStatus1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/dbon.png")));
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
    
    private boolean verificaLogin(String login, String senha) {
            String lg = u.getDadoUsuarioString("login", login); //Pega o login
            String sh = u.getDadoUsuarioString("senha", senha); // Pega a senha
        return login.equals(lg) && senha.equals(sh); // Retorna true se for igual
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        lblStatus = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        lblLogin = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        textSenha = new javax.swing.JPasswordField();
        botaoEntrar = new javax.swing.JButton();
        textHeader = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblStatus1 = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/dbon.png"))); // NOI18N

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hospital Misericordia");
        setBackground(new java.awt.Color(255, 255, 204));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Img/5724972_building_healthcare_hospital_medical_nursing_icon.png")).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLogin.setLabelFor(textLogin);
        lblLogin.setText("Login:");
        getContentPane().add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 50, -1));

        lblSenha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSenha.setLabelFor(textSenha);
        lblSenha.setText("Senha:");
        getContentPane().add(lblSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 50, -1));

        textSenha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(204, 255, 255), new java.awt.Color(204, 204, 204), null));
        getContentPane().add(textSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 150, 20));

        textLogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(204, 255, 255), new java.awt.Color(204, 204, 204), null));
        textLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(textLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 150, 20));

        botaoEntrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botaoEntrar.setText("Entrar");
        botaoEntrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        botaoEntrar.setBorderPainted(false);
        botaoEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 129, 90, 30));

        textHeader.setEditable(false);
        textHeader.setBackground(new java.awt.Color(0, 255, 255));
        textHeader.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        textHeader.setForeground(new java.awt.Color(255, 255, 255));
        textHeader.setText("------HOSPITAL MISERICORDIA------");
        textHeader.setBorder(null);
        getContentPane().add(textHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(310, 44));

        lblData.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblData.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                .addComponent(lblStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 28, Short.MAX_VALUE)
                        .addComponent(lblData))
                    .addComponent(lblStatus1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 310, 50));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        this.status();
        this.setarData();
    }//GEN-LAST:event_formWindowActivated

    private void botaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarActionPerformed
        // TODO add your handling code here:
        String login = this.textLogin.getText();
        String senha = String.valueOf(this.textSenha.getPassword());
        try {
            boolean v = verificaLogin(login, senha);
            if (v) {
                if (u.getEspecialidade(login).equals("Recepcionista")) {
                    //Abre a Janela_Recepcao após a verificação
                    u.changeStatusOn(login);
                    Janela_Recepcao jr = new Janela_Recepcao();
                    this.dispose();
                    jr.setVisible(true);
                } else {
                    //Abre a Janela_Medico após a verificação
                    u.changeStatusOn(login);
                    Janela_Medico jm = new Janela_Medico();
                    this.dispose();
                    jm.setVisible(true);

                }
                
            } else {
                JOptionPane.showMessageDialog(this, "Email ou Senha incorretos!");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Usuario não existe no sistema!");
        }
    }//GEN-LAST:event_botaoEntrarActionPerformed

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
            java.util.logging.Logger.getLogger(Janela_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Janela_Principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEntrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStatus1;
    private javax.swing.JTextField textHeader;
    private final javax.swing.JTextField textLogin = new javax.swing.JTextField();
    private javax.swing.JPasswordField textSenha;
    // End of variables declaration//GEN-END:variables
}
