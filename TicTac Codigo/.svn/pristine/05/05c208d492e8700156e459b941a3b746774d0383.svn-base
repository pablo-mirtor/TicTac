package integracion.factoriaDao;

import integracion.cliente.DAOCliente;
import integracion.compra.DAOCompra;
import integracion.factoriaDao.imp.FactoriaDAOImp;
import integracion.reloj.DAOReloj;

public abstract class FactoriaDAO {
	
	private static FactoriaDAO factoriaDao;
	
	public static FactoriaDAO getInstance() {
		if (factoriaDao == null){
			factoriaDao = new FactoriaDAOImp();
		}
		return factoriaDao;
	}
	
	public abstract DAOReloj createDAOReloj();
	public abstract DAOCliente createDAOCliente();
	public abstract DAOCompra createDAOCompra();

}
