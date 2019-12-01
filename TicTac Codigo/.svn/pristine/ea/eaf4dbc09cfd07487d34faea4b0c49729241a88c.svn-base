package presentacion.comandos.negocio.trabajador;

import negocio.trabajador.TransferTrabajador;
import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioModificarTrabajadorComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		int id = FactoriaServicioAplicacion.getInstance().createSATrabajador().modificarTrabajador((TransferTrabajador)datos);		
		return new Contexto(ListaComandos.MOSTRAR_MODIFICAR_TRABAJADOR, id);
	}
}
