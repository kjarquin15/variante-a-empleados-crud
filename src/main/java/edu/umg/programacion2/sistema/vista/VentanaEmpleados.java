package edu.umg.programacion2.sistema.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import edu.umg.programacion2.sistema.modelo.Empleado;
import edu.umg.programacion2.sistema.servicio.EmpleadoServicio;

public class VentanaEmpleados extends JFrame {

    private static final long serialVersionUID = 1L;

    // =========================
    // COLORES
    // =========================

    private static final Color ROJO_OSCURO = new Color(128, 0, 32);
    private static final Color ROJO = new Color(180, 30, 50);
    private static final Color ROJO_CLARO = new Color(245, 225, 230);
    private static final Color BLANCO = Color.WHITE;
    private static final Color GRIS_TEXTO = new Color(60, 60, 60);

    // =========================
    // COMPONENTES
    // =========================

    private JPanel contentPane;

    private JTextField txtNombre;
    private JTextField txtPuesto;
    private JTextField txtSalario;
    private JTextField txtTelefono;
    private JTextField txtCorreo;
    private JComboBox<String> cmbContrato;

    private JTable table;
    private DefaultTableModel modeloTabla;

    // =========================
    // SERVICIO
    // =========================

    private EmpleadoServicio empleadoServicio;

    // ID del empleado seleccionado
    private int idEmpleadoSeleccionado = 0;

    // =========================
    // CONSTRUCTOR
    // =========================

    public VentanaEmpleados() {

        empleadoServicio = new EmpleadoServicio();

        setTitle("Sistema de Empleados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 650);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBackground(BLANCO);
        contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
        contentPane.setLayout(new BorderLayout(15, 15));

        setContentPane(contentPane);

        // =========================
        // TITULO
        // =========================

        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(ROJO_OSCURO);

        JLabel lblTitulo = new JLabel("SISTEMA DE EMPLEADOS");
        lblTitulo.setForeground(BLANCO);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));

        panelTitulo.add(lblTitulo);

        contentPane.add(panelTitulo, BorderLayout.NORTH);

        // =========================
        // PANEL CENTRAL
        // =========================

        JPanel panelCentral = new JPanel();
        panelCentral.setBackground(BLANCO);
        panelCentral.setLayout(new BorderLayout(15, 15));

        contentPane.add(panelCentral, BorderLayout.CENTER);

        // =========================
        // FORMULARIO
        // =========================

        JPanel panelFormulario = new JPanel();

        panelFormulario.setBackground(ROJO_CLARO);

