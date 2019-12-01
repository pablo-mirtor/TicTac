package presentacion.vistas.vistaCompetencia;

import presentacion.controlador.Contexto;

public abstract class VistaCompetencia {
	private static VistaCompetencia instance;
	
	public static synchronized VistaCompetencia getInstance() {
		if (instance == null)
			instance = new VistaCompetenciaImp();
		return instance;
	}

	public abstract void update(Contexto contexto);
}