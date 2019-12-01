package presentacion.vistas.vistaTrabajador;

import presentacion.controlador.Contexto;

public abstract class VistaTrabajador {
	private static VistaTrabajador instance;
	
	public static synchronized VistaTrabajador getInstance() 	{
		if (instance == null)
			instance = new VistaTrabajadorImp();
		return instance;
	}

	public abstract void update(Contexto contexto);
}