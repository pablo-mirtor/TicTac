package presentacion.comandos.vistas.compra;

import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class VistaPrincipalCompraComando implements Comando {
	
	/**
	 * Metodo que se encarga de ejcutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		return new Contexto(ListaComandos.VENTANA_PRINCIPAL_COMPRA, datos);
		}

}
