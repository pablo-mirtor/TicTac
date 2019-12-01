package presentacion.comandos.negocio.compra;

import negocio.compra.TransferLineaDeCompra;
import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioDevolucionCompraComando implements Comando {

	/**
	 * Metodo que se encarga de ejcutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		int id = FactoriaServicioAplicacion.getInstance().createSACompra().devolverProducto((TransferLineaDeCompra)datos);
		return new Contexto (ListaComandos.MOSTRAR_DEVOLUCION_PRODUCTO_COMPRA , id);
	}

}