package presentacion.comandos.negocio.compra;

import negocio.compra.TransferCompra;
import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioFinalizarCompraComando implements Comando {

	/**
	 * Metodo que se encarga de ejecutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		int resultado = FactoriaServicioAplicacion.getInstance().createSACompra().finalizarCompra((TransferCompra) datos);
		return new Contexto (ListaComandos.MOSTRAR_FINALIZAR_COMPRA, resultado);
	}

}
