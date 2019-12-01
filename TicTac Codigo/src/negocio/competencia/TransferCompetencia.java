package negocio.competencia;

public class TransferCompetencia {
	private int id;
	private String nombre;
	private String descripcion;
	private boolean activo;

	public TransferCompetencia(String nombre, String descripcion, boolean activo) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}
	
	public TransferCompetencia(int id, String nombre, String descripcion, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public int getId() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public boolean getActivo() {
		return this.activo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDireccion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public String toString() {
		return "Id: " + id + " Nombre: " + nombre + " Descripción: " + descripcion + " Activo: " + activo;
	}
}