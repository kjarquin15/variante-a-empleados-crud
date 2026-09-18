package edu.umg.programacion2.sistema.dao;

import edu.umg.programacion2.sistema.conexion.ConexionBD;
import edu.umg.programacion2.sistema.modelo.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    // CREATE
    public void guardar(Empleado empleado) throws SQLException {

        String sql = """
                INSERT INTO empleados
                (nombre_completo, puesto, salario, telefono, correo)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, empleado.getNombreCompleto());
            sentencia.setString(2, empleado.getPuesto());
            sentencia.setBigDecimal(3, empleado.getSalario());
            sentencia.setString(4, empleado.getTelefono());
            sentencia.setString(5, empleado.getCorreo());

            sentencia.executeUpdate();
        }
    }

    // READ
    public List<Empleado> listar() throws SQLException {

        List<Empleado> empleados = new ArrayList<>();

        String sql = """
                SELECT id_empleado, nombre_completo, puesto,
                       salario, telefono, correo
                FROM empleados
                """;

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery()) {

            while (resultado.next()) {

                Empleado empleado = new Empleado();

                empleado.setIdEmpleado(resultado.getInt("id_empleado"));
                empleado.setNombreCompleto(resultado.getString("nombre_completo"));
                empleado.setPuesto(resultado.getString("puesto"));
                empleado.setSalario(resultado.getBigDecimal("salario"));
                empleado.setTelefono(resultado.getString("telefono"));
                empleado.setCorreo(resultado.getString("correo"));

                empleados.add(empleado);
            }
        }

        return empleados;
    }

    // UPDATE
    public void actualizar(Empleado empleado) throws SQLException {

        String sql = """
                UPDATE empleados
                SET nombre_completo = ?,
                    puesto = ?,
                    salario = ?,
                    telefono = ?,
                    correo = ?
                WHERE id_empleado = ?
                """;

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setString(1, empleado.getNombreCompleto());
            sentencia.setString(2, empleado.getPuesto());
            sentencia.setBigDecimal(3, empleado.getSalario());
            sentencia.setString(4, empleado.getTelefono());
            sentencia.setString(5, empleado.getCorreo());
            sentencia.setInt(6, empleado.getIdEmpleado());

            sentencia.executeUpdate();
        }
    }

    // DELETE
    public void eliminar(int idEmpleado) throws SQLException {

        String sql = "DELETE FROM empleados WHERE id_empleado = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {

            sentencia.setInt(1, idEmpleado);

            sentencia.executeUpdate();
        }
    }
}