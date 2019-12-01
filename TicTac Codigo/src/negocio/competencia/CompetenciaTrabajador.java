package negocio.competencia;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Version;

import negocio.trabajador.Trabajador;

@Entity
@IdClass(CompetenciaTrabajadorId.class)
@NamedQueries({
	@NamedQuery(name = "negocio.competencia.CompetenciaTrabajador.findBycompetencia", query = "select obj from CompetenciaTrabajador obj where obj.competencia = :competencia"),
	@NamedQuery(name = "negocio.competencia.CompetenciaTrabajador.findBytrabajador", query = "select obj from CompetenciaTrabajador obj where obj.trabajador = :trabajador"),
	@NamedQuery(name = "negocio.competencia.CompetenciaTrabajador.findBynivel", query = "select obj from CompetenciaTrabajador obj where obj.nivel = :nivel"),
	@NamedQuery(name = "negocio.competencia.CompetenciaTrabajador.findBycompetenciatrabajador", query="select obj from CompetenciaTrabajador obj where obj.competencia = :competencia AND obj.trabajador = :trabajador AND obj.activo = :activo"),
	@NamedQuery(name = "negocio.competencia.CompetenciaTrabajador.findBycompetenciaAsignado", query="select obj from CompetenciaTrabajador obj where obj.competencia = :competencia AND obj.activo = :activo"),
	@NamedQuery(name = "negocio.competencia.CompetenciaTrabajador.findBytrabajadorAsignado", query="select obj from CompetenciaTrabajador obj where obj.trabajador = :trabajador AND obj.activo = :activo"),
	@NamedQuery(name = "negocio.competencia.CompetenciaTrabajador.findByversion", query = "select obj from CompetenciaTrabajador obj where obj.version = :version")
})		
public class CompetenciaTrabajador implements Serializable {
	private static final long serialVersionUID = 0;
	@Id @ManyToOne private Competencia competencia;
	@Id @ManyToOne private Trabajador trabajador;
	private boolean activo;
	private int nivel;
	@Version private int version;

	
	public CompetenciaTrabajador(){
		super();
	}	
	
	public CompetenciaTrabajador(Trabajador trabajador, Competencia competencia, boolean activo) {
		this.trabajador = trabajador;
		this.competencia = competencia;
		this.activo = activo;
	}
	
	public CompetenciaTrabajador(Trabajador trabajador, Competencia competencia, int nivel, boolean activo) {
		this.trabajador = trabajador;
		this.competencia = competencia;
		this.nivel = nivel;
		this.activo = activo;
	}
	

	public int getNivel() {
		return this.nivel;
	}
	
	public boolean getActivo() {
		return activo;
	}
	
	
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}	
	
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String toString() {
		return "Trabajador: " + trabajador + " Competencia: " + competencia + " Nivel: " + nivel + " Activo: " + activo;
	}
}

