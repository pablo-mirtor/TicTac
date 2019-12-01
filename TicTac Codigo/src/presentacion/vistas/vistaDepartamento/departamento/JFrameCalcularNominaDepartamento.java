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
import javax.swing.JButton;
import presentacion.comandos.ListaComandos;
import presentacion.controlador.Controlador;

/**
 * Clase de la capa presentaci�n que permite la implementaci�n de la ventana para calcular la nomina de un departamento
 */
public class JFrameCalcularNominaDepartamento extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField id;
	private JButton enviar;
	private JButton volver;
	
	public JFrameCalcularNominaDepartamento(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Calcular n�mina trabajador");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(2, 2));
		
		id = new JTextField("");
		enviar = new JButton("Calcular");
		volver = new JButton("Volver");
		
		id.setPreferredSize(new Dimension(250, 25));
		
		enviar.addActionListener(new ActionListenerCalcularNominaDepartamento());
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				cerrar();
			}
		});
		buttonPanel.add(new JLabel("ID del departamento:"));
		buttonPanel.add(id);
		buttonPanel.add(enviar);
		buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	}
	
	public class ActionListenerCalcularNominaDepartamento implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			if(id.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Celda vac�a", "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				try{
					Controlador.getInstance().accion(ListaComandos.NEGOCIO_CALCULAR_NOMINA_DEPARTAMENTO, Integer.parseInt(id.getText()));
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "El formato del id no es correcto", "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	
	public void cerrar(){
		id.setText("");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_DEPARTAMENTO, null);
	}
}