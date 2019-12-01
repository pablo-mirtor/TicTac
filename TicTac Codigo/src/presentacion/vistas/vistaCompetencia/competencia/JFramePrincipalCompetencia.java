package presentacion.vistas.vistaCompetencia.competencia;

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

public class JFramePrincipalCompetencia extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton altaCompetencia;
	private JButton bajaCompetencia;
	private JButton listarCompetencias;
	private JButton modificarCompetencia;
	private JButton mostrarCompetencia;
	private JButton asignarCompetenciaTrabajador;
	private JButton desasignarCompetenciaTrabajador;
	private JButton asignarNivelCompetencia;
	private JButton mostrarNivelCompetencia;
	private JButton volver;
	
	public JFramePrincipalCompetencia() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Principal competencia");
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				cerrarBotonera();
			}
		});

		JPanel buttonPanel = new JPanel(new GridLayout(10, 1));

		altaCompetencia = new JButton("Alta competencia");
		bajaCompetencia = new JButton("Baja competencia");
		mostrarCompetencia = new JButton("Mostrar competencia");
		listarCompetencias = new JButton("Listar competencias");
		modificarCompetencia = new JButton("Modificar competencia");
		asignarCompetenciaTrabajador = new JButton("Asignar trabajador a competencia");
		desasignarCompetenciaTrabajador = new JButton("Desasignar trabajador a competencia");
		asignarNivelCompetencia = new JButton("Asignar nivel a competencia");
		mostrarNivelCompetencia = new JButton("Mostrar nivel competencia");
		volver = new JButton("Volver");

		altaCompetencia.setPreferredSize(new Dimension(320, 35));

		altaCompetencia.addActionListener(new ActionListenerPrincipalCompetencia(0));
		bajaCompetencia.addActionListener(new ActionListenerPrincipalCompetencia(1));
		mostrarCompetencia.addActionListener(new ActionListenerPrincipalCompetencia(2));
		listarCompetencias.addActionListener(new ActionListenerPrincipalCompetencia(3));
		modificarCompetencia.addActionListener(new ActionListenerPrincipalCompetencia(4));
		asignarCompetenciaTrabajador.addActionListener(new ActionListenerPrincipalCompetencia(5));
		desasignarCompetenciaTrabajador.addActionListener(new ActionListenerPrincipalCompetencia(6));
		asignarNivelCompetencia.addActionListener(new ActionListenerPrincipalCompetencia(7));
		mostrarNivelCompetencia.addActionListener(new ActionListenerPrincipalCompetencia(8));
		
		volver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cerrarBotonera();
			}
		});

		buttonPanel.add(altaCompetencia);
		buttonPanel.add(bajaCompetencia);
		buttonPanel.add(mostrarCompetencia);
		buttonPanel.add(listarCompetencias);
		buttonPanel.add(modificarCompetencia);
		buttonPanel.add(asignarCompetenciaTrabajador);
		buttonPanel.add(desasignarCompetenciaTrabajador);
		buttonPanel.add(asignarNivelCompetencia);
		buttonPanel.add(mostrarNivelCompetencia);
		buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	}

	public class ActionListenerPrincipalCompetencia implements ActionListener {
		private int event;

		public ActionListenerPrincipalCompetencia(int event) {
			this.event = event;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int comando = 0;

			switch (event) 
			{
				case 0:
					comando = ListaComandos.VENTANA_ALTA_COMPETENCIA;
					break;
				case 1:
					comando = ListaComandos.VENTANA_BAJA_COMPETENCIA;
					break;
				case 2:
					comando = ListaComandos.VENTANA_MOSTRAR_COMPETENCIA;
					break;
				case 3:
					comando = ListaComandos.VENTANA_LISTAR_COMPETENCIAS;
					break;
				case 4:
					comando = ListaComandos.VENTANA_MODIFICAR_COMPETENCIA;
					break;
				case 5:
					comando = ListaComandos.VENTANA_ASIGNAR_COMPETENCIA_TRABAJADOR;
					break;
				case 6:
					comando = ListaComandos.VENTANA_DESASIGNAR_COMPETENCIA_TRABAJADOR;
					break;
				case 7:
					comando = ListaComandos.VENTANA_ASIGNAR_NIVEL_COMPETENCIA;
					break;
				case 8:
					comando = ListaComandos.VENTANA_MOSTRAR_NIVEL_COMPETENCIA;
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