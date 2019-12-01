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


import negocio.reloj.TransferReloj;
import negocio.reloj.TransferRelojAnalogico;
import negocio.reloj.TransferRelojDigital;
import presentacion.comandos.ListaComandos;
import presentacion.controlador.Controlador;


/**
 * Clase de la capa presentacion que implementa la ventana de mostrar reloj
 */
public class JFrameMostrarReloj extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JButton enviar;
	private JButton volver;
	protected static JLabel lblid;
	private JTextField textoID;
	private JTextField textoID1;
	private JTextField textoModelo;
	private JTextField textoMarca;
	private JTextField textoPrecio;
	private JTextField textoActivo;
	private JLabel tipo;
	private JTextField textoTipo;
	private JPanel panelDatos;
	
	public JFrameMostrarReloj() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Mostrar reloj");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
		
		enviar = new JButton("Mostrar");
		volver = new JButton("Volver");
	
		JPanel panelID = new JPanel();
		textoID = new JTextField(5);
		
		panelID.add(new JLabel("ID de reloj: "));
		panelID.add(textoID);
		panelID.setPreferredSize(new Dimension (900,35));
		
		JPanel panelBotones = new JPanel();
		panelBotones.add(enviar);
		panelBotones.add(volver);	
		
		panelDatos = new JPanel();
		textoID1 = new JTextField(3);
		textoID1.setEditable(false);
		textoModelo = new JTextField(10);
		textoModelo.setEditable(false);
		textoMarca = new JTextField(10);
		textoMarca.setEditable(false);
		textoPrecio = new JTextField(5);
		textoPrecio.setEditable(false);
		textoActivo = new JTextField(3);
		textoActivo.setEditable(false);
		tipo = new JLabel("");
		textoTipo = new JTextField(6);
		textoTipo.setEditable(false);
		
		panelDatos.add(new JLabel("ID de reloj: ")); 	panelDatos.add(textoID1);		
		panelDatos.add(new JLabel("Modelo: ")); 		panelDatos.add(textoModelo);		
		panelDatos.add(new JLabel("Marca: "));  			panelDatos.add(textoMarca);
		panelDatos.add(new JLabel("Precio: "));  		panelDatos.add(textoPrecio);
		panelDatos.add(new JLabel("Activo: "));  		panelDatos.add(textoActivo);
		panelDatos.add(tipo);							panelDatos.add(textoTipo);
		panelDatos.setVisible(false);
		enviar.addActionListener(new ActionListenerMostrarReloj());	
		
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
	
	public class ActionListenerMostrarReloj implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0){			
			try{
				if(textoID.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "No pueden haber celdas vacías", "Información", JOptionPane.INFORMATION_MESSAGE);
				else
					Controlador.getInstance().accion(ListaComandos.NEGOCIO_MOSTRAR_RELOJ, Integer.parseInt(textoID.getText()));
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "El formato del reloj no es correcto", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void setAreaDetalle(TransferReloj reloj){
		textoID1.setText(String.valueOf(reloj.getId()));
		textoModelo.setText(reloj.getModelo());
		textoMarca.setText(reloj.getMarca());
		textoPrecio.setText(String.valueOf(reloj.getPrecio()));
		textoActivo.setText(String.valueOf(reloj.getActivo()));
		if(reloj instanceof TransferRelojDigital){
			tipo.setText("Pantalla: ");
			textoTipo.setText(((TransferRelojDigital) reloj).getPantalla());
		}
		else{
			tipo.setText("Esfera: ");
			textoTipo.setText(((TransferRelojAnalogico) reloj).getEsfera());
		}
		panelDatos.setVisible(true);
	}
	
	public void cerrar(){		
		this.setVisible(false);
		textoID.setText("");
		textoID1.setText("");
		textoModelo.setText("");
		textoMarca.setText("");
		textoPrecio.setText("");
		textoActivo.setText("");
		textoTipo.setText("");
		panelDatos.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_RELOJ, null);
	}	
}
