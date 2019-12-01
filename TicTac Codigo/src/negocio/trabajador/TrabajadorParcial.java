package negocio.trabajador;

import java.io.Serializable;
import javax.persistence.*;

import negocio.departamento.Departamento;

/**
 * Entity implementation class for Entity: EmpleadoParcial
 *
 */
@Entity

public class TrabajadorParcial extends Trabajador implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private int horasSemanales;
	
	public TrabajadorParcial() {
		super();
	}
   
	public TrabajadorParcial(String nombre, String dni, double salario, Departamento dep,boolean activo, int horasSemanales) {
		super(nombre,dni,salario,dep,activo);
		this.horasSemanales = horasSemanales;
	}
	
	public TrabajadorParcial(int id, String nombre, String dni, double salario, Departamento dep, boolean activo, int horasSemanales) {
		super(id,nombre,dni,salario,dep,activo);
		this.horasSemanales = horasSemanales;
	}
	
	public int getHorasSemanales(){
		return this.horasSemanales;
	}
	
	public void setHorasSemanales(int horas){
		this.horasSemanales = horas;
	}

	@Override
	public double calcularSueldo() {
		return salario * horasSemanales;
	}
   
}
