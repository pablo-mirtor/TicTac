package negocio.trabajador;


public class TransferTrabajadorParcial extends TransferTrabajador {

	private int horasSemanales;
	
	public TransferTrabajadorParcial(int id, String nombre, String dni, double sueldo, int idDepartamento,boolean activo, int horasSemanales) {
		super(id, nombre, dni, sueldo, idDepartamento, activo);
		this.horasSemanales = horasSemanales;
	}
	public TransferTrabajadorParcial(String nombre, String dni, double sueldo, int idDep ,boolean activo, int horasSemanales) {
		super(nombre, dni, sueldo, idDep, activo);
		this.horasSemanales = horasSemanales;
	}

	public int getHorasSemanales(){
		return this.horasSemanales;
	}
	
	public void setHorasSemanales(int h){
		this.horasSemanales = h;
	}
	@Override
	public double calcularSueldo() {
		return (horasSemanales * 5) + salario;
	}
}
