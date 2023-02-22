/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.util.List;
import modelo.daoApp;


/**
 *
 * @author Usuario
 */
public class clsApp {
    private int IdApp;
    private String NombreApp;
    private String EstadoApp;

    public clsApp() {
    }

    public clsApp(int IdApp, String NombreApp, String EstadoApp) {
        this.IdApp = IdApp;
        this.NombreApp = NombreApp;
        this.EstadoApp = EstadoApp;
    }

    public clsApp(String NombreApp, String EstadoApp) {
        this.NombreApp = NombreApp;
        this.EstadoApp = EstadoApp;
    }

    public clsApp(int IdApp) {
        this.IdApp = IdApp;
    }

    public int getIdApp() {
        return IdApp;
    }

    public void setIdApp(int IdApp) {
        this.IdApp = IdApp;
    }

    public String getNombreApp() {
        return NombreApp;
    }

    public void setNombreApp(String NombreApp) {
        this.NombreApp = NombreApp;
    }

    public String getEstadoApp() {
        return EstadoApp;
    }

    public void setEstadoApp(String EstadoApp) {
        this.EstadoApp = EstadoApp;
    }

    @Override
    public String toString() {
        return "clsApp{" + "IdApp=" + IdApp + ", NombreApp=" + NombreApp + ", EstadoApp=" + EstadoApp + '}';
    }

    public clsApp getBuscarInformacionAppPorNombre(clsApp app)
    {
        daoApp daoapp = new daoApp();
        return daoapp.consultaAppsPorNombre(app);
    }
    public clsApp getBuscarInformacionAppPorId(clsApp app)
    {
        daoApp daousuario = new daoApp();
        return daousuario.consultaAppsPorId(app);
    }    
    public List<clsApp> getListadoApps()
    {
        daoApp daoapp = new daoApp();
        List<clsApp> listadoApps = daoapp.consultaApps();
        return listadoApps;
    }
    public int setBorrarApp(clsApp app)
    {
        daoApp daoapp = new daoApp();
        return daoapp.borrarApps(app);
    }          
    public int setIngresarApp(clsApp app)
    {
        daoApp daoapp = new daoApp();
        return daoapp.ingresaApps(app);
    }              
    public int setModificarApp(clsApp app)
    {
        daoApp daoapp = new daoApp();
        return daoapp.actualizaApps(app);
    }              
}