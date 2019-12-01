package presentacion.comandos.negocio.trabajador;

import negocio.trabajador.TransferTrabajador;
import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioAltaTrabajadorComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		int id = FactoriaServicioAplicacion.getInstance().createSATrabajador().altaTrabajador((TransferTrabajador) datos);		
		return new Contexto(ListaComandos.MOSTRAR_ALTA_TRABAJADOR, id);
	}

}
