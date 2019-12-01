package presentacion.vistas.vistaCompra.compra;

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
 * Clase de la capa presentación que permite la implementación de la ventana de la ventana principal de compra
 */
public class JFramePrincipalCompra extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JButton iniciarCompra;
	private JButton devolucionCompra;
	private JButton detalleCompra;
	private JButton listarCompras;
	private JButton volver;
	private JButton cantidadRelojes;
	private JButton numeroClientes;
	
	public JFramePrincipalCompra(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Principal compra");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrarBotonera();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(7, 1));
		iniciarCompra = new JButton("Iniciar compra");
		devolucionCompra = new JButton("Devolver compra");
		detalleCompra = new JButton("Mostrar compra");
		listarCompras = new JButton("Listar compras");
		cantidadRelojes =new JButton("Cantidad de relojes");
		numeroClientes = new JButton("Número de clientes");
		volver = new JButton("Volver");
		
		iniciarCompra.setPreferredSize(new Dimension(320, 35));

		iniciarCompra.addActionListener(new ActionListenerBotoneraCompra(0));
		devolucionCompra.addActionListener(new ActionListenerBotoneraCompra(1));
		detalleCompra.addActionListener(new ActionListenerBotoneraCompra(2));
		listarCompras.addActionListener(new ActionListenerBotoneraCompra(3));
		cantidadRelojes.addActionListener(new ActionListenerBotoneraCompra(4));
		numeroClientes.addActionListener(new ActionListenerBotoneraCompra(5));
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				cerrarBotonera();
			}
		});
		
		buttonPanel.add(iniciarCompra);
		buttonPanel.add(devolucionCompra);
		buttonPanel.add(detalleCompra);
		buttonPanel.add(listarCompras);
		buttonPanel.add(cantidadRelojes);
		buttonPanel.add(numeroClientes);
		buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	    this.setVisible(true);
	}
	
	
	public class ActionListenerBotoneraCompra implements ActionListener{
		private int event;
		
		public ActionListenerBotoneraCompra(int event){
			this.event = event;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0){
			int comando = 0;
			
			switch(event){
				case 0:
					comando = ListaComandos.VENTANA_INICIAR_COMPRA;
					break;
				case 1:
					comando = ListaComandos.VENTANA_DEVOLUCION_COMPRA;
					break;
				case 2:
					comando = ListaComandos.VENTANA_MOSTRAR_COMPRA;
					break;
				case 3:
					comando = ListaComandos.VENTANA_LISTAR_COMPRAS;
					break;
				case 4:
					comando = ListaComandos.VENTANA_CANTIDAD_RELOJES_QUERY;
					break;
				case 5:
					comando = ListaComandos.VENTANA_NUMERO_CLIENTES_QUERY;
					break;
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