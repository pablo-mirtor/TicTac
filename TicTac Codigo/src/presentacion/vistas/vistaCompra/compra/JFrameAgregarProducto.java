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
import presentacion.controlador.Contexto;
import presentacion.controlador.Controlador;

/**
 * Clase de la capa presentación que permite la implementación de la ventana de agregar un producto
 */
public class JFrameAgregarProducto extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField idProducto;
	private JTextField cantidadProducto;
	private JButton enviar;
	private JButton volver;
	
	public JFrameAgregarProducto(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Agregar producto");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(3, 2));

		idProducto = new JTextField("");
		cantidadProducto = new JTextField("");
		enviar = new JButton("Enviar");
		volver = new JButton("Volver");
		
		idProducto.setPreferredSize(new Dimension(250, 35));
		
		enviar.addActionListener(new ActionListenerAgregarProductoCompra());
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cerrar();
			}
		});
		buttonPanel.add(new JLabel("ID del Producto:"));
		buttonPanel.add(idProducto);
		buttonPanel.add(new JLabel("Cantidad:"));
		buttonPanel.add(cantidadProducto);
        buttonPanel.add(enviar);
        buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	}
	
	public class ActionListenerAgregarProductoCompra implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0){
			try{
				if(idProducto.getText().isEmpty() || cantidadProducto.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "No pueden haber celdas vacías", "Información", JOptionPane.INFORMATION_MESSAGE);
				else if(Integer.parseInt(cantidadProducto.getText()) <= 0)
					JOptionPane.showMessageDialog(null, "Error: la cantidad tiene que ser positiva", "Información", JOptionPane.INFORMATION_MESSAGE);
				else 
					Controlador.getInstance().accion(ListaComandos.NEGOCIO_AGREGAR_PRODUCTO_COMPRA, new Contexto(Integer.parseInt(idProducto.getText()), Integer.parseInt(cantidadProducto.getText())));
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "El formato del producto es incorrecto", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void cerrar()
	{
		idProducto.setText("");
		cantidadProducto.setText("");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_GESTION_CARRITO_COMPRA, null);
	}
}