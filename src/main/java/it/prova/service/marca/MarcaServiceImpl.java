package it.prova.service.marca;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.dao.EntityManagerUtil;
import it.prova.dao.marca.IMarcaDAO;
import it.prova.model.Marca;
import it.prova.model.Modello;

public class MarcaServiceImpl implements IMarcaService {

	private IMarcaDAO marcaDAO;
	
	@Override
	public List<Marca> listAll() throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			marcaDAO.setEntityManager(entityManager);

			return marcaDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
		
	}

	@Override
	public Marca caricaSingoloElemento(Long id) throws Exception {

		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			marcaDAO.setEntityManager(entityManager);

			return marcaDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
		
	}

	@Override
	public void aggiorna(Marca marcaInstance) throws Exception {

		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			marcaDAO.setEntityManager(entityManager);

			marcaDAO.update(marcaInstance);

			entityManager.getTransaction().commit();

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public void inserisciNuovo(Marca marcaInstance) throws Exception {

		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			marcaDAO.setEntityManager(entityManager);

			marcaDAO.insert(marcaInstance);

			entityManager.getTransaction().commit();

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public void rimuovi(Marca marcaInstance) throws Exception {

		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			marcaDAO.setEntityManager(entityManager);
			
			Marca marca = marcaDAO.getEagerModello(marcaInstance);
			
			if (marca.getModelli().isEmpty())
				marcaDAO.delete(marcaInstance);
			else
				throw new Exception("Sono presenti dei modelli.");

			entityManager.getTransaction().commit();

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
		
	}

	@Override
	public void aggiungiModello(Marca marcaInstance, Modello modelloInstance) {

		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {
			
			entityManager.getTransaction().begin();
			
			marcaDAO.setEntityManager(entityManager);
			
			marcaInstance = entityManager.merge(marcaInstance);
			modelloInstance = entityManager.merge(modelloInstance);
			
			marcaInstance.getModelli().add(modelloInstance);
			
			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
		
	}

	@Override
	public void setMarcaDAO(IMarcaDAO marcaInstance) {
		this.marcaDAO = marcaInstance;
	}

}
