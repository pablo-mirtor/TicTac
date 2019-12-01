package integracion.transactionManager.imp;

import integracion.transactionManager.Transaction;
import integracion.transactionManager.TransactionFactory;
import integracion.transactionManager.mysql.TransactionMySQL;

public class TransactionFactoryImp extends TransactionFactory 
{
	@Override
	public Transaction crearTransaccion() 
	{
		return new TransactionMySQL();
	}
}