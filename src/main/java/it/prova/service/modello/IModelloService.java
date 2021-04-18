package it.prova.service.modello;

import java.util.List;

import it.prova.dao.modello.IModelloDAO;
import it.prova.model.Applicazione;
import it.prova.model.Marca;
import it.prova.model.Modello;

public interface IModelloService {

	public List<Modello> listAll() throws Exception;

	public Modello caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Modello modelloInstance) throws Exception;

	public void inserisciNuovo(Modello modelloInstance) throws Exception;

	public void rimuovi(Modello modelloInstance) throws Exception;

	public void aggiungiMarca(Modello modelloInstance, Marca marcaInstance);
	
	public void aggiungiApplicazione(Modello modelloInstance, Applicazione applicazioneInstance);

	public void setModelloDAO(IModelloDAO modelloInstance);
	
}
