package it.prova.dao;

import it.prova.dao.applicazione.ApplicazioneDAOImpl;
import it.prova.dao.applicazione.IApplicazioneDAO;
import it.prova.dao.marca.IMarcaDAO;
import it.prova.dao.marca.MarcaDAOImpl;
import it.prova.dao.modello.IModelloDAO;
import it.prova.dao.modello.ModelloDAOImpl;

public class MyDaoFactory {

	private static IApplicazioneDAO applicazioneDAOInstance = null;
	private static IMarcaDAO marcaDAOInstance = null;
	private static IModelloDAO modelloDAOInstance = null;
	
	public static IApplicazioneDAO getApplicazioneDAOInstance() {
		if (applicazioneDAOInstance == null)
			applicazioneDAOInstance = new ApplicazioneDAOImpl();
		return applicazioneDAOInstance;
	}
	
	public static IMarcaDAO getMarcaDAOInstance() {
		if (marcaDAOInstance == null)
			marcaDAOInstance = new MarcaDAOImpl();
		return marcaDAOInstance;
	}
	
	public static IModelloDAO getModelloDAOInstance() {
		if (modelloDAOInstance == null)
			modelloDAOInstance = new ModelloDAOImpl();
		return modelloDAOInstance;
	}
	
}
