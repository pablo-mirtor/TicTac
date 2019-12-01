package negocio.trabajador;

import java.io.Serializable;
import javax.persistence.*;

import negocio.departamento.Departamento;

/**
 * Entity implementation class for Entity: Empleado
 *
 */

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({
	@NamedQuery(name = "negocio.trabajador.Trabajador.findByid", query = "select obj from Trabajador obj where obj.id = :id"),
	@NamedQuery(name = "negocio.trabajador.Trabajador.findBynombre", query = "select obj from Trabajador obj where obj.nombre = :nombre"),
	@NamedQuery(name = "negocio.trabajador.Trabajador.findBydni", query = "select obj from Trabajador obj where obj.dni = :dni"),
	@NamedQuery(name = "negocio.trabajador.Trabajador.findByactivo", query = "select obj from Trabajador obj where obj.activo = :activo"),
	@NamedQuery(name = "negocio.trabajador.Trabajador.findBydepartamentoActivo", query = "select obj from Trabajador obj where obj.departamento = :departamento AND obj.activo = :activo"),
	@NamedQuery(name = "negocio.trabajador.Trabajador.findByDepartamento", query = "select obj from Trabajador obj where obj.departamento = :departamento"),
	@NamedQuery(name = "negocio.trabajador.Trabajador.findBysalario", query = "select obj from Trabajador obj where obj.salario = :salario"),
	@NamedQuery(name = "negocio.trabajador.Trabajador.findByversion", query = "select obj from Trabajador obj where obj.version = :version")
})
public abstract class Trabajador implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;
	
	protected String nombre;
	protected String dni;
	protected boolean activo;
	protected double salario;
	
	@ManyToOne
	protected Departamento departamento;
	
	@Version 
	protected int version;
	
	public Trabajador() {}
	
	public Trabajador(String nombre, String dni, double salario, Departamento dep,boolean activo) {
		this.nombre = nombre;
		this.dni = dni;
		this.salario = salario;
		this.activo = activo;	
		this.departamento = dep;
	}
	
	public Trabajador(int id, String nombre, String dni, double salario,Departamento dep,boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.activo = activo;	
		this.salario =salario;
		this.departamento = dep;
	}
	public int getId() {
		return this.id;
	}
		
	public String getNombre(){
		return this.nombre;
	}
	
	public String getDni() {
		return dni;
	}
	
	public double getSalario() {
		return this.salario;
	}
	
	public boolean getActivo() {
		return this.activo;
	}	


	public Departamento getDepartamento() {
		return this.departamento;
	}


	//setters
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public abstract double calcularSueldo();
}
