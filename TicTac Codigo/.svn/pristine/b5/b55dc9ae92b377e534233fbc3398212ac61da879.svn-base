package integracion.compra.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import negocio.compra.TransferCompra;
import negocio.compra.TransferLineaDeCompra;
import integracion.compra.DAOCompra;
import integracion.transactionManager.TransactionManager;

/**
 * implementación del DAO compra
 */
public class DAOCompraImp implements DAOCompra{

	@Override
	public int add(TransferCompra tCompra) {
		int resource = 0;
		Connection cn = null;
		Statement statement = null;
		
		try {
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			statement = cn.createStatement();
			String query = "INSERT INTO compra (ClienteID, CosteTotal, Fecha, Activo) VALUES (" + tCompra.getIdCliente() +", "+ tCompra.getCosteTotal() + ", '" + tCompra.getFecha() + "', 1)";
			resource = statement.executeUpdate(query);
		    if(resource != 0){
		    	ResultSet rsUltima = statement.executeQuery("SELECT LAST_INSERT_ID()");
		    	rsUltima.next();
		    	resource = rsUltima.getInt(1);
		    	
				Iterator<TransferLineaDeCompra> it = tCompra.getLineaCompra().iterator();
		    	
				while (it.hasNext()) {
					TransferLineaDeCompra t = it.next();                                              
					statement.executeUpdate("INSERT INTO lineacompra (Compra, Reloj, Cantidad, precio, Activo) VALUES (" + resource + ", " + t.getIdProducto() + ", " + t.getCantidad() + ", " + t.getPrecio() + ", 1)");
				}
		    }
		} 
		catch (SQLException e) {
                e.printStackTrace();}
		finally{
		    try {
				statement.close();
			} 
		    catch (SQLException e) {
                        e.printStackTrace();
                    }
		}
		
		return resource;
	}

	@Override
	public TransferCompra searchId(int id) {
		TransferCompra t = null;
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			st = cn.createStatement();               
		    rs = st.executeQuery("SELECT ID,ClienteID, CosteTotal, fecha, activo FROM compra WHERE id = " + id + " FOR UPDATE"); 
		    
		    if (rs.next()){
		    	double total = rs.getDouble(3);
		    	t = new TransferCompra(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDate(4), rs.getBoolean(5));
		    	rs = st.executeQuery("SELECT reloj, cantidad, precio, activo FROM lineacompra WHERE compra = " + id + " FOR UPDATE"); 
		    
		    	while(rs.next()){
		    		TransferLineaDeCompra lc = new TransferLineaDeCompra(rs.getInt(1),rs.getInt(2),rs.getDouble(3));
		    		t.addProd(lc);	
		    	}
		    	t.setCosteTotal(total);
		    }
	
             rs.close();
             st.close();
		    }
		catch (SQLException e) {}
		
		return t;
	}

	@Override
	public TransferLineaDeCompra searchLineaCompra(TransferLineaDeCompra tLineaCompra) {
		TransferLineaDeCompra lineaCompra = null;
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			st = cn.createStatement();   
			
			rs = st.executeQuery("SELECT cantidad, activo, precio FROM lineacompra WHERE compra = " + tLineaCompra.getIdCompra() + " && reloj = " + tLineaCompra.getIdProducto() + " FOR UPDATE"); 
			    
		    if (rs.next())
		    	lineaCompra = new TransferLineaDeCompra(tLineaCompra.getIdCompra(), tLineaCompra.getIdProducto(), rs.getInt(1), rs.getBoolean(2), rs.getDouble(3));

			rs.close();
			st.close();
		} 
		catch (SQLException e) {}
		
		return lineaCompra;
	}

	@Override
	public int devolucionProducto(TransferCompra tCompra, TransferLineaDeCompra tLineaCompra){
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		int rsDevolucion = 0;
		
		try 
		{
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			st = cn.createStatement(); 
			
			rsDevolucion = st.executeUpdate("UPDATE lineacompra SET cantidad = '" + tLineaCompra.getCantidad() + "', Activo = " + tLineaCompra.getActivo() + " WHERE Compra = '" + tLineaCompra.getIdCompra() + "' && Reloj = '" + tLineaCompra.getIdProducto() + "'"); 
			
			if(rsDevolucion != 0)
			{
				rs = st.executeQuery("SELECT count(*) FROM lineacompra WHERE Compra = " + tLineaCompra.getIdCompra() + " && Activo = true FOR UPDATE"); 
				
				if(rs.next())
					if(rs.getInt(1) == 0)
						tCompra.setActivo(false);
				
								
				
				rsDevolucion = st.executeUpdate("UPDATE compra SET CosteTotal = " + tCompra.getCosteTotal()  + ", Activo = " + tCompra.getActivo() + " WHERE ID = '" + tCompra.getId() + "'"); 
			}
		}
		catch (SQLException e) {
                    e.printStackTrace();
                }
		finally
		{
		    try 
		    {
				st.close();
			} 
		    catch (SQLException e) {}
		}
		
		return rsDevolucion;
	}

	@Override
	public ArrayList<TransferCompra> list() {
		ArrayList<TransferCompra> tList = new ArrayList<TransferCompra>();
		TransferCompra t = null;
		Connection cn = null;
		Statement stCompra = null;
		Statement stLinea = null;
		ResultSet rsCompra = null;
		ResultSet rsLinea = null;
		
		try {
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			stCompra = cn.createStatement();     
			stLinea = cn.createStatement(); 
			rsCompra = stCompra.executeQuery("SELECT * FROM compra");
		    
		    while (rsCompra.next()){
		    	t = new TransferCompra(rsCompra.getInt(1), rsCompra.getInt(2), 0, rsCompra.getDate(4), rsCompra.getBoolean(5));
		    	rsLinea = stLinea.executeQuery("SELECT reloj, cantidad, precio FROM lineacompra WHERE compra = " + t.getId()); 	    	
		    	while(rsLinea.next()){
		    		TransferLineaDeCompra lc = new TransferLineaDeCompra(rsLinea.getInt(1),rsLinea.getInt(2),rsLinea.getDouble(3));
		    		t.addProd(lc);	
		    	}
		    	tList.add(t);
		    }
		}
		catch (SQLException e) {}
		finally{
		    try {
		    	rsCompra.close();
		    	if(rsLinea != null)
		    		rsLinea.close();
		    	stCompra.close();
		    	stLinea.close();
			} 
		    catch (SQLException e) {}
		}
		
		return tList;
	}

}
