package presentacion.vistas.vistaCompra.compra;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import negocio.compra.TransferCompra;
import negocio.compra.TransferLineaDeCompra;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JTextField;

import presentacion.comandos.ListaComandos;
import presentacion.controlador.Controlador;

/**
 * Clase de la capa presentación que permite la implementación de la ventana de Gestion de Carrito
 */
public class JFrameGestionCarrito extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField IDCliente;
	private JTextField fecha;
	private JTextField costeTotal;
	private JButton agregarProducto;
	private JButton eliminarProducto;
	private JButton finalizarCompra;
	private TransferCompra tCompra;
	private JButton volver;
	private JScrollPane scrollPane;
	protected static JTable tabla;
	protected static String[] columnas = {"Producto", "Unidades", "Precio/Unidad", "Coste"};
	protected static DefaultTableModel model;

	public JFrameGestionCarrito(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Carrito de la compra");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		
		JPanel infoCompra = new JPanel();
		IDCliente = new JTextField(5);
		IDCliente.setEditable(false);
		fecha = new JTextField(6);
		fecha.setEditable(false);
		costeTotal = new JTextField(7);
		costeTotal.setEditable(false);
		infoCompra.add(new JLabel("ID del cliente:"));
		infoCompra.add(IDCliente);
		infoCompra.add(new JLabel("Coste total:"));
		infoCompra.add(costeTotal);
		infoCompra.add(new JLabel("Fecha:"));
		infoCompra.add(fecha);
		
		model = new DefaultTableModel(0, columnas.length);
		model.setColumnIdentifiers(columnas);
		tabla = new JTable(model);
		scrollPane = new JScrollPane(tabla);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		JPanel buttonPanel = new JPanel(new GridLayout(4, 1));	

		agregarProducto = new JButton("Agregar producto");
		eliminarProducto = new JButton("Eliminar producto");
		finalizarCompra = new JButton("Finalizar compra");
		volver = new JButton("Volver sin comprar");
		
		finalizarCompra.setPreferredSize(new Dimension(600, 35));
		
		agregarProducto.addActionListener(new ActionListenerGestionCarritoCompra(0));
		eliminarProducto.addActionListener(new ActionListenerGestionCarritoCompra(1));
		finalizarCompra.addActionListener(new ActionListenerGestionCarritoCompra(2));
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cerrar();
			}
		});
		
		panelPrincipal.add(infoCompra);
		panelPrincipal.add(scrollPane);
		buttonPanel.add(agregarProducto);
		buttonPanel.add(eliminarProducto);
        buttonPanel.add(finalizarCompra);
        buttonPanel.add(volver);
       
		panelPrincipal.add(buttonPanel);
		this.getContentPane().add(panelPrincipal);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	}
	
	public class ActionListenerGestionCarritoCompra implements ActionListener {
		private int event;
		
		public ActionListenerGestionCarritoCompra(int event){
			this.event = event;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0){
			int comando = 0;
			
			switch(event){
				case 0:
					comando = ListaComandos.VENTANA_AGREGAR_PRODUCTO_COMPRA;
					cerrarParaVistaPropia();
					Controlador.getInstance().accion(comando, null);
					break;
				case 1:
					comando = ListaComandos.VENTANA_ELIMINAR_PRODUCTO_COMPRA;
					cerrarParaVistaPropia();
					Controlador.getInstance().accion(comando, tCompra);
					break;
				case 2:
					if(!tCompra.getLineaCompra().isEmpty()){
						comando = ListaComandos.NEGOCIO_FINALIZAR_COMPRA;
						Controlador.getInstance().accion(comando, tCompra);
					}
					else
						JOptionPane.showMessageDialog(null, "El carrito está vacío", "Información", JOptionPane.INFORMATION_MESSAGE);
					break;
			}
		}
	}
	
	public TransferCompra getTransferCompra(){
		return tCompra;
	}
	
	public void setTransferCompra(TransferCompra tCompra){
		this.tCompra =tCompra;
		this.tCompra.setCosteTotal(0);
		IDCliente.setText(String.valueOf(tCompra.getIdCliente()));
		costeTotal.setText(String.valueOf(tCompra.getCosteTotal()));
		fecha.setText(String.valueOf(tCompra.getFecha()));
		
	}
	
	public void setLineaCompra(TransferLineaDeCompra producto){
		this.tCompra.addProd(producto);
		actualizaTabla();	
	}
	
	public void actualizaTabla(){	
		model = new DefaultTableModel(this.tCompra.getLineaCompra().size(), columnas.length);
		model.setColumnIdentifiers(columnas);
		int column = 0;
		ArrayList<TransferLineaDeCompra> a= tCompra.getLineaCompra();
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
		costeTotal.setText(String.valueOf(tCompra.getCosteTotal()));
	}
	
	public void cerrarParaVistaPropia(){
		this.setVisible(false);
	}	
	
	public void cerrar(){
		this.setVisible(false);
		model.setRowCount(0);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_COMPRA, null);
	}
}
