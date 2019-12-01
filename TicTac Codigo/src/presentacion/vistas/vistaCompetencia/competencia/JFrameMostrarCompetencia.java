package presentacion.vistas.vistaCompetencia.competencia;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import negocio.competencia.TransferCompetencia;

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
 * Clase de la capa presentación que permite la implementación de la ventana de mostrar competencia
 */
public class JFrameMostrarCompetencia extends JFrame{
	private static final long serialVersionUID = 1L;
	private JButton enviar;
	private JButton volver;
	protected static JLabel lblid;
	private JTextField textoID;
	private JTextField textoID1;
	private JTextField textoNombre;
	private JTextField textoDescripcion;
	private JTextField textoActivo;
	
	public JFrameMostrarCompetencia(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Mostrar competencia");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
		
		enviar = new JButton("Mostrar");
		volver = new JButton("Volver");
	
		JPanel panelID = new JPanel();
		JLabel l0 = new JLabel("ID Competencia: ");
		textoID = new JTextField(5);
		
		panelID.add(l0);
		panelID.add(textoID);
		panelID.setPreferredSize(new Dimension (800,35));
		
		JPanel panelBotones = new JPanel();
		panelBotones.add(enviar);
		panelBotones.add(volver);	
		
		JPanel panelDatos = new JPanel();
		textoID1 = new JTextField(3);
		textoID1.setEditable(false);
		textoNombre = new JTextField(10);
		textoNombre.setEditable(false);
		textoDescripcion = new JTextField(20);
		textoDescripcion.setEditable(false);
		textoActivo = new JTextField(5);
		textoActivo.setEditable(false);
		panelDatos.add(new JLabel("ID Competencia: "));		 	panelDatos.add(textoID1);		
		panelDatos.add(new JLabel("Nombre: ")); 				panelDatos.add(textoNombre);		
		panelDatos.add(new JLabel("Descripción: "));  			panelDatos.add(textoDescripcion);
		panelDatos.add(new JLabel("Activo: "));  				panelDatos.add(textoActivo);
		
		
		enviar.addActionListener(new ActionListenerMostrarCompetencia());	
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
	
	public class ActionListenerMostrarCompetencia implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){			
			try{
				Controlador.getInstance().accion(ListaComandos.NEGOCIO_MOSTRAR_COMPETENCIA, Integer.parseInt(textoID.getText()));
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "El formato del ID Competencia no es correcto", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void setAreaDetalle(TransferCompetencia comp){
		textoID1.setText(String.valueOf(comp.getId()));
		textoNombre.setText(comp.getNombre());
		textoDescripcion.setText(comp.getDescripcion());
		textoActivo.setText(String.valueOf(comp.getActivo()));
	}
	
	public void cerrar(){		
		this.setVisible(false);
		textoID.setText("");
		textoID1.setText("");
		textoNombre.setText("");
		textoDescripcion.setText("");
		textoActivo.setText("");
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_COMPETENCIA, null);
	}	
}
