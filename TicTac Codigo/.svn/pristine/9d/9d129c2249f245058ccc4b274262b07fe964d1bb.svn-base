package presentacion.comandos.negocio.departamento;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioCalcularNominaDepartamentoComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		double salario = FactoriaServicioAplicacion.getInstance().createSADepartamento().calcularNomina((int) datos);		
		return new Contexto(ListaComandos.MOSTRAR_CALCULAR_NOMINA_DEPARTAMENTO, salario);
	}

}
