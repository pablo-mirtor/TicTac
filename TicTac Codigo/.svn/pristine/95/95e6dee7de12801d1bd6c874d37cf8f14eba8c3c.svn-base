package presentacion.comandos.negocio.cliente;

import negocio.cliente.TransferCliente;
import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioModificarClienteComando implements Comando {
	
	/**
	 * Metodo que se encarga de ejcutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		int id = FactoriaServicioAplicacion.getInstance().createSACliente().modificarCliente((TransferCliente) datos);
		return new Contexto (ListaComandos.MOSTRAR_MODIFICAR_CLIENTE, id);
	}

}

