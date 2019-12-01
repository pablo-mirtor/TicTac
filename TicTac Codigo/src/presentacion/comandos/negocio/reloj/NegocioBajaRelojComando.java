package presentacion.comandos.negocio.reloj;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioBajaRelojComando implements Comando {
	
	/**
	 * Metodo que se encarga de ejcutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		int ejecucion = FactoriaServicioAplicacion.getInstance().createSAReloj().bajaReloj((int)datos);
		return new Contexto(ListaComandos.MOSTRAR_BAJA_RELOJ, ejecucion);
	}

}
