package integracion.transactionManager.imp;

import java.util.concurrent.ConcurrentHashMap;

import integracion.transactionManager.Transaction;
import integracion.transactionManager.TransactionFactory;
import integracion.transactionManager.TransactionManager;

public class TransactionManagerImp extends TransactionManager 
{
	private ConcurrentHashMap<Thread, Transaction> concurrentHashMap;
	
	public TransactionManagerImp () 
	{
		this.concurrentHashMap = new ConcurrentHashMap<Thread, Transaction>();
	}
	
	public boolean nuevaTransaccion() 
	{
		if (!concurrentHashMap.containsKey(Thread.currentThread())) 
		{
			this.concurrentHashMap.put(Thread.currentThread(), TransactionFactory.getInstance().crearTransaccion());
			return true;
		}
		return false;
	}
	
	public Transaction getTransaccion() 
	{
		return this.concurrentHashMap.get(Thread.currentThread());
	}
	
	public boolean eliminaTransaccion() 
	{
		if (concurrentHashMap.containsKey(Thread.currentThread())) 
		{
			this.concurrentHashMap.remove(Thread.currentThread());
			return true;
		}
		return false;
	}
}