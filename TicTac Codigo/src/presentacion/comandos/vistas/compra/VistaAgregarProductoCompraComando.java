package presentacion.comandos.vistas.compra;

import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class VistaAgregarProductoCompraComando implements Comando {
	/**
	 * Metodo que se encarga de ejcutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		return new Contexto(ListaComandos.VENTANA_AGREGAR_PRODUCTO_COMPRA, datos);
	}

}
