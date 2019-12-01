package negocio.trabajador;

import java.io.Serializable;
import javax.persistence.*;

import negocio.departamento.Departamento;

/**
 * Entity implementation class for Entity: EmpleadoCompleto
 *
 */
@Entity

public class TrabajadorCompleto extends Trabajador implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private int productividad;
	
	public TrabajadorCompleto() {
		super();
	}
	
	public TrabajadorCompleto(String nombre, String dni, double salario, Departamento dep,boolean activo, int productividad) {
		super(nombre,dni,salario,dep,activo);
		this.productividad = productividad;
	}
	
	public TrabajadorCompleto(int id, String nombre, String dni, double salario ,Departamento dep ,boolean activo, int productividad) {
		super(id,nombre,dni,salario,dep,activo);
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
		return (salario * 40) * productividad; //jornada completa 40 horas, consideramos productividad como un porcentaje
	}
}
