package it.prova.service.modello;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.dao.EntityManagerUtil;
import it.prova.dao.modello.IModelloDAO;
import it.prova.model.Applicazione;
import it.prova.model.Marca;
import it.prova.model.Modello;

public class ModelloServiceImpl implements IModelloService {

	private IModelloDAO modelloDAO;
	
	@Override
	public List<Modello> listAll() throws Exception {

		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			modelloDAO.setEntityManager(entityManager);

			return modelloDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
		
	}

	@Override
	public Modello caricaSingoloElemento(Long id) throws Exception {

		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			modelloDAO.setEntityManager(entityManager);

			return modelloDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
		
	}

	@Override
	public void aggiorna(Modello modelloInstance) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			modelloDAO.setEntityManager(entityManager);

			modelloDAO.update(entityManager.merge(modelloInstance));

			entityManager.getTransaction().commit();

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public void inserisciNuovo(Modello modelloInstance) throws Exception {

		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			modelloDAO.setEntityManager(entityManager);

			modelloDAO.insert(modelloInstance);

			entityManager.getTransaction().commit();

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public void rimuovi(Modello modelloInstance) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			modelloDAO.setEntityManager(entityManager);
			
			modelloDAO.delete(modelloInstance);

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
	public void aggiungiMarca(Modello modelloInstance, Marca marcaInstance) {

		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {

			entityManager.getTransaction().begin();

			modelloDAO.setEntityManager(entityManager);

			modelloInstance = entityManager.merge(modelloInstance);
			marcaInstance = entityManager.merge(marcaInstance);

			modelloInstance.setMarca(marcaInstance);

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
	public void aggiungiApplicazione(Modello modelloInstance, Applicazione applicazioneInstance) {

		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {

			entityManager.getTransaction().begin();

			modelloDAO.setEntityManager(entityManager);

			modelloInstance = entityManager.merge(modelloInstance);
			applicazioneInstance = entityManager.merge(applicazioneInstance);

			modelloInstance.getApplicazioni().add(applicazioneInstance);

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
	public void setModelloDAO(IModelloDAO modelloInstance) {
		this.modelloDAO = modelloInstance;
	}

}
