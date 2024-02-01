package Models;

import DB_Connect.Comunica_Banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Status {
    private final Comunica_Banco db = new Comunica_Banco();
    private final Connection con = db.conectar();
    
    public String getStatusAtd(String cpf) {
        String sqlStatus = String.format("SELECT * FROM status_atd WHERE cpf_paciente = '%s';", cpf);
        try {
            PreparedStatement stmt1 = con.prepareStatement(sqlStatus);
            ResultSet rs1 = stmt1.executeQuery();
            rs1.next();
            String status = rs1.getString("sts_atd");
            return status;
        } catch (SQLException e) {
            System.out.println("Status.getStatusAtd(String cpf): " + e);
            return null;
        }
    }
    
    public String getTipoAtd(String cpf) {
        String sqlAtd = String.format("SELECT * FROM status_atd WHERE cpf_paciente = '%s';", cpf);
        try {
            PreparedStatement stmt1 = con.prepareStatement(sqlAtd);
            ResultSet rs1 = stmt1.executeQuery();
            rs1.next();
            String tipoAtd = rs1.getString("tipo_atd");
            System.out.println(tipoAtd);
            return tipoAtd;
        } catch (SQLException e) {
            System.out.println("Status.getTipoAtd(String cpf): " + e);
            return null;
        }
    }
    
}
