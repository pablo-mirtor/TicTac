package presentacion.vistas.vistaDepartamento;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import negocio.departamento.TransferDepartamento;
import presentacion.comandos.ListaComandos;
import presentacion.controlador.Contexto;
import presentacion.vistas.vistaDepartamento.departamento.JFrameAltaDepartamento;
import presentacion.vistas.vistaDepartamento.departamento.JFrameBajaDepartamento;
import presentacion.vistas.vistaDepartamento.departamento.JFramePrincipalDepartamento;
import presentacion.vistas.vistaDepartamento.departamento.JFrameCalcularNominaDepartamento;
import presentacion.vistas.vistaDepartamento.departamento.JFrameMostrarDepartamento;
import presentacion.vistas.vistaDepartamento.departamento.JFrameListarDepartamentos;
import presentacion.vistas.vistaDepartamento.departamento.JFrameModificarDepartamento;

public class VistaDepartamentoImp extends VistaDepartamento {
	private JFrameAltaDepartamento altaDepartamento;
	private JFrameBajaDepartamento bajaDepartamento;
	private JFramePrincipalDepartamento botoneraDepartamento;
	private JFrameMostrarDepartamento mostrarDepartamento;
	private JFrameListarDepartamentos listarDepartamentos;
	private JFrameModificarDepartamento modificarDepartamento;
	private JFrameCalcularNominaDepartamento calcularNominaDepartamento;
	
	public VistaDepartamentoImp() {
		createJFrameAltaDepartamento();
		createJFrameBajaDepartamento();
		createJFrameBotoneraDepartamento();
		createJFrameMostrarDepartamento();
		createJFrameListarDepartamentos();
		createJFrameModificarDepartamento();
		createJFrameCalcularNominaDepartamento();
	}	
	
	public void createJFrameAltaDepartamento() {
		if(altaDepartamento == null)
			altaDepartamento = new JFrameAltaDepartamento();
	}

	public void createJFrameBajaDepartamento() {
		if(bajaDepartamento == null)
			bajaDepartamento = new JFrameBajaDepartamento();
	}

	public void createJFrameBotoneraDepartamento() {
		if(botoneraDepartamento == null)
			botoneraDepartamento = new JFramePrincipalDepartamento();
	}

	public void createJFrameMostrarDepartamento() {
		if(mostrarDepartamento == null)
			mostrarDepartamento = new JFrameMostrarDepartamento();
	}

	public void createJFrameListarDepartamentos() {
		if(listarDepartamentos == null)
			listarDepartamentos = new JFrameListarDepartamentos();
	}

	public void createJFrameModificarDepartamento() {
		if(modificarDepartamento == null)
			modificarDepartamento = new JFrameModificarDepartamento();
	}
	
