package presentacion.comandos.negocio.competencia;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.competencia.TransferCompetencia;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioModificarCompetenciaComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		int id = FactoriaServicioAplicacion.getInstance().createSACompetencia().modificarCompetencia((TransferCompetencia)datos);		
		return new Contexto(ListaComandos.MOSTRAR_MODIFICAR_COMPETENCIA, id);
	}

}