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
import presentacion.controlador.PareadoQuery;


/**
 * Clase de la capa presentacion que implementa la ventana de cantidad de relojes
 */
public class JFrameCantidadRelojes extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField idCliente;
	private JTextField idReloj;
	private JButton enviar;
	private JButton volver;
	
	public JFrameCantidadRelojes(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Cantidad de relojes");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(3, 1));

		idCliente = new JTextField("");
		idReloj = new JTextField("");
		enviar = new JButton("Enviar");
		volver = new JButton("Volver");
		
		idCliente.setPreferredSize(new Dimension(250, 25));
		
		enviar.addActionListener(new ActionListenerCantidadRelojesCompra());
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cerrar();
			}
		});
		buttonPanel.add(new JLabel("ID del cliente:"));
		buttonPanel.add(idCliente);
		buttonPanel.add(new JLabel("ID del reloj:"));
		buttonPanel.add(idReloj);
        buttonPanel.add(enviar);
        buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	}
	
	public class ActionListenerCantidadRelojesCompra implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			try{
				if(idCliente.getText().isEmpty() || idReloj.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "No pueden haber celdas vacías", "Información", JOptionPane.INFORMATION_MESSAGE);
				else
					Controlador.getInstance().accion(ListaComandos.NEGOCIO_CANTIDAD_RELOJES_QUERY, new PareadoQuery(Integer.parseInt(idCliente.getText()), Integer.parseInt(idReloj.getText())));
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "El formato es incorrecto", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	} 
	
	public void cerrar(){
		idCliente.setText("");
		idReloj.setText("");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_COMPRA, null);
	}	
}
