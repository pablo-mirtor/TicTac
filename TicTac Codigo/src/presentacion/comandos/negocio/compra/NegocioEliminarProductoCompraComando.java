package presentacion.comandos.negocio.compra;

import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioEliminarProductoCompraComando implements Comando {

	/**
	 * Metodo que se encarga de ejecutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		return new Contexto (ListaComandos.MOSTRAR_ELIMINAR_PRODUCTO_COMPRA, datos);
	}
	

}
