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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.compra.TransferLineaDeCompra;
import presentacion.comandos.ListaComandos;
import presentacion.controlador.Controlador;

/**
 * Clase de la capa presentación que permite la implementación de la ventana de devolución de compra
 */
public class JFrameDevolucionCompra extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTextField idCompra;
	private JTextField idProducto;
	private JTextField cantidadProducto;
	private JButton enviar;
	private JButton volver;
	
	public JFrameDevolucionCompra(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Devolución compra");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(4, 2));

		idCompra = new JTextField("");
		idProducto = new JTextField("");
		cantidadProducto = new JTextField("");
		enviar = new JButton("Devolver compra");
		volver = new JButton("Volver");
		
		idCompra.setPreferredSize(new Dimension(250, 35));
		
		enviar.addActionListener(new ActionListenerDevolucionCompra());
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cerrar();
			}
		});
		buttonPanel.add(new JLabel("ID compra:"));
		buttonPanel.add(idCompra);
		buttonPanel.add(new JLabel("ID producto:"));
		buttonPanel.add(idProducto);
		buttonPanel.add(new JLabel("Cantidad producto:"));
		buttonPanel.add(cantidadProducto);
        buttonPanel.add(enviar);
        buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	}
	
	public class ActionListenerDevolucionCompra implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0){
			try{
				if(idCompra.getText().isEmpty() || idProducto.getText().isEmpty() || cantidadProducto.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "No pueden haber celdas vacías", "Información", JOptionPane.INFORMATION_MESSAGE);
				else if(Integer.parseInt(cantidadProducto.getText()) <= 0)
					JOptionPane.showMessageDialog(null, "Error: la cantidad a devolver tiene que ser positiva", "Información", JOptionPane.INFORMATION_MESSAGE);
				else
					Controlador.getInstance().accion(ListaComandos.NEGOCIO_DEVOLUCION_COMPRA, new TransferLineaDeCompra(Integer.parseInt(idCompra.getText()), Integer.parseInt(idProducto.getText()), Integer.parseInt(cantidadProducto.getText()), 0));
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "El formato de la devolución es incorrecto", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void cerrar(){
		idCompra.setText("");
		idProducto.setText("");
		cantidadProducto.setText("");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_COMPRA, null);
	}	
}