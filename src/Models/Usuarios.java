package Models;

import DB_Connect.Comunica_Banco;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class Usuarios {
    private final Comunica_Banco db = new Comunica_Banco();
    private final Connection con = db.conectar();
    

    public String getDadoString(String dado, String s) {
          
     
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
        return null;
    }
    }
}
