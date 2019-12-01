package presentacion.comandos.vistas.departamento;

import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class VistaMostrarDepartamentoComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		return new Contexto(ListaComandos.VENTANA_MOSTRAR_DEPARTAMENTO, datos);
	}
}