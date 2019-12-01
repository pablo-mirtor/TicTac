package negocio.departamento;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import negocio.trabajador.Trabajador;

/**
 * Entity implementation class for Entity: Departamento
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "negocio.departamento.Departamento.findByid", query = "select obj from Departamento obj where obj.id = :id"),
	@NamedQuery(name = "negocio.departamento.Departamento.findBytrabajador", query = "select obj from Departamento obj where obj.trabajadores = :trabajadores"),
	@NamedQuery(name = "negocio.departamento.Departamento.findBynombre", query = "select obj from Departamento obj where obj.nombre = :nombre"),
	@NamedQuery(name = "negocio.departamento.Departamento.findBydescripcion", query = "select obj from Departamento obj where obj.descripcion = :descripcion"),
	@NamedQuery(name = "negocio.departamento.Departamento.findByactivo", query = "select obj from Departamento obj where obj.activo = :activo"),
	@NamedQuery(name = "negocio.departamento.Departamento.findByintversion", query = "select obj from Departamento obj where obj.version = :version")
	})
public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) private int id;
	private String nombre;
	private String descripcion;
	private boolean activo;
	@OneToMany(mappedBy = "departamento")
	private List<Trabajador> trabajadores;
	@Version private int version;
	public Departamento() {
		super();
	}
	public Departamento(String nombre, String descripcion, boolean activo){
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
		this.id = 0;
	}
	
	public Departamento(int id, String nombre, String descripcion, boolean activo){
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
