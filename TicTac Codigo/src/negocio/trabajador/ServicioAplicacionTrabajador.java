package negocio.trabajador;

import java.util.ArrayList;

public interface ServicioAplicacionTrabajador {
	public int altaTrabajador(TransferTrabajador t);
	public int bajaTrabajador(int id);
	public TransferTrabajador mostrarTrabajador(int id);
	public ArrayList<TransferTrabajador> listarTrabajadores();
	public int modificarTrabajador(TransferTrabajador t);
}