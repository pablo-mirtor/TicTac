package integracion.query.imp;

import integracion.query.FactoriaQuery;
import integracion.query.Query;
import presentacion.comandos.ListaComandos;

public class FactoriaQueryImp extends FactoriaQuery{

	@Override
	public Query getQuery(int event) 
	{
		Query query = null;
		
		switch(event)
		{
		case ListaComandos.NEGOCIO_NUMERO_CLIENTES_QUERY:
			query = new NumeroClientesQuery();
			break;
		case ListaComandos.NEGOCIO_CANTIDAD_RELOJES_QUERY:
			query = new CantidadRelojesQuery();
			break;
		}
		
		return query;
	}
}