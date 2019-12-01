package negocio.competencia;

public class TransferCompetenciaTrabajador {
	private int trabajador;
	private int competencia;
	private int nivel;
	private boolean activo;
	
	public TransferCompetenciaTrabajador(int trabajador, int competencia) {
		this.trabajador = trabajador;
		this.competencia = competencia;
	}	
	
	public TransferCompetenciaTrabajador(int trabajador, int competencia, boolean activo) {
		this.trabajador = trabajador;
		this.competencia = competencia;
		this.activo = activo;
	}
	
	public TransferCompetenciaTrabajador(int trabajador, int competencia, int nivel, boolean activo) {
		this.trabajador = trabajador;
		this.competencia = competencia;
		this.nivel = nivel;
		this.activo = activo;
	}
	
	public int getTrabajador() {
		return this.trabajador;
	}
	
	public int getCompetencia() {
		return this.competencia;
	}
	
	public int getNivel() {
		return this.nivel;
	}
	
	public boolean getActivo() {
		return activo;
	}
	
	public void setTrabajador(int trabajador) {
		this.trabajador = trabajador;
	}
	
	public void setCompetencia(int competencia) {
		this.competencia = competencia;
	}
	
	public void setCantidad(int nivel) {
		this.nivel = nivel;
	}	
	
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String toString() {
		return "Trabajador: " + trabajador + " Competencia: " + competencia + " Nivel: " + nivel + " Activo: " + activo;
	}
}
