package it.prova.dao.modello;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.model.Modello;

public class ModelloDAOImpl implements IModelloDAO {

	private EntityManager entityManager;
	
	@Override
	public List<Modello> list() throws Exception {
		return entityManager.createQuery("from Modello", Modello.class).getResultList();
	}

	@Override
	public Modello get(Long id) throws Exception {
		return entityManager.find(Modello.class, id);
	}

	@Override
	public void update(Modello object) throws Exception {
		if (object == null)
			throw new Exception("Valore inserito non valido!");
		
		object = entityManager.merge(object);
	}

	@Override
	public void insert(Modello object) throws Exception {
		if (object == null)
			throw new Exception("Valore inserito non valido!");
		
		entityManager.persist(object);
	}

	@Override
	public void delete(Modello object) throws Exception {
		if (object == null)
			throw new Exception("Valore inserito non valido!");
		
		entityManager.remove(entityManager.merge(object));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
