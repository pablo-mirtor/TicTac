package presentacion.vistas.vistaReloj;

import presentacion.controlador.Contexto;

/**
 * Clase abstracta de la capa presentacion que define los metodos de la vista del reloj
 */
public abstract class VistaReloj
{
	private static VistaReloj instance;
	
	/**
	 * Devuelve la instancia, en este caso su implementacion
	 * @return instancia
	 */
	public static VistaReloj getInstance() 
	{
		if(instance == null)
			instance = new VistaRelojImp();
		return instance;
	}

	public abstract void update(Contexto contexto);
}
