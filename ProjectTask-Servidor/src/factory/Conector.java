package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {

    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/";
            String banco = "bikeshop2";
            String usuario = "root";
            String senha = "";

            return DriverManager.getConnection(url + banco, usuario, senha);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    }
}
