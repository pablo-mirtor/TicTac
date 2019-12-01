package integracion.cliente.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

import integracion.cliente.DAOCliente;
import integracion.transactionManager.TransactionManager;
import negocio.cliente.TransferCliente;

public class DAOClienteImp implements DAOCliente{

	/**
	 *M�todo para a�adir un cliente dado por un transfer a la base de datos
	 *@param t transfer del cliente a a�adir
	 *@return 0 si hay error
	 */
	@Override
	public int add(TransferCliente t) {
		int result=0;
		Connection cn;
		Statement st=null;
		String Query="INSERT INTO cliente (Nombre, Tarjeta, Activo, DNI) VALUES ('"+
				t.getNombre()+"', '"+t.getTarjetaDeCredito()+"', '"+(t.getActivo()?1:0)+"', '"+t.getDNI()+"')";
		try{
			cn=(Connection)TransactionManager.getInstance().getTransaccion().getResource();
			st=cn.createStatement();
			result=st.executeUpdate(Query);
			if(result != 0)
		    {
		    	ResultSet rsultima = st.executeQuery("SELECT LAST_INSERT_ID()");
		    	rsultima.next();
		    	result = rsultima.getInt(1);
		    }
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{

		    try 
		    {
				st.close();
			} 
		    catch (SQLException e) {}
		}
		
		return result;
	}

	@Override
	public int update(TransferCliente t) {
		/**
		 *Edita los campos de un cliente seg�n un ID
		 */
		
		Connection cn = null;
		Statement st = null;
		int result = 0;
		String query="UPDATE cliente SET nombre = '" + t.getNombre() + "', dni = '"+ t.getDNI() +"', tarjeta = '" +t.getTarjetaDeCredito() 
				+ "', activo = '" + (t.getActivo() ? 1 : 0) + "'  WHERE id = " + t.getId();
		
		try 
		{
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			st = cn.createStatement(); 
			result = st.executeUpdate(query); 

		    if(result != 0)
		    	result = t.getId();
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
		
		return result;
	}
	/**
	 * Busca por DNI.
	 * 
	 * */
	@Override
	public TransferCliente search(TransferCliente t) {

		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		String query="SELECT * FROM cliente WHERE dni like '" + t.getDNI() + "' FOR UPDATE";
		
		TransferCliente enviar = null;
		try 
		{
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			st = cn.createStatement();               
		    rs = st.executeQuery(query); 
		    
		    if (rs.next())
		    	enviar = new TransferCliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getBoolean(5));
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
		    try 
		    {
				rs.close();
			    st.close();
			} 
		    catch (SQLException e) {}
		}
		
		return enviar;
	}

	@Override
	public TransferCliente searchId(int id) {
		TransferCliente cliente = null;
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try 
		{
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			st = cn.createStatement();               
		    rs = st.executeQuery("SELECT * FROM cliente WHERE id = " + id + " FOR UPDATE"); 
		    
		    if (rs.next())
		    	cliente = new TransferCliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getBoolean(5));
		}
		catch (SQLException e) {e.printStackTrace();}
		finally
		{
		    try 
		    {
				rs.close();
			    st.close();
			} 
		    catch (SQLException e) {}
		}
		
		return cliente;
	}

	@Override
	public ArrayList<TransferCliente> list() {/**
		 * M�todo de la capa integraci�n que permite listar los clientes, a traves de la conexi�n y haciendo un select de SQL
		 */
		Statement statement = null;
		ResultSet resource = null;
		ArrayList<TransferCliente> tList = new ArrayList<TransferCliente>();
		
		try {
			statement = ((Connection) TransactionManager.getInstance().getTransaccion().getResource()).createStatement();               
		    resource = statement.executeQuery("SELECT * FROM cliente");
		    
		    while (resource.next())
		    	tList.add(new TransferCliente(resource.getInt(1), resource.getString(2), resource.getString(3), resource.getInt(4), resource.getBoolean(5)));
		    
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
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
