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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.departamento.TransferDepartamento;

import javax.swing.JButton;

import presentacion.comandos.ListaComandos;
import presentacion.controlador.Controlador;

/**
 * Clase de la capa presentación que permite la implementación de la ventana de Modificar un departamento
 */
public class JFrameModificarDepartamento extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTextField id;
	private JTextField nombre;
	private JTextField descripcion;
	private JButton enviar;
	private JButton volver;
	
	public JFrameModificarDepartamento(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Modificar departamento");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(4, 2));
		
		id = new JTextField("");
		nombre = new JTextField("");
		descripcion = new JTextField("");
		enviar = new JButton("Modificar departamento");
		volver = new JButton("Volver");
		
		id.setPreferredSize(new Dimension(250, 25));
		
		enviar.addActionListener(new ActionListenerModificarDepartamento());
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				cerrar();
			}
		});	

		buttonPanel.add(new JLabel ("ID Departamento: "));
		buttonPanel.add(id);
		buttonPanel.add( new JLabel("Nombre: "));
		buttonPanel.add(nombre);
		buttonPanel.add(new JLabel("Descripción: "));
		buttonPanel.add(descripcion);
        buttonPanel.add(enviar);
        buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	}
	
	public class ActionListenerModificarDepartamento implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			if(nombre.getText().isEmpty() || descripcion.getText().isEmpty() || id.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "No pueden haber celdas vacías", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				try{
					Controlador.getInstance().accion(ListaComandos.NEGOCIO_MODIFICAR_DEPARTAMENTO, new TransferDepartamento(Integer.parseInt(id.getText()), nombre.getText(), descripcion.getText(), true));
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "El formato del id es incorrecto", "Información", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	public void cerrar(){
		id.setText("");
		nombre.setText("");
		descripcion.setText("");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_DEPARTAMENTO, null);
	}	
}