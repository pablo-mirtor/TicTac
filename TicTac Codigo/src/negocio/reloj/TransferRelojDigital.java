package negocio.reloj;

/**
 * Clase de la capa Negocio que implementa Transfer de Reloj Digital
 */
public class TransferRelojDigital extends TransferReloj{
	
	protected String pantalla;
	
	/**
	 * Constructor con todos los parametros
	 * @param id: identificador reloj
	 * @param modelo: modelo del reloj
	 * @param marca: marca del reloj
	 * @param precio: precio del reloj
	 * @param pantalla: tipo de pantalla del reloj
	 * @param activo: representa si el reloj esta activo
	 */
	public TransferRelojDigital(int id, String modelo, String marca, double precio, String pantalla, boolean activo) {
		super(id, modelo, marca, precio, activo);
		this.pantalla = pantalla;
	}
	
	/**
	 * Constructor sin id 
	 * @param modelo: modelo del reloj
	 * @param marca: marca del reloj
	 * @param precio: precio del reloj
	 * @param pantalla: tipo de pantalla del reloj
	 * @param activo: representa si el reloj esta activo
	 */
	public TransferRelojDigital(String modelo, String marca, double precio, String pantalla, boolean activo) {
		super(modelo, marca, precio, activo);
		this.pantalla = pantalla;
	}
	
	/**
	 * Getters y Setters
	 */
	public String getPantalla() {
		return pantalla;
	}

	public void setPantalla(String pantalla) {
		this.pantalla = pantalla;
	}
	
	public String toString (){
		return "Id: " + id + " Modelo: " + modelo + " Marca: " + marca + " Precio: " + precio + " Tipo de pantalla: " + pantalla +  " Activo: " + activo;
	}
}
