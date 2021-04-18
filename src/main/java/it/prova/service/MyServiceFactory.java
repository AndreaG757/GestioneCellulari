package it.prova.service;

import it.prova.dao.MyDaoFactory;
import it.prova.service.applicazione.ApplicazioneServiceImpl;
import it.prova.service.applicazione.IApplicazioneService;
import it.prova.service.marca.IMarcaService;
import it.prova.service.marca.MarcaServiceImpl;
import it.prova.service.modello.IModelloService;
import it.prova.service.modello.ModelloServiceImpl;

public class MyServiceFactory {

	private static IMarcaService MARCA_SERVICE_INSTANCE;
	private static IModelloService MODELLO_SERVICE_INSTANCE;
	private static IApplicazioneService APPLICAZIONE_SERVICE_INSTANCE;
	
	public static IMarcaService getMarcaServiceInstance() {
		if (MARCA_SERVICE_INSTANCE == null)
			MARCA_SERVICE_INSTANCE = new MarcaServiceImpl();
		
		MARCA_SERVICE_INSTANCE.setMarcaDAO(MyDaoFactory.getMarcaDAOInstance());
		return MARCA_SERVICE_INSTANCE;
	}
	
	public static IModelloService getModelloServiceInstance() {
		if (MODELLO_SERVICE_INSTANCE == null)
			MODELLO_SERVICE_INSTANCE = new ModelloServiceImpl();
		
		MODELLO_SERVICE_INSTANCE.setModelloDAO(MyDaoFactory.getModelloDAOInstance());
		return MODELLO_SERVICE_INSTANCE;
	}
	
	public static IApplicazioneService getApplicazioneServiceInstance() {
		if (APPLICAZIONE_SERVICE_INSTANCE == null)
			APPLICAZIONE_SERVICE_INSTANCE = new ApplicazioneServiceImpl();
		
		APPLICAZIONE_SERVICE_INSTANCE.setApplicazioneDAO(MyDaoFactory.getApplicazioneDAOInstance());
		return APPLICAZIONE_SERVICE_INSTANCE;
	}
	
}
