package presentacion.comandos.negocio.departamento;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.departamento.TransferDepartamento;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioMostrarDepartamentoComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		TransferDepartamento t = FactoriaServicioAplicacion.getInstance().createSADepartamento().mostrarDepartamento((int) datos);		
		return new Contexto(ListaComandos.MOSTRAR_MOSTRAR_DEPARTAMENTO, t);
	}

}
