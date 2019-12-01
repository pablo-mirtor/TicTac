package presentacion.comandos.negocio.compra;

import negocio.compra.TransferCompra;
import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioMostrarCompraComando implements Comando {
	
	/**
	 * Metodo que se encarga de ejecutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		TransferCompra id = FactoriaServicioAplicacion.getInstance().createSACompra().mostrarCompra((int) datos);
		return new Contexto (ListaComandos.MOSTRAR_MOSTRAR_COMPRA, id);
	}

}
