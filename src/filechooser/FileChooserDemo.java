package filechooser;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

/**
 * 
 * Realiza el siguiente tutorial "Adding a File Chooser to a Java Application"
 * 
 * @author Guillermo Boquizo Sánchez
 * @version 1.0
 *
 */
public class FileChooserDemo extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenuItem mntmNuevo;
	private JMenuItem mntmAbrir;
	private JMenuItem mntmGuardarComo;
	private JSeparator separador_1;
	private JMenuItem mntmConfigurarPgina;
	private JMenuItem mntmImprimir;
	private JSeparator separador_2;
	private JMenuItem mntmSalir;
	private JMenu mnEdicion;
	private JMenuItem mntmDeshacer;
	private JSeparator separator_3;
	private JMenuItem mntmCortar;
	private JMenuItem mntmCopiar;
	private JMenuItem mntmPegar;
	private JMenuItem mntmEliminar;
	private JSeparator separator_4;
	private JMenuItem mntmBuscar;
	private JMenuItem mntmBuscarSiguiente;
	private JMenuItem mntmReemplazar;
	private JMenuItem mntmIra;
	private JSeparator separator_5;
	private JMenuItem mntmSeleccionar;
	private JMenuItem mntmHoraYFecha;
	private JMenu mnFormato;
	private JCheckBoxMenuItem mntmAjusteDeLnea;
	private JMenuItem mntmFuente;
	private JMenu mnVer;
	private JMenuItem mntmBarraDeEstad;
	private JMenu mnAyuda;
	private JMenuItem mntmNewMenuItem_14;
	private JSeparator separator;
	private JMenuItem mntmAcercaDe;
	protected Frame frame;
	private JMenuItem mntmGuardar;
	private Container contenedor;
	JTextArea areaDeTexto;
	JButton botonAbrir;
	JButton botonGuardar;
	JScrollPane scrollPaneArea;
	JFileChooser fileChooser;
	String texto;

	public FileChooserDemo() {
		setResizable(false);
		contenedor = getContentPane();
		contenedor = new Container();
		contenedor.setBackground(new Color(100, 149, 237));
		fileChooser = new JFileChooser();
		getContentPane().setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(FileChooserDemo.class.getResource("/filechooser/resources/favicon.png")));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(10, 11, 492, 419);
		getContentPane().add(panel);
		panel.setLayout(null);
		scrollPaneArea = new JScrollPane();
		scrollPaneArea.setBounds(10, 11, 472, 358);
		panel.add(scrollPaneArea);

		areaDeTexto = new JTextArea();
		scrollPaneArea.setViewportView(areaDeTexto);
		areaDeTexto.setLineWrap(true);
		// permite que no queden palabras incompletas al hacer el salto de linea
		areaDeTexto.setWrapStyleWord(true);

		botonAbrir = new JButton();
		botonAbrir.setBounds(47, 385, 73, 23);
		panel.add(botonAbrir);
		botonAbrir.setText("Abrir");

		botonGuardar = new JButton();
		botonGuardar.setBounds(117, 385, 85, 23);
		panel.add(botonGuardar);
		botonGuardar.setText("Guardar");
		botonGuardar.addActionListener(this);
		botonAbrir.addActionListener(this);
		setTitle("JFileChooserDemo");
		setSize(518, 487);
		// pone la ventana en el Centro de la pantalla
		setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == botonAbrir) {
			String archivo = abrirArchivo();
			areaDeTexto.setText(archivo);
		}

		if (evento.getSource() == botonGuardar) {
			guardarArchivo();
		}
	}

	{
		menuBar = new JMenuBar();
		menuBar.setBackground(new Color(100, 149, 237));
		setJMenuBar(menuBar);
		{
			mnArchivo = new JMenu("Archivo");
			menuBar.add(mnArchivo);
			{
				mntmNuevo = new JMenuItem("Nuevo");
				mnArchivo.add(mntmNuevo);
			}
			{
				mntmAbrir = new JMenuItem("Abrir...");
				mntmAbrir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String archivo = abrirArchivo();
						areaDeTexto.setText(archivo);
					}
				});
				mnArchivo.add(mntmAbrir);
			}
			{
				mntmGuardar = new JMenuItem("Guardar");

				mntmGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Object[] options = { "Si", "No", "Cancelar" };
						JOptionPane.showOptionDialog((Component) frame, "¿Desea guardar los cambios?", "Confirmación",
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
								options[2]);
					}
				});

				mnArchivo.add(mntmGuardar);

				mntmGuardarComo = new JMenuItem("Guardar como...");
				mntmGuardarComo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showConfirmDialog(frame, "¿Realmente desea guardar los datos?", "Confirmación",
								JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						guardarArchivo();
					}
				});
				mnArchivo.add(mntmGuardarComo);

				separador_1 = new JSeparator();
				mnArchivo.add(separador_1);

				mntmConfigurarPgina = new JMenuItem("Configurar página...");
				mnArchivo.add(mntmConfigurarPgina);
				{
					mntmImprimir = new JMenuItem("Imprimir...");
					mnArchivo.add(mntmImprimir);
				}
				{
					separador_2 = new JSeparator();
					mnArchivo.add(separador_2);
				}
				{
					mntmSalir = new JMenuItem("Salir");
					mntmSalir.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.exit(0);
						}
					});
					mnArchivo.add(mntmSalir);
				}
			}

			{
				mnEdicion = new JMenu("Edición");
				menuBar.add(mnEdicion);
				{
					mntmDeshacer = new JMenuItem("Deshacer");
					mnEdicion.add(mntmDeshacer);
				}
				{
					separator_3 = new JSeparator();
					mnEdicion.add(separator_3);
				}
				{
					mntmCortar = new JMenuItem("Cortar");
					mnEdicion.add(mntmCortar);
				}
				{
					mntmCopiar = new JMenuItem("Copiar");
					mnEdicion.add(mntmCopiar);
				}
				{
					mntmPegar = new JMenuItem("Pegar");
					mnEdicion.add(mntmPegar);
				}
				{
					mntmEliminar = new JMenuItem("Eliminar");
					mnEdicion.add(mntmEliminar);
				}
				{
					separator_4 = new JSeparator();
					mnEdicion.add(separator_4);
				}
				{
					mntmBuscar = new JMenuItem("Buscar...");
					mnEdicion.add(mntmBuscar);
				}
				{
					mntmBuscarSiguiente = new JMenuItem("Buscar siguiente...");
					mnEdicion.add(mntmBuscarSiguiente);
				}
				{
					mntmReemplazar = new JMenuItem("Reemplazar...");
					mnEdicion.add(mntmReemplazar);
				}
				{
					mntmIra = new JMenuItem("Ir a...");
					mnEdicion.add(mntmIra);
				}
				{
					separator_5 = new JSeparator();
					mnEdicion.add(separator_5);
				}
				{
					mntmSeleccionar = new JMenuItem("Seleccionar todo...");
					mnEdicion.add(mntmSeleccionar);
				}
				{
					mntmHoraYFecha = new JMenuItem("Hora y fecha");
					mnEdicion.add(mntmHoraYFecha);
				}
			}
			{
				mnFormato = new JMenu("Formato");
				menuBar.add(mnFormato);

				mntmAjusteDeLnea = new JCheckBoxMenuItem("Ajuste de línea");
				mntmAjusteDeLnea.setSelected(true);
				mnFormato.add(mntmAjusteDeLnea);

				mntmFuente = new JMenuItem("Fuente...");
				mnFormato.add(mntmFuente);
			}

			mnVer = new JMenu("Ver");
			menuBar.add(mnVer);
			{
				mntmBarraDeEstad = new JMenuItem("Barra de estado");
				mnVer.add(mntmBarraDeEstad);
			}

			mnAyuda = new JMenu("Ayuda");
			menuBar.add(mnAyuda);
			{
				mntmNewMenuItem_14 = new JMenuItem("Ver la Ayuda");
				mnAyuda.add(mntmNewMenuItem_14);
			}
			{
				separator = new JSeparator();
				mnAyuda.add(separator);
			}
			{
				mntmAcercaDe = new JMenuItem("Acerca de...");
				mnAyuda.add(mntmAcercaDe);
			}
		}

	}

	/**
	 * Permite mostrar la ventana que carga archivos en el area de texto
	 * 
	 * @return texto, el texto contenido en el área de texto.
	 */
	private String abrirArchivo() {

		String aux = "";
		texto = "";

		try {
			fileChooser.showOpenDialog(this);
			File abrir = fileChooser.getSelectedFile();

			/*
			 * recorremos el archivo, lo leemos para plasmarlo en el area de
			 * texto
			 */
			if (abrir != null) {
				FileReader archivos = new FileReader(abrir);
				BufferedReader leer = new BufferedReader(archivos);
				while ((aux = leer.readLine()) != null) {
					texto += aux + "\n";
				}

				leer.close();
			}
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, ex + "" + "\nNo se ha encontrado el archivo", "¡ERROR!!!!",
					JOptionPane.WARNING_MESSAGE);
		}
		return texto;
	}

	/**
	 * Guardamos el archivo del area de texto en el equipo
	 */
	private void guardarArchivo() {

		try {
			@SuppressWarnings("unused")
			String nombre = "";
			JFileChooser file = new JFileChooser();
			file.showSaveDialog(this);
			File guardar = file.getSelectedFile();

			if (guardar != null) {
				nombre = file.getSelectedFile().getName();
				FileWriter save = new FileWriter(guardar + ".txt");
				save.write(areaDeTexto.getText());
				save.close();
				JOptionPane.showMessageDialog(null, "El archivo se ha guardado con éxito", "Información",
						JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Su archivo no se ha guardado", "Advertencia",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	/**
	 * Lanza la aplicación.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileChooserDemo frame = new FileChooserDemo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
