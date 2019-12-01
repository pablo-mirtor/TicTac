package presentacion.vistas.vistaCompetencia.competencia;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import negocio.competencia.TransferCompetenciaTrabajador;

import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import presentacion.comandos.ListaComandos;
import presentacion.controlador.Controlador;

/**
 * Clase de la capa presentación que permite la implementación de la ventana de mostrar nivel de una competencia
 */
public class JFrameMostrarNivelCompetencia extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton enviar;
	private JButton volver;
	protected static JLabel lblid;
	private JTextField textoID;
	private JTextField textoID1;
	private JTextField textoIDCompetencia;
	private JTextField textoIDCompetencia1;
	private JTextField textoNivel;
	private JTextField textoActivo;
	
	public JFrameMostrarNivelCompetencia(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Mostrar nivel competencia");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
		
		enviar = new JButton("Mostrar");
		volver = new JButton("Volver");
	
		JPanel panelID = new JPanel();
		JLabel l0 = new JLabel("ID Trabajador: ");
		textoID = new JTextField(5);
		JLabel l1 = new JLabel("ID Competencia: ");
		textoIDCompetencia = new JTextField(5);
		
		
		panelID.add(l0);
		panelID.add(textoID);
		panelID.add(l1);
		panelID.add(textoIDCompetencia);
		
		panelID.setPreferredSize(new Dimension (800,35));
		
		JPanel panelBotones = new JPanel();
		panelBotones.add(enviar);
		panelBotones.add(volver);	
		
		JPanel panelDatos = new JPanel();
		textoID1 = new JTextField(3);
		textoID1.setEditable(false);
		textoIDCompetencia1 = new JTextField(3);
		textoIDCompetencia1.setEditable(false);
		textoNivel = new JTextField(10);
		textoNivel.setEditable(false);
		textoActivo = new JTextField(5);
		textoActivo.setEditable(false);
		panelDatos.add(new JLabel("ID Trabajador: "));		 	panelDatos.add(textoID1);		
		panelDatos.add(new JLabel("ID Competencia: "));		 	panelDatos.add(textoIDCompetencia1);
		panelDatos.add(new JLabel("Nivel: ")); 					panelDatos.add(textoNivel);		
		panelDatos.add(new JLabel("Activo: "));  				panelDatos.add(textoActivo);
		
		
		enviar.addActionListener(new ActionListenerMostrarNivelCompetencia());	
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				cerrar();
			}
		});
		
		buttonPanel.add(panelID);
		buttonPanel.add(panelBotones);
		buttonPanel.add(panelDatos);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	}
	
	public class ActionListenerMostrarNivelCompetencia implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){			
			try{
				Controlador.getInstance().accion(ListaComandos.NEGOCIO_MOSTRAR_NIVEL_COMPETENCIA, new TransferCompetenciaTrabajador (Integer.parseInt(textoID.getText()), Integer.parseInt(textoIDCompetencia.getText())));
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "El formato no es correcto", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void setAreaDetalle(TransferCompetenciaTrabajador comp){
		textoID1.setText(String.valueOf(comp.getTrabajador()));
		textoIDCompetencia1.setText(String.valueOf(comp.getCompetencia()));
		textoNivel.setText(String.valueOf(comp.getNivel()));
		textoActivo.setText(String.valueOf(comp.getActivo()));
	}
	
	public void cerrar(){		
		this.setVisible(false);
		textoID.setText("");
		textoID1.setText("");
		textoIDCompetencia.setText("");
		textoIDCompetencia1.setText("");
		textoNivel.setText("");
		textoActivo.setText("");
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_COMPETENCIA, null);
	}	
}
