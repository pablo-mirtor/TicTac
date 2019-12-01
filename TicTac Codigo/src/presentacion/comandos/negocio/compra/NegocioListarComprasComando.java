package presentacion.comandos.negocio.compra;

import java.util.ArrayList;

import negocio.compra.TransferCompra;
import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioListarComprasComando implements Comando {
	
	/**
	 * Metodo que se encarga de ejecutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		ArrayList<TransferCompra> lista = FactoriaServicioAplicacion.getInstance().createSACompra().listarCompras();
		return new Contexto (ListaComandos.MOSTRAR_LISTAR_COMPRAS , lista);
	}

}
