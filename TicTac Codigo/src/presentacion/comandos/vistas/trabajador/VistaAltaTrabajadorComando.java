package presentacion.comandos.vistas.trabajador;

import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class VistaAltaTrabajadorComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		return new Contexto(ListaComandos.VENTANA_ALTA_TRABAJADOR, datos);
	}
}