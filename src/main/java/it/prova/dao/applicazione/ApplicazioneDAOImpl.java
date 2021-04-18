package it.prova.dao.applicazione;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.model.Applicazione;

public class ApplicazioneDAOImpl implements IApplicazioneDAO {

	private EntityManager entityManager;
	
	@Override
	public List<Applicazione> list() throws Exception {
		return entityManager.createQuery("from Applicazione", Applicazione.class).getResultList();
	}

	@Override
	public Applicazione get(Long id) throws Exception {
		return entityManager.find(Applicazione.class, id);
	}

	@Override
	public void update(Applicazione object) throws Exception {
		if (object == null)
			throw new Exception("Valore inserito non valido!");
		
		object = entityManager.merge(object);
	}

	@Override
	public void insert(Applicazione object) throws Exception {
		if (object == null)
			throw new Exception("Valore inserito non valido!");
		
		entityManager.persist(object);
	}

	@Override
	public void delete(Applicazione object) throws Exception {
		if (object == null)
			throw new Exception("Valore inserito non valido!");
		
		entityManager.remove(entityManager.merge(object));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
