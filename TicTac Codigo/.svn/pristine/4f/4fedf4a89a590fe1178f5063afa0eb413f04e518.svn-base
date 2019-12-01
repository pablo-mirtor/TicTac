package presentacion.vistas.vistaCliente;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import negocio.cliente.TransferCliente;
import presentacion.comandos.ListaComandos;
import presentacion.controlador.Contexto;
import presentacion.vistas.vistaCliente.cliente.JFrameAltaCliente;
import presentacion.vistas.vistaCliente.cliente.JFrameBajaCliente;
import presentacion.vistas.vistaCliente.cliente.JFramePrincipalCliente;
import presentacion.vistas.vistaCliente.cliente.JFrameMostrarCliente;
import presentacion.vistas.vistaCliente.cliente.JFrameListarClientes;
import presentacion.vistas.vistaCliente.cliente.JFrameModificarCliente;

/**
 * Clase de la capa presentación que implementa la vista de cliente
 */
public class VistaClienteImp extends VistaCliente{
	private JFrameAltaCliente altaCliente;
	private JFrameBajaCliente bajaCliente;
	private JFramePrincipalCliente principalCliente;
	private JFrameMostrarCliente mostrarCliente;
	private JFrameListarClientes listarClientes;
	private JFrameModificarCliente modificarCliente;
	
	public VistaClienteImp(){
		createJFrameAltaCliente();
		createJFrameBajaCliente();
		createJFramePrincipalCliente();
		createJFrameMostrarCliente();
		createJFrameListarClientes();
		createJFrameModificarCliente();
	}
	
	public void createJFrameAltaCliente(){
		if (altaCliente == null){
			altaCliente = new JFrameAltaCliente();
		}
	}

	public void createJFrameBajaCliente(){
		if (bajaCliente == null){
			bajaCliente = new JFrameBajaCliente();
		}
	}

	public void createJFramePrincipalCliente(){
		if (principalCliente == null){
			principalCliente = new JFramePrincipalCliente();
		}
	}

	public void createJFrameMostrarCliente(){
		if (mostrarCliente == null){
			mostrarCliente = new JFrameMostrarCliente();
		}
	}

	public void createJFrameListarClientes(){
		if (listarClientes == null){
			listarClientes = new JFrameListarClientes();
		}
	}

	public void createJFrameModificarCliente(){
		if (modificarCliente == null){
			modificarCliente = new JFrameModificarCliente();
		}
	}


	
	/**
	 * Este método, en función del evento del parámetro contexto, pondrá visible la ventana correspondiente y mostrará los datos del contexto
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void update(Contexto contexto){
		
		switch (contexto.getEvento()){
			case ListaComandos.VENTANA_ALTA_CLIENTE:
				altaCliente.setVisible(true); break;
				
			case ListaComandos.VENTANA_BAJA_CLIENTE:
				bajaCliente.setVisible(true); break;
				
			case ListaComandos.VENTANA_PRINCIPAL_CLIENTE:
				principalCliente.setVisible(true); break;
				
			case ListaComandos.VENTANA_MOSTRAR_CLIENTE:
				mostrarCliente.setVisible(true); break;
				
			case ListaComandos.VENTANA_LISTAR_CLIENTES:
				listarClientes.setVisible(true); break;
				
			case ListaComandos.VENTANA_MODIFICAR_CLIENTE:
				modificarCliente.setVisible(true); break;
				
		
		
			// Mostrar
			
			case ListaComandos.MOSTRAR_ALTA_CLIENTE:
				String msgAlta = "";
				switch((int)contexto.getDatos()){			
					case -2:
						msgAlta = "Cliente no activo, se ha vuelto a activar."; break;
						
					case -1:
						msgAlta = "Error: el DNI del cliente ya existe."; break;
						
					case 0:
						msgAlta = "Error producido al conectar con la base de datos"; break;
						
					default:
						msgAlta = "Operación realizada con éxito, cliente dado de alta con id: " + contexto.getDatos();
				}
				
				JOptionPane.showMessageDialog(null, msgAlta, "Información", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRAR_BAJA_CLIENTE:
				String msgBaja = "";
				switch((int)contexto.getDatos())
				{			
					case -2:
						msgBaja = "El cliente ya estaba inactivo";
						break;
					case -1:
						msgBaja = "Error: el ID del cliente no existe";
						break;
					case 0:
						msgBaja = "Cliente no eliminado debido a un error con la BD";
						break;
					default:
						msgBaja = "Operación realizada con éxito, cliente dado de baja con id: " + contexto.getDatos();
				}
				
				JOptionPane.showMessageDialog(null, msgBaja, "Información", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRAR_MODIFICAR_CLIENTE:
				String msgModificar = "";
				switch((int)contexto.getDatos())
				{
					case -3:
						msgModificar = "Error: Ya existe un cliente con ese DNI";
						break;
					case -2:
						msgModificar = "Error: Cliente inactivo. Para modificarlo vuelva a darlo de alta";
						break;
					case -1:
						msgModificar = "Error: No existe ningún cliente con ese ID";
						break;
					case 0:
						msgModificar = "Se ha producido un error en la base de datos";
						break;
					default:
						msgModificar = "Operación realizada con éxito, cliente modificado con id: " + contexto.getDatos();
				}
				
				JOptionPane.showMessageDialog(null, msgModificar, "Información", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case ListaComandos.MOSTRAR_MOSTRAR_CLIENTE:
				if(contexto.getDatos() != null)
					mostrarCliente.setAreaDetalle((TransferCliente) contexto.getDatos());
				else
					JOptionPane.showMessageDialog(null, "No existe el cliente introducido", "Información", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case ListaComandos.MOSTRAR_LISTAR_CLIENTES:
				if(((ArrayList<TransferCliente>) contexto.getDatos()).size() > 0)
					listarClientes.setAreaDetalle((ArrayList<TransferCliente>) contexto.getDatos());
				else
					JOptionPane.showMessageDialog(null, "No hay ningún cliente", "Información", JOptionPane.INFORMATION_MESSAGE);
				break;
				
		}
	}
}
