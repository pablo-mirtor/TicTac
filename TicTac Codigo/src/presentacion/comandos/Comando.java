package presentacion.comandos;

import presentacion.controlador.Contexto;

/**
 * Interfaz que permite extender las funcionalidad execute de los comandos
 */
public interface Comando {
	public abstract Contexto execute(Object datos);
}
