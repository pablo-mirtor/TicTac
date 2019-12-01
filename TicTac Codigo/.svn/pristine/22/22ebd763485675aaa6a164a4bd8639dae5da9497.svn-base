package negocio.competencia;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Competencia
 *
 */

@Entity
@NamedQueries({
	@NamedQuery(name = "negocio.competencia.Competencia.findByid", query = "select obj from Competencia obj where obj.id = :id"),
	@NamedQuery(name = "negocio.competencia.Competencia.findBynombre", query = "select obj from Competencia obj where obj.nombre = :nombre"),
	@NamedQuery(name = "negocio.competencia.Competencia.findBydescripcion", query = "select obj from Competencia obj where obj.descripcion = :descripcion"),
	@NamedQuery(name = "negocio.competencia.Competencia.findByactivo", query = "select obj from Competencia obj where obj.activo = :activo"),
	@NamedQuery(name = "negocio.competencia.Competencia.findByintversion", query = "select obj from Competencia obj where obj.version = :version")
	})
public class Competencia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) private int id;
	private String nombre;
	private String descripcion;
	private boolean activo;
	@Version
	private int version;
	public Competencia() {
		super();
	}
	
	public Competencia(String nombre, String descripcion, boolean activo){
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}
	
	public Competencia(int id, String nombre, String descripcion, boolean activo){
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}
   
	public int getId() {
		return this.id;
	}
		
	public String getNombre(){
		return this.nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public boolean getActivo() {
		return this.activo;
	}	

	//setters
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
