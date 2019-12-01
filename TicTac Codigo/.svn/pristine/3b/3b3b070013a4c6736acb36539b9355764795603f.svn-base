package negocio.competencia.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import negocio.competencia.Competencia;
import negocio.competencia.CompetenciaTrabajador;
import negocio.competencia.CompetenciaTrabajadorId;
import negocio.competencia.ServicioAplicacionCompetencia;
import negocio.competencia.TransferCompetencia;
import negocio.competencia.TransferCompetenciaTrabajador;
import negocio.trabajador.Trabajador;


public class ServicioAplicacionCompetenciaImp implements ServicioAplicacionCompetencia {

	@Override
	public int altaCompetencia(TransferCompetencia t) {
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("TicTac Codigo").createEntityManager();
		eM.getTransaction().begin();
		TypedQuery<Competencia> findByName = eM.createNamedQuery("negocio.competencia.Competencia.findBynombre", Competencia.class);
		findByName.setParameter("nombre", t.getNombre());
		findByName.setLockMode(LockModeType.OPTIMISTIC);
		
		if (findByName.getResultList().size() == 0)	{
			Competencia aux = new Competencia(t.getNombre(), t.getDescripcion(), true);
			eM.persist(aux);
			try	{
				eM.getTransaction().commit();
				result = aux.getId();
			}
			catch(Exception e) {
				eM.getTransaction().rollback();
				result = -10;
			}	
		}
		else {
			Competencia aux = findByName.getSingleResult();
			
			if(!aux.getActivo()) {
				aux.setActivo(true);
				try	{
					eM.getTransaction().commit();
					result = -2;
				}
				catch(Exception e) {
					eM.getTransaction().rollback();
					result = -10;
				}
				
			}
			else
				result = -1;
		}
		
		eM.close();
		
		return result;
	}

