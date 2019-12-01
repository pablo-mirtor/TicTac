package negocio.departamento;

import java.util.ArrayList;

public interface ServicioAplicacionDepartamento {
	
	public int crearDepartamento(TransferDepartamento t);
	public int bajaDepartamento(int id);
	public int modificarDepartamento(TransferDepartamento t);
	public TransferDepartamento mostrarDepartamento(int id);
	public ArrayList<TransferDepartamento> listarDepartamentos();
	public double calcularNomina(int id);
	
}
