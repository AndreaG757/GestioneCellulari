package it.prova.service.applicazione;

import java.util.List;

import it.prova.dao.applicazione.IApplicazioneDAO;
import it.prova.model.Applicazione;
import it.prova.model.Modello;

public interface IApplicazioneService {

	public List<Applicazione> listAll() throws Exception;

	public Applicazione caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Applicazione applicazioneInstance) throws Exception;

	public void inserisciNuovo(Applicazione applicazioneInstance) throws Exception;

	public void rimuovi(Applicazione applicazioneInstance) throws Exception;

	public void aggiungiModello(Applicazione applicazioneInstance, Modello modelloInstance);

	public void setApplicazioneDAO(IApplicazioneDAO applicazioneInstance);
	
}
