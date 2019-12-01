package presentacion.comandos.negocio.competencia;

import negocio.competencia.TransferCompetencia;
import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioAltaCompetenciaComando implements Comando {
	
	/**
	 * Metodo que se encarga de ejcutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		int id = FactoriaServicioAplicacion.getInstance().createSACompetencia().altaCompetencia((TransferCompetencia) datos);
		return new Contexto (ListaComandos.MOSTRAR_ALTA_COMPETENCIA, id);
	}

}
