package negocio.cliente.imp;


import java.util.ArrayList;
import presentacion.comandos.ListaComandos;
import presentacion.controlador.PareadoQuery;
import integracion.factoriaDao.FactoriaDAO;
import integracion.query.FactoriaQuery;
import integracion.transactionManager.TransactionManager;
import negocio.cliente.ServicioAplicacionCliente;
import negocio.cliente.TransferCliente;

/**
 * Clase de la capa Negocio que implementa el SA Cliente
 */
public class ServicioAplicacionClienteImp implements ServicioAplicacionCliente{
	
	/**
	 * Metodo que se encarga de dar de alta a un cliente
	 * @return el id del nuevo cliente (número mayor que 0) si se realiza con éxito, -1 si el dni ya existe, -2 si se ha reactivado a un cliente inactivo, 0 error de la base de datos
	 */
	public int altaCliente(TransferCliente t){
		int id;
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		TransferCliente tc = FactoriaDAO.getInstance().createDAOCliente().search(t); //se comprueba si el cliente ya existe en la base de datos
		
		if (tc == null){ //no existe
			id = FactoriaDAO.getInstance().createDAOCliente().add(t);
			if (id == 0)
				TransactionManager.getInstance().getTransaccion().rollback();
			else
				TransactionManager.getInstance().getTransaccion().commit();
		}
		else { //existe
			if(!tc.getActivo()){			
				t.setId(tc.getId());
				id = FactoriaDAO.getInstance().createDAOCliente().update(t); //se permite modificar datos del cliente a reactivar
				if (id == 0)
					TransactionManager.getInstance().getTransaccion().rollback();
				else{
					TransactionManager.getInstance().getTransaccion().commit();
					id = -2;
				}
				}
			else
				id = -1;	//Cliente ya activo	
		}
		TransactionManager.getInstance().eliminaTransaccion();
		return id;
	}
	
	/**
	 *Metodo que se encarga de dar de baja a un cliente 
	 */
	public int bajaCliente(int idEntrada){
		int id;
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		TransferCliente tc = FactoriaDAO.getInstance().createDAOCliente().searchId(idEntrada);
		
		if (tc != null) {
		    if (tc.getActivo()){
			    tc.setActivo(false);
			    id = FactoriaDAO.getInstance().createDAOCliente().update(tc);
				if (id == 0)
					TransactionManager.getInstance().getTransaccion().rollback();
				else
					TransactionManager.getInstance().getTransaccion().commit();
			}
			else
				id = -2;
		}
		else
			id = -1;
		
		TransactionManager.getInstance().eliminaTransaccion();
		return id;
	}
	
	/**
	 *Metodo que se encarga de modificar a un cliente existente
	 */
	public int modificarCliente(TransferCliente t){
		int id;
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		TransferCliente tExist = FactoriaDAO.getInstance().createDAOCliente().searchId(t.getId());
		
		if (tExist != null) {
			if(tExist.getActivo()){
				TransferCliente tExistDNI = FactoriaDAO.getInstance().createDAOCliente().search(t);
				
			    if (tExistDNI == null || tExistDNI.getId() == tExist.getId()) {
				    id = FactoriaDAO.getInstance().createDAOCliente().update(t);
					if (id == 0)
						TransactionManager.getInstance().getTransaccion().rollback();
					else
						TransactionManager.getInstance().getTransaccion().commit();
				}
				else
					id = -3;		
			}
			else
				id = -2;
		}
		else
			id = -1;

		TransactionManager.getInstance().eliminaTransaccion();
		return id;
	}
	
	/**
	 *Metodo que se encarga de mostrar un cliente especifico
	 *id: id cliente
	 */
	public TransferCliente mostrarCliente(int id){
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		TransferCliente t = FactoriaDAO.getInstance().createDAOCliente().searchId(id);
		TransactionManager.getInstance().getTransaccion().commit();
		TransactionManager.getInstance().eliminaTransaccion();
		return t;
	}

	/**
	 * Metodo que se encarga de listar todos los clientes 
	 */
	public ArrayList<TransferCliente> listarClientes(){
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		ArrayList<TransferCliente> lista = FactoriaDAO.getInstance().createDAOCliente().list();	
		TransactionManager.getInstance().getTransaccion().commit();
		TransactionManager.getInstance().eliminaTransaccion();
		return lista;
	}
	
	/**
	 * Metodo que se encarga de ejecutar la query numero de clientes
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<TransferCliente> numeroClientes(PareadoQuery pQuery){
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		ArrayList<TransferCliente> lista = (ArrayList<TransferCliente>) FactoriaQuery.getInstance().getQuery(ListaComandos.NEGOCIO_NUMERO_CLIENTES_QUERY).execute(pQuery);
		TransactionManager.getInstance().getTransaccion().commit();
		TransactionManager.getInstance().eliminaTransaccion();
		return lista;
	}
}
