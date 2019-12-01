package presentacion.comandos.negocio.reloj;

import java.util.ArrayList;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.reloj.TransferReloj;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioListarRelojesComando implements Comando {
	
	/**
	 * Metodo que se encarga de ejecutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		ArrayList<TransferReloj> lista = FactoriaServicioAplicacion.getInstance().createSAReloj().listarRelojes();
		return new Contexto(ListaComandos.MOSTRAR_LISTAR_RELOJES, lista);
	}

}
