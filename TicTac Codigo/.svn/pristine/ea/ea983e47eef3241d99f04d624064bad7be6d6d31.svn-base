/**
 * El fichero persistence.xml por motivos extraños decide descartar esta clase y no permitirá que conecte con la base de datos.
 * Hemos creado un fichero auxiliar persistencia.xml que consiste en el fichero persistence con la configuracíon correcta.
 * */

package negocio.competencia;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class CompetenciaTrabajadorId implements Serializable {
	private static final long serialVersionUID = 0;
	private int trabajador;
	private int competencia;
	
	public CompetenciaTrabajadorId() {}
	
	public CompetenciaTrabajadorId(int trabajador, int competencia) {
		this.trabajador = trabajador;
		this.competencia = competencia;
	}
	
	public int getTrabajador() {
		return trabajador;
	}

	public int getCompetencia() {
		return competencia;
	}
	
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof CompetenciaTrabajadorId))
			return false;
		CompetenciaTrabajadorId pk = (CompetenciaTrabajadorId) obj;
		if (!(trabajador == pk.trabajador))
			return false;
		if (!(competencia == pk.competencia))
			return false;
		return true;
	}

	public int hashCode() {
		int hashcode = 0;
		hashcode += trabajador;
		hashcode += competencia;
		return hashcode;
	}
}