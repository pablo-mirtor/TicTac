package presentacion.vistas.vistaTrabajador.trabajador;


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


import negocio.trabajador.TransferTrabajador;
import negocio.trabajador.TransferTrabajadorParcial;
import negocio.trabajador.TransferTrabajadorCompleto;
import presentacion.comandos.ListaComandos;
import presentacion.controlador.Controlador;


/**
 * Clase de la capa presentacion que implementa la ventana de mostrar trabajador
 */
public class JFrameMostrarTrabajador extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JButton enviar;
	private JButton volver;
	protected static JLabel lblid;
	private JTextField textoID;
	private JTextField textoID1;
	private JTextField textoNombre;
	private JTextField textoDNI;
	private JTextField textoSueldo;
	private JTextField textoActivo;
	private JTextField idDepartamento;
	private JLabel tipo;
	private JTextField textoTipo;
	private JPanel panelDatos;
	
	public JFrameMostrarTrabajador() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Mostrar trabajador");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
		
		enviar = new JButton("Mostrar");
		volver = new JButton("Volver");
	
		JPanel panelID = new JPanel();
		textoID = new JTextField(6);
		
		panelID.add(new JLabel("ID Trabajador: "));
		panelID.add(textoID);
		panelID.setPreferredSize(new Dimension (900,35));
		
		JPanel panelBotones = new JPanel();
		panelBotones.add(enviar);
		panelBotones.add(volver);	
		
		panelDatos = new JPanel();
		textoID1 = new JTextField(3);
		textoID1.setEditable(false);
		textoNombre = new JTextField(10);
		textoNombre.setEditable(false);
		textoDNI = new JTextField(10);
		textoDNI.setEditable(false);
		textoSueldo = new JTextField(5);
		textoSueldo.setEditable(false);
		idDepartamento = new JTextField(3);
		idDepartamento.setEditable(false);
		textoActivo = new JTextField(3);
		textoActivo.setEditable(false);
		tipo = new JLabel("");
		textoTipo = new JTextField(6);
		textoTipo.setEditable(false);
		
		panelDatos.add(new JLabel("ID de reloj: ")); 	panelDatos.add(textoID1);		
		panelDatos.add(new JLabel("Nombre: ")); 		panelDatos.add(textoNombre);		
		panelDatos.add(new JLabel("DNI: "));  			panelDatos.add(textoDNI);
		panelDatos.add(new JLabel("Sueldo: "));  		panelDatos.add(textoSueldo);
		panelDatos.add(new JLabel("Departamento: "));  	panelDatos.add(idDepartamento);
		panelDatos.add(new JLabel("Activo: "));  		panelDatos.add(textoActivo);
		panelDatos.add(tipo);							panelDatos.add(textoTipo);
		panelDatos.setVisible(false);
		enviar.addActionListener(new ActionListenerMostrarTrabajador());	
		
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
	
	public class ActionListenerMostrarTrabajador implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0){			
			try{
				if(textoID.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "No pueden haber celdas vacías", "Información", JOptionPane.INFORMATION_MESSAGE);
				else
					Controlador.getInstance().accion(ListaComandos.NEGOCIO_MOSTRAR_TRABAJADOR, Integer.parseInt(textoID.getText()));
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "El formato del trabajador no es correcto", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void setAreaDetalle(TransferTrabajador trab){
		textoID1.setText(String.valueOf(trab.getId()));
		textoNombre.setText(trab.getNombre());
		textoDNI.setText(trab.getDNI());
		textoSueldo.setText(String.valueOf(trab.getSalario()));
		textoActivo.setText(String.valueOf(trab.getActivo()));
		idDepartamento.setText(String.valueOf(trab.getIdDepartamento()));
		if(trab instanceof TransferTrabajadorParcial){
			tipo.setText("Horas semanales: ");
			textoTipo.setText(String.valueOf(((TransferTrabajadorParcial) trab).getHorasSemanales()));
		}
		else{
			tipo.setText("Productividad: ");
			textoTipo.setText(String.valueOf(((TransferTrabajadorCompleto) trab).getProductividad()));
		}
		panelDatos.setVisible(true);
	}
	
	public void cerrar(){		
		this.setVisible(false);
		textoID.setText("");
		textoID1.setText("");
		textoNombre.setText("");
		textoDNI.setText("");
		textoSueldo.setText("");
		textoActivo.setText("");
		textoTipo.setText("");
		idDepartamento.setText("");
		panelDatos.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_TRABAJADOR, null);
	}	
}