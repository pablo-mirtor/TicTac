package negocio.compra.imp;

import java.util.ArrayList;

import presentacion.controlador.Contexto;
import integracion.factoriaDao.FactoriaDAO;
import integracion.transactionManager.TransactionManager;
import negocio.cliente.TransferCliente;
import negocio.compra.ServicioAplicacionCompra;
import negocio.compra.TransferCompra;
import negocio.compra.TransferLineaDeCompra;
import negocio.reloj.TransferReloj;

/**
 * Clase de la capa negocio que implementa el SA Compra
 */
public class ServicioAplicacionCompraImp implements ServicioAplicacionCompra {

	/**
	 * Metodo que se encarga de iniciar la compra
	 */
	public TransferCompra iniciarCompra(int id){
		
		//Creamos una nueva transacción y la iniciamos.
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		
		//Montamos los Transfer
		TransferCompra tCompra = null;
		TransferCliente tCliente = FactoriaDAO.getInstance().createDAOCliente().searchId(id);
		
		//Si existe el cliente y esta activo
		if(tCliente != null && tCliente.getActivo())
			tCompra = new TransferCompra((int)tCliente.getId(), 0, true);
		
		//Finalmente cerramos la transación
		TransactionManager.getInstance().eliminaTransaccion();
		
		return tCompra;
	}
	
	/**
	 * Metodo que se encarga de agregar productos
	 */
	public TransferLineaDeCompra agregarProducto(Contexto producto){
		
		//Creamos una nueva transacción y la iniciamos.
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		
		//Montamos el Transfer
		TransferReloj tReloj = FactoriaDAO.getInstance().createDAOReloj().searchId(producto.getEvento());
		TransferLineaDeCompra t;
		//Si el juego no existe y no esta activo
		if(tReloj == null || !tReloj.getActivo()){
                    t = null;
                    TransactionManager.getInstance().getTransaccion().rollback();
        }
        else{
        	t= new TransferLineaDeCompra(tReloj.getId(), (int)producto.getDatos(),tReloj.getPrecio());
             TransactionManager.getInstance().getTransaccion().commit();
         }
		
		//Finalmente cerramos la transaccion
		TransactionManager.getInstance().eliminaTransaccion();
		
		return t;
                
      
	}
	
	/**
	 * Metodo que se encarga de realizar la devolucion de un producto en una 
	 * linea de compra
	 */
	public int devolverProducto(TransferLineaDeCompra tLineaCompra){
		int id;
		
		//Creamos la Transaccion
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		
		//Montamos el Transfer
		TransferLineaDeCompra lineaCompraAlmacenada = FactoriaDAO.getInstance().createDAOCompra().searchLineaCompra(tLineaCompra);
		
		//Si la Linea De Compra existe y esta activa
		if (lineaCompraAlmacenada != null && lineaCompraAlmacenada.getActivo()){
			
			//Montamos Transfer y los datos necesarios para las operaciones(la cantidad a devolver del articulo)
			TransferCompra tCompraId = FactoriaDAO.getInstance().createDAOCompra().searchId(tLineaCompra.getIdCompra());
			
            /*miramos cuantas unidades quedan*/
            int cantidadDevolucion = lineaCompraAlmacenada.getCantidad() - tLineaCompra.getCantidad();
			
			//Operaciones y Comprobaciones  
                        /*si no quedan todo a o*/
              
            if(cantidadDevolucion < 0){
            	id = -4; //no se pueden devolver más cantidad de la que hay
            }
            else{
            	if(cantidadDevolucion == 0){
            		tCompraId.setCosteTotal(tCompraId.getCosteTotal()- (tLineaCompra.getCantidad() * lineaCompraAlmacenada.getPrecio()) );
    				tLineaCompra.setCantidad(0);
    				tLineaCompra.setActivo(false);
    				id = -3;
    			}
            	else{
    				tCompraId.setCosteTotal(tCompraId.getCosteTotal()- (tLineaCompra.getCantidad() * lineaCompraAlmacenada.getPrecio()) );
    				tLineaCompra.setCantidad(cantidadDevolucion);
    				id = -2;
    			}
            	int auxResultado = FactoriaDAO.getInstance().createDAOCompra().devolucionProducto(tCompraId, tLineaCompra);
    			
    			if (auxResultado == 0){
    				TransactionManager.getInstance().getTransaccion().rollback();
    				id = 0;
    			}
    			else
    				TransactionManager.getInstance().getTransaccion().commit();
            }
		}
		else 
			id = -1; // 
		
		//Finalmente Cerramos la Transaccion
		TransactionManager.getInstance().eliminaTransaccion();
		return id;
	}
	
	/**
	 * Metodo que se encarga de realizar la compra
	 */
	@Override
	public int finalizarCompra(TransferCompra tCompra){
		
		//Creamos la Transaccion y los datos necesarios(lista de articulos a quitar y el iterador para recorrerla)
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		
		//Introducimos la compra 
		int resultado = FactoriaDAO.getInstance().createDAOCompra().add(tCompra);
		//hacemos commit
		if(resultado == 0)
              TransactionManager.getInstance().getTransaccion().rollback();       
        else{
            TransactionManager.getInstance().getTransaccion().commit();
        }
		//Finalmente cerramos la Transaccion
		TransactionManager.getInstance().eliminaTransaccion();
		return resultado;
	}

	/**
	 * Metodo que muestra una compra especifica
	 */
	@Override
	public TransferCompra mostrarCompra(int id) {
		
		//Creamos la Transaccion
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		
		//Hacemos Commit 
		TransferCompra t = FactoriaDAO.getInstance().createDAOCompra().searchId(id);
		TransactionManager.getInstance().getTransaccion().commit();
		
		//Finalmente cerramos la Transaccion
		TransactionManager.getInstance().eliminaTransaccion();
		return t;
	}

	/**
	 * Metodo que se encarga de listar las compras realizadas
	 */
	@Override
	public ArrayList<TransferCompra> listarCompras() {
		
		//Creamos la Transaccion
		TransactionManager.getInstance().nuevaTransaccion();
		TransactionManager.getInstance().getTransaccion().start();
		ArrayList<TransferCompra> lista = FactoriaDAO.getInstance().createDAOCompra().list();
		
		//Hacemos Commit
		TransactionManager.getInstance().getTransaccion().commit();
		
		//Finalmnete cerramos la Transaccion
		TransactionManager.getInstance().eliminaTransaccion();
		return lista;
	}
}

