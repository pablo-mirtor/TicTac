package integracion.query.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import integracion.query.Query;
import integracion.transactionManager.TransactionManager;
import presentacion.controlador.PareadoQuery;

public class CantidadRelojesQuery implements Query{

	@Override
	public Object execute(Object datos) {
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		int cantidad = 0;
		
		try 
		{
			String query="SELECT SUM(cantidad) FROM lineacompra WHERE reloj = '" + ((PareadoQuery)datos).getSegundoObjeto() + "' && Compra IN (SELECT ID FROM compra WHERE ClienteID LIKE '" + ((PareadoQuery)datos).getPrimeroObjeto() + "')";
			cn = (Connection) TransactionManager.getInstance().getTransaccion().getResource();
			st = cn.createStatement();               
		    rs = st.executeQuery(query); 
		    if (rs.next())
		    	cantidad = rs.getInt(1);
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
		
		return cantidad;		
	}

}
