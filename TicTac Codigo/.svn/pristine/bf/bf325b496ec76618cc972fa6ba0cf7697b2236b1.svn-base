package presentacion.comandos.negocio.competencia;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.competencia.TransferCompetenciaTrabajador;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioDesasignarCompetenciaTrabajadorComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		int id = FactoriaServicioAplicacion.getInstance().createSACompetencia().desasignarCompetencia((TransferCompetenciaTrabajador)datos);		
		return new Contexto(ListaComandos.MOSTRAR_DESASIGNAR_COMPETENCIA_TRABAJADOR, id);
	}
}