	@Override
	public int bajaCompetencia(int id) {
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("TicTac Codigo").createEntityManager();
		eM.getTransaction().begin();
		Competencia aux = eM.find(Competencia.class, id, LockModeType.OPTIMISTIC);
		
		if (aux != null) {
			if (aux.getActivo()) {				
				TypedQuery<CompetenciaTrabajador> findByCompetenciaActivo = eM.createNamedQuery("negocio.competencia.CompetenciaTrabajador.findBycompetenciaAsignado", CompetenciaTrabajador.class);
				findByCompetenciaActivo.setParameter("competencia", aux);
				findByCompetenciaActivo.setParameter("activo", true);
				findByCompetenciaActivo.setLockMode(LockModeType.OPTIMISTIC);
				
				if(findByCompetenciaActivo.getResultList().size() == 0) { //no pueden haber trabajadores con esa competencia asignada
					aux.setActivo(false);
					try {
						eM.getTransaction().commit();
						result = id;
					}
					catch(Exception e) {
						eM.getTransaction().rollback();
						result = -10;
					}
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

	@Override
	public int modificarCompetencia(TransferCompetencia t) {
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("TicTac Codigo").createEntityManager();
		eM.getTransaction().begin();
		Competencia aux = eM.find(Competencia.class, t.getId(), LockModeType.OPTIMISTIC);
		
		if (aux != null) {
			if (aux.getActivo()) {
				TypedQuery<Competencia> findByName = eM.createNamedQuery("negocio.competencia.Competencia.findBynombre", Competencia.class);
				findByName.setParameter("nombre", t.getNombre());
				findByName.setLockMode(LockModeType.OPTIMISTIC);
				
				if (findByName.getResultList().size() == 0 || (aux.getId() == findByName.getSingleResult().getId())) {
					aux.setNombre(t.getNombre());
					aux.setDescripcion(t.getDescripcion());
					try {
						eM.getTransaction().commit();
						result = t.getId();
					}
					catch(Exception e) {
						eM.getTransaction().rollback();
						result = -1;
					}
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

	@Override
	public TransferCompetencia mostrarCompetencia(int id) {
		TransferCompetencia result = null;
		EntityManager eM = Persistence.createEntityManagerFactory("TicTac Codigo").createEntityManager();
		eM.getTransaction().begin();
		Competencia aux = eM.find(Competencia.class, id);
		eM.getTransaction().commit();
		eM.close();
		
		if (aux != null) 
			result = new TransferCompetencia(aux.getId(), aux.getNombre(), aux.getDescripcion(), aux.getActivo());
		return result;
	}

	@Override
	public ArrayList<TransferCompetencia> listarCompetencias() {
		ArrayList<TransferCompetencia> lista = new ArrayList<TransferCompetencia> ();
		EntityManager eM = Persistence.createEntityManagerFactory("TicTac Codigo").createEntityManager();
		eM.getTransaction().begin();
		
		List<Competencia> l = eM.createQuery("SELECT obj FROM Competencia obj", Competencia.class).getResultList();
		Competencia aux;
		
		for(int k = 0; k < l.size(); k++) {
			aux = l.get(k);
			lista.add(new TransferCompetencia(aux.getId(), aux.getNombre(), aux.getDescripcion(), aux.getActivo()));
		}

		eM.getTransaction().commit();
		eM.close();
		return lista;
	}

	@Override
	public int asignarCompetencia(TransferCompetenciaTrabajador t) {
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("TicTac Codigo").createEntityManager();
		eM.getTransaction().begin();
		
		Trabajador auxTrabajador = eM.find(Trabajador.class, t.getTrabajador(), LockModeType.OPTIMISTIC);
		
		if(auxTrabajador != null && auxTrabajador.getActivo()) {
			Competencia auxCompetencia = eM.find(Competencia.class, t.getCompetencia(), LockModeType.OPTIMISTIC);
			if(auxCompetencia != null && auxCompetencia.getActivo()) {
				CompetenciaTrabajadorId auxid = new CompetenciaTrabajadorId(t.getTrabajador(), t.getCompetencia());
				CompetenciaTrabajador auxPresupuesto = eM.find(CompetenciaTrabajador.class, auxid, LockModeType.OPTIMISTIC);
				
				if(auxPresupuesto == null) {
					CompetenciaTrabajador aux = new CompetenciaTrabajador(auxTrabajador, auxCompetencia, 0, true);
					eM.persist(aux);
					try {
						eM.getTransaction().commit();
						result = t.getCompetencia();
					}
					catch(Exception e) {
						eM.getTransaction().rollback();
						result = -10;
					}
				}
				else {
					if(!auxPresupuesto.getActivo())	{
						auxPresupuesto.setNivel(0);
						auxPresupuesto.setActivo(true);
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
						result = -3;
				}
			}
			else
				result = -2;
		}
		else
			result = -1;
		
		eM.close();
		return result;
	}

	@Override
	public int desasignarCompetencia(TransferCompetenciaTrabajador t) {
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("TicTac Codigo").createEntityManager();
		eM.getTransaction().begin();
		
		Trabajador auxTrabajador = eM.find(Trabajador.class, t.getTrabajador(), LockModeType.OPTIMISTIC);
		
		if(auxTrabajador != null && auxTrabajador.getActivo()) {
			Competencia auxCompetencia = eM.find(Competencia.class, t.getCompetencia());
			if(auxCompetencia != null && auxCompetencia.getActivo()) {
				CompetenciaTrabajadorId auxid = new CompetenciaTrabajadorId(t.getTrabajador(), t.getCompetencia());
				CompetenciaTrabajador auxPresupuesto = eM.find(CompetenciaTrabajador.class, auxid, LockModeType.OPTIMISTIC);
				
				if(auxPresupuesto != null) {
					if(auxPresupuesto.getActivo()) {
						auxPresupuesto.setNivel(0);
						auxPresupuesto.setActivo(false);
						try {
							eM.getTransaction().commit();
							result = -5;
						}
						catch(Exception e) {
							eM.getTransaction().rollback();
							result = -10;
						}
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


	@Override
	public TransferCompetenciaTrabajador mostrarNivelCompetencia(TransferCompetenciaTrabajador t) {
		TransferCompetenciaTrabajador result = null;
		EntityManager eM = Persistence.createEntityManagerFactory("TicTac Codigo").createEntityManager();
		eM.getTransaction().begin();
		
		Trabajador auxTrabajador = eM.find(Trabajador.class, t.getTrabajador());
		
		if(auxTrabajador != null)	{
			Competencia auxCompetencia = eM.find(Competencia.class, t.getCompetencia());
			if(auxCompetencia != null) {
				CompetenciaTrabajadorId auxid = new CompetenciaTrabajadorId(t.getTrabajador(), t.getCompetencia());
				CompetenciaTrabajador auxPresupuesto = eM.find(CompetenciaTrabajador.class, auxid, LockModeType.OPTIMISTIC);
				
				if (auxPresupuesto != null) 
					result = new TransferCompetenciaTrabajador(t.getTrabajador(), t.getCompetencia(), auxPresupuesto.getNivel(), auxPresupuesto.getActivo());
			}
		}
		
		eM.getTransaction().commit();
		eM.close();
		return result;
	}

	@Override
	public int asignarNivel(TransferCompetenciaTrabajador t) {
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("TicTac Codigo").createEntityManager();
		eM.getTransaction().begin();
		
		Trabajador auxTrabajador = eM.find(Trabajador.class, t.getTrabajador(), LockModeType.OPTIMISTIC);
		
		if(auxTrabajador != null) {
			Competencia auxCompetencia = eM.find(Competencia.class, t.getCompetencia());
			if(auxCompetencia != null) {
				CompetenciaTrabajadorId auxid = new CompetenciaTrabajadorId(t.getTrabajador(), t.getCompetencia());
				CompetenciaTrabajador auxCompTrab = eM.find(CompetenciaTrabajador.class, auxid, LockModeType.OPTIMISTIC);
				
				if(auxCompTrab != null) {
					if(auxCompTrab.getActivo()) {
						auxCompTrab.setNivel(t.getNivel());
						try	{
							eM.getTransaction().commit();
							result = -5; //exito
						}
						catch(Exception e) {
							eM.getTransaction().rollback();
							result = -10;
						}
					}
					else
						result = -4; //competencia trabajador inactiva
				}
				else
					result = -3; //no existe competencia trabajador
			}
			else
				result = -2; //no existe competencia
		}
		else
			result = -1;//no existe trabajador
		
		eM.close();
		return result;
	}

}
