package presentacion.comandos.negocio.cliente;

import negocio.cliente.TransferCliente;
import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

/**
 * Clase de la capa presentacion que implementa el comando
 */
public class NegocioMostrarClienteComando implements Comando {
	
	/**
	 * Metodo que se encarga de ejecutar el comando
	 */
	@Override
	public Contexto execute(Object datos) {
		TransferCliente id = FactoriaServicioAplicacion.getInstance().createSACliente().mostrarCliente((int) datos);
		return new Contexto (ListaComandos.MOSTRAR_MOSTRAR_CLIENTE, id);
	}

}
