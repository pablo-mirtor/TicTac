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
import javax.swing.JButton;
import presentacion.comandos.ListaComandos;
import presentacion.controlador.Controlador;


/**
 * Clase de la capa presentacion que implementa la ventana de baja de reloj
 */
public class JFrameBajaReloj extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField id;
	private JButton enviar;
	private JButton volver;
	
	public JFrameBajaReloj(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Baja reloj");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(2, 2));
		
		id = new JTextField("");
		enviar = new JButton("Dar de baja");
		volver = new JButton("Volver");
		
		id.setPreferredSize(new Dimension(250, 25));
		
		enviar.addActionListener(new ActionListenerBajaReloj());
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				cerrar();
			}
		});

		buttonPanel.add(new JLabel("ID del reloj:"));
		buttonPanel.add(id);
		buttonPanel.add(enviar);
		buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	}
	
	public class ActionListenerBajaReloj implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0){
			try{
				if(id.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "No pueden haber celdas vacías", "Información", JOptionPane.INFORMATION_MESSAGE);
				else
					Controlador.getInstance().accion(ListaComandos.NEGOCIO_BAJA_RELOJ, Integer.parseInt(id.getText()));
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "El formato del ID del reloj no es correcto", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void cerrar(){
		id.setText("");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_RELOJ, null);
	}
}
