package negocio.compra;

/**
 * Clase de la capa Negocio que implementa el Transfer de la Linea de Compra
 */
public class TransferLineaDeCompra {
	private int idCompra;
	private int idProducto;
	private int cantidad;
    private double precio;
	private boolean activo;
	/**
	 * Constructor (se usa al crear una linea de compra)
	 * @param idCompra: identificador de la compra
	 * @param idProducto: identificador del producto
	 * @param cantidad: cantidad del articulo
         * @param precio: valor unitario
	 */
	public TransferLineaDeCompra(int idProducto, int cantidad, double precio){
		this.idProducto = idProducto;
		this.cantidad = cantidad;
                this.precio = precio;
		activo = true;
	}
	
	/**
	 * Constructor (se usa al crear una linea de compra)
	 * @param idCompra: identificador de la compra
	 * @param idProducto: identificador del producto
	 * @param cantidad: cantidad del articulo
         * @param precio: valor unitario
	 */
	public TransferLineaDeCompra(int idCompra, int idProducto, int cantidad, double precio){
		this.idCompra = idCompra;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
                this.precio = precio;
		activo = true;
	}
	
	/**
	 * Constructor con todos los parametros
	 * @param idCompra: identificador compra
	 * @param idProducto: identificador del producto
	 * @param cantidad: cantidad del articulo
	 * @param activo: representa si la compra esta activa
	 */
	public TransferLineaDeCompra(int idCompra, int idProducto, int cantidad, boolean activo, double precio){
		this.idCompra = idCompra;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.activo = activo;
                this.precio = precio;
	}
	
	//Getters y Setters
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }


	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public boolean getActivo() {
		return activo;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setCantidad(int cantidadDevolucion) {
		this.cantidad = cantidadDevolucion;
		
	}

	public void setActivo(boolean b) {
		this.activo = b;
		
	}

}

