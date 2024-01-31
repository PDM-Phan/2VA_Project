package DB_Connect;
import Hospital.Paciente;
import java.sql.Connection; //lib do jdbc do java para a conexao com o banco
import java.sql.DriverManager; //tipo de banco de dados
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Comunica_Banco {
    private Connection con;
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/db2va";
    private final String user = "root";
    private final String password = "Macacoalado1!";
    
    public Connection conectar() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    
    public String getDadoString(String dado, String s) {
        String select = String.format("SELECT * FROM usuarios WHERE %s = '%s';", dado, s);
        System.out.println(select);
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password); // Abrir conexão com o banco
            PreparedStatement stmt = con.prepareStatement(select); // Prepara o SELECT
            ResultSet rs = stmt.executeQuery(); // Executa o SELECT
            if (rs.next()) { // Move cursor para a primeira linha
                String result = rs.getString(dado); // Retorna a string desejada da coluna
                return result;
            } else {
                System.out.println("Linha vazia.");
                return null; 
            }
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }
    
    public List<Paciente> getALLPacientes() {
        String sql = "SELECT * FROM paciente"; //faz o SELECT de toda a tabela dos pacientes(posteriormente sera resumido a os vinculados ao medico
        try {
            con = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Paciente> listaPaciente = new ArrayList<>();//lista para guardar todos os pacientes
            while(rs.next()) { //passa por todas as linhas
                Paciente paciente = new Paciente();
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
