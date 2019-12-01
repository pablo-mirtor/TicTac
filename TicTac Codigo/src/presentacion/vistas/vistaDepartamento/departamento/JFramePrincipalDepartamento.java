package presentacion.vistas.vistaDepartamento.departamento;


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
 * Clase de la capa presentación que permite la implementación de la ventana principal del módulo departamento
 */
public class JFramePrincipalDepartamento extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton altaDepartamento;
	private JButton bajaDepartamento;
	private JButton mostrarDepartamento;
	private JButton listarDepartamentos;
	private JButton modificarDepartamento;
	private JButton calcularNominaDepartamento;
	private JButton volver;
	
	public JFramePrincipalDepartamento() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Principal departamento");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrarBotonera();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(7, 1));
		
		altaDepartamento = new JButton("Alta departamento");
		bajaDepartamento = new JButton("Eliminar departamento");
		mostrarDepartamento = new JButton("Mostrar departamento");
		listarDepartamentos = new JButton("Listar departamentos");
		modificarDepartamento = new JButton("Modificar departamento");
		calcularNominaDepartamento = new JButton("Calcular nómina del departamento");
		volver = new JButton("Volver");
		
		altaDepartamento.setPreferredSize(new Dimension(320, 35));
		
		altaDepartamento.addActionListener(new ActionListenerBotoneraDepartamento(0));
		bajaDepartamento.addActionListener(new ActionListenerBotoneraDepartamento(1));
		mostrarDepartamento.addActionListener(new ActionListenerBotoneraDepartamento(2));
		listarDepartamentos.addActionListener(new ActionListenerBotoneraDepartamento(3));
		modificarDepartamento.addActionListener(new ActionListenerBotoneraDepartamento(4));
		calcularNominaDepartamento.addActionListener(new ActionListenerBotoneraDepartamento(5));
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				cerrarBotonera();
			}
		});
		
		buttonPanel.add(altaDepartamento);
		buttonPanel.add(bajaDepartamento);
		buttonPanel.add(mostrarDepartamento);
		buttonPanel.add(listarDepartamentos);
		buttonPanel.add(modificarDepartamento);
		buttonPanel.add(calcularNominaDepartamento);
		buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	    this.setVisible(true);
	}
	
	public class ActionListenerBotoneraDepartamento implements ActionListener{
		private int event;
		
		public ActionListenerBotoneraDepartamento(int event){
			this.event = event;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0){
			int comando = 0;
			
			switch(event){
				case 0:
					comando = ListaComandos.VENTANA_ALTA_DEPARTAMENTO; break;
				case 1:
					comando = ListaComandos.VENTANA_BAJA_DEPARTAMENTO; break;
				case 2:
					comando = ListaComandos.VENTANA_MOSTRAR_DEPARTAMENTO; break;
				case 3:
					comando = ListaComandos.VENTANA_LISTAR_DEPARTAMENTOS; break;
				case 4:
					comando = ListaComandos.VENTANA_MODIFICAR_DEPARTAMENTO; break;
				case 5:
					comando = ListaComandos.VENTANA_CALCULAR_NOMINA_DEPARTAMENTO; break;
			}
			
			cerrarParaVistaPropia();
			Controlador.getInstance().accion(comando, null);
		}
	}
	
	public void cerrarParaVistaPropia(){
		this.setVisible(false);
	}
	
	public void cerrarBotonera(){
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL, null);
	}
}