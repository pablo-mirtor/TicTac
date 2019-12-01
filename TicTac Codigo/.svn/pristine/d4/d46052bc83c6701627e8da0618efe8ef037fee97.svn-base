package presentacion.comandos.negocio.competencia;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.competencia.TransferCompetenciaTrabajador;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioAsignarNivelCompetenciaComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		int id = FactoriaServicioAplicacion.getInstance().createSACompetencia().asignarNivel((TransferCompetenciaTrabajador)datos);		
		return new Contexto(ListaComandos.MOSTRAR_ASIGNAR_NIVEL_COMPETENCIA, id);
	}

}
