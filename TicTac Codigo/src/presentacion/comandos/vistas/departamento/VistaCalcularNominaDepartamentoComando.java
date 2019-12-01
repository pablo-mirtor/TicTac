package presentacion.comandos.vistas.departamento;

import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class VistaCalcularNominaDepartamentoComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		return new Contexto(ListaComandos.VENTANA_CALCULAR_NOMINA_DEPARTAMENTO, datos);
	}
}