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
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import negocio.reloj.TransferReloj;
import negocio.reloj.TransferRelojAnalogico;
import negocio.reloj.TransferRelojDigital;
import presentacion.comandos.ListaComandos;
import presentacion.controlador.Controlador;

/**
 * Clase de la capa presentacion que implementa la ventana de listar relojes
 */
public class JFrameListarRelojes extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JButton enviar;
	private JButton volver;
	private JScrollPane scrollPane;
	protected static JTable tabla;
	protected static String[] columnas = {"ID Reloj", "Modelo", "Marca" , "Precio", "Esfera", "Pantalla" ,"Activo"};
	protected static DefaultTableModel model;
	
	public JFrameListarRelojes(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setTitle("Listar relojes");
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/tic_tac_icono.png"));
        this.setIconImage(icon);
		this.setLayout(new FlowLayout());
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent evt) {cerrar();}}); 
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		
		JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
		
		
		enviar = new JButton("Mostrar lista");
		volver = new JButton("Volver");
		model = new DefaultTableModel(0, columnas.length);
		model.setColumnIdentifiers(columnas);
		tabla = new JTable(model);
		scrollPane = new JScrollPane(tabla);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		enviar.setPreferredSize(new Dimension(800, 35));
		
		enviar.addActionListener(new ActionListenerListarRelojes());
		
		volver.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0){
				cerrar();
			}
		});

		buttonPanel.add(enviar);
		buttonPanel.add(volver);
		panelPrincipal.add(scrollPane);
		panelPrincipal.add(buttonPanel);
		this.getContentPane().add(panelPrincipal);
		this.pack();
		
		Dimension ventana = this.getSize();
		this.setLocation((pantalla.width-ventana.width) / 2, (pantalla.height-ventana.height) / 2);
		this.setLocationRelativeTo(null);
	}
	
	public class ActionListenerListarRelojes implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			Controlador.getInstance().accion(ListaComandos.NEGOCIO_LISTAR_RELOJES, null);
		}
	}
	
	public void setAreaDetalle(ArrayList<TransferReloj> reloj){		
		int column = 0;
		model = new DefaultTableModel(reloj.size(), columnas.length);
		model.setColumnIdentifiers(columnas);
		for(TransferReloj transfer: reloj){
			model.setValueAt(transfer.getId(), column, 0);
			model.setValueAt(transfer.getModelo(), column, 1);
			model.setValueAt(transfer.getMarca(), column, 2);
			model.setValueAt(transfer.getPrecio(), column, 3);
			model.setValueAt(transfer.getActivo(), column, 6);
			if(transfer instanceof TransferRelojAnalogico)
				model.setValueAt(((TransferRelojAnalogico) transfer).getEsfera(), column, 4);
			else
				model.setValueAt(((TransferRelojDigital) transfer).getPantalla(), column, 5);
			column++;
		}
		tabla.setMaximumSize(new Dimension(200, 200));
		tabla.setEnabled(false);
		tabla.setModel(model);
	}
	
	public void cerrar(){
		model = new DefaultTableModel(5, columnas.length);
		tabla = new JTable(model);
		scrollPane = new JScrollPane(tabla);
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_RELOJ, null);
	}	
}
