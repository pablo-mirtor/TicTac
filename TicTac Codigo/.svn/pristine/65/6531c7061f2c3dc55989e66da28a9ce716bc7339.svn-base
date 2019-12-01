package presentacion.comandos.negocio.departamento;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioBajaDepartamentoComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		int id = FactoriaServicioAplicacion.getInstance().createSADepartamento().bajaDepartamento((int)datos);
		return new Contexto(ListaComandos.MOSTRAR_BAJA_DEPARTAMENTO, id);
	}

}