	public void createJFrameCalcularNominaDepartamento() {
		if(calcularNominaDepartamento == null)
			calcularNominaDepartamento = new JFrameCalcularNominaDepartamento();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Contexto contexto) {
		switch(contexto.getEvento()) {
			case ListaComandos.VENTANA_ALTA_DEPARTAMENTO:
				altaDepartamento.setVisible(true);
				break;
			case ListaComandos.VENTANA_BAJA_DEPARTAMENTO:
				bajaDepartamento.setVisible(true);
				break;
			case ListaComandos.VENTANA_PRINCIPAL_DEPARTAMENTO:
				botoneraDepartamento.setVisible(true);
				break;
			case ListaComandos.VENTANA_MOSTRAR_DEPARTAMENTO:
				mostrarDepartamento.setVisible(true);
				break;
			case ListaComandos.VENTANA_LISTAR_DEPARTAMENTOS:
				listarDepartamentos.setVisible(true);
				break;
			case ListaComandos.VENTANA_MODIFICAR_DEPARTAMENTO:
				modificarDepartamento.setVisible(true);
				break;
			case ListaComandos.VENTANA_CALCULAR_NOMINA_DEPARTAMENTO:
				calcularNominaDepartamento.setVisible(true);
				break;	
			case ListaComandos.MOSTRAR_ALTA_DEPARTAMENTO:
				String mostrarAltaDepartamento = "";
				
				switch((int)contexto.getDatos()) {
					case -10:
						mostrarAltaDepartamento = "Error transacción";
						break;
					case -2:
						mostrarAltaDepartamento = "Departamento desactivado, lo hemos activado de nuevo";
						break;
					case -1:
						mostrarAltaDepartamento = "Existe un departamento con el mismo nombre y está activo";
						break;
					default:
						mostrarAltaDepartamento = "Se ha insertado con éxito el departamento con id: " + contexto.getDatos();
				}
				JOptionPane.showMessageDialog(null, mostrarAltaDepartamento, "Información", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRAR_BAJA_DEPARTAMENTO:
				String mostrarBajaDepartamento = "";
				
				switch((int)contexto.getDatos()) {
					case -10:
						mostrarBajaDepartamento = "Error transacción";
						break;
					case -4:
						mostrarBajaDepartamento = "No puede darse de baja el departamento ya que tiene una asignación activa";
						break;
					case -3:
						mostrarBajaDepartamento = "No puede darse de baja el departamento ya que tiene empleados activos";
						break;		
					case -2:
						mostrarBajaDepartamento = "El departamento está desactivado";
						break;
					case -1:
						mostrarBajaDepartamento = "El departamento no existe";
						break;
					default:
						mostrarBajaDepartamento = "Departamento dado de baja con éxito con id: " + (int)contexto.getDatos();
				}
				JOptionPane.showMessageDialog(null, mostrarBajaDepartamento, "Información", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRAR_MODIFICAR_DEPARTAMENTO:
				String mostrarModificarDepartamento = "";
				
				switch((int)contexto.getDatos()) {
					case -10:
						mostrarModificarDepartamento = "Error transacción";
						break;
					case -3:
						mostrarModificarDepartamento = "Ya existe un departamento con ese nombre";
						break;
					case -2:
						mostrarModificarDepartamento = "El departamento está dado de baja por lo que no se puede modificar";
						break;
					case -1:
						mostrarModificarDepartamento = "El departamento no existe";
						break;
					default:
						mostrarModificarDepartamento = "Departamento modificado con éxito con id: " + contexto.getDatos();
				}
				
				JOptionPane.showMessageDialog(null, mostrarModificarDepartamento, "Información", JOptionPane.INFORMATION_MESSAGE);	
				break;	
			case ListaComandos.MOSTRAR_CALCULAR_NOMINA_DEPARTAMENTO:
				String mostrarCalcularNomina = "";
				double salario = (double)contexto.getDatos();
				
				if(salario == -2)
					mostrarCalcularNomina = "El departamento no está activo";
				else if(salario == -1)
					mostrarCalcularNomina = "El departamento no existe";
				else
					mostrarCalcularNomina = "La suma de los salarios de todos los trabajadores es: " + salario + "€";
				
				JOptionPane.showMessageDialog(null, mostrarCalcularNomina, "Información", JOptionPane.INFORMATION_MESSAGE);
				break;
			case ListaComandos.MOSTRAR_MOSTRAR_DEPARTAMENTO:
				
				if (contexto.getDatos() == null)
					JOptionPane.showMessageDialog(null, "No existe el departamento buscado", "Información", JOptionPane.INFORMATION_MESSAGE);
				else
					mostrarDepartamento.setAreaDetalle((TransferDepartamento) contexto.getDatos());				
				
				break;
			case ListaComandos.MOSTRAR_LISTAR_DEPARTAMENTOS:


				ArrayList<TransferDepartamento> lista = (ArrayList<TransferDepartamento>) contexto.getDatos();
				
				if (lista.size() > 0) {
					for (int k = 0; k < lista.size(); ++k)
						listarDepartamentos.setAreaDetalle(lista);
				}
				else
					JOptionPane.showMessageDialog(null, "No hay ningún departamento", "Información", JOptionPane.INFORMATION_MESSAGE);			
				break;
		}
	}
}