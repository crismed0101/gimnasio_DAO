package interfaces;

import dao.Conexion;
import logica.Gimnasio;

import javax.swing.*;
import java.sql.*;

public class DAOGimnasioImplementacion implements DAOGimnasio {

    Conexion conexion = Conexion.getInstance();

    @Override
    public void registar(Gimnasio gimnasio) {
        try {
            Connection con = conexion.getConnection();
            PreparedStatement registrar = con.prepareStatement("insert into cliente values(?,?,?,?) ");
            registrar.setString(1,gimnasio.getNombre());
            registrar.setString(2,gimnasio.getDni());
            registrar.setString(3,gimnasio.getDireccion());
            registrar.setString(4,gimnasio.getCelular());

            registrar.executeUpdate();

            conexion.cerrarConexion();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void modificar(Gimnasio gimnasio) {

        try {
            Connection con = conexion.getConnection();

            PreparedStatement modificar = con.prepareStatement("update cliente set nombre = ?  ,direccion =? , celular =? where dni =?");
            modificar.setString(1,gimnasio.getNombre());

            modificar.setString(2,gimnasio.getDireccion());
            modificar.setString(3,gimnasio.getCelular());
            modificar.setString(4,gimnasio.getDni());

            modificar.executeUpdate();

            conexion.cerrarConexion();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void eliminar(Gimnasio gimnasio) {


        try {
            Connection con = conexion.getConnection();

            PreparedStatement eliminar = con.prepareStatement("delete from cliente where dni =? ");
            eliminar.setString(1, gimnasio.getDni());
            eliminar.executeUpdate();
            conexion.cerrarConexion();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void buscar(Gimnasio gimnasio) {
        try {
            Connection con = conexion.getConnection();
            PreparedStatement buscar = con.prepareStatement("select * from cliente where dni = ? ");
            buscar.setString(1,gimnasio.getDni() );

            ResultSet consula = buscar.executeQuery();
            if (consula.next()){
                gimnasio.setNombre(consula.getString("nombre"));
                gimnasio.setDni(consula.getString("dni"));
                gimnasio.setDireccion(consula.getString("direccion"));
                gimnasio.setCelular(consula.getString("celular"));
            }
            conexion.cerrarConexion();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
