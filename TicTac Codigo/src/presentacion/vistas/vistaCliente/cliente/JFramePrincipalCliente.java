package presentacion.vistas.vistaCliente.cliente;

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
 * Clase de la capa presentación que permite la implementación de la ventana principal del módulo cliente
 */
public class JFramePrincipalCliente extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton altaCliente;
	private JButton bajaCliente;
	private JButton mostrarCliente;
	private JButton listarClientes;
	private JButton modificarCliente;
	private JButton volver;
	
	public JFramePrincipalCliente() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Principal cliente");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrarBotonera();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(6, 1));
		
		altaCliente = new JButton("Alta Cliente");
		bajaCliente = new JButton("Eliminar Cliente");
		mostrarCliente = new JButton("Mostrar cliente");
		listarClientes = new JButton("Listar clientes");
		modificarCliente = new JButton("Modificar cliente");
		volver = new JButton("Volver");
		
		altaCliente.setPreferredSize(new Dimension(320, 35));
		
		altaCliente.addActionListener(new ActionListenerBotoneraCliente(0));
		bajaCliente.addActionListener(new ActionListenerBotoneraCliente(1));
		mostrarCliente.addActionListener(new ActionListenerBotoneraCliente(2));
		listarClientes.addActionListener(new ActionListenerBotoneraCliente(3));
		modificarCliente.addActionListener(new ActionListenerBotoneraCliente(4));
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				cerrarBotonera();
			}
		});
		
		buttonPanel.add(altaCliente);
		buttonPanel.add(bajaCliente);
		buttonPanel.add(mostrarCliente);
		buttonPanel.add(listarClientes);
		buttonPanel.add(modificarCliente);
		buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	    this.setVisible(true);
	}
	
	public class ActionListenerBotoneraCliente implements ActionListener{
		private int event;
		
		public ActionListenerBotoneraCliente(int event){
			this.event = event;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0){
			int comando = 0;
			
			switch(event){
				case 0:
					comando = ListaComandos.VENTANA_ALTA_CLIENTE; break;
				case 1:
					comando = ListaComandos.VENTANA_BAJA_CLIENTE; break;
				case 2:
					comando = ListaComandos.VENTANA_MOSTRAR_CLIENTE; break;
				case 3:
					comando = ListaComandos.VENTANA_LISTAR_CLIENTES; break;
				case 4:
					comando = ListaComandos.VENTANA_MODIFICAR_CLIENTE; break;
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
