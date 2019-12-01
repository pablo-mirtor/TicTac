package presentacion.vistas.vistaCompetencia;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import negocio.competencia.TransferCompetenciaTrabajador;
import negocio.competencia.TransferCompetencia;
import presentacion.comandos.ListaComandos;
import presentacion.controlador.Contexto;
import presentacion.vistas.vistaCompetencia.competencia.JFrameAltaCompetencia;
import presentacion.vistas.vistaCompetencia.competencia.JFrameAsignarCompetenciaTrabajador;
import presentacion.vistas.vistaCompetencia.competencia.JFrameAsignarNivelCompetencia;
import presentacion.vistas.vistaCompetencia.competencia.JFrameBajaCompetencia;
import presentacion.vistas.vistaCompetencia.competencia.JFramePrincipalCompetencia;
import presentacion.vistas.vistaCompetencia.competencia.JFrameDesasignarCompetenciaTrabajador;
import presentacion.vistas.vistaCompetencia.competencia.JFrameMostrarNivelCompetencia;
import presentacion.vistas.vistaCompetencia.competencia.JFrameMostrarCompetencia;
import presentacion.vistas.vistaCompetencia.competencia.JFrameListarCompetencias;
import presentacion.vistas.vistaCompetencia.competencia.JFrameModificarCompetencia;

public class VistaCompetenciaImp extends VistaCompetencia {
	private JFrameAltaCompetencia altaCompetencia;
	private JFrameBajaCompetencia bajaCompetencia;
	private JFramePrincipalCompetencia principalCompetencia;
	private JFrameMostrarCompetencia mostrarCompetencia;
	private JFrameListarCompetencias listarCompetencias;
	private JFrameModificarCompetencia modificarCompetencia;
	private JFrameAsignarCompetenciaTrabajador asignarCompetenciaTrabajador;
	private JFrameDesasignarCompetenciaTrabajador desasignarCompetenciaTrabajador;
	private JFrameAsignarNivelCompetencia asignarNivelCompetencia;
	private JFrameMostrarNivelCompetencia mostrarNivelCompetencia;

	public VistaCompetenciaImp()	{
		createJFrameAltaCompetencia();
		createJFrameBajaTienda();
		createJFramePrincipalCompetencia();
		createJFrameMostrarCompetencia();
		createJFrameListarCompetencias();
		createJFrameModificarCompetencia();
		createJFrameAsignarCompetenciaTrabajador();
		createJFrameDesasignarCompetenciaTrabajador();
		createJFrameAsignarNivelCompetencia();
		createJFrameMostrarNivelCompetencia();
	}
	
	public void createJFrameAltaCompetencia() {
		if (altaCompetencia == null)
			altaCompetencia = new JFrameAltaCompetencia();
	}

	public void createJFrameBajaTienda() {
		if (bajaCompetencia == null)
			bajaCompetencia = new JFrameBajaCompetencia();
	}
	
	public void createJFramePrincipalCompetencia() {
		if (principalCompetencia == null)
			principalCompetencia = new JFramePrincipalCompetencia();
	}
	
	public void createJFrameMostrarCompetencia() {
		if (mostrarCompetencia == null)
			mostrarCompetencia = new JFrameMostrarCompetencia();
	}

	public void createJFrameListarCompetencias() {
		if (listarCompetencias == null)
			listarCompetencias = new JFrameListarCompetencias();
	}

	public void createJFrameModificarCompetencia() {
		if (modificarCompetencia == null)
			modificarCompetencia = new JFrameModificarCompetencia();
	}

	public void createJFrameAsignarCompetenciaTrabajador() {
		if (asignarCompetenciaTrabajador == null)
			asignarCompetenciaTrabajador = new JFrameAsignarCompetenciaTrabajador();
	}	
	
	public void createJFrameDesasignarCompetenciaTrabajador() {
		if (desasignarCompetenciaTrabajador == null)
			desasignarCompetenciaTrabajador = new JFrameDesasignarCompetenciaTrabajador();
	}	
	
	public void createJFrameAsignarNivelCompetencia() {
		if (asignarNivelCompetencia == null)
			asignarNivelCompetencia = new JFrameAsignarNivelCompetencia();
	}
	
