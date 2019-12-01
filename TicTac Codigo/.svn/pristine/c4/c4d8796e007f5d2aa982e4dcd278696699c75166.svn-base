package presentacion.vistas.vistaCompetencia.competencia;

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
 * Clase de la capa presentación que permite la implementación de la ventana de baja de una competencia
 */
public class JFrameBajaCompetencia extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField id;
	private JButton enviar;
	private JButton volver;
	
	public JFrameBajaCompetencia(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Baja competencia");
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
		
		enviar.addActionListener(new ActionListenerBajaCompetencia());
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				cerrar();
			}
		});
		buttonPanel.add(new JLabel("ID de la competencia:"));
		buttonPanel.add(id);
		buttonPanel.add(enviar);
		buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	}
	
	public class ActionListenerBajaCompetencia implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			if(id.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Celda vacía", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				try{
					Controlador.getInstance().accion(ListaComandos.NEGOCIO_BAJA_COMPETENCIA, Integer.parseInt(id.getText()));
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "El formato del id no es correcto", "Información", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	public void cerrar(){
		id.setText("");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_COMPETENCIA, null);
	}
}