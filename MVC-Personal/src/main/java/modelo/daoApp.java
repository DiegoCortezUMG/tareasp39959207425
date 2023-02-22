/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import controlador.clsApp;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;/**
 *
 * @author Usuario
 */
public class daoApp {
    
    private static final String SQL_SELECT = "SELECT appid, appnombre, appcontrasena FROM tbl_app";
    private static final String SQL_INSERT = "INSERT INTO tbl_app(appnombre, appestado) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_app SET appnombre=?, appestado=? WHERE appid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_app WHERE appid=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT appid, appnombre, appestado FROM tbl_app WHERE appnombre = ?";
    private static final String SQL_SELECT_ID = "SELECT appid, appnombre, appestado FROM tbl_app WHERE appid = ?";    

    public List<clsApp> consultaApps() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsApp> apps = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("appid");
                String nombre = rs.getString("appnombre");
                String estado = rs.getString("appestado");
                clsApp app = new clsApp();
                app.setIdApp(id);
                app.setNombreApp(nombre);
                app.setEstadoApp(estado);
                apps.add(app);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return apps;
    }

    public int ingresaApps(clsApp app) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, app.getNombreApp());
            stmt.setString(2, app.getEstadoApp());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaApps(clsApp app) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, app.getNombreApp());
            stmt.setString(2, app.getEstadoApp());
            stmt.setInt(3, app.getIdApp());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarApps(clsApp app) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, app.getIdApp());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsApp consultaAppsPorNombre(clsApp app) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + app);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setString(1, app.getNombreApp());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("usuid");
                String nombre = rs.getString("usunombre");
                String estado = rs.getString("usucontrasena");

                //usuario = new clsUsuario();
                app.setIdApp(id);
                app.setNombreApp(nombre);
                app.setEstadoApp(estado);
                System.out.println(" registro consultado: " + app);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return app;
    }
    public clsApp consultaAppsPorId(clsApp app) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + app);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, app.getIdApp());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("appid");
                String nombre = rs.getString("appnombre");
                String estado = rs.getString("appestado");

                //usuario = new clsUsuario();
                app.setIdApp(id);
                app.setNombreApp(nombre);
                app.setEstadoApp(estado);
                System.out.println(" registro consultado: " + app);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return app;
    }    
}
