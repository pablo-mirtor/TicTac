package negocio.trabajador;


public class TransferTrabajadorCompleto extends TransferTrabajador {

	private int productividad;
	
	public TransferTrabajadorCompleto(String nombre, String dni, double sueldo, int idDepartamento,boolean activo, int productividad) {
		super(nombre, dni, sueldo, idDepartamento,activo);
		this.productividad = productividad;
	}
	
	public TransferTrabajadorCompleto(int id, String nombre, String dni, double sueldo,int idDepartamento,boolean activo, int productividad) {
		super(id, nombre, dni, sueldo, idDepartamento,activo);
		this.productividad = productividad;
	}

	public int getProductividad(){
		return this.productividad;
	}
	
	public void setProductividad(int p){
		this.productividad = p;
	}

	@Override
	public double calcularSueldo() {
		return salario * productividad;
	}
}
