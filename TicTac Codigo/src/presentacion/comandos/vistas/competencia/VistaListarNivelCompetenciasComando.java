package presentacion.comandos.vistas.competencia;

import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class VistaListarNivelCompetenciasComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		return new Contexto(ListaComandos.VENTANA_LISTAR_NIVEL_COMPETENCIAS, datos);
	}
}