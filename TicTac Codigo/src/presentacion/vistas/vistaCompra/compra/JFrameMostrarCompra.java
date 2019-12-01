package presentacion.vistas.vistaCompra.compra;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import negocio.compra.TransferCompra;
import negocio.compra.TransferLineaDeCompra;
import presentacion.comandos.ListaComandos;
import presentacion.controlador.Controlador;

/**
 * Clase de la capa presentación que permite la implementación de la ventana de mostrar compra
 */
public class JFrameMostrarCompra extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JButton enviar;
	private JButton volver;
	private JTextField textoID;
	private JTextField textoIDCompra;
	private JTextField textoIDCliente;
	private JTextField textoCosteTotal;
	private JTextField textoFecha;
	private JTextField textoActivo;
	private JScrollPane scrollPane;
	protected static JTable tabla;
	protected static String[] columnas = {"Producto", "Unidades", "Precio/Unidad","Coste"};
	protected static DefaultTableModel model;
	
	public JFrameMostrarCompra(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Mostrar Compra");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		
		enviar = new JButton("Mostrar");
		volver = new JButton("Volver");
	
		JPanel panelID = new JPanel();
		JLabel l0 = new JLabel("ID de compra: ");
		textoID = new JTextField(5);
		
		panelID.add(l0);
		panelID.add(textoID);
		panelID.setPreferredSize(new Dimension (800,35));
		
		JPanel panelBotones = new JPanel();
		panelBotones.add(enviar);
		panelBotones.add(volver);	
		
		JPanel panelDatos = new JPanel();
		textoIDCompra = new JTextField(3);
		textoIDCompra.setEditable(false);
		textoIDCliente = new JTextField(10);
		textoIDCliente.setEditable(false);
		textoCosteTotal = new JTextField(8);
		textoCosteTotal.setEditable(false);
		textoFecha = new JTextField(8);
		textoFecha.setEditable(false);
		textoActivo = new JTextField(5);
		textoActivo.setEditable(false);
		panelDatos.add(new JLabel("ID de compra: ")); 	panelDatos.add(textoIDCompra);		
		panelDatos.add(new JLabel("ID de cliente: ")); 		panelDatos.add(textoIDCliente);		
		panelDatos.add(new JLabel("Coste total: "));  			panelDatos.add(textoCosteTotal);
		panelDatos.add(new JLabel("Fecha: "));  		panelDatos.add(textoFecha);
		panelDatos.add(new JLabel("Activo: "));  		panelDatos.add(textoActivo);
		
		model = new DefaultTableModel(0, columnas.length);
		model.setColumnIdentifiers(columnas);
		tabla = new JTable(model);
		scrollPane = new JScrollPane(tabla);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		enviar.addActionListener(new ActionListenerMostrarCompra());	
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				cerrar();
			}
		});
		
		buttonPanel.add(panelID);
		buttonPanel.add(panelBotones);
		buttonPanel.add(panelDatos);
		buttonPanel.add(scrollPane);
		
		this.getContentPane().add(buttonPanel);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	}
	
	public class ActionListenerMostrarCompra implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){			
			try{
				if(textoID.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Celda vacía", "Información", JOptionPane.INFORMATION_MESSAGE);
				else
					Controlador.getInstance().accion(ListaComandos.NEGOCIO_MOSTRAR_COMPRA, Integer.parseInt(textoID.getText()));
			}
			catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, "El formato de compra es incorrecto", "Información", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public void setAreaDetalle(TransferCompra compra){
		textoIDCompra.setText(String.valueOf(compra.getId()));
		textoIDCliente.setText(String.valueOf(compra.getIdCliente()));
		textoCosteTotal.setText(String.valueOf(compra.getCosteTotal()));
		textoFecha.setText(String.valueOf(compra.getFecha()));
		textoActivo.setText(String.valueOf(compra.getActivo()));
		
		model = new DefaultTableModel(compra.getLineaCompra().size(), columnas.length);
		model.setColumnIdentifiers(columnas);
		int column = 0;
		ArrayList<TransferLineaDeCompra> a= compra.getLineaCompra();
		int i = 0;
		while(i < a.size()){
			model.setValueAt(a.get(i).getIdProducto(), column, 0);
			model.setValueAt(a.get(i).getCantidad(), column, 1);
			model.setValueAt(a.get(i).getPrecio(), column, 2);
			model.setValueAt(a.get(i).getPrecio()*a.get(i).getCantidad(), column, 3);
			column++;
			i++;
		}
		tabla.setMaximumSize(new Dimension(200, 200));
		tabla.setEnabled(false);
		tabla.setModel(model);
		
	}
	
	public void cerrar(){		
		this.setVisible(false);
		textoID.setText("");
		textoIDCompra.setText("");
		textoIDCliente.setText("");
		textoCosteTotal.setText("");
		textoFecha.setText("");
		textoIDCompra.setText("");
		model.setRowCount(0);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_COMPRA, null);
	}	
}