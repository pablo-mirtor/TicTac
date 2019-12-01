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
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import negocio.competencia.TransferCompetencia;
import presentacion.comandos.ListaComandos;
import presentacion.controlador.Controlador;

/**
 * Clase de la capa presentación que permite la implementación de la ventana de listar competencias
 */
public class JFrameListarCompetencias extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JButton enviar;
	private JButton volver;
	private JScrollPane scrollPane;
	protected static JTable tabla;
	protected static String[] columnas = {"ID Competencia", "Nombre", "Descripción" , "Activo"};
	protected static DefaultTableModel model;
	
	public JFrameListarCompetencias(){
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
				
		this.setTitle("Listar competencias");
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
		
		enviar.addActionListener(new ActionListenerListarCompetencias());
		
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
	
	public class ActionListenerListarCompetencias implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			Controlador.getInstance().accion(ListaComandos.NEGOCIO_LISTAR_COMPETENCIAS, null);
		}
	}
	
	public void setAreaDetalle(ArrayList<TransferCompetencia> comp){
		int column = 0;
		model = new DefaultTableModel(comp.size(), columnas.length);
		model.setColumnIdentifiers(columnas);
		for(TransferCompetencia transfer: comp){
			model.setValueAt(transfer.getId(), column, 0);
			model.setValueAt(transfer.getNombre(), column, 1);
			model.setValueAt(transfer.getDescripcion(), column, 2);
			model.setValueAt(transfer.getActivo(), column, 3);
			column++;
		}
		tabla.setMaximumSize(new Dimension(200, 200));
		tabla.setEnabled(false);
		tabla.setModel(model);
	}
	
	public void cerrar(){ 
		model.setRowCount(0);
		this.setVisible(false);
		Controlador.getInstance().accion(ListaComandos.VENTANA_PRINCIPAL_COMPETENCIA, null);
	}	
}