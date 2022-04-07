package br.com.fiap.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.FilmeDao;
import br.com.fiap.entidade.Filme;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;

public class FilmeDaoImpl implements FilmeDao {

	private EntityManager em;
	
	public FilmeDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	public Filme pesquisar(Integer id) throws IdNotFoundException {
		
		
		Filme filme = em.find(Filme.class, id);
				
		if (filme == null)
			throw new IdNotFoundException(); 
				
		return filme;
				
	}

	public void cadastrar(Filme filme) {
		em.persist(filme);
		
	}

	public void atualizar(Filme filme) throws IdNotFoundException {
		pesquisar(filme.getCodigo()); 
		em.merge(filme);
		
	}

	public void remover(Integer id) throws IdNotFoundException {
		Filme filme = pesquisar(id);
		em.remove(filme);
		
	}

	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new CommitException();
		}
		
	}

	
	
}
