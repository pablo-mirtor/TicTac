
package negocio.trabajador.imp;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import negocio.competencia.CompetenciaTrabajador;
import negocio.departamento.Departamento;
import negocio.trabajador.ServicioAplicacionTrabajador;
import negocio.trabajador.Trabajador;
import negocio.trabajador.TrabajadorCompleto;
import negocio.trabajador.TrabajadorParcial;
import negocio.trabajador.TransferTrabajadorCompleto;
import negocio.trabajador.TransferTrabajadorParcial;
import negocio.trabajador.TransferTrabajador;

public class ServicioAplicacionTrabajadorImp implements ServicioAplicacionTrabajador {
	
	@Override
	public int altaTrabajador(TransferTrabajador t) {
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("TicTac Codigo").createEntityManager();
		eM.getTransaction().begin();
		
		Departamento dep = eM.find(Departamento.class, t.getIdDepartamento(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
		
		if(dep != null)	{
			if(dep.getActivo())	{
				TypedQuery<Trabajador> findByDni = eM.createNamedQuery("negocio.trabajador.Trabajador.findBydni", Trabajador.class);
				findByDni.setParameter("dni", t.getDNI());
				findByDni.setLockMode(LockModeType.OPTIMISTIC);
				
				if (findByDni.getResultList().size() == 0) {
					Trabajador aux = null;
					if (t instanceof TransferTrabajadorCompleto)
						aux = new TrabajadorCompleto(t.getNombre(), t.getDNI(), t.getSalario(), dep, true, ((TransferTrabajadorCompleto) t).getProductividad());
					else
						aux = new TrabajadorParcial(t.getNombre(), t.getDNI(), t.getSalario(),dep, true, ((TransferTrabajadorParcial) t).getHorasSemanales());
					
					eM.persist(aux);
					try {
						eM.getTransaction().commit();
						result = aux.getId();
					}
					catch(Exception e) {
						eM.getTransaction().rollback();
						result = -10;
					}
				}
				else {
					Trabajador aux = findByDni.getSingleResult();
					
					if(!aux.getActivo()) {
						aux.setActivo(true);
						try {
							eM.getTransaction().commit();
							result = -4;
						}
						catch(Exception e) {
							eM.getTransaction().rollback();
							result = -10;
						}
					}
					else
						result = -3; //empleado ya existe y está activo
				}
			}
			else
				result = -2; //departamento inactivo
		}
		else
			result = -1; //departamento no existe
		
		eM.close();
		return result;
	}

	@Override
	public int bajaTrabajador(int id) {
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("TicTac Codigo").createEntityManager();
		eM.getTransaction().begin();
		Trabajador aux = eM.find(Trabajador.class, id, LockModeType.OPTIMISTIC);
		
		if (aux != null) {
			if (aux.getActivo()) {
				TypedQuery<CompetenciaTrabajador> findByCompetenciaActivo = eM.createNamedQuery("negocio.competencia.CompetenciaTrabajador.findBytrabajadorAsignado", CompetenciaTrabajador.class);
				findByCompetenciaActivo.setParameter("trabajador", aux);
				findByCompetenciaActivo.setParameter("activo", true);
				findByCompetenciaActivo.setLockMode(LockModeType.OPTIMISTIC);
				
				if(findByCompetenciaActivo.getResultList().size() == 0) { //no pueden haber trabajadores con competencia asignada
					aux.setActivo(false);
					try	{
						eM.getTransaction().commit();
						result = id; //dado de baja con éxito
					}
					catch(Exception e) {
						eM.getTransaction().rollback();
						result = -10; 
					}
				}
				else result = -3; //tiene competencias asignadas
			}
			else 
				result = -2; // ya inactivo
		}
		else 
			result = -1; //no existe
		
		eM.close();
		return result;
	}

	@Override
	public TransferTrabajador mostrarTrabajador(int id) {
		TransferTrabajador result = null;
		EntityManager eM = Persistence.createEntityManagerFactory("TicTac Codigo").createEntityManager();
		eM.getTransaction().begin();
		Trabajador aux = eM.find(Trabajador.class, id);
		eM.getTransaction().commit();
		eM.close();
		
		if (aux != null) {
			if (aux instanceof TrabajadorCompleto)
				result = new TransferTrabajadorCompleto(aux.getId(), aux.getNombre(), aux.getDni(), aux.getSalario(), aux.getDepartamento().getId(),true, ((TrabajadorCompleto) aux).getProductividad());
			else
				result = new TransferTrabajadorParcial(aux.getId(), aux.getNombre(), aux.getDni(), aux.getSalario(), aux.getDepartamento().getId(),true, ((TrabajadorParcial) aux).getHorasSemanales());
		}
		return result;
	}

	@Override
	public ArrayList<TransferTrabajador> listarTrabajadores() {
		ArrayList<TransferTrabajador> lista = new ArrayList<TransferTrabajador> ();
		EntityManager eM = Persistence.createEntityManagerFactory("TicTac Codigo").createEntityManager();
		eM.getTransaction().begin();
		
		List<Trabajador> l = eM.createQuery("SELECT obj FROM Trabajador obj", Trabajador.class).getResultList();
		Trabajador aux;
		
		for(int k = 0; k < l.size(); k++) {
			aux = l.get(k);
			
			if (aux instanceof TrabajadorCompleto)
				lista.add(new TransferTrabajadorCompleto(aux.getId(), aux.getNombre(), aux.getDni(), aux.getSalario(), aux.getDepartamento().getId(),aux.getActivo(), ((TrabajadorCompleto) aux).getProductividad()));
			else
				lista.add(new TransferTrabajadorParcial(aux.getId(), aux.getNombre(), aux.getDni(), aux.getSalario(), aux.getDepartamento().getId(), aux.getActivo(), ((TrabajadorParcial) aux).getHorasSemanales()));	
			}

		eM.getTransaction().commit();
		eM.close();
		return lista;
	}
	
	@Override
	public int modificarTrabajador(TransferTrabajador t) {
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("TicTac Codigo").createEntityManager();
		eM.getTransaction().begin();
		Trabajador aux = eM.find(Trabajador.class, t.getId(), LockModeType.OPTIMISTIC);
		
		if (aux != null) {
			if (aux.getActivo()) {
				Departamento dep = eM.find(Departamento.class, t.getIdDepartamento(), LockModeType.OPTIMISTIC);
				
				if(dep != null)	{
					if(dep.getActivo())	{
						TypedQuery<Trabajador> findByDni = eM.createNamedQuery("negocio.trabajador.Trabajador.findBydni", Trabajador.class);
						findByDni.setParameter("dni", t.getDNI());
						findByDni.setLockMode(LockModeType.OPTIMISTIC);
						
						if (findByDni.getResultList().size() == 0 || (aux.getId() == findByDni.getSingleResult().getId())) {
							if((t instanceof TransferTrabajadorCompleto && aux instanceof TrabajadorCompleto) || (t instanceof TransferTrabajadorParcial && aux instanceof TrabajadorParcial)) {
								aux.setNombre(t.getNombre());
								aux.setDni(t.getDNI());
								aux.setSalario(t.getSalario());
								aux.setDepartamento(dep);
			
								if (aux instanceof TrabajadorCompleto) {
									((TrabajadorCompleto) aux).setProductividad(((TransferTrabajadorCompleto) t).getProductividad());
								}
								else {
									((TrabajadorParcial) aux).setHorasSemanales(((TransferTrabajadorParcial) t).getHorasSemanales());
								}
								
								try {
									eM.getTransaction().commit();
									result = t.getId();
								}
								catch(Exception e) {
									eM.getTransaction().rollback();
									result = -10;
								}
							}
							else
								result = -6;
						}
						else
							result = -5;
					}
					else
						result = -4;
				}
				else
					result = -3;
			}
			else 
				result = -2;
		}
		else 
			result = -1;
		
		eM.close();
		return result;
	}
}