package presentacion.comandos.vistas.trabajador;

import presentacion.comandos.ListaComandos;
import presentacion.comandos.Comando;
import presentacion.controlador.Contexto;

public class VistaListarTrabajadoresComando implements Comando {

	@Override
	public Contexto execute(Object datos) {
		return new Contexto(ListaComandos.VENTANA_LISTAR_TRABAJADORES, datos);
	}
}