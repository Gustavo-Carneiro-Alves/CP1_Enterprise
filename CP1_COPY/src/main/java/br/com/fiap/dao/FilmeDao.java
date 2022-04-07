package br.com.fiap.dao;

import br.com.fiap.entidade.Filme;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;

public interface FilmeDao {

	Filme pesquisar(Integer id) throws IdNotFoundException;
	
	void cadastrar(Filme filme);
	
	void atualizar(Filme filme) throws IdNotFoundException;
	
	void remover(Integer id) throws IdNotFoundException;
	
	void commit() throws CommitException;
	
}
