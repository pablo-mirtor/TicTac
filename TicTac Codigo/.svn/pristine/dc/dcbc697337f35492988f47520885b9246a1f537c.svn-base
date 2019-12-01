package presentacion.comandos.negocio.departamento;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.departamento.TransferDepartamento;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioAltaDepartamentoComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		int id = FactoriaServicioAplicacion.getInstance().createSADepartamento().crearDepartamento((TransferDepartamento) datos);
		return new Contexto(ListaComandos.MOSTRAR_ALTA_DEPARTAMENTO, id);
	}

}