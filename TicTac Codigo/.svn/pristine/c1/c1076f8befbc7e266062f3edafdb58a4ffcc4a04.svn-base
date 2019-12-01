package negocio.departamento.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import negocio.departamento.Departamento;
import negocio.departamento.ServicioAplicacionDepartamento;
import negocio.departamento.TransferDepartamento;
import negocio.trabajador.Trabajador;

public class ServicioAplicacionDepartamentoImp implements ServicioAplicacionDepartamento {

	@Override
	public int crearDepartamento(TransferDepartamento t) {
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("TicTac Codigo").createEntityManager();
		eM.getTransaction().begin();
		TypedQuery<Departamento> findByName = eM.createNamedQuery("negocio.departamento.Departamento.findBynombre", Departamento.class);
		findByName.setParameter("nombre", t.getNombre());
		findByName.setLockMode(LockModeType.OPTIMISTIC);
		
		if (findByName.getResultList().size() == 0)	{
			Departamento aux = new Departamento(t.getNombre(), t.getDescripcion(), true);
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
			Departamento aux = findByName.getSingleResult();
			
			if(!aux.getActivo()) {
				aux.setDescripcion(t.getDescripcion());
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
	public int bajaDepartamento(int id) {
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("TicTac Codigo").createEntityManager();
		eM.getTransaction().begin();
		Departamento aux = eM.find(Departamento.class, id, LockModeType.OPTIMISTIC);
		
		if (aux != null) {
			if (aux.getActivo()) {				
				TypedQuery<Trabajador> findByDepartamentoActivo = eM.createNamedQuery("negocio.trabajador.Trabajador.findBydepartamentoActivo", Trabajador.class);
				findByDepartamentoActivo.setParameter("departamento", aux);
				findByDepartamentoActivo.setParameter("activo", true);
				findByDepartamentoActivo.setLockMode(LockModeType.OPTIMISTIC);
				
				if(findByDepartamentoActivo.getResultList().size() == 0) {
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
	public int modificarDepartamento(TransferDepartamento t) {
		int result;
		EntityManager eM = Persistence.createEntityManagerFactory("TicTac Codigo").createEntityManager();
		eM.getTransaction().begin();
		Departamento aux = eM.find(Departamento.class, t.getId(), LockModeType.OPTIMISTIC);
		
		if (aux != null) {
			if (aux.getActivo()) {
				TypedQuery<Departamento> findByName = eM.createNamedQuery("negocio.departamento.Departamento.findBynombre", Departamento.class);
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
	public TransferDepartamento mostrarDepartamento(int id) {
		TransferDepartamento result = null;
		EntityManager eM = Persistence.createEntityManagerFactory("TicTac Codigo").createEntityManager();
		eM.getTransaction().begin();
		Departamento aux = eM.find(Departamento.class, id);
		eM.getTransaction().commit();
		eM.close();
		
		if (aux != null) 
			result = new TransferDepartamento(aux.getId(), aux.getNombre(), aux.getDescripcion(), aux.getActivo());
		return result;
	}

	@Override
	public ArrayList<TransferDepartamento> listarDepartamentos() {
		ArrayList<TransferDepartamento> lista = new ArrayList<TransferDepartamento> ();
		EntityManager eM = Persistence.createEntityManagerFactory("TicTac Codigo").createEntityManager();
		eM.getTransaction().begin();
		
		List<Departamento> l = eM.createQuery("SELECT obj FROM Departamento obj", Departamento.class).getResultList();
		Departamento aux;
		
		for(int k = 0; k < l.size(); k++) {
			aux = l.get(k);
			lista.add(new TransferDepartamento(aux.getId(), aux.getNombre(), aux.getDescripcion(), aux.getActivo()));
		}

		eM.getTransaction().commit();
		eM.close();
		return lista;
	}

	@Override
	public double calcularNomina(int id) {
		double result = 0;
		EntityManager eM = Persistence.createEntityManagerFactory("TicTac Codigo").createEntityManager();
		eM.getTransaction().begin();
		Departamento aux = eM.find(Departamento.class, id, LockModeType.OPTIMISTIC);
		
		if (aux != null) {
			if(aux.getActivo())	{
				TypedQuery<Trabajador> findByDepartamento = eM.createNamedQuery("negocio.trabajador.Trabajador.findBydepartamentoActivo", Trabajador.class);
				findByDepartamento.setParameter("departamento", aux);
				findByDepartamento.setParameter("activo", true);
				findByDepartamento.setLockMode(LockModeType.OPTIMISTIC);
				
				List<Trabajador> l = findByDepartamento.getResultList();
				
				for(int k=0; k<l.size(); k++) {
					Trabajador auxTrabajador = l.get(k);
					eM.lock(auxTrabajador, LockModeType.OPTIMISTIC);
					result += auxTrabajador.calcularSueldo();
				}
				eM.getTransaction().commit();
			}
			else
				result = -2; //departamento inactivo
		}
		else
			result = -1; //no existe el departamento
		
		eM.close();
		return result;
	}

}
