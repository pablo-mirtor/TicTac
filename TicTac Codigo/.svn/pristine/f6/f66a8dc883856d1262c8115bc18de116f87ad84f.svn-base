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
 * Clase de la capa presentación que permite la implementación de la ventana de número de clientes
 */
public class JFrameNumeroClientes extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField idReloj;
	private JButton enviar;
	private JButton volver;
	
	public JFrameNumeroClientes(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Número de clientes");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(2, 2));

		idReloj = new JTextField("");
		enviar = new JButton("Enviar");
		volver = new JButton("Volver");
		
		idReloj.setPreferredSize(new Dimension(250, 25));
		enviar.addActionListener(new ActionListenerNumeroClientesCompra());
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cerrar();
			}
		});
		
		buttonPanel.add(new JLabel("ID del reloj: "));
		buttonPanel.add(idReloj);
        buttonPanel.add(enviar);
        buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	}
	
	public class ActionListenerNumeroClientesCompra implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			try{
				Controlador.getInstance().accion(ListaComandos.NEGOCIO_NUMERO_CLIENTES_QUERY,new PareadoQuery(Integer.parseInt(idReloj.getText()),0));
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "El formato del artículo no es correcto", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void cerrar(){
		idReloj.setText("");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_COMPRA, null);
	}
}
