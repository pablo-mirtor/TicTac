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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import presentacion.comandos.ListaComandos;
import presentacion.controlador.Controlador;

/**
 * Clase de la capa presentación que permite la implementación de la ventana de iniciar una compra
 */
public class JFrameIniciarCompra extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField idCliente;
	private JButton enviar;
	private JButton volver;
	
	public JFrameIniciarCompra(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Iniciar compra");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		
		JPanel buttonPanel = new JPanel(new GridLayout(2, 2));
		
		idCliente = new JTextField("");
		enviar = new JButton("Iniciar compra");
		volver = new JButton("Volver");
		
		idCliente.setPreferredSize(new Dimension(250, 25));
		
		enviar.addActionListener(new ActionListenerIniciarCompra());
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				cerrar();
			}
		});
		buttonPanel.add(new JLabel("ID del cliente:"));
		buttonPanel.add(idCliente);
		buttonPanel.add(enviar);
		buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	}
	
	public class ActionListenerIniciarCompra implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			try{
				if(idCliente.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "No pueden haber celdas vacías", "Información", JOptionPane.INFORMATION_MESSAGE);
				else
					Controlador.getInstance().accion(ListaComandos.NEGOCIO_GESTION_CARRITO_COMPRA, Integer.parseInt(idCliente.getText()));
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "El formato del ID del cliente no es correcto", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void cerrarPorVista(){
		idCliente.setText("");
		this.setVisible(false);
	}
	
	public void cerrar(){
		cerrarPorVista();
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_COMPRA, null);
	}
}
