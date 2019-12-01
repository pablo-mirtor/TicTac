package presentacion.comandos.negocio.departamento;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.departamento.TransferDepartamento;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioModificarDepartamentoComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		int id = FactoriaServicioAplicacion.getInstance().createSADepartamento().modificarDepartamento((TransferDepartamento)datos);		
		return new Contexto(ListaComandos.MOSTRAR_MODIFICAR_DEPARTAMENTO, id);
	}

}
