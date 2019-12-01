package presentacion.vistas.vistaPrincipal.principal;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import presentacion.comandos.ListaComandos;
import presentacion.controlador.Controlador;

/**
 * Clase de la capa presentacion que permite la vista de la ventana principal de la aplicación. Hereda de JFrame.
 */
public class JFramePrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton cliente;
	private JButton compra;
	private JButton reloj;
	private JButton trabajador;
	private JButton competencia;
	private JButton departamento;
	private JButton salir;
	
	/**
	 * Contructor de la clase. Inicia la ventana principal
	 */
	public JFramePrincipal(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("TicTac");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {ocultarVentana();}});
		
		//Creamos nuestro panel de botones, que contendra los botones que nos permitiran abrir el resto de apartados de la aplicacion
		JPanel buttonPanel = new JPanel(new GridLayout(7, 1));
		
		//Inicializamos los botones
		cliente = new JButton("Módulo Cliente");
		compra = new JButton("Módulo Compra");
		reloj = new JButton("Módulo Reloj");
		trabajador = new JButton("Módulo Trabajador");
		competencia = new JButton("Módulo Competencia");
		departamento = new JButton("Módulo Departamento");
		salir = new JButton("Salir");
		
		//Añadimos los actionListeners a los botones, que ejecutaran los metodos del controlador en funcion del evento
		cliente.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				ocultarVentana();
				Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_CLIENTE, null);
			}
		});
		
		compra.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				ocultarVentana();
				Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_COMPRA, null);
			}
		});
		
		reloj.setPreferredSize(new Dimension(300, 35));
		
		reloj.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				ocultarVentana();
				Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_RELOJ, null);
			}
		});
		
		trabajador.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				ocultarVentana();
				Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_TRABAJADOR, null);
			}
		});
		
		competencia.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				ocultarVentana();
				Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_COMPETENCIA, null);
			}
		});
		
		departamento.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				ocultarVentana();
				Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_DEPARTAMENTO, null);
			}
		});
		
		salir.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				cerrarAplicacion();
			}
		});
		
		
		this.getContentPane().add(cliente);
		this.getContentPane().add(compra);
		this.getContentPane().add(reloj);
		this.getContentPane().add(trabajador);
		this.getContentPane().add(competencia);
		this.getContentPane().add(departamento);
		this.getContentPane().add(salir);
		
		//Añadimos a la ventana principal los botones
		buttonPanel.add(reloj);
		buttonPanel.add(cliente);
		buttonPanel.add(compra);
		buttonPanel.add(trabajador);
		buttonPanel.add(competencia);
		buttonPanel.add(departamento);
		buttonPanel.add(salir);
		
		//Añadimos al Contentpane nuestro panel de botones
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	    this.setVisible(true);
	}
	
	/**
	 * Funcion que oculta la ventana sin finalizar la ejecución del programa.
	 */
	public void ocultarVentana(){
		this.setVisible(false);
	}
	
	/**
	 * Funcion que cierra la aplicacion finalizando la ejecución del programa.
	 */
	public void cerrarAplicacion(){
		this.dispose();
		System.exit(0);
	}	
}