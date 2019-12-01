package negocio.reloj;

/**
 * Clase de la capa Negocio que implementa Transfer de Reloj Analogico 
 */
public class TransferRelojAnalogico extends TransferReloj{
	
	protected String esfera;
	
	/**
	 * Constructor con todos los parametros
	 * @param id: identificador reloj
	 * @param modelo: modelo del reloj
	 * @param marca: marca del reloj
	 * @param precio: precio del reloj
	 * @param esfera: tipo de esfera del reloj
	 * @param activo: representa si el reloj esta activo
	 */
	public TransferRelojAnalogico(int id, String modelo, String marca, double precio, String esfera, boolean activo) {
		super(id, modelo, marca, precio, activo);
		this.esfera = esfera;
	}
	
	/**
	 * Constructor sin id 
	 * @param modelo: modelo del reloj
	 * @param marca: marca del reloj
	 * @param precio: precio del reloj
	 * @param esfera: tipo de esfera del reloj
	 * @param activo: representa si el reloj esta activo
	 */
	public TransferRelojAnalogico(String modelo, String marca, double precio, String esfera, boolean activo) {
		super(modelo, marca, precio, activo);
		this.esfera = esfera;
	}
	
	/**
	 * Getters y Setters
	 */
	public String getEsfera() {
		return esfera;
	}

	public void setEsfera(String esfera) {
		this.esfera = esfera;
	}
	
	public String toString (){
		return "Id: " + id + " Modelo: " + modelo + " Marca: " + marca + " Precio: " + precio + " Tipo de esfera: " + esfera +  " Activo: " + activo;
	}
}
