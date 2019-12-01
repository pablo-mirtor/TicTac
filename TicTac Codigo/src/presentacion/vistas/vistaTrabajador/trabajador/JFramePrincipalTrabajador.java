package presentacion.vistas.vistaTrabajador.trabajador;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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

public class JFramePrincipalTrabajador extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton altaTrabajador;
	private JButton bajaTrabajador;
	private JButton mostrarTrabajador;
	private JButton listarTrabajadores;
	private JButton modificarTrabajador;
	private JButton salir;
	
	public JFramePrincipalTrabajador() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		this.setTitle("Principal trabajador");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				cerrarBotonera();
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(6, 1));

		altaTrabajador = new JButton("Alta trabajador");
		bajaTrabajador = new JButton("Baja trabajador");
		mostrarTrabajador = new JButton("Mostrar trabajador");
		listarTrabajadores = new JButton("Listar trabajadores");
		modificarTrabajador = new JButton("Modificar trabajador");
		salir = new JButton("Volver");

		altaTrabajador.setPreferredSize(new Dimension(320, 35));

		altaTrabajador.addActionListener(new ActionListenerPrincipalTrabajador(0));
		bajaTrabajador.addActionListener(new ActionListenerPrincipalTrabajador(1));
		mostrarTrabajador.addActionListener(new ActionListenerPrincipalTrabajador(2));
		listarTrabajadores.addActionListener(new ActionListenerPrincipalTrabajador(3));
		modificarTrabajador.addActionListener(new ActionListenerPrincipalTrabajador(4));

		salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cerrarBotonera();
			}
		});

		buttonPanel.add(altaTrabajador);
		buttonPanel.add(bajaTrabajador);
		buttonPanel.add(mostrarTrabajador);
		buttonPanel.add(listarTrabajadores);
		buttonPanel.add(modificarTrabajador);
		buttonPanel.add(salir);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	}

	public class ActionListenerPrincipalTrabajador implements ActionListener {
		private int event;

		public ActionListenerPrincipalTrabajador(int event) {
			this.event = event;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int comando = 0;

			switch (event) {
				case 0:
					comando = ListaComandos.VENTANA_ALTA_TRABAJADOR;
					break;
				case 1:
					comando = ListaComandos.VENTANA_BAJA_TRABAJADOR;
					break;
				case 2:
					comando = ListaComandos.VENTANA_MOSTRAR_TRABAJADOR;
					break;
				case 3:
					comando = ListaComandos.VENTANA_LISTAR_TRABAJADORES;
					break;
				case 4:
					comando = ListaComandos.VENTANA_MODIFICAR_TRABAJADOR;
					break;
			}

			cerrarParaVistaPropia();
			Controlador.getInstance().accion(comando, null);
		}
	}

	public void cerrarParaVistaPropia() {
		this.setVisible(false);
	}

	public void cerrarBotonera() {
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL, null);
	}
}