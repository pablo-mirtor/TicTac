package presentacion.comandos.negocio.competencia;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.competencia.TransferCompetencia;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioMostrarCompetenciaComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		TransferCompetencia t = FactoriaServicioAplicacion.getInstance().createSACompetencia().mostrarCompetencia((int) datos);
		return new Contexto(ListaComandos.MOSTRAR_MOSTRAR_COMPETENCIA, t);
	}
}
