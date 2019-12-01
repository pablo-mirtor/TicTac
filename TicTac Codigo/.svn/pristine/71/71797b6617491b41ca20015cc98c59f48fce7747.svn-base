package presentacion.comandos.negocio.competencia;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioBajaCompetenciaComando implements Comando {
	
	/**
	 * Metodo que se encarga de ejcutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		int id = FactoriaServicioAplicacion.getInstance().createSACompetencia().bajaCompetencia((int) datos);
		return new Contexto (ListaComandos.MOSTRAR_BAJA_COMPETENCIA, id);
	}

}