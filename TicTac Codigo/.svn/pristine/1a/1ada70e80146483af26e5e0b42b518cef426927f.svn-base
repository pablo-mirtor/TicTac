package presentacion.comandos.negocio.compra;

import negocio.compra.TransferCompra;
import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioGestionCarritoCompraComando implements Comando {

	/**
	 * Metodo que se encarga de ejcutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		TransferCompra t = FactoriaServicioAplicacion.getInstance().createSACompra().iniciarCompra((int)datos);
		return new Contexto (ListaComandos.MOSTRAR_GESTION_CARRITO_COMPRA, t);
	}
		

}
