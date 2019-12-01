package presentacion.vistas.vistaReloj;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import negocio.reloj.TransferReloj;
import presentacion.comandos.ListaComandos;
import presentacion.controlador.Contexto;
import presentacion.vistas.vistaReloj.reloj.JFrameAltaRelojAnalogico;
import presentacion.vistas.vistaReloj.reloj.JFrameAltaRelojDigital;
import presentacion.vistas.vistaReloj.reloj.JFrameBajaReloj;
import presentacion.vistas.vistaReloj.reloj.JFramePrincipalReloj;
import presentacion.vistas.vistaReloj.reloj.JFrameMostrarReloj;
import presentacion.vistas.vistaReloj.reloj.JFrameListarRelojes;
import presentacion.vistas.vistaReloj.reloj.JFrameModificarRelojAnalogico;
import presentacion.vistas.vistaReloj.reloj.JFrameModificarRelojDigital;

/**
 * Clase de la capa presentacion que implementa la vista del reloj 
 */
public class VistaRelojImp extends VistaReloj {
	private JFrameAltaRelojAnalogico altaRelojAnalogico;
	private JFrameAltaRelojDigital altaRelojDigital;
	private JFrameBajaReloj bajaReloj;
	private JFramePrincipalReloj principalReloj;
	private JFrameMostrarReloj mostrarReloj;
	private JFrameListarRelojes listarRelojes;
	private JFrameModificarRelojAnalogico modificarRelojAnalogico;
	private JFrameModificarRelojDigital modificarRelojDigital;
	
	
	public VistaRelojImp()	{
		createJFrameAltaRelojAnalogico();
		createJFrameAltaRelojDigital();
		createJFrameBajaReloj();
		createJFramePrincipalReloj();
		createJFrameMostrarReloj();
		createJFrameListarRelojes();
		createJFrameModificarRelojAnalogico();
		createJFrameModificarRelojDigital();
	}
	
	public void createJFrameAltaRelojAnalogico(){
		if (altaRelojAnalogico == null) 
			altaRelojAnalogico = new JFrameAltaRelojAnalogico();
	}

	public void createJFrameAltaRelojDigital(){
		if (altaRelojDigital == null)
			altaRelojDigital = new JFrameAltaRelojDigital();
	}

	public void createJFrameBajaReloj(){
		if (bajaReloj == null)
			bajaReloj = new JFrameBajaReloj();
	}

	public void createJFramePrincipalReloj(){
		if (principalReloj == null)
			principalReloj = new JFramePrincipalReloj();
	}

	public void createJFrameMostrarReloj(){
		if (mostrarReloj == null)
			mostrarReloj = new JFrameMostrarReloj();
	}

	public void createJFrameListarRelojes(){
		if (listarRelojes == null)
			listarRelojes = new JFrameListarRelojes();
	}

	public void createJFrameModificarRelojAnalogico(){
		if (modificarRelojAnalogico == null)
			modificarRelojAnalogico = new JFrameModificarRelojAnalogico();
	}

	public void createJFrameModificarRelojDigital(){
		if (modificarRelojDigital == null)
			modificarRelojDigital = new JFrameModificarRelojDigital();
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public void update(Contexto contexto){
		switch (contexto.getEvento()){
			// Ventana
		
			case ListaComandos.VENTANA_ALTA_RELOJ_ANALOGICO:
				altaRelojAnalogico.setVisible(true);
				break;
			case ListaComandos.VENTANA_ALTA_RELOJ_DIGITAL:
				altaRelojDigital.setVisible(true);
				break;
			case ListaComandos.VENTANA_BAJA_RELOJ:
				bajaReloj.setVisible(true);
				break;
			case ListaComandos.VENTANA_PRINCIPAL_RELOJ:
				principalReloj.setVisible(true);
				break;
			case ListaComandos.VENTANA_MOSTRAR_RELOJ:
				mostrarReloj.setVisible(true);
				break;
			case ListaComandos.VENTANA_LISTAR_RELOJES:
				listarRelojes.setVisible(true);
				break;
			case ListaComandos.VENTANA_MODIFICAR_RELOJ_ANALOGICO:
				modificarRelojAnalogico.setVisible(true);
				break;
			case ListaComandos.VENTANA_MODIFICAR_RELOJ_DIGITAL:
				modificarRelojDigital.setVisible(true);
				break;
			
				
			// Mostrar
				
			case ListaComandos.MOSTRAR_ALTA_RELOJ:
				String msgAlta = "";
				switch((int)contexto.getDatos()){		
					case -3: 
						msgAlta = "Error: no se puede reactivar un reloj analógico como digital, y viceversa.";
						break;
					case -2:
						msgAlta = "Reloj reactivado con éxito.";
						break;
					case -1:
						msgAlta = "Error: Ya existe ese modelo de reloj.";
						break;
					case 0:
						msgAlta = "Reloj no guardado, debido a un error con la Base de Datos.";
						break;
					default:
						msgAlta = "Operación realizada con exito, reloj dado de alta con ID: " + contexto.getDatos();
				}
				
				JOptionPane.showMessageDialog(null, msgAlta, "Información", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case ListaComandos.MOSTRAR_BAJA_RELOJ:
				String msgBaja = "";
				switch((int)contexto.getDatos()){			
					case -2:
						msgBaja = "Error: El reloj ya estaba dado de baja";
						break;
					case -1:
						msgBaja = "Error: El reloj introducido no existe";
						break;
					case 0:
						msgBaja = "Reloj no eliminado, debido a un error con la Base de Datos";
						break;
					default:
						msgBaja = "Operación realizada con exito, reloj dado de baja con ID: " + contexto.getDatos();
				}
				
				JOptionPane.showMessageDialog(null, msgBaja, "Información", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case ListaComandos.MOSTRAR_MODIFICAR_RELOJ:
				String msgModificar = "";
				switch((int)contexto.getDatos()){
					case -4:
						msgModificar = "Error: no se puede modificar un reloj analógico como digital, y viceversa.";
						break;
					case -3:
						msgModificar = "Error: ya existe el modelo";
						break;
					case -2:
						msgModificar = "Error: reloj inactivo. Para modificarlo tienes que reactivarlo.";
						break;
					case -1:
						msgModificar = "Error: no existe ningún reloj con ese ID";
						break;
					case 0:
						msgModificar = "Reloj no modificado, debido a un error con la BD";
						break;
					default:
						msgModificar = "Operación realizada con exito, reloj modificado con ID: " + contexto.getDatos();
				}
				
				JOptionPane.showMessageDialog(null, msgModificar, "Información", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case ListaComandos.MOSTRAR_MOSTRAR_RELOJ:
				if(contexto.getDatos() != null)
					mostrarReloj.setAreaDetalle((TransferReloj) contexto.getDatos());
				else
					JOptionPane.showMessageDialog(null, "No existe el reloj introducido", "Información", JOptionPane.INFORMATION_MESSAGE);
				break;
				
			case ListaComandos.MOSTRAR_LISTAR_RELOJES:
				if(((ArrayList<TransferReloj>) contexto.getDatos()).size() > 0)
					listarRelojes.setAreaDetalle((ArrayList<TransferReloj>) contexto.getDatos());
				else
					JOptionPane.showMessageDialog(null, "No hay ningun reloj", "Información", JOptionPane.INFORMATION_MESSAGE);
				break;
			
		}
	}
}
