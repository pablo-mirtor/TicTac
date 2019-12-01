package presentacion.comandos.negocio.trabajador;

import java.util.ArrayList;

import negocio.trabajador.TransferTrabajador;
import negocio.factoriaSA.FactoriaServicioAplicacion;

import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioListarTrabajadoresComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		ArrayList<TransferTrabajador> lista = FactoriaServicioAplicacion.getInstance().createSATrabajador().listarTrabajadores();		
		return new Contexto(ListaComandos.MOSTRAR_LISTAR_TRABAJADORES, lista);
	}

}
