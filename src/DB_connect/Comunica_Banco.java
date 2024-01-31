package DB_Connect;
import java.sql.Connection; //lib do jdbc do java para a conexao com o banco
import java.sql.DriverManager; //tipo de banco de dados
import java.sql.SQLException;

public class Comunica_Banco {
    private Connection con;
    private  String driver = "com.mysql.cj.jdbc.Driver";
    private  String url = "jdbc:mysql://localhost:3306/db2va";
    private  String user = "root";
    private  String password = "Macacoalado1!";

    public String getDriver() {
        return driver;
    }

    private void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    private void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    private void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }
    
    public Connection getCon() {
        return con;
    }

    private void setCon(Connection con) {
        this.con = con;
    }
    

    public Comunica_Banco() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
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
  
}
