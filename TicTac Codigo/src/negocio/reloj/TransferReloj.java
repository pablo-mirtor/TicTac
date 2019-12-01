package negocio.reloj;

/**
 * Clase de la capa Negocio que implementa el Transfer de Reloj
 */
public class TransferReloj {
	protected int id;
	protected String modelo;
	protected String marca;
	protected double precio;
	protected boolean activo;
	
	/**
	 * Constructor vacio
	 */
	public TransferReloj(){}
	
	/**
	 * Constructor sin id (se usa al crear un reloj)
	 * @param modelo: modelo del reloj
	 * @param marca: marca del reloj
	 * @param precio: precio del reloj
	 * @param activo: representa si el reloj esta activo
	 */
	public TransferReloj(String modelo, String marca, double precio, boolean activo){
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
		this.activo = activo;
	}
	
	/**
	 * Constructor con todos los parametros
	 * @param id: identificador reloj
	 * @param modelo: modelo del reloj
	 * @param marca: marca del reloj
	 * @param precio: precio del reloj
	 * @param activo: representa si el reloj esta activo
	 */
	public TransferReloj(int id, String modelo, String marca, double precio, boolean activo){
		this.id = id;
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
		this.activo = activo;
	}
	
	/**
	 * Getters y Setters
	 */
	public int getId() {
		return id;
	}

	public String getModelo() {
		return modelo;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public boolean getActivo() {
		return activo;
	}

	public void setId(int id) {
		this.id = id;
	}	
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}	

	public void setMarca(String marca) {
		this.marca = marca;
	}	

	public void setPrecio(double precio) {
		this.precio = precio;
	}	

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}

