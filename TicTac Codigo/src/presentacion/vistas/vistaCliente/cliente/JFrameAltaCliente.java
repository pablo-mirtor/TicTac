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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.cliente.TransferCliente;

import javax.swing.JButton;

import presentacion.comandos.ListaComandos;
import presentacion.controlador.Controlador;

/**
 * Clase de la capa presentación que permite la implementación de la ventana de alta de un cliente
 */
public class JFrameAltaCliente extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField nombre;
	private JTextField dni;
	private JTextField tarjetaDePago;
	private JButton enviar;
	private JButton volver;
	
	public JFrameAltaCliente() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
				
		this.setTitle("Alta cliente");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(4, 2));

		nombre = new JTextField("");
		dni = new JTextField("");
		tarjetaDePago = new JTextField("");

		enviar = new JButton("Dar de alta");
		volver = new JButton("Volver");
		
		nombre.setPreferredSize(new Dimension(250, 25));	
		
		enviar.addActionListener(new ActionListenerAltaCliente());
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cerrar();
			}
		});
		
		buttonPanel.add( new JLabel("Nombre: "));
		buttonPanel.add(nombre);
		buttonPanel.add(new JLabel("DNI: "));
		buttonPanel.add(dni);
		buttonPanel.add(new JLabel("Tarjeta: "));
		buttonPanel.add(tarjetaDePago);
        buttonPanel.add(enviar);
        buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	}
	
	public class ActionListenerAltaCliente implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			if(nombre.getText().isEmpty() || dni.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "No pueden haber celdas vacías", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				try{
					Controlador.getInstance().accion(ListaComandos.NEGOCIO_ALTA_CLIENTE, new TransferCliente(nombre.getText(), dni.getText(), Integer.parseInt(tarjetaDePago.getText()), true));
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "El número de tarjeta no es correcto", "Información", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	

		
	}
	
	//Metodo que nos permite retornar a la ventana principal de la aplicacion.
	public void cerrar(){
		nombre.setText("");
		dni.setText("");
		tarjetaDePago.setText("");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_CLIENTE, null);
	}
}