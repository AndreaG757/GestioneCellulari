package it.prova.dao.marca;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.model.Marca;

public class MarcaDAOImpl implements IMarcaDAO {

	private EntityManager entityManager;
	
	@Override
	public List<Marca> list() throws Exception {
		return entityManager.createQuery("from Marca", Marca.class).getResultList();
	}

	@Override
	public Marca get(Long id) throws Exception {
		return entityManager.find(Marca.class, id);
	}

	@Override
	public void update(Marca object) throws Exception {
		if (object == null)
			throw new Exception("Valore inserito non valido!");
		
		object = entityManager.merge(object);
	}

	@Override
	public void insert(Marca object) throws Exception {
		if (object == null)
			throw new Exception("Valore inserito non valido!");
		
		entityManager.persist(object);
	}

	@Override
	public void delete(Marca object) throws Exception {
		if (object == null)
			throw new Exception("Valore inserito non valido!");
		
		entityManager.remove(entityManager.merge(object));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Marca getEagerModello(Marca marca) {
		return entityManager.createQuery("from Marca m left join fetch m.modelli where m.id = :id", Marca.class)
				.setParameter("id", entityManager.merge(marca).getId())
				.getResultStream().findFirst().orElse(null);
	}

}
