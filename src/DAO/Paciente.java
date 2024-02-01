package DAO;

import DB_Connect.Comunica_Banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Models.Usuario;
import javax.swing.JOptionPane;
import View.Janela_Recepcao_Cadastrar;

public class Paciente {
    private final Comunica_Banco db = new Comunica_Banco();
    private final Connection con = db.conectar();
    
    
    public ArrayList<Models.Paciente> filtraPacientes() {
       ArrayList<Models.Paciente> listaPacientes = new ArrayList<>();
       ArrayList<String> listaCPF = new ArrayList<>();
       String sqlPaciente = "SELECT * FROM paciente"; // Pega todos os pacientes
       String sqlLogado = "SELECT * FROM usuarios WHERE status_lg = 1"; // Pegar todos os usuarios logados (so pode haver 1)
       try {
           PreparedStatement stmt1 = con.prepareStatement(sqlLogado);
           ResultSet rs1 = stmt1.executeQuery(); // Retorna a linha do usuario
           //System.out.println("stmt1 passou");
           rs1.next();
           String sqlAtd = String.format("SELECT * FROM status_atd WHERE id_medico = %d", rs1.getInt("id"));
           //System.out.println(sqlAtd);
           PreparedStatement stmt2 = con.prepareStatement(sqlAtd);
           ResultSet rs2 = stmt2.executeQuery(); // Retorna todas as linhas vinculadas ao usuario logado
           //System.out.println("stmt2 passou");
           while (rs2.next()) { // Pega o cpf de todos os pacientes vinculados
               listaCPF.add(rs2.getString("cpf_paciente"));
           }
           //System.out.println(listaCPF);
           //System.out.println(listaPacientes);
           PreparedStatement stmt3 = con.prepareStatement(sqlPaciente);
           ResultSet rs3 = stmt3.executeQuery(); // retorna todos os pacientes
           while (rs3.next()) { // Verifica todos os pacientes da tabela baseado num cpf          
                for (int c = 0; c < listaCPF.size(); c++) { // faz o loop baseado na quantidade de cpf guardados
                    if(rs3.getString("cpf").equals(listaCPF.get(c))) { // se o cpf do paciente for igual ao cpf verificador, vai adicionar na lista
                        //System.out.println(listaCPF.get(c));
                        Models.Paciente paciente = new Models.Paciente();
                        paciente.setId(rs3.getInt("id"));
                        paciente.setNome(rs3.getString("nome"));
                        paciente.setCpf(rs3.getString("cpf"));
                        paciente.setTelefone(rs3.getString("telefone"));
                        //System.out.println(paciente);
                        listaPacientes.add(paciente);
                    }
                }
           }
           return listaPacientes;
           
       } catch (SQLException e) {
           System.out.println("Paciente.filtraPacientes(): " + e);
           return null; 
       }
    }
    
    public String cadastrarPaciente(String nome, String cpf, String telefone, String atd, Usuario medico) {
        String sqlPaciente = "INSERT INTO paciente (nome, cpf, telefone) VALUES (?, ?, ?)";
        String sqlStatus_atd = "INSERT INTO status_atd (cpf_paciente, sts_atd, id_medico, tipo_atd) VALUES (?, ?, ?, ?)";
        String sqlMedicoID = String.format("SELECT * FROM usuarios WHERE login = '%s'", medico.getLogin());
        String r = "";
        
        if(nome.length() != 0) {
            if (cpf.length() != 0) {
                if (telefone.length() != 0) {
                    try {
                        //Faz o insert na tabela paciente com os dados do paciente
                        PreparedStatement stmt1 = con.prepareStatement(sqlPaciente);
                        stmt1.setString(1, nome);
                        stmt1.setString(2, cpf);
                        stmt1.setString(3, telefone);
                        stmt1.execute();
                        //Executa o select pra pegar o id do medico na tabela
                        PreparedStatement stmt2 = con.prepareStatement(sqlMedicoID);
                        ResultSet rs = stmt2.executeQuery();
                        rs.next();
                        System.out.println(rs.getInt("id"));
                        //Faz o insert na tabela status_atd com os dados do paciente/medico
                        PreparedStatement stmt3 = con.prepareStatement(sqlStatus_atd);
                        stmt3.setString(1, cpf);
                        stmt3.setString(2, "Aguardando Atendimento");
                        stmt3.setInt(3, rs.getInt("id"));
                        stmt3.setString(4, atd);
                        stmt3.execute();
                        r = "realizado";
                    } catch (SQLException ex) {
                        System.out.println("DAO.Paciente.CadastrarPaciente: " + ex);
                    }
                } else {
                    r = "falha";
                }
            } else {
                r = "falha";
            } 
        } else {
            r = "falha";
        }
        
        return r;
    }
}

