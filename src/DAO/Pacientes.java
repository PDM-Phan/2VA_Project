package DAO;

import DB_Connect.Comunica_Banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Models.*;

public class Pacientes {
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
    
    public Models.Paciente getPacienteString(String txtnome) {
        String sqlPaciente = String.format("SELECT * FROM paciente WHERE nome = '%s';", txtnome);
        String sqlTipoATD = "SELECT * FROM status_atd WHERE cpf_paciente = ?;";
        // Montando o obj Paciente
        Models.Paciente p = new Paciente();
        
        try {
            PreparedStatement stmt1 = con.prepareStatement(sqlPaciente); // Pega o paciente procurado
            PreparedStatement stmt2 = con.prepareStatement(sqlTipoATD); // Puxa os dados do paciente da tabela status_atd
            ResultSet rs1 = stmt1.executeQuery();
            rs1.next();
            stmt2.setString(1, rs1.getString("cpf"));
            ResultSet rs2 = stmt2.executeQuery();
            rs2.next();
            p.setId(rs1.getInt("id"));
            p.setNome(rs1.getString("nome"));
            p.setCpf(rs1.getString("cpf"));
            p.setTelefone(rs1.getString("telefone"));
            p.setTipo_atd(rs2.getString("tipo_atd"));
            
        } catch (SQLException e) {
            System.out.println("DAO.Pacientes.getPaciente: " + e);
        }
        
        return p;
    }
    
        public Models.Paciente getPacienteInt(int id) {
        String sqlPaciente = String.format("SELECT * FROM paciente WHERE id = %d;", id);
        String sqlTipoATD = "SELECT * FROM status_atd WHERE cpf_paciente = ?;";
        // Montando o obj Paciente
        Models.Paciente p = new Paciente();
        
        try {
            PreparedStatement stmt1 = con.prepareStatement(sqlPaciente); // Pega o paciente procurado
            PreparedStatement stmt2 = con.prepareStatement(sqlTipoATD); // Puxa os dados do paciente da tabela status_atd
            ResultSet rs1 = stmt1.executeQuery();
            rs1.next();
            stmt2.setString(1, rs1.getString("cpf"));
            ResultSet rs2 = stmt2.executeQuery();
            rs2.next();
            p.setId(rs1.getInt("id"));
            p.setNome(rs1.getString("nome"));
            p.setCpf(rs1.getString("cpf"));
            p.setTelefone(rs1.getString("telefone"));
            p.setTipo_atd(rs2.getString("tipo_atd"));
            
        } catch (SQLException e) {
            System.out.println("DAO.Pacientes.getPaciente: " + e);
        }
        
        return p;
    }
    
    public String atualizaTabela(String nome, String cpf, String telefone, String atd, String pesquisa) {
        String status = "";
        Paciente paciente = getPacienteString(pesquisa); // usa o ID para os update
        String sqlUPnome = String.format("UPDATE paciente SET nome = '%s' WHERE id = %d;", nome, paciente.getId());
        String sqlUPcpf = String.format("UPDATE paciente SET cpf = '%s' WHERE id = %d;", cpf, paciente.getId());
        String sqlCPFsts = String.format("UPDATE status_atd set cpf_paciente = '%s' WHERE cpf_paciente = '%s';", cpf, paciente.getCpf());
        String sqlUPtelefone = String.format("UPDATE paciente SET telefone = '%s' WHERE id = %d;", telefone, paciente.getId());
        String sqlUPatd = String.format("UPDATE status_atd SET tipo_atd = '%s' WHERE cpf_paciente = '%s';", atd, paciente.getCpf());
        
        if (nome.length() !=  0) {
            if (cpf.length() !=  0) {
                if (telefone.length() !=  0) {
                    try {
                        // Prepara os Statements para fazer o update
                        PreparedStatement stmt1 = con.prepareStatement(sqlUPnome);
                        PreparedStatement stmt2 = con.prepareStatement(sqlUPcpf);
                        PreparedStatement stmt3 = con.prepareStatement(sqlUPtelefone);
                        PreparedStatement stmt4 = con.prepareStatement(sqlUPatd);
                        PreparedStatement stmt5 = con.prepareStatement(sqlCPFsts);
                        // Executa os statements
                        stmt1.execute();
                        stmt2.execute();
                        stmt3.execute();
                        stmt4.execute();
                        stmt5.execute();
                        // Prepara para mostrar a mensagem na tela
                        status = "sucesso";
                    } catch (SQLException e) {
                        System.out.println("DAO.Pacientes.atualizaTabela: " + e);
                        status = "falha";
                    }
                } else {
                    status = "falha";
                }
            } else {
                status = "falha";
            } 
        }else {
            status = "falha";
        }
        
        return status;
    }
    
    public String deletePaciente(String nome) { // Recebe o nome para verificar uma tabela do banco de dados
        String status = "";
        Models.Paciente p = this.getPacienteString(nome); // instacia o obj para receber o id (PK)
        String sqlDelete = String.format("DELETE FROM paciente WHERE id = %d;", p.getId());
        
        try {
            PreparedStatement stmt1 = con.prepareStatement(sqlDelete);
            stmt1.execute();
            status = "completo";
        } catch (SQLException e) {
            System.out.println("DAO.Pacientes.deletePaciente: " + e);
            status = "falha";
        }
       
        return status;
    }
}

