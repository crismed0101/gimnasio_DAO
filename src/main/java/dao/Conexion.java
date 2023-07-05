package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection connection;
    private static Conexion instancia ;
    private  static final String url="jdbc:mysql://localhost:3306/bd_gimnasio";
    private static final String user="root";
    private static final String password= "madarauchiha100";

    private Conexion(){}
    public Connection getConnection(){

        try {
            connection = DriverManager.getConnection(url,user,password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cerrarConexion(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Conexion getInstance(){
        if (instancia == null){
            instancia = new Conexion();
        }

        return instancia;
    }
}
