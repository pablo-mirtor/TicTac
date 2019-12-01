package presentacion.vistas.vistaCompra;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import negocio.cliente.TransferCliente;
import negocio.compra.TransferCompra;
import negocio.compra.TransferLineaDeCompra;
import presentacion.comandos.ListaComandos;
import presentacion.controlador.Contexto;
import presentacion.vistas.vistaCompra.compra.JFrameAgregarProducto;
import presentacion.vistas.vistaCompra.compra.JFrameCantidadRelojes;
import presentacion.vistas.vistaCompra.compra.JFramePrincipalCompra;
import presentacion.vistas.vistaCompra.compra.JFrameMostrarCompra;
import presentacion.vistas.vistaCompra.compra.JFrameNumeroClientes;
import presentacion.vistas.vistaCompra.compra.JFrameDevolucionCompra;
import presentacion.vistas.vistaCompra.compra.JFrameEliminarProducto;
import presentacion.vistas.vistaCompra.compra.JFrameGestionCarrito;
import presentacion.vistas.vistaCompra.compra.JFrameIniciarCompra;
import presentacion.vistas.vistaCompra.compra.JFrameListarCompras;

/**
 * Clase de la capa presentacion que implementa la vista de compra
 */
public class VistaCompraImp extends VistaCompra {
	
	private JFrameAgregarProducto agregarProducto;
	private JFramePrincipalCompra principalCompra;
	private JFrameMostrarCompra mostrarCompra;
	private JFrameDevolucionCompra devolucionCompra;
	private JFrameEliminarProducto eliminarProducto;
	private JFrameGestionCarrito gestionCarrito;
	private JFrameIniciarCompra iniciarCompra;
	private JFrameListarCompras listarCompras;
	private JFrameCantidadRelojes cantidadRelojes;
	private JFrameNumeroClientes numeroClientes;
	
	public VistaCompraImp(){
		createJFrameAgregarProducto();
		createJFramePrincipalCompra();
		createJFrameMostrarCompra();
		createJFrameDevolucionCompra();
		createJFrameEliminarProducto();
		createJFrameGestionCarrito();
		createJFrameIniciarCompra();
		createJFrameListarCompras();
		createJFrameCantidadRelojes();
		createJFrameNumeroClientes();
	}
	
	public void createJFrameAgregarProducto(){
		if (agregarProducto == null){
			agregarProducto = new JFrameAgregarProducto();
		}
	}

	public void createJFramePrincipalCompra(){
		if (principalCompra == null){
			principalCompra = new JFramePrincipalCompra();
		}
	}

	public void createJFrameMostrarCompra(){
		if (mostrarCompra == null){
			mostrarCompra = new JFrameMostrarCompra();
		}
	}

	public void createJFrameDevolucionCompra(){
		if (devolucionCompra == null){
			devolucionCompra = new JFrameDevolucionCompra();
		}
	}

	public void createJFrameEliminarProducto(){
		if (eliminarProducto == null){
			eliminarProducto = new JFrameEliminarProducto();
		}
	}

	public void createJFrameGestionCarrito(){
		if (gestionCarrito == null){
			gestionCarrito = new JFrameGestionCarrito();
		}
	}

	public void createJFrameIniciarCompra(){
		if (iniciarCompra == null){
			iniciarCompra = new JFrameIniciarCompra();
		}
	}

	public void createJFrameListarCompras(){
		if (listarCompras == null){
			listarCompras = new JFrameListarCompras();
		}
	}
	
	public void createJFrameCantidadRelojes(){
		if (cantidadRelojes == null)
			cantidadRelojes = new JFrameCantidadRelojes();
	}	
	
	public void createJFrameNumeroClientes(){
		if (numeroClientes == null){
			numeroClientes = new JFrameNumeroClientes();
		}
	}	

