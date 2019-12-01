package negocio.reloj.imp;

import integracion.factoriaDao.FactoriaDAO;
import integracion.query.FactoriaQuery;
import integracion.transactionManager.TransactionManager;

import java.util.ArrayList;

import presentacion.comandos.ListaComandos;
import presentacion.controlador.PareadoQuery;
import negocio.cliente.TransferCliente;
import negocio.reloj.ServicioAplicacionReloj;
import negocio.reloj.TransferReloj;
import negocio.reloj.TransferRelojAnalogico;
import negocio.reloj.TransferRelojDigital;

/**
 * Clase de la capa Negocio que implementa el SA de reloj
 */
public class ServicioAplicacionRelojImp implements ServicioAplicacionReloj{
	
	/**
	 * Metodo que se encarga de dar de alta un reloj o reactivarlo
	 */
	@Override
	public int altaReloj(TransferReloj t) {
		int id = 0;
		
		//Creamos una nueva transacción y la iniciamos.
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		
		TransferReloj relojExistente = FactoriaDAO.getInstance().createDAOReloj().search(t);
		
		//Si no existe el reloj
		if(relojExistente == null){
			id = FactoriaDAO.getInstance().createDAOReloj().add(t);
			if(id == 0){
				TransactionManager.getInstance().getTransaccion().rollback();
			}
			else{
				TransactionManager.getInstance().getTransaccion().commit();
			}
		}
		else{
			if(!relojExistente.getActivo()){
				if((t instanceof TransferRelojDigital && relojExistente instanceof TransferRelojDigital) //Aseguramos que el reloj que se reactiva es del mismo tipo que estaba en la BD
				|| (t instanceof TransferRelojAnalogico && relojExistente instanceof TransferRelojAnalogico)){
					t.setId(relojExistente.getId());
					id = FactoriaDAO.getInstance().createDAOReloj().update(t);
					if(id == 0){
						TransactionManager.getInstance().getTransaccion().rollback();
					}
					else{
						TransactionManager.getInstance().getTransaccion().commit();
					}
				}
				else
					id = -3; // No se puede cambiar un reloj de analógico a digital
			}
			else{
				id = -1; //Reloj ya existe y esta activo
			}
		}
		
		//Finalmente cerramos la transación
		TransactionManager.getInstance().eliminaTransaccion();
		return id;
	}
	
	/**
	 * Metodo que se encarga de dar de baja un reloj
	 */
	@Override
	public int bajaReloj(int idAux) {
		int id;
		
		//Creamos una nueva transacción y la iniciamos.
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();

		TransferReloj tb = FactoriaDAO.getInstance().createDAOReloj().searchId(idAux);
		
		if (tb != null){
		    if (tb.getActivo() == true) {
			    tb.setActivo(false);
			    id = FactoriaDAO.getInstance().createDAOReloj().update(tb);
				if (id == 0){
					TransactionManager.getInstance().getTransaccion().rollback();
				}
				else{
					TransactionManager.getInstance().getTransaccion().commit();
				}
			}
			else{
				id = -2; //Reloj no activo
			}
		}
		else{
			id = -1; //Reloj no existe
		}
		
		//Cerramos la transacción
		TransactionManager.getInstance().eliminaTransaccion();
		return id;
	}
	
	/**
	 * Metodo que se encarga de modificar un reloj existente
	 */
	@Override
	public int modificarReloj(TransferReloj transferPropuesto) {
		/**
		 *Método para modificar los datos de un reloj por el ID dado en el transfer si coincide la categoría del 
		 *Transfer y de la base de datos para ajustarlo a los datos del transfer.
		 */
		int id;
		
		//Creamos e iniciamos la transacción
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		
		//Obtenemos el transfer del reloj por el id
		TransferReloj transferActual = FactoriaDAO.getInstance().createDAOReloj().searchId(transferPropuesto.getId());
		
		if (transferActual != null) {
			if(transferActual.getActivo()) {
		    	if((transferPropuesto instanceof TransferRelojDigital && transferActual instanceof TransferRelojDigital) || (transferPropuesto instanceof TransferRelojAnalogico && transferActual instanceof TransferRelojAnalogico)) {	
		    		id = FactoriaDAO.getInstance().createDAOReloj().update(transferPropuesto);
					if (id == 0){
						TransactionManager.getInstance().getTransaccion().rollback();
					}
					else {
						TransactionManager.getInstance().getTransaccion().commit();
					}
		    	}
		    	else {
		    		id = -4;
		    	}
			}
			else{
				id = -2; //Reloj no activo
			}
		}
		else{
			id = -1; //Reloj no existe
		}
		
		//Cerramos la transacción
		TransactionManager.getInstance().eliminaTransaccion();
		return id;
	}
	
	/**
	 * Metodo que se encarga de mostrar un reloj especifico
	 */
	@Override
	public TransferReloj mostrarReloj(int id) {
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		
		TransferReloj tReloj = FactoriaDAO.getInstance().createDAOReloj().searchId(id);
		TransactionManager.getInstance().getTransaccion().commit();
		
		TransactionManager.getInstance().eliminaTransaccion();
		return tReloj;
	}
	
	/**
	 * Metodo que se encarga de listar todos los relojes
	 */
	@Override
	public ArrayList<TransferReloj> listarRelojes() {
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		
		ArrayList<TransferReloj> listarRelojes = FactoriaDAO.getInstance().createDAOReloj().list();	
		TransactionManager.getInstance().getTransaccion().commit();
		
		TransactionManager.getInstance().eliminaTransaccion();
		return listarRelojes;
	}
	
	/**
	 * Metodo que se encarga de ejecutar la query numero de relojes
	 */
	@Override
	public int numeroRelojes(PareadoQuery pQuery) {
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		
		TransferCliente tExist = FactoriaDAO.getInstance().createDAOCliente().searchId((int)pQuery.getPrimeroObjeto());
		int id = 0;
		
		if (tExist != null) 
			id = (int) FactoriaQuery.getInstance().getQuery(ListaComandos.NEGOCIO_CANTIDAD_RELOJES_QUERY).execute(pQuery);
		else
			id = -1;
		
		TransactionManager.getInstance().getTransaccion().commit();
		TransactionManager.getInstance().eliminaTransaccion();
		return id;
	}

}
