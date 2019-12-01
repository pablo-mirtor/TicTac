package presentacion.comandos.vistas.competencia;

import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class VistaAsignarCompetenciaTrabajadorComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		return new Contexto(ListaComandos.VENTANA_ASIGNAR_COMPETENCIA_TRABAJADOR, datos);
	}
}