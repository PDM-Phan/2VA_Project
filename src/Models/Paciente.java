package Models;

import DB_Connect.Comunica_Banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Paciente {
    private final Comunica_Banco db = new Comunica_Banco();
    private final Connection con = db.conectar();
    
    
    
    public List<Hospital.Paciente> getALLPacientes() {
    String sql = "SELECT * FROM paciente"; //faz o SELECT de toda a tabela dos pacientes(posteriormente sera resumido a os vinculados ao medico
    try {
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Hospital.Paciente> listaPaciente = new ArrayList<>();//lista para guardar todos os pacientes
        while(rs.next()) { //passa por todas as linhas
            Hospital.Paciente paciente = new Hospital.Paciente();
            paciente.setId(rs.getInt("id"));
            paciente.setNome(rs.getString("nome"));
            paciente.setCpf(rs.getString("cpf"));
            paciente.setTelefone(rs.getString("telefone"));
            listaPaciente.add(paciente);
        }
        return listaPaciente;
    } catch (SQLException ex) {
        Logger.getLogger(Comunica_Banco.class.getName()).log(Level.SEVERE, null, ex);
        return null;
    }
    }
}