	@SuppressWarnings("unchecked")
	@Override
	public void update(Contexto contexto){
		switch (contexto.getEvento()){
			case ListaComandos.VENTANA_AGREGAR_PRODUCTO_COMPRA:
				agregarProducto.setVisible(true);
				break;
			case ListaComandos.VENTANA_PRINCIPAL_COMPRA:
				principalCompra.setVisible(true);
				break;
			case ListaComandos.VENTANA_MOSTRAR_COMPRA:
				mostrarCompra.setVisible(true);
				break;
			case ListaComandos.VENTANA_DEVOLUCION_COMPRA:
				devolucionCompra.setVisible(true);
				break;
			case ListaComandos.VENTANA_ELIMINAR_PRODUCTO_COMPRA:
				eliminarProducto.setVisible(true);
				eliminarProducto.setTransferCompra((TransferCompra) contexto.getDatos());
				break;
			case ListaComandos.VENTANA_GESTION_CARRITO_COMPRA:
				gestionCarrito.setVisible(true);
				break;
			case ListaComandos.VENTANA_INICIAR_COMPRA:
				iniciarCompra.setVisible(true);
				break;
			case ListaComandos.VENTANA_LISTAR_COMPRAS:
				listarCompras.setVisible(true);
				break;
			case ListaComandos.VENTANA_CANTIDAD_RELOJES_QUERY:
				cantidadRelojes.setVisible(true);
				break;
			case ListaComandos.VENTANA_NUMERO_CLIENTES_QUERY:
				numeroClientes.setVisible(true); break;
				
			// Mostrar
				
			case ListaComandos.MOSTRAR_GESTION_CARRITO_COMPRA:
				if(contexto.getDatos() != null){
					gestionCarrito.setTransferCompra((TransferCompra) contexto.getDatos());
					gestionCarrito.setVisible(true);
					iniciarCompra.cerrarPorVista();
				}
				else{
					JOptionPane.showMessageDialog(null, "El cliente no existe o está inactivo", "Información", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case ListaComandos.MOSTRAR_AGREGAR_PRODUCTO_COMPRA:
				if(contexto.getDatos() != null){
					gestionCarrito.setLineaCompra((TransferLineaDeCompra) contexto.getDatos());
					agregarProducto.cerrar();
				}	
				else{
					JOptionPane.showMessageDialog(null, "No existe el producto o está inactivo, pruebe de nuevo", "Información", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case ListaComandos.MOSTRAR_ELIMINAR_PRODUCTO_COMPRA:
				eliminarProducto.cerrar();
				gestionCarrito.actualizaTabla();
				break;
				
			case ListaComandos.MOSTRAR_FINALIZAR_COMPRA:
				if((int)contexto.getDatos() != 0){
					JOptionPane.showMessageDialog(null, "Compra realizada con éxito con ID: " + (int)contexto.getDatos(), "Informacion", JOptionPane.INFORMATION_MESSAGE);
					gestionCarrito.cerrar();
					principalCompra.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "No se ha podido finalizar la compra, inténtelo de nuevo", "Información", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case ListaComandos.MOSTRAR_DEVOLUCION_PRODUCTO_COMPRA:
				String msgDevolucion = "";
				switch((int)contexto.getDatos()){
					case -4:
						msgDevolucion = "Error: la compra tiene menos productos de los que quieres devolver.";
						break;
					case -3:
						msgDevolucion = "Eliminada línea de compra totalmente";
						devolucionCompra.cerrar();
						break;
					case -2:
						msgDevolucion = "Producto devuelto";
						devolucionCompra.cerrar();
						break;						
					case -1:
						msgDevolucion = "No se puede devolver el producto porque no existe esa línea de compra";
						break;
					case 0:
						msgDevolucion = "Devolución no realizada, debido a un error con la BD";
						break;
				}
				JOptionPane.showMessageDialog(null, msgDevolucion, "Información", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case ListaComandos.MOSTRAR_MOSTRAR_COMPRA:
				if(contexto.getDatos() != null){
					mostrarCompra.setAreaDetalle((TransferCompra) contexto.getDatos());
				}
				else{
					JOptionPane.showMessageDialog(null, "No existe la compra introducida", "Información", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case ListaComandos.MOSTRAR_LISTAR_COMPRAS:
				if(((ArrayList<TransferCompra>) contexto.getDatos()).size() > 0){
					listarCompras.setAreaDetalle((ArrayList<TransferCompra>) contexto.getDatos());
				}
				else{
					JOptionPane.showMessageDialog(null, "No hay ninguna compra", "Información", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			case ListaComandos.MOSTRAR_CANTIDAD_RELOJES_QUERY:
				String msgCantidadRelojes = "";
				switch((int)contexto.getDatos()){
					case -1:
						msgCantidadRelojes = "El cliente no existe";
						break;
					case 0:
						msgCantidadRelojes = "El cliente no ha comprado ningún reloj de ese modelo";
						break;
						
					default:
						msgCantidadRelojes = "El cliente ha comprado " + contexto.getDatos() + " reloj(es) de ese modelo";
				}
				
				JOptionPane.showMessageDialog(null, msgCantidadRelojes, "Información", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRAR_NUMERO_CLIENTES_QUERY:				
				if(((ArrayList<TransferCliente>) contexto.getDatos()).size() > 0){	
					JOptionPane.showMessageDialog(null, "Dicho modelo de reloj ha sido comprado por "+ ((ArrayList<TransferCliente>) contexto.getDatos()).size() +" cliente(s).", "Información", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null, "No hay ningún cliente", "Información", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
		}
	}
}
