package negocio.trabajador;

public abstract class TransferTrabajador {
	protected int id;
	protected String nombre;
	protected String dni;
	protected double salario;
	protected int idDepartamento;
	protected boolean activo;

	public TransferTrabajador(int id, String nombre, String dni, double sueldo, int idDepartamento, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.salario = sueldo;
		this.activo = activo;
		this.idDepartamento = idDepartamento;
	}

	public TransferTrabajador(String nombre, String dni, double sueldo, int idDepartamento, boolean activo) {
		this.nombre = nombre;
		this.dni = dni;
		this.salario = sueldo;
		this.activo = activo;
		this.idDepartamento =  idDepartamento;
	}

	public int getId() {
		return this.id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDNI() {
		return dni;
	}

	
	public double getSalario() {
		return salario;
	}	
	
	public int getIdDepartamento() {
		return this.idDepartamento;
	}
	
	public boolean getActivo() {
		return activo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setIdDepartamento(int idDep){
		this.idDepartamento = idDep;
	}

	public void setSalario(double sueldo) {
		this.salario = sueldo;
	}
	
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public abstract double calcularSueldo();
}