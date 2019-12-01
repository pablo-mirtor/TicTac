package presentacion.vistas.vistaTrabajador;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import negocio.trabajador.TransferTrabajador;
import presentacion.comandos.ListaComandos;
import presentacion.vistas.vistaTrabajador.trabajador.JFrameAltaTrabajador;
import presentacion.vistas.vistaTrabajador.trabajador.JFrameBajaTrabajador;
import presentacion.vistas.vistaTrabajador.trabajador.JFramePrincipalTrabajador;
import presentacion.vistas.vistaTrabajador.trabajador.JFrameMostrarTrabajador;
import presentacion.vistas.vistaTrabajador.trabajador.JFrameListarTrabajadores;
import presentacion.vistas.vistaTrabajador.trabajador.JFrameModificarTrabajador;
import presentacion.controlador.Contexto;

public class VistaTrabajadorImp extends VistaTrabajador
{
	private JFrameAltaTrabajador altaTrabajador;
	private JFrameBajaTrabajador bajaTrabajador;
	private JFramePrincipalTrabajador principalTrabajador;
	private JFrameMostrarTrabajador mostrarTrabajador;
	private JFrameListarTrabajadores listarTrabajadores;
	private JFrameModificarTrabajador modificarTrabajador;
	
	public VistaTrabajadorImp() {
		createJFrameAltaTrabajador();
		createJFrameBajaTrabajador();
		createJFramePrincipalTrabajador();
		createJFrameMostrarTrabajador();
		createJFrameListarTrabajadores();
		createJFrameModificarTrabajador();
	}
	
	public void createJFrameAltaTrabajador() {
		if (altaTrabajador == null)
			altaTrabajador = new JFrameAltaTrabajador();
	}

	public void createJFrameBajaTrabajador() {
		if (bajaTrabajador == null)
			bajaTrabajador = new JFrameBajaTrabajador();
	}

	public void createJFramePrincipalTrabajador() {
		if (principalTrabajador == null)
			principalTrabajador = new JFramePrincipalTrabajador();
	}

	public void createJFrameMostrarTrabajador() {
		if (mostrarTrabajador == null)
			mostrarTrabajador = new JFrameMostrarTrabajador();
	}

	public void createJFrameListarTrabajadores() {
		if (listarTrabajadores == null)
			listarTrabajadores = new JFrameListarTrabajadores();
	}

	public void createJFrameModificarTrabajador()	{
		if (modificarTrabajador == null)
			modificarTrabajador = new JFrameModificarTrabajador();
	}

	public void update(Contexto contexto) {
		switch(contexto.getEvento()) {
			case ListaComandos.VENTANA_ALTA_TRABAJADOR:
				altaTrabajador.setVisible(true);
				break;
			case ListaComandos.VENTANA_BAJA_TRABAJADOR:
				bajaTrabajador.setVisible(true);
				break;
			case ListaComandos.VENTANA_PRINCIPAL_TRABAJADOR:
				principalTrabajador.setVisible(true);
				break;
			case ListaComandos.VENTANA_MOSTRAR_TRABAJADOR:
				mostrarTrabajador.setVisible(true);
				break;
			case ListaComandos.VENTANA_LISTAR_TRABAJADORES:
				listarTrabajadores.setVisible(true);
				break;
			case ListaComandos.VENTANA_MODIFICAR_TRABAJADOR:
				modificarTrabajador.setVisible(true);
				break;
			case ListaComandos.MOSTRAR_ALTA_TRABAJADOR:
				String mostrarAltaTrabajador = "";
				
				switch((int)contexto.getDatos()) {
					case -10:
						mostrarAltaTrabajador = "Error transacción";
						break;				
					case -4:
						mostrarAltaTrabajador = "Trabajador desactivado, lo hemos activado de nuevo";
						break;
					case -3:
						mostrarAltaTrabajador = "Existe un trabajador con el mismo DNI y está activo";
						break;
					case -2:
						mostrarAltaTrabajador = "El departamento no está activo";
						break;
					case -1:
						mostrarAltaTrabajador = "El departamento no existe";
						break;
					default:
						mostrarAltaTrabajador = "Se ha insertado con éxito el trabajador con id: " + contexto.getDatos();
				}
				JOptionPane.showMessageDialog(null, mostrarAltaTrabajador, "Información", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRAR_BAJA_TRABAJADOR:
				String mostrarBajaTrabajador = "";
				
				switch((int)contexto.getDatos()) {
					case -10:
						mostrarBajaTrabajador = "Error transacción";
						break;
					case -3:
						mostrarBajaTrabajador = "El trabajador no puede darse de baja porque tiene competencias asignadas.";
						break;
					case -2:
						mostrarBajaTrabajador = "El trabajador está desactivado";
						break;
					case -1:
						mostrarBajaTrabajador = "El trabajador no existe";
						break;
					default:
						mostrarBajaTrabajador = "Trabajador dado de baja con éxito con id: " + contexto.getDatos();
				}
				JOptionPane.showMessageDialog(null, mostrarBajaTrabajador, "Información", JOptionPane.INFORMATION_MESSAGE);	
				break;
			case ListaComandos.MOSTRAR_MODIFICAR_TRABAJADOR:
				String mostrarModificarTrabajador = "";
				
				switch((int)contexto.getDatos()) {
					case -10:
						mostrarModificarTrabajador = "Error transacción";
						break;
					case -6:
						mostrarModificarTrabajador = "El trabajador introducido no es del tipo correcto";
						break;
					case -5:
						mostrarModificarTrabajador = "Ya existe un trabajador con ese DNI";
						break;
					case -4:
						mostrarModificarTrabajador = "El departamento no está activo";
						break;
					case -3:
						mostrarModificarTrabajador = "El departamento no existe";
						break;
					case -2:
						mostrarModificarTrabajador = "El trabajador está dado de baja por lo que no se puede modificar";
						break;
					case -1:
						mostrarModificarTrabajador = "El trabajador no existe";
						break;
					default:
						mostrarModificarTrabajador = "Empleado modificado con éxito con id: " + contexto.getDatos();
				}
				JOptionPane.showMessageDialog(null, mostrarModificarTrabajador, "Información", JOptionPane.INFORMATION_MESSAGE);	
				break;
			case ListaComandos.MOSTRAR_MOSTRAR_TRABAJADOR:
				if(contexto.getDatos() != null)
					mostrarTrabajador.setAreaDetalle((TransferTrabajador) contexto.getDatos());
				else
					JOptionPane.showMessageDialog(null, "No existe el trabajador introducido", "Información", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRAR_LISTAR_TRABAJADORES:
				ArrayList<TransferTrabajador> lista = (ArrayList<TransferTrabajador>) contexto.getDatos();
				if(lista.size() > 0)
					listarTrabajadores.setAreaDetalle(lista);
				else
					JOptionPane.showMessageDialog(null, "No hay ningun trabajador", "Información", JOptionPane.INFORMATION_MESSAGE);
				break;
		}
	}
}