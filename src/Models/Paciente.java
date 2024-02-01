package Models;

import DB_Connect.Comunica_Banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Paciente {
    private final Comunica_Banco db = new Comunica_Banco();
    private final Connection con = db.conectar();
    
    
    public ArrayList<Hospital.Paciente> filtraPacientes() {
       ArrayList<Hospital.Paciente> listaPacientes = new ArrayList<>();
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
                        Hospital.Paciente paciente = new Hospital.Paciente();
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
}
