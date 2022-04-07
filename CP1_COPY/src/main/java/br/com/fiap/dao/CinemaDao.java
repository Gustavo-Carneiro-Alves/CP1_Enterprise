package br.com.fiap.dao;

import br.com.fiap.entidade.Cinema;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;

public interface CinemaDao {
	
	Cinema pesquisar(Integer id) throws IdNotFoundException;
	
	void cadastrar(Cinema cinema);
	
	void atualizar(Cinema cinema) throws IdNotFoundException;
	
	void remover(Integer id) throws IdNotFoundException;
	
	void commit() throws CommitException;
 
}
