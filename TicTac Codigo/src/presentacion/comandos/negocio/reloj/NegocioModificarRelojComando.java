package presentacion.comandos.negocio.reloj;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.reloj.TransferReloj;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioModificarRelojComando implements Comando {
	
	/**
	 * Metodo que se encarga de ejcutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		int id = FactoriaServicioAplicacion.getInstance().createSAReloj().modificarReloj((TransferReloj)datos);
		return new Contexto(ListaComandos.MOSTRAR_MODIFICAR_RELOJ, id);
	}

}
