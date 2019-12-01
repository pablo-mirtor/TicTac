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
import javax.swing.JComboBox;
import javax.swing.JButton;

import negocio.trabajador.TransferTrabajadorParcial;
import negocio.trabajador.TransferTrabajadorCompleto;
import negocio.trabajador.TransferTrabajador;
import presentacion.comandos.ListaComandos;
import presentacion.controlador.Controlador;

public class JFrameAltaTrabajador extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField nombre;
	private JTextField dni;
	private JTextField sueldo;
	private JComboBox<String> tipo;
	private JTextField horasSemanales;
	private JTextField productividad;
	private JTextField idDepartamento;
	private JButton enviar;
	private JButton volver;
	
	public JFrameAltaTrabajador() {
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
				
		this.setTitle("Alta trabajador");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel buttonPanel = new JPanel(new GridLayout(8, 2));

		nombre = new JTextField("");
		dni = new JTextField("");
		sueldo = new JTextField("");
		String[] tiposEmpleado = {"Parcial", "Completo"};
		tipo = new JComboBox<String>(tiposEmpleado);
		tipo.setSelectedIndex(0);
		horasSemanales = new JTextField("");
		productividad = new JTextField("");
		idDepartamento =new JTextField("");
		enviar = new JButton("Dar de alta");
		volver = new JButton("Volver");
		
		nombre.setPreferredSize(new Dimension(250, 25));
		horasSemanales.setEditable(true);
    	productividad.setEditable(false);
    	
		tipo.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent event) {
		        if (tipo.getSelectedIndex() == 0) {
		        	horasSemanales.setEditable(true);
		        	productividad.setEditable(false);
		        } 
		        else {
		        	horasSemanales.setEditable(false);
		        	productividad.setEditable(true);
		        }
		    }
		});	
		
		enviar.addActionListener(new ActionListenerAltaTrabajador());
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cerrar();
			}
		});
		
		buttonPanel.add(new JLabel("Nombre: "));
		buttonPanel.add(nombre);
		buttonPanel.add(new JLabel("DNI: "));
		buttonPanel.add(dni);
		buttonPanel.add(new JLabel("Salario (por hora): "));
		buttonPanel.add(sueldo);
		buttonPanel.add(new JLabel("Tipo: "));
		buttonPanel.add(tipo);
		buttonPanel.add(new JLabel("Horas semanales: "));
		buttonPanel.add(horasSemanales);
		buttonPanel.add(new JLabel("Productividad: "));
		buttonPanel.add(productividad);
		buttonPanel.add(new JLabel("ID del departamento: "));
		buttonPanel.add(idDepartamento);
		
		
        buttonPanel.add(enviar);
        buttonPanel.add(volver);
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	}
	
	public class ActionListenerAltaTrabajador implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				TransferTrabajador t = null;
		        if (tipo.getSelectedIndex() == 0) 
		        	t = new TransferTrabajadorParcial(nombre.getText(), dni.getText(), Double.parseDouble(sueldo.getText()), Integer.parseInt(idDepartamento.getText()),true, Integer.parseInt(horasSemanales.getText()));
		        else
		        	t = new TransferTrabajadorCompleto(nombre.getText(), dni.getText(), Double.parseDouble(sueldo.getText()), Integer.parseInt(idDepartamento.getText()),true, Integer.parseInt(productividad.getText()));			
		        
		        Controlador.getInstance().accion(ListaComandos.NEGOCIO_ALTA_TRABAJADOR, t);
			} 
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"El formato del trabajador no es correcto", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	//Metodo que nos permite retornar a la ventana principal de la aplicacion.
	public void cerrar(){
		nombre.setText("");
		dni.setText("");
		sueldo.setText("");
		horasSemanales.setText("");
		productividad.setText("");
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_TRABAJADOR, null);
	}
}
