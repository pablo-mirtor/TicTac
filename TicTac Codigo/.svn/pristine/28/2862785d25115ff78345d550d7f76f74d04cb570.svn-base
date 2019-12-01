package presentacion.comandos.negocio.trabajador;

import negocio.trabajador.TransferTrabajador;
import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioMostrarTrabajadorComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		TransferTrabajador t = FactoriaServicioAplicacion.getInstance().createSATrabajador().mostrarTrabajador((int) datos);		
		return new Contexto(ListaComandos.MOSTRAR_MOSTRAR_TRABAJADOR, t);
	}
}
