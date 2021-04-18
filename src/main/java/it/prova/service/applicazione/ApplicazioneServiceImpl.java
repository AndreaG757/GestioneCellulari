package it.prova.service.applicazione;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.dao.EntityManagerUtil;
import it.prova.dao.applicazione.IApplicazioneDAO;
import it.prova.model.Applicazione;
import it.prova.model.Modello;

public class ApplicazioneServiceImpl implements IApplicazioneService {

	private IApplicazioneDAO applicazioneDAO;
	
	@Override
	public List<Applicazione> listAll() throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			applicazioneDAO.setEntityManager(entityManager);

			return applicazioneDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
		
	}

	@Override
	public Applicazione caricaSingoloElemento(Long id) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			applicazioneDAO.setEntityManager(entityManager);

			return applicazioneDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			entityManager.close();
		}
		
	}

	@Override
	public void aggiorna(Applicazione applicazioneInstance) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			applicazioneDAO.setEntityManager(entityManager);

			applicazioneDAO.update(applicazioneInstance);

			entityManager.getTransaction().commit();

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public void inserisciNuovo(Applicazione applicazioneInstance) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			applicazioneDAO.setEntityManager(entityManager);

			applicazioneDAO.insert(applicazioneInstance);

			entityManager.getTransaction().commit();

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public void rimuovi(Applicazione applicazioneInstance) throws Exception {

		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {

			entityManager.getTransaction().begin();

			applicazioneDAO.setEntityManager(entityManager);
			
			applicazioneInstance = entityManager.merge(applicazioneInstance);
			
			for (Modello modelloItem : applicazioneInstance.getModelli()) {
				modelloItem.removeFromApp(applicazioneInstance);
			}
			if (applicazioneInstance.getModelli().isEmpty()) 
				applicazioneDAO.delete(applicazioneInstance);
			else
				throw new Exception("Sono presenti ancora dei modelli");

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
	public void aggiungiModello(Applicazione applicazioneInstance, Modello modelloInstance) {

		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		
		try {

			entityManager.getTransaction().begin();

			applicazioneDAO.setEntityManager(entityManager);

			applicazioneInstance = entityManager.merge(applicazioneInstance);
			modelloInstance = entityManager.merge(modelloInstance);

			applicazioneInstance.addToModello(modelloInstance);

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
	public void setApplicazioneDAO(IApplicazioneDAO applicazioneInstance) {
		this.applicazioneDAO = applicazioneInstance;
	}

}
