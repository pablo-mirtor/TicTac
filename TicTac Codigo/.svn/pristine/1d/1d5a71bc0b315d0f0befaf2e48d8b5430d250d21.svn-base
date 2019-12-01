package integracion.reloj.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import integracion.reloj.DAOReloj;
import integracion.transactionManager.TransactionManager;
import negocio.reloj.TransferReloj;
import negocio.reloj.TransferRelojAnalogico;
import negocio.reloj.TransferRelojDigital;

public class DAORelojImp implements DAOReloj{
	@Override
	public int add(TransferReloj reloj) {
		/**
		 * Método de la capa integración que permite añadir un nuevo reloj, a traves de la conexión y haciendo un insert de SQL
		 */
		Statement statement = null;
		int resource = 0;
		
		try {
			statement = ((Connection) TransactionManager.getInstance().getTransaccion().getResource()).createStatement();
			String query="INSERT INTO reloj(modelo, marca, precio, activo) VALUES ('" + reloj.getModelo() + "', '" + reloj.getMarca() + "', " + reloj.getPrecio() + ", " + reloj.getActivo() + ");";
			resource = statement.executeUpdate(query);
			
		    if (reloj instanceof TransferRelojDigital){
		    	query="INSERT INTO relojDigital(ID, pantalla)VALUES(LAST_INSERT_ID(), '" + ((TransferRelojDigital) reloj).getPantalla() + "');";
		    	resource = statement.executeUpdate(query); 
		    }
		    else if(reloj instanceof TransferRelojAnalogico){
		    	query="INSERT INTO relojAnalogico(id, esfera) VALUES(LAST_INSERT_ID(), '" + ((TransferRelojAnalogico) reloj).getEsfera() + "');";
		    	resource = statement.executeUpdate(query); 
		    }
		    if(resource > 0) {
		    	ResultSet rsultima = statement.executeQuery("SELECT LAST_INSERT_ID()");
		    	rsultima.next();
		    	resource = rsultima.getInt(1);
		    }
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
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
	public int update(TransferReloj reloj) {
		/**
		 * Método de la capa integración que permite actualizar un reloj, a traves de la conexión y haciendo un update de SQL
		 */
		Connection cn = null;
		Statement statement = null;
		int resource = 0;
		String query = "UPDATE reloj SET modelo = '" + reloj.getModelo() + "', marca = '" + reloj.getMarca() + "', precio = '" + reloj.getPrecio() 
						+ "', activo = '" + (reloj.getActivo() ? 1 : 0) + "'  WHERE id = " + reloj.getId();
		
		try {
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			statement = cn.createStatement(); 
			resource = statement.executeUpdate(query); 

		    if(resource != 0){
			    if (reloj instanceof TransferRelojDigital)
			    	resource = statement.executeUpdate("UPDATE relojDigital SET pantalla = '" + ((TransferRelojDigital) reloj).getPantalla() + "' WHERE id = '" + reloj.getId()+ "';"); 
			    else if(reloj instanceof TransferRelojAnalogico)
			    	resource = statement.executeUpdate("UPDATE relojAnalogico SET esfera = '" + ((TransferRelojAnalogico) reloj).getEsfera() + "' WHERE id = " + reloj.getId()); 		    
			    
		    	resource = reloj.getId();
		    }
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
		    try {
				statement.close();
			} 
		    catch (SQLException e) {}
		}
		
		return resource;
	}
	
	@Override
	public TransferReloj search(TransferReloj reloj) {
		/**
		 * Método de la capa integración que permite buscar un reloj, a traves de la conexión y haciendo un select de SQL
		 */
		Statement statement = null;
		ResultSet resource = null;
		TransferReloj enviar = null;
		
		try {
			statement = ((Connection) TransactionManager.getInstance().getTransaccion().getResource()).createStatement();               
		    resource = statement.executeQuery("SELECT * FROM reloj WHERE modelo like '" + reloj.getModelo() + "'"); 
		    
		    if (resource.next()){
		    	int id = resource.getInt(1);
		    	resource = statement.executeQuery("SELECT * FROM reloj INNER JOIN relojdigital USING(id) WHERE id = " + id + " FOR UPDATE"); 
				    
				 if (resource.next())
				   	enviar = new TransferRelojDigital(resource.getInt(1), resource.getString(2), resource.getString(3), resource.getDouble(4), resource.getString(6), resource.getBoolean(5));	
				  else {
				    resource = statement.executeQuery("SELECT * FROM reloj INNER JOIN relojanalogico USING(id) WHERE id = " + id + " FOR UPDATE"); 
				    if(resource.next())
				    	enviar = new TransferRelojAnalogico(resource.getInt(1), resource.getString(2), resource.getString(3), resource.getDouble(4), resource.getString(6), resource.getBoolean(5));	
				   }
		    }
		    resource.close();
		    statement.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return enviar;
	}
	
	@Override
	public TransferReloj searchId(int id) {
		/**
		 * Método de la capa integración que permite buscar un reloj por id, a traves de la conexión y haciendo un select de SQL
		 */
		Statement statement = null;
		ResultSet resource = null;
		TransferReloj reloj = null;
		
		try {
			statement = ((Connection) TransactionManager.getInstance().getTransaccion().getResource()).createStatement();               
		    resource = statement.executeQuery("SELECT * FROM reloj INNER JOIN relojdigital USING(id) WHERE id = " + id + " FOR UPDATE"); 
		    
		    if (resource.next())
		    	reloj = new TransferRelojDigital(resource.getInt(1), resource.getString(2), resource.getString(3), resource.getDouble(4), resource.getString(6), resource.getBoolean(5));	
		    else {
		    	resource = statement.executeQuery("SELECT * FROM reloj INNER JOIN relojanalogico USING(id) WHERE id = " + id + " FOR UPDATE"); 
		    	
		    	if(resource.next())
		    		reloj = new TransferRelojAnalogico(resource.getInt(1), resource.getString(2), resource.getString(3), resource.getDouble(4), resource.getString(6), resource.getBoolean(5));	
		    }
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return reloj;
	}
	
	@Override
	public ArrayList<TransferReloj> list() {
		/**
		 * Método de la capa integración que permite listar un reloj, a traves de la conexión y haciendo un select de SQL
		 */
		Statement statement = null;
		ResultSet resource = null;
		ArrayList<TransferReloj> tList = new ArrayList<TransferReloj>();
		
		try {
			statement = ((Connection) TransactionManager.getInstance().getTransaccion().getResource()).createStatement();               
		    resource = statement.executeQuery("SELECT * FROM reloj INNER JOIN relojDigital USING(id) FOR UPDATE");
		    
		    while (resource.next())
		    	tList.add(new TransferRelojDigital(resource.getInt(1), resource.getString(2), resource.getString(3), resource.getDouble(4), resource.getString(6), resource.getBoolean(5)));
		    
		    resource = statement.executeQuery("SELECT * FROM reloj INNER JOIN relojAnalogico USING(id) FOR UPDATE"); 
		    
		    while (resource.next())
		    	tList.add(new TransferRelojAnalogico(resource.getInt(1), resource.getString(2), resource.getString(3), resource.getDouble(4), resource.getString(6), resource.getBoolean(5)));
		}
		catch (SQLException e) {}
		finally {
		    try {
				resource.close();
			    statement.close();
			} 
		    catch (SQLException e) {}
		}		
		return tList;
	}
}
