package integracion.factoriaDao.imp;

import integracion.cliente.DAOCliente;
import integracion.cliente.imp.DAOClienteImp;
import integracion.compra.DAOCompra;
import integracion.compra.imp.DAOCompraImp;
import integracion.factoriaDao.FactoriaDAO;
import integracion.reloj.DAOReloj;
import integracion.reloj.imp.DAORelojImp;

/**
 * Clase de la capa integracion que implementa a la FactoriaDAO
 */
public class FactoriaDAOImp extends FactoriaDAO{

	@Override
	public DAOReloj createDAOReloj() {
		return new DAORelojImp();
	}

	@Override
	public DAOCliente createDAOCliente() {
		return new DAOClienteImp();
	}

	@Override
	public DAOCompra createDAOCompra() {
		return new DAOCompraImp();
	}

}
