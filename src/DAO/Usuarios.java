package DAO;

import DB_Connect.Comunica_Banco;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;

public class Usuarios {
    private final Comunica_Banco db = new Comunica_Banco();
    private final Connection con = db.conectar();
    
    public String getEspecialidade(String login) {
        String select = String.format("SELECT * FROM usuarios WHERE login = '%s';", login);
        try {
            PreparedStatement stmt = con.prepareStatement(select); // Prepara o SELECT
            ResultSet rs = stmt.executeQuery(); // Executa o SELECT
            rs.next();
            return rs.getString("especialidade");
            
        } catch (SQLException e) {
            System.out.println("Usuarios.getEspecialidade(String login): " + e);
            return null;
        }
    }
    
    public String getDadoUsuarioString(String dado, String s) {
          

        String select = String.format("SELECT * FROM usuarios WHERE %s = '%s';", dado, s);
        System.out.println(select);
        try {
            PreparedStatement stmt = con.prepareStatement(select); // Prepara o SELECT
            ResultSet rs = stmt.executeQuery(); // Executa o SELECT
            if (rs.next()) { // Move cursor para a primeira linha
                String result = rs.getString(dado); // Retorna a string desejada da coluna
                return result;
            } else {
                System.out.println("Linha vazia.");
                return null; 
            }
            
        } catch (SQLException e) {
            System.out.println("Usuarios.getDadoUsuarioString(String dado, String s): " + e);
            return null;
        }
    }
    
    public void changeStatusOn(String login){
        Models.Usuario user = new Models.Usuario();
        String sql = String.format("SELECT * FROM usuarios WHERE login = '%s';", login); //Select para pegar os dados da linha que tenha o login desejado
        System.out.println(sql);
        try {
            //Statement para pegar os dados da tabela usuarios
            PreparedStatement stmt1 = con.prepareStatement(sql); // Prepara o SELECT
            ResultSet rs1 = stmt1.executeQuery(); // Executa o SELECT
            rs1.next();
            user.setId(rs1.getInt("id"));
            //Statement para atualizar a coluna status_lg
            String update = "UPDATE usuarios SET status_lg = 1 WHERE id = ?";
            stmt1.close();
            PreparedStatement stmt2 = con.prepareStatement(update);
            stmt2.setInt(1, user.getId());
            stmt2.executeUpdate(); // executa o update     
            stmt2.close();
        } catch(SQLException e) {
            System.out.println("Usuarios.changeStatusOn(String login): " + e);
        }
    }
    
    public void changeStatusOff() {
        //Hospital.Usuario user = new Hospital.Usuario();
        try {
            //Pegar a linha do usuario que esta logado
            PreparedStatement stmt1 = con.prepareStatement("SELECT * FROM usuarios WHERE status_lg = 1;");
            ResultSet rs = stmt1.executeQuery();
            rs.next();
            //Trocar o status do usuario logado
            PreparedStatement stmt2 = con.prepareStatement("UPDATE usuarios SET status_lg = 0 WHERE id = ?");
            stmt2.setInt(1, rs.getInt("id"));
            stmt2.executeUpdate();
            System.out.println("stmt2 passou");
        } catch (SQLException e) {
            System.out.println("Usuarios.changeStatusOff(): " + e);
        }
    }
    
    public ArrayList<Models.Usuario> getAllMedicos() {
        ArrayList<Models.Usuario> listaMedico = new ArrayList<>();
        String sqlMedico = "SELECT * FROM usuarios WHERE especialidade = 'Medico';";
        try {
            PreparedStatement stmt1 = con.prepareStatement(sqlMedico);
            ResultSet rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                Models.Usuario user = new Models.Usuario();
                user.setLogin(rs1.getString("login"));
                user.setSenha(rs1.getString("senha"));
                user.setNome(rs1.getString("nome"));
                user.setEspecialidade("especialidade");
                user.setStatus_lg(rs1.getInt("id"));
                listaMedico.add(user);
            }
            
        } catch (SQLException e) {
            System.out.println("Usuarios.getAllMedicos: " + e);
        }
        
        return listaMedico;
    }
}
