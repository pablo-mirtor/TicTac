package presentacion.vistas.vistaReloj.reloj;

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
 * Clase de la capa presentacion que implementa la ventana principal de reloj
 */
public class JFramePrincipalReloj extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JButton altaRelojAnalogico;
	private JButton altaRelojDigital;
	private JButton bajaReloj;
	private JButton mostrarReloj;
	private JButton listarRelojes;
	private JButton modificarRelojAnalogico;
	private JButton modificarRelojDigital;
	private JButton volver;
	
	public JFramePrincipalReloj(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Principal reloj");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrarPrincipal();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(8, 1));
		
		altaRelojAnalogico = new JButton("Crear reloj analógico");
		altaRelojDigital = new JButton("Crear reloj digital");
		bajaReloj = new JButton("Eliminar reloj");
		mostrarReloj = new JButton("Mostrar reloj");
		listarRelojes = new JButton("Listar relojes");
		modificarRelojAnalogico = new JButton("Modificar reloj analógico");
		modificarRelojDigital = new JButton("Modificar reloj digital");
		
		volver = new JButton("Volver");
		
		altaRelojAnalogico.setPreferredSize(new Dimension(320, 35));
		
		altaRelojAnalogico.addActionListener(new ActionListenerPrincipalReloj(0));
		altaRelojDigital.addActionListener(new ActionListenerPrincipalReloj(1));
		bajaReloj.addActionListener(new ActionListenerPrincipalReloj(2));
		mostrarReloj.addActionListener(new ActionListenerPrincipalReloj(3));
		listarRelojes.addActionListener(new ActionListenerPrincipalReloj(4));
		modificarRelojAnalogico.addActionListener(new ActionListenerPrincipalReloj(5));
		modificarRelojDigital.addActionListener(new ActionListenerPrincipalReloj(6));
		
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				cerrarPrincipal();
			}
		});
		
		buttonPanel.add(altaRelojAnalogico);
		buttonPanel.add(altaRelojDigital);
		buttonPanel.add(bajaReloj);
		buttonPanel.add(mostrarReloj);
		buttonPanel.add(listarRelojes);
		buttonPanel.add(modificarRelojAnalogico);
		buttonPanel.add(modificarRelojDigital);
		buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	    this.setVisible(true);
	}
	
	public class ActionListenerPrincipalReloj implements ActionListener {
		private int event;
		
		public ActionListenerPrincipalReloj(int event){
			this.event = event;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0){
			int comando = 0;
			
			switch(event){
				case 0:
					comando = ListaComandos.VENTANA_ALTA_RELOJ_ANALOGICO;
					break;
				case 1:
					comando = ListaComandos.VENTANA_ALTA_RELOJ_DIGITAL;
					break;
				case 2:
					comando = ListaComandos.VENTANA_BAJA_RELOJ;
					break;
				case 3:
					comando = ListaComandos.VENTANA_MOSTRAR_RELOJ;
					break;
				case 4:
					comando = ListaComandos.VENTANA_LISTAR_RELOJES;
					break;
				case 5:
					comando = ListaComandos.VENTANA_MODIFICAR_RELOJ_ANALOGICO;
					break;
				case 6:
					comando = ListaComandos.VENTANA_MODIFICAR_RELOJ_DIGITAL;
					break;
			}
			
			cerrarParaVistaPropia();
			Controlador.getInstance().accion(comando, null);
		}
	}
	
	public void cerrarParaVistaPropia(){
		this.setVisible(false);
	}
	
	public void cerrarPrincipal(){
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL, null);
	}
}
