package DB_Connect;
import java.sql.Connection; //lib do jdbc do java para a conexao com o banco
import java.sql.DriverManager; //tipo de banco de dados

public class Conecta_banco {
    private Connection con;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/db2va";
    private String user = "root";
    private String password = "Macacoalado1!";
    
    public Connection conectar() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
