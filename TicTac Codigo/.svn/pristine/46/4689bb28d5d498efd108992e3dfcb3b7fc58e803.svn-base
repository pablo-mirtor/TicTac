package presentacion.comandos.negocio.cliente;

import java.util.ArrayList;

import negocio.cliente.TransferCliente;
import negocio.factoriaSA.FactoriaServicioAplicacion;

import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioListarClientesComando implements Comando {
	
	/**
	 * Metodo que se encarga de ejcutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		ArrayList<TransferCliente> lista = FactoriaServicioAplicacion.getInstance().createSACliente().listarClientes();
		return new Contexto (ListaComandos.MOSTRAR_LISTAR_CLIENTES, lista);
	}

}

