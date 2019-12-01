package integracion.transactionManager.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import integracion.transactionManager.Transaction;


public class TransactionMySQL extends Transaction {
	private Connection connection;

	public TransactionMySQL() {
		
		try {			
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictac","root","");
		} 
		catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Error al conectar con la base de datos");
		}
	}
	
	@Override
	public void start() {
		try {
			connection.setAutoCommit(false);
		} 
		catch (SQLException e) {}
	}

	@Override
	public void commit() {
		try {
			connection.commit();
			connection.close();
		} 
		catch (SQLException e) {}
	}

	@Override
	public void rollback() {
		try {
			connection.rollback();
			connection.close();
		} 
		catch (SQLException e) {}
	}

	@Override
	public Object getResource() {
		return connection;
	}
}
