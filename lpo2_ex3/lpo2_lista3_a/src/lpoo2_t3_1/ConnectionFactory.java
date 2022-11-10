package lpoo2_t3_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String host = "jdbc:mysql://localhost/pizzaria?useSSL=false";
    private static final String user = "root";
    private static final String pwd = "root";
    
    private ConnectionFactory(){}
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(host, user, pwd);
    }
}
