package presentacion.comandos.negocio.competencia;

import negocio.factoriaSA.FactoriaServicioAplicacion;
import negocio.competencia.TransferCompetenciaTrabajador;
import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class NegocioMostrarNivelCompetenciaComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		TransferCompetenciaTrabajador t = FactoriaServicioAplicacion.getInstance().createSACompetencia().mostrarNivelCompetencia((TransferCompetenciaTrabajador)datos);
		return new Contexto(ListaComandos.MOSTRAR_MOSTRAR_NIVEL_COMPETENCIA, t);
	}

}
