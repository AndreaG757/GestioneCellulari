package it.prova.service.marca;

import java.util.List;

import it.prova.dao.marca.IMarcaDAO;
import it.prova.model.Marca;
import it.prova.model.Modello;

public interface IMarcaService {

	public List<Marca> listAll() throws Exception;

	public Marca caricaSingoloElemento(Long id) throws Exception;

	public void aggiorna(Marca marcaInstance) throws Exception;

	public void inserisciNuovo(Marca marcaInstance) throws Exception;

	public void rimuovi(Marca marcaInstance) throws Exception;

	public void aggiungiModello(Marca marcaInstance, Modello modelloInstance);

	public void setMarcaDAO(IMarcaDAO marcaInstance);
	
}
