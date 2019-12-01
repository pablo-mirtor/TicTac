package integracion.reloj;

import java.util.ArrayList;

import negocio.reloj.TransferReloj;

public interface DAOReloj {
	public int add(TransferReloj tv);
	public int update(TransferReloj tv);
	public TransferReloj search(TransferReloj tv);
	public TransferReloj searchId(int id);
	public ArrayList<TransferReloj> list();
}

