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
 * Clase de la capa presentación que permite la implementación de la ventana para desasignar una competencia y trabajador
 */
public class JFrameDesasignarCompetenciaTrabajador extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField trabajador;
	private JTextField competencia;
	private JButton enviar;
	private JButton volver;
	
	public JFrameDesasignarCompetenciaTrabajador() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
				
		this.setTitle("Desasignar competencia y trabajador");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(3, 2));

		trabajador = new JTextField("");
		competencia = new JTextField("");

		enviar = new JButton("Desasignar");
		volver = new JButton("Volver");
		
		trabajador.setPreferredSize(new Dimension(250, 25));	
		
		enviar.addActionListener(new ActionListenerDesasignarCompetenciaTrabajador());
		
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
        buttonPanel.add(enviar);
        buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	}
	
	public class ActionListenerDesasignarCompetenciaTrabajador implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			if(trabajador.getText().isEmpty() || competencia.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "No pueden haber celdas vacías", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
			else{				
				Controlador.getInstance().accion(ListaComandos.NEGOCIO_DESASIGNAR_COMPETENCIA_TRABAJADOR, new TransferCompetenciaTrabajador(Integer.parseInt(trabajador.getText()), Integer.parseInt(competencia.getText()) ,true));	
			}
		}
	}
	
	//Metodo que nos permite retornar a la ventana principal de la aplicacion.
	public void cerrar(){
		trabajador.setText("");
		competencia.setText("");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_COMPETENCIA, null);
	}
}