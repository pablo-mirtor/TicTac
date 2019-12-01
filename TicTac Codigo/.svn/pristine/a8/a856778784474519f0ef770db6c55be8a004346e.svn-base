package presentacion.comandos.negocio.trabajador;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioBajaTrabajadorComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		int id = FactoriaServicioAplicacion.getInstance().createSATrabajador().bajaTrabajador((int) datos);		
		return new Contexto(ListaComandos.MOSTRAR_BAJA_TRABAJADOR, id);
	}

}