	public void createJFrameMostrarNivelCompetencia() {
		if (mostrarNivelCompetencia == null)
			mostrarNivelCompetencia = new JFrameMostrarNivelCompetencia();
	}	
	
	
	
	@Override
	public void update(Contexto contexto) {
		switch(contexto.getEvento())
		{
			case ListaComandos.VENTANA_ALTA_COMPETENCIA:
				altaCompetencia.setVisible(true);
				break;
			case ListaComandos.VENTANA_BAJA_COMPETENCIA:
				bajaCompetencia.setVisible(true);
				break;
			case ListaComandos.VENTANA_PRINCIPAL_COMPETENCIA:
				principalCompetencia.setVisible(true);
				break;
			case ListaComandos.VENTANA_MOSTRAR_COMPETENCIA:
				mostrarCompetencia.setVisible(true);
				break;
			case ListaComandos.VENTANA_LISTAR_COMPETENCIAS:
				listarCompetencias.setVisible(true);
				break;
			case ListaComandos.VENTANA_MODIFICAR_COMPETENCIA:
				modificarCompetencia.setVisible(true);
				break;
			case ListaComandos.VENTANA_ASIGNAR_COMPETENCIA_TRABAJADOR:
				asignarCompetenciaTrabajador.setVisible(true);
				break;
			case ListaComandos.VENTANA_DESASIGNAR_COMPETENCIA_TRABAJADOR:
				desasignarCompetenciaTrabajador.setVisible(true);
				break;
			case ListaComandos.VENTANA_ASIGNAR_NIVEL_COMPETENCIA:
				asignarNivelCompetencia.setVisible(true);
				break;
			case ListaComandos.VENTANA_MOSTRAR_NIVEL_COMPETENCIA:
				mostrarNivelCompetencia.setVisible(true);
				break;
			case ListaComandos.MOSTRAR_ALTA_COMPETENCIA:
				String mostrarAltaCompetencia = "";
				
				switch((int)contexto.getDatos()) {
					case -10:
						mostrarAltaCompetencia = "Error transacci�n";
						break;				
					case -2:
						mostrarAltaCompetencia = "Competencia desactivada, la hemos activado de nuevo";
						break;
					case -1:
						mostrarAltaCompetencia = "Existe una competencia con el mismo nombre y est� activo";
						break;
					default:
						mostrarAltaCompetencia = "Se ha insertado con exito la competencia con id: " + contexto.getDatos();
				}
				
				JOptionPane.showMessageDialog(null, mostrarAltaCompetencia, "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRAR_BAJA_COMPETENCIA:
				String mostrarBajaCompetencia = "";
				
				switch((int)contexto.getDatos()) {
					case -10:
						mostrarBajaCompetencia = "Error transacci�n";
						break;				
					case -3:
						mostrarBajaCompetencia = "La competencia no puede desactivarse porque tiene activa una asignaci�n";
						break;
					case -2:
						mostrarBajaCompetencia = "La competencia est� desactivada";
						break;
					case -1:
						mostrarBajaCompetencia = "La competencia no existe";
						break;
					default:
						mostrarBajaCompetencia = "Competencia dada de baja con �xito con id: " + contexto.getDatos();
				}
				
				JOptionPane.showMessageDialog(null, mostrarBajaCompetencia, "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRAR_MODIFICAR_COMPETENCIA:
				String mostrarModificarCompetencia = "";
				
				switch((int)contexto.getDatos()) {
					case -10:
						mostrarModificarCompetencia = "Error transacci�n";
						break;				
					case -3:
						mostrarModificarCompetencia = "Ya existe una competencia con ese nombre";
						break;
					case -2:
						mostrarModificarCompetencia = "La competencia est� dada de baja por lo que no se puede modificar";
						break;
					case -1:
						mostrarModificarCompetencia = "La competencia no existe";
						break;
					default:
						mostrarModificarCompetencia = "Competencia modificada con �xito con id: " + contexto.getDatos();
				}
				
				JOptionPane.showMessageDialog(null, mostrarModificarCompetencia, "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRAR_ASIGNAR_COMPETENCIA_TRABAJADOR:
				String mostrarAsignarCompetenciaTrabajador = "";
				
				switch((int)contexto.getDatos()) {
					case -10:
						mostrarAsignarCompetenciaTrabajador = "Error transacci�n";
						break;
					case -4:
						mostrarAsignarCompetenciaTrabajador = "Asignaci�n desactivada, la hemos activado de nuevo";
						break;
					case -3:
						mostrarAsignarCompetenciaTrabajador = "Esta asignaci�n ya esta activa o est� desactivada";
						break;
					case -2:
						mostrarAsignarCompetenciaTrabajador = "La competencia introducida no existe o est� desactivada";
						break;
					case -1:
						mostrarAsignarCompetenciaTrabajador = "El trabajador introducido no existe o est� desactivado";
						break;
					default:
						mostrarAsignarCompetenciaTrabajador = "Competencia asignada con �xito a trabajador: " + contexto.getDatos();
				}
				
				JOptionPane.showMessageDialog(null, mostrarAsignarCompetenciaTrabajador, "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRAR_DESASIGNAR_COMPETENCIA_TRABAJADOR:
				String mostrarDesasignarCompetenciaTrabajador = "";
				
				switch((int)contexto.getDatos()) {
					case -10:
						mostrarDesasignarCompetenciaTrabajador = "Error transacci�n";
						break;				
					case -5:
						mostrarDesasignarCompetenciaTrabajador = "Asignaci�n desactivada con �xito";
						break;
					case -4:
						mostrarDesasignarCompetenciaTrabajador = "La asignaci�n ya est� desactivada";
						break;
					case -3:
						mostrarDesasignarCompetenciaTrabajador = "Esta asignaci�n no existe";
						break;
					case -2:
						mostrarDesasignarCompetenciaTrabajador = "La competencia introducida no existe o est� desactivada";
						break;
					case -1:
						mostrarDesasignarCompetenciaTrabajador = "El trabajador introducido no existe o est� desactivado";
						break;
				}
				
				JOptionPane.showMessageDialog(null, mostrarDesasignarCompetenciaTrabajador, "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRAR_ASIGNAR_NIVEL_COMPETENCIA:
				String mostrarAsignarCompetencia = "";
				
				switch((int)contexto.getDatos()) {
					case -10:
						mostrarAsignarCompetencia = "Error transacci�n";
						break;				
					case -5:
						mostrarAsignarCompetencia = "Nivel asignado con �xito";
						break;
					case -4:
						mostrarAsignarCompetencia = "El trabajador no est� asociado a la competencia, no podemos asignar nivel";
						break;
					case -3:
						mostrarAsignarCompetencia = "Esta asignaci�n no existe";
						break;
					case -2:
						mostrarAsignarCompetencia = "La competencia introducida no existe";
						break;
					case -1:
						mostrarAsignarCompetencia = "El trabajador introducido no existe";
						break;
				}				
				
				JOptionPane.showMessageDialog(null, mostrarAsignarCompetencia, "Informaci�n", JOptionPane.INFORMATION_MESSAGE);	
				break;
				
				
			case ListaComandos.MOSTRAR_MOSTRAR_COMPETENCIA:
				if(contexto.getDatos() != null)
					mostrarCompetencia.setAreaDetalle((TransferCompetencia) contexto.getDatos());
				else
					JOptionPane.showMessageDialog(null, "No existe la competencia introducida", "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
				break;
				
				
			case ListaComandos.MOSTRAR_LISTAR_COMPETENCIAS:
				ArrayList<TransferCompetencia>lista = (ArrayList<TransferCompetencia>) contexto.getDatos();
				if(lista.size() > 0)
					listarCompetencias.setAreaDetalle(lista);
				else
					JOptionPane.showMessageDialog(null, "No hay ninguna competencia", "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
				break;
				
				
			case ListaComandos.MOSTRAR_MOSTRAR_NIVEL_COMPETENCIA:
				
				if(contexto.getDatos() != null)
				mostrarNivelCompetencia.setAreaDetalle((TransferCompetenciaTrabajador) contexto.getDatos());
			else
				JOptionPane.showMessageDialog(null, "No existe un trabajador asignado a esa competencia", "Informaci�n", JOptionPane.INFORMATION_MESSAGE);
			break;
				
				
		}
	}
}
