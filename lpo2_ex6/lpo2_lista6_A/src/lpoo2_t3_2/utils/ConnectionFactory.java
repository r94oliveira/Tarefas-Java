package lpoo2_t3_2.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    public static Connection getConnection() {
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            String servername = "localhost";
            String database = "lpoo2_3_2";
            String url = "jdbc:mysql://" + servername + "/" + database + "?useSSL=false";
            String username = "root";
            String password = "1234";
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
