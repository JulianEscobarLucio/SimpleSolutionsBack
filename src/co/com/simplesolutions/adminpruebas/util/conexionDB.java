package co.com.simplesolutions.adminpruebas.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionDB {
    
    
    public static Connection getConexion() {
        String url = "jdbc:mysql://localhost:3306/administradorpruebas";
//    	String url = "jdbc:sqlserver://;database=administradorpruebas;integratedSecurity=true;";
        String usuario = "root";
        String clave = "";
        String driver = "com.mysql.jdbc.Driver";
        return getConexion(url, usuario, clave, driver);
//    	Connection conect = null;
//        try {
//        	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
//        	String connectionUrl = "jdbc:sqlserver://;database=administradorpruebas;integratedSecurity=true;";
//        	conect =  DriverManager.getConnection(connectionUrl);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
//        return conect;
    }

    public static Connection getConexion(String url, String usuario,
            String clave, String driver) {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, clave);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }
    

}
