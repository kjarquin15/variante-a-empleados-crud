package edu.umg.programacion2.sistema.servicio;

import edu.umg.programacion2.sistema.dao.EmpleadoDAO;
import edu.umg.programacion2.sistema.modelo.Empleado;

import java.sql.SQLException;
import java.util.List;

public class EmpleadoServicio {

    private final EmpleadoDAO empleadoDAO;

    public EmpleadoServicio() {
        this.empleadoDAO = new EmpleadoDAO();
    }

    public void guardar(Empleado empleado) throws SQLException {
        empleadoDAO.guardar(empleado);
    }

    public List<Empleado> listar() throws SQLException {
        return empleadoDAO.listar();
    }

    public void actualizar(Empleado empleado) throws SQLException {
        empleadoDAO.actualizar(empleado);
    }

    public void eliminar(int idEmpleado) throws SQLException {
        empleadoDAO.eliminar(idEmpleado);
    }
}