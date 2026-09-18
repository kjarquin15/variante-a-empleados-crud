package edu.umg.programacion2.sistema.vista;
import java.awt.BorderLayout; 
import java.awt.Color; 
import java.awt.Font; 
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class VentanaEmpleados extends JFrame {

	private static final long serialVersionUID = 1L;

	// ==============================
	// COLORES
	// ==============================

	private static final Color ROJO_OSCURO = new Color(128, 0, 32);
	private static final Color ROJO = new Color(180, 30, 50);
	private static final Color ROJO_CLARO = new Color(245, 225, 230);
	private static final Color BLANCO = Color.WHITE;
	private static final Color GRIS_TEXTO = new Color(60, 60, 60);

	// ==============================
	// COMPONENTES
	// ==============================

	private JPanel contentPane;

	private JTextField txtNombre;
	private JTextField txtPuesto;
	private JTextField txtSalario;

	private JTable table;

	private DefaultTableModel modeloTabla;

	// ==============================
	// CONSTRUCTOR
	// ==============================

	public VentanaEmpleados() {

		setTitle("Sistema de Empleados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 600);
		setLocationRelativeTo(null);

		// ==============================
		// PANEL PRINCIPAL
		// ==============================

		contentPane = new JPanel();
		contentPane.setBackground(BLANCO);
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		contentPane.setLayout(new BorderLayout(15, 15));

		setContentPane(contentPane);

		// ==============================
		// ENCABEZADO
		// ==============================

		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(ROJO_OSCURO);

		JLabel lblTitulo = new JLabel("SISTEMA DE EMPLEADOS");
		lblTitulo.setForeground(BLANCO);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));

		panelTitulo.add(lblTitulo);

		contentPane.add(panelTitulo, BorderLayout.NORTH);

		// ==============================
		// PANEL CENTRAL
		// ==============================

		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(BLANCO);
		panelCentral.setLayout(new BorderLayout(15, 15));

		contentPane.add(panelCentral, BorderLayout.CENTER);

		// ==============================
		// FORMULARIO
		// ==============================

		JPanel panelFormulario = new JPanel();

		panelFormulario.setBackground(ROJO_CLARO);
		panelFormulario.setBorder(
			BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(ROJO_OSCURO),
				BorderFactory.createEmptyBorder(15, 15, 15, 15)
			)
		);

		panelFormulario.setLayout(new GridLayout(4, 2, 10, 10));

		// Nombre completo

		JLabel lblNombre = new JLabel("Nombre completo:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setForeground(GRIS_TEXTO);

		panelFormulario.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));

		panelFormulario.add(txtNombre);

		// Puesto

		JLabel lblPuesto = new JLabel("Puesto:");
		lblPuesto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPuesto.setForeground(GRIS_TEXTO);

		panelFormulario.add(lblPuesto);

		txtPuesto = new JTextField();
		txtPuesto.setFont(new Font("Tahoma", Font.PLAIN, 14));

		panelFormulario.add(txtPuesto);

		// Salario

		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalario.setForeground(GRIS_TEXTO);

		panelFormulario.add(lblSalario);

		txtSalario = new JTextField();
		txtSalario.setFont(new Font("Tahoma", Font.PLAIN, 14));

		panelFormulario.add(txtSalario);

		// ==============================
		// BOTÓN GUARDAR
		// ==============================

		JButton btnGuardar = new JButton("GUARDAR");

		btnGuardar.setBackground(ROJO_OSCURO);
		btnGuardar.setForeground(BLANCO);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGuardar.setFocusPainted(false);

		panelFormulario.add(btnGuardar);

		// ==============================
		// BOTÓN LIMPIAR
		// ==============================

		JButton btnLimpiar = new JButton("LIMPIAR");

		btnLimpiar.setBackground(ROJO);
		btnLimpiar.setForeground(BLANCO);
		btnLimpiar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLimpiar.setFocusPainted(false);

		panelFormulario.add(btnLimpiar);

		panelCentral.add(panelFormulario, BorderLayout.NORTH);

		// ==============================
		// TÍTULO DE LA TABLA
		// ==============================

		JPanel panelTabla = new JPanel();
		panelTabla.setBackground(BLANCO);
		panelTabla.setLayout(new BorderLayout(5, 5));

		JLabel lblLista = new JLabel("Lista de empleados");
		lblLista.setForeground(ROJO_OSCURO);
		lblLista.setFont(new Font("Tahoma", Font.BOLD, 18));

		panelTabla.add(lblLista, BorderLayout.NORTH);

		// ==============================
		// TABLA
		// ==============================

		modeloTabla = new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"ID",
				"Nombre completo",
				"Puesto",
				"Salario"
			}
		);

		table = new JTable(modeloTabla);

		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setRowHeight(28);
		table.setBackground(BLANCO);
		table.setForeground(GRIS_TEXTO);
		table.setGridColor(ROJO_CLARO);

		// Encabezado de tabla

		table.getTableHeader().setBackground(ROJO_OSCURO);
		table.getTableHeader().setForeground(BLANCO);
		table.getTableHeader().setFont(
			new Font("Tahoma", Font.BOLD, 13)
		);

		JScrollPane scrollPane = new JScrollPane(table);

		panelTabla.add(scrollPane, BorderLayout.CENTER);

		panelCentral.add(panelTabla, BorderLayout.CENTER);

		// ==============================
		// BOTÓN LIMPIAR
		// ==============================

		btnLimpiar.addActionListener(e -> {

			txtNombre.setText("");
			txtPuesto.setText("");
			txtSalario.setText("");

			txtNombre.requestFocus();
		});

		// ==============================
		// BOTÓN GUARDAR
		// ==============================

		btnGuardar.addActionListener(e -> {

			String nombre = txtNombre.getText();
			String puesto = txtPuesto.getText();
			String salario = txtSalario.getText();

			if (!nombre.isEmpty() && !puesto.isEmpty() && !salario.isEmpty()) {

				int id = modeloTabla.getRowCount() + 1;

				modeloTabla.addRow(
					new Object[] {
						id,
						nombre,
						puesto,
						salario
					}
				);

				txtNombre.setText("");
				txtPuesto.setText("");
				txtSalario.setText("");

				txtNombre.requestFocus();
			}
		});
	}

	// ==============================
	// MÉTODO MAIN
	// ==============================

	public static void main(String[] args) {

		VentanaEmpleados ventana = new VentanaEmpleados();

		ventana.setVisible(true);
	}
}

