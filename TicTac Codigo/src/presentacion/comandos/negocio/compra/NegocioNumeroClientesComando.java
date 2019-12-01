package presentacion.comandos.negocio.compra;

import java.util.ArrayList;

import negocio.cliente.TransferCliente;
import negocio.factoriaSA.FactoriaServicioAplicacion;

import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;
import presentacion.controlador.PareadoQuery;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioNumeroClientesComando implements Comando {
	
	/**
	 * Metodo que se encarga de ejcutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		ArrayList<TransferCliente> lista = FactoriaServicioAplicacion.getInstance().createSACliente().numeroClientes((PareadoQuery)datos);
		return new Contexto (ListaComandos.MOSTRAR_NUMERO_CLIENTES_QUERY, lista);
	}
}
