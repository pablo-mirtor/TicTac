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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import negocio.reloj.TransferRelojAnalogico;

import javax.swing.JButton;

import presentacion.comandos.ListaComandos;
import presentacion.controlador.Controlador;

/**
 * Clase de la capa presentación que implementa la ventana de modificar un reloj analógico
 */
public class JFrameModificarRelojAnalogico extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField id;
	private JTextField modelo;
	private JTextField marca;
	private JTextField precio;
	private JTextField esfera;
	private JButton enviar;
	private JButton volver;
	
	public JFrameModificarRelojAnalogico(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Modificar reloj analógico");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(6, 2));
		
		
		id = new JTextField("");
		modelo = new JTextField("");
		marca = new JTextField("");
		precio = new JTextField("");
		esfera = new JTextField("");
		enviar = new JButton("Modificar reloj");
		volver = new JButton("Volver");
		
		id.setPreferredSize(new Dimension(250, 25));
		
		enviar.addActionListener(new ActionListenerModificarRelojAnalogico());	
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				cerrar();
			}
		});	
		
		buttonPanel.add(new JLabel ("ID del reloj: "));
		buttonPanel.add(id);
		buttonPanel.add(new JLabel ("Modelo: "));
		buttonPanel.add(modelo);
		buttonPanel.add(new JLabel ("Marca: "));
		buttonPanel.add(marca);
		buttonPanel.add(new JLabel ("Precio: "));
		buttonPanel.add(precio);
		buttonPanel.add(new JLabel ("Tipo de esfera: "));
		buttonPanel.add(esfera);
        buttonPanel.add(enviar);
        buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	}
	
	public class ActionListenerModificarRelojAnalogico implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			try	{
				if(id.getText().isEmpty() || modelo.getText().isEmpty() || marca.getText().isEmpty() || precio.getText().isEmpty() || esfera.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "No pueden haber celdas vacías", "Información", JOptionPane.INFORMATION_MESSAGE);
				else
					Controlador.getInstance().accion(ListaComandos.NEGOCIO_MODIFICAR_RELOJ, new TransferRelojAnalogico(Integer.parseInt(id.getText()), modelo.getText(), marca.getText(), Double.parseDouble(precio.getText()), esfera.getText(), true));
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "El formato del ID y del precio debe ser numérico", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void cerrar(){
		id.setText("");
		modelo.setText("");
		marca.setText("");
		precio.setText("");
		esfera.setText("");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_RELOJ, null);
	}
}
