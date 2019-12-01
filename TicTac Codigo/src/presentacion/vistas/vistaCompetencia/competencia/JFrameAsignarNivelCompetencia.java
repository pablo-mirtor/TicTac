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

import negocio.competencia.TransferCompetenciaTrabajador;

import javax.swing.JButton;

import presentacion.comandos.ListaComandos;
import presentacion.controlador.Controlador;

/**
 * Clase de la capa presentaci�n que permite la implementaci�n de la ventana para asignar nivel a una competencia y trabajador
 */
public class JFrameAsignarNivelCompetencia extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField trabajador;
	private JTextField competencia;
	private JTextField nivel;
	private JButton enviar;
	private JButton volver;
	
	public JFrameAsignarNivelCompetencia() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
				
		this.setTitle("Asignar nivel competencia");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(4, 2));

		trabajador = new JTextField("");
		competencia = new JTextField("");
		nivel = new JTextField("");

		enviar = new JButton("Asignar");
		volver = new JButton("Volver");
		
		trabajador.setPreferredSize(new Dimension(250, 25));	
		
		enviar.addActionListener(new ActionListenerAsignarNivelCompetencia());
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cerrar();
			}
		});
		
		buttonPanel.add( new JLabel("ID Trabajador: "));
		buttonPanel.add(trabajador);
		buttonPanel.add(new JLabel("ID Competencia: "));
		buttonPanel.add(competencia);
		buttonPanel.add(new JLabel("Nivel: "));
		buttonPanel.add(nivel);
        buttonPanel.add(enviar);
        buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	}
	
	public class ActionListenerAsignarNivelCompetencia implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			if(trabajador.getText().isEmpty() || competencia.getText().isEmpty() || nivel.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "No pueden haber celdas vac�as", "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
			}
			else{				
				Controlador.getInstance().accion(ListaComandos.NEGOCIO_ASIGNAR_NIVEL_COMPETENCIA, new TransferCompetenciaTrabajador(Integer.parseInt(trabajador.getText()), Integer.parseInt(competencia.getText()), Integer.parseInt(nivel.getText()) ,true));	
			}
		}
	}
	
	//Metodo que nos permite retornar a la ventana principal de la aplicacion.
	public void cerrar(){
		trabajador.setText("");
		competencia.setText("");
		nivel.setText("");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_COMPETENCIA, null);
	}
}