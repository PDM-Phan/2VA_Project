package Models;

import DB_Connect.Comunica_Banco;
import java.sql.Connection;

public class Status {
    private final Comunica_Banco db = new Comunica_Banco();
    private final Connection con = db.conectar();
    
    
    
}
