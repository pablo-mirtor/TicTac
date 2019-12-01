package integracion.query.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import presentacion.controlador.PareadoQuery;
//import presentacion.controlador.PareadoQuery;
import integracion.query.Query;
import integracion.transactionManager.TransactionManager;
import negocio.cliente.TransferCliente;

public class NumeroClientesQuery implements Query
{
	@Override
	public Object execute(Object datos) 
	{
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<TransferCliente> tList = new ArrayList<TransferCliente>();
		
		try 
		{
			String query="SELECT * FROM cliente id WHERE id IN (SELECT ClienteID FROM compra WHERE ID IN (SELECT compra FROM lineacompra WHERE reloj=" + ((PareadoQuery)datos).getPrimeroObjeto()+ ") GROUP BY ClienteID)";
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			st = cn.createStatement();               
		    rs = st.executeQuery(query); 

		    while (rs.next())
		    	tList.add(new TransferCliente(rs.getInt(1), rs.getString(2), rs.getString(3),  rs.getInt(4), rs.getBoolean(5)));
		}
		catch (SQLException e) {}
		finally
		{
		    try 
		    {
				rs.close();
			    st.close();
			} 
		    catch (SQLException e) {}
		}
		
		return tList;		
	}
}
