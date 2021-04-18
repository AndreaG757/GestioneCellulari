package it.prova.dao.marca;

import it.prova.dao.IBaseDAO;
import it.prova.model.Marca;

public interface IMarcaDAO extends IBaseDAO<Marca> {

	public Marca getEagerModello(Marca marca);
	
}