        panelFormulario.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(ROJO_OSCURO),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
            )
        );

        panelFormulario.setLayout(new GridLayout(7, 2, 10, 10));

        // NOMBRE

        JLabel lblNombre = new JLabel("Nombre completo:");
        lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNombre.setForeground(GRIS_TEXTO);

        panelFormulario.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));

        panelFormulario.add(txtNombre);

        // PUESTO

        JLabel lblPuesto = new JLabel("Puesto:");
        lblPuesto.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPuesto.setForeground(GRIS_TEXTO);

        panelFormulario.add(lblPuesto);

        txtPuesto = new JTextField();
        txtPuesto.setFont(new Font("Tahoma", Font.PLAIN, 14));

        panelFormulario.add(txtPuesto);

        // SALARIO

        JLabel lblSalario = new JLabel("Salario:");
        lblSalario.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSalario.setForeground(GRIS_TEXTO);

        panelFormulario.add(lblSalario);

        txtSalario = new JTextField();
        txtSalario.setFont(new Font("Tahoma", Font.PLAIN, 14));

        panelFormulario.add(txtSalario);

        // TELEFONO

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTelefono.setForeground(GRIS_TEXTO);

        panelFormulario.add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));

        panelFormulario.add(txtTelefono);

        // CORREO

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCorreo.setForeground(GRIS_TEXTO);

        panelFormulario.add(lblCorreo);

        txtCorreo = new JTextField();
        txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 14));

        panelFormulario.add(txtCorreo);
        

     // TIPO DE CONTRATO
     JLabel lblContrato = new JLabel("Tipo de contrato:");
     lblContrato.setFont(new Font("Tahoma", Font.BOLD, 14));
     lblContrato.setForeground(GRIS_TEXTO);
     panelFormulario.add(lblContrato);

     cmbContrato = new JComboBox<>();
     cmbContrato.addItem("Seleccione...");
     cmbContrato.addItem("Temporal");
     cmbContrato.addItem("Permanente");
     cmbContrato.addItem("Por hora");
     cmbContrato.setFont(new Font("Tahoma", Font.PLAIN, 14));
     panelFormulario.add(cmbContrato);

        // BOTONES

        JButton btnGuardar = new JButton("GUARDAR");
        btnGuardar.setBackground(ROJO_OSCURO);
        btnGuardar.setForeground(BLANCO);
        btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnGuardar.setFocusPainted(false);

        panelFormulario.add(btnGuardar);

        JButton btnModificar = new JButton("MODIFICAR");
        btnModificar.setBackground(ROJO);
        btnModificar.setForeground(BLANCO);
        btnModificar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnModificar.setFocusPainted(false);

        panelFormulario.add(btnModificar);

        panelCentral.add(panelFormulario, BorderLayout.NORTH);

        // =========================
        // TABLA
        // =========================

        JPanel panelTabla = new JPanel();
        panelTabla.setBackground(BLANCO);
        panelTabla.setLayout(new BorderLayout(5, 5));

        JLabel lblLista = new JLabel("Lista de empleados");
        lblLista.setForeground(ROJO_OSCURO);
        lblLista.setFont(new Font("Tahoma", Font.BOLD, 18));

        panelTabla.add(lblLista, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "ID",
                "Nombre completo",
                "Puesto",
                "Salario",
                "Teléfono",
                "Correo",
                "Contrato"
            }
        ) {

            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(modeloTabla);

        table.setFont(new Font("Tahoma", Font.PLAIN, 13));
        table.setRowHeight(28);
        table.setBackground(BLANCO);
        table.setForeground(GRIS_TEXTO);
        table.setGridColor(ROJO_CLARO);

        table.getTableHeader().setBackground(ROJO_OSCURO);
        table.getTableHeader().setForeground(BLANCO);
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));

        JScrollPane scrollPane = new JScrollPane(table);

        panelTabla.add(scrollPane, BorderLayout.CENTER);

        panelCentral.add(panelTabla, BorderLayout.CENTER);

        // =========================
        // PANEL DE BOTONES INFERIOR
        // =========================

        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(BLANCO);

        JButton btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setBackground(ROJO_OSCURO);
        btnEliminar.setForeground(BLANCO);
        btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnEliminar.setFocusPainted(false);

        JButton btnLimpiar = new JButton("LIMPIAR");
        btnLimpiar.setBackground(ROJO);
        btnLimpiar.setForeground(BLANCO);
        btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnLimpiar.setFocusPainted(false);

        JButton btnActualizarLista = new JButton("ACTUALIZAR LISTA");
        btnActualizarLista.setBackground(ROJO_OSCURO);
        btnActualizarLista.setForeground(BLANCO);
        btnActualizarLista.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnActualizarLista.setFocusPainted(false);

        panelBotones.add(btnEliminar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnActualizarLista);
        
        JButton btnVerTotales = new JButton("VER TOTALES");

        btnVerTotales.setBackground(ROJO);
        btnVerTotales.setForeground(BLANCO);
        btnVerTotales.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnVerTotales.setFocusPainted(false);

        panelBotones.add(btnVerTotales);

        contentPane.add(panelBotones, BorderLayout.SOUTH);

        // =========================
        // EVENTO GUARDAR
        // =========================

        btnGuardar.addActionListener(e -> guardarEmpleado());

        // =========================
        // EVENTO MODIFICAR
        // =========================

        btnModificar.addActionListener(e -> modificarEmpleado());

        // =========================
        // EVENTO ELIMINAR
        // =========================

        btnEliminar.addActionListener(e -> eliminarEmpleado());

        // =========================
        // EVENTO LIMPIAR
        // =========================

        btnLimpiar.addActionListener(e -> limpiarCampos());

        // =========================
        // EVENTO ACTUALIZAR LISTA
        // =========================

        btnActualizarLista.addActionListener(e -> cargarEmpleados());
        btnVerTotales.addActionListener(e -> verTotales());

        // =========================
        // SELECCIONAR FILA
        // =========================

        table.getSelectionModel().addListSelectionListener(e -> {

            if (!e.getValueIsAdjusting()) {

                int fila = table.getSelectedRow();

                if (fila >= 0) {

                    idEmpleadoSeleccionado =
                            Integer.parseInt(
                                    table.getValueAt(fila, 0).toString()
                            );

                    txtNombre.setText(
                            table.getValueAt(fila, 1).toString()
                    );

                    txtPuesto.setText(
                            table.getValueAt(fila, 2).toString()
                    );

                    txtSalario.setText(
                            table.getValueAt(fila, 3).toString()
                    );

                    txtTelefono.setText(
                            table.getValueAt(fila, 4).toString()
                    );

                    txtCorreo.setText(
                            table.getValueAt(fila, 5).toString()
                    );
                    cmbContrato.setSelectedItem(
                            table.getValueAt(fila, 6).toString()
                    );
                }
            }
        });

        // =========================
        // CARGAR DATOS AL INICIAR
        // =========================

        cargarEmpleados();
    }

    // =====================================================
    // GUARDAR EMPLEADO
    // =====================================================

    private void guardarEmpleado() {

        try {

            if (!validarCampos()) {
                return;
            }

            Empleado empleado = new Empleado();

            empleado.setNombreCompleto(txtNombre.getText().trim());
            empleado.setPuesto(txtPuesto.getText().trim());

            empleado.setSalario(
                    new BigDecimal(txtSalario.getText().trim())
            );

            empleado.setTelefono(txtTelefono.getText().trim());
            empleado.setCorreo(txtCorreo.getText().trim());
            empleado.setContrato(
                    cmbContrato.getSelectedItem().toString()
            );
            empleadoServicio.guardar(empleado);

            JOptionPane.showMessageDialog(
                    this,
                    "Empleado guardado correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE
            );

            limpiarCampos();
            cargarEmpleados();

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "El salario debe ser un número válido.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error al guardar el empleado:\n" + ex.getMessage(),
                    "Error de base de datos",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =====================================================
    // MODIFICAR EMPLEADO
    // =====================================================

    private void modificarEmpleado() {

        try {

            if (idEmpleadoSeleccionado == 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Seleccione un empleado de la tabla.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            if (!validarCampos()) {
                return;
            }

            Empleado empleado = new Empleado();

            empleado.setIdEmpleado(idEmpleadoSeleccionado);
            empleado.setNombreCompleto(txtNombre.getText().trim());
            empleado.setPuesto(txtPuesto.getText().trim());

            empleado.setSalario(
                    new BigDecimal(txtSalario.getText().trim())
            );

            empleado.setTelefono(txtTelefono.getText().trim());
            empleado.setCorreo(txtCorreo.getText().trim());
            empleado.setContrato(
                    cmbContrato.getSelectedItem().toString()
            );
            empleadoServicio.actualizar(empleado);

            JOptionPane.showMessageDialog(
                    this,
                    "Empleado modificado correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE
            );

            limpiarCampos();
            cargarEmpleados();

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "El salario debe ser un número válido.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error al modificar el empleado:\n" + ex.getMessage(),
                    "Error de base de datos",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =====================================================
    // ELIMINAR EMPLEADO
    // =====================================================

    private void eliminarEmpleado() {

        try {

            if (idEmpleadoSeleccionado == 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Seleccione un empleado de la tabla.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }

            int respuesta = JOptionPane.showConfirmDialog(
                    this,
                    "¿Está seguro de eliminar este empleado?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if (respuesta != JOptionPane.YES_OPTION) {
                return;
            }

            empleadoServicio.eliminar(idEmpleadoSeleccionado);

            JOptionPane.showMessageDialog(
                    this,
                    "Empleado eliminado correctamente.",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE
            );

            limpiarCampos();
            cargarEmpleados();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error al eliminar el empleado:\n" + ex.getMessage(),
                    "Error de base de datos",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =====================================================
    // CARGAR EMPLEADOS
    // =====================================================

    private void cargarEmpleados() {

        try {

            List<Empleado> empleados = empleadoServicio.listar();

            modeloTabla.setRowCount(0);

            for (Empleado empleado : empleados) {

                modeloTabla.addRow(
                        new Object[] {
                            empleado.getIdEmpleado(),
                            empleado.getNombreCompleto(),
                            empleado.getPuesto(),
                            empleado.getSalario(),
                            empleado.getTelefono(),
                            empleado.getCorreo(),
                            empleado.getContrato()
                        }
                );
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error al cargar los empleados:\n" + ex.getMessage(),
                    "Error de base de datos",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
 // =====================================================
 // VER TOTALES
 // =====================================================

 private void verTotales() {

     try {

         List<Empleado> empleados = empleadoServicio.listar();

         if (empleados.isEmpty()) {

             JOptionPane.showMessageDialog(
                     this,
                     "No hay empleados registrados para calcular los totales.",
                     "Información",
                     JOptionPane.INFORMATION_MESSAGE
             );

             return;
         }

         BigDecimal total = BigDecimal.ZERO;

         for (Empleado empleado : empleados) {

             total = total.add(empleado.getSalario());
         }

         BigDecimal promedio = total.divide(
                 BigDecimal.valueOf(empleados.size()),
                 2,
                 java.math.RoundingMode.HALF_UP
         );

         JOptionPane.showMessageDialog(
                 this,
                 "Total de salarios: Q " + total
                 + "\nPromedio de salarios: Q " + promedio,
                 "Totales",
                 JOptionPane.INFORMATION_MESSAGE
         );

     } catch (SQLException ex) {

         JOptionPane.showMessageDialog(
                 this,
                 "Error al obtener los empleados:\n" + ex.getMessage(),
                 "Error de base de datos",
                 JOptionPane.ERROR_MESSAGE
         );
     }
 }
    // =====================================================
    // LIMPIAR CAMPOS
    // =====================================================

    private void limpiarCampos() {

        txtNombre.setText("");
        txtPuesto.setText("");
        txtSalario.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        cmbContrato.setSelectedIndex(0);
        idEmpleadoSeleccionado = 0;

        table.clearSelection();

        txtNombre.requestFocus();
    }

    // =====================================================
    // VALIDAR CAMPOS
    // =====================================================

    private boolean validarCampos() {

        String nombre = txtNombre.getText().trim();
        String puesto = txtPuesto.getText().trim();
        String salario = txtSalario.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String correo = txtCorreo.getText().trim();
        String contrato = (String) cmbContrato.getSelectedItem();

        // Validar campos vacíos
        if (nombre.isEmpty() || puesto.isEmpty() || salario.isEmpty()
                || telefono.isEmpty() || correo.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Todos los campos son obligatorios.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE
            );

            return false;
        }

        // Validar nombre
        if (nombre.length() > 50) {

            JOptionPane.showMessageDialog(
                    this,
                    "El nombre completo no puede superar los 50 caracteres.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE
            );

            return false;
        }

        // Validar salario
        try {

            BigDecimal valorSalario = new BigDecimal(salario);

            if (valorSalario.compareTo(BigDecimal.ZERO) <= 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "El salario debe ser mayor que 0.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE
                );

                return false;
            }

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    this,
                    "El salario debe contener únicamente un número válido.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE
            );

            return false;
        }

        // Validar teléfono
        if (!telefono.matches("\\d+")) {

            JOptionPane.showMessageDialog(
                    this,
                    "El teléfono debe contener únicamente números.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE
            );

            return false;
        }

        // Validar correo
        if (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {

            JOptionPane.showMessageDialog(
                    this,
                    "Ingrese un correo electrónico válido.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE
            );

            return false;
        }

    
        if (contrato == null || contrato.equals("Seleccione...")) {
            JOptionPane.showMessageDialog(this,
                    "Debe seleccionar un tipo de contrato.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    // =====================================================
    // MAIN
    // =====================================================

    public static void main(String[] args) {

        VentanaEmpleados ventana = new VentanaEmpleados();

        ventana.setVisible(true);
    }
}