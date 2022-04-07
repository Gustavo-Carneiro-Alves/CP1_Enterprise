package br.com.fiap.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CinemaDao;
import br.com.fiap.entidade.Cinema;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;

public class CinemaDaoImpl implements CinemaDao {

	
	private EntityManager em;
	
	public CinemaDaoImpl(EntityManager em) {
		this.em = em;
	}

	
	
	public Cinema pesquisar(Integer id) throws IdNotFoundException {
		Cinema cinema = em.find(Cinema.class, id);
		
		if (cinema == null)
			throw new IdNotFoundException(); 
				
		return cinema;
	}

	public void cadastrar(Cinema cinema) {
		em.persist(cinema);
		
	}

	public void atualizar(Cinema cinema) throws IdNotFoundException {
		pesquisar(cinema.getCodigo()); 
		em.merge(cinema);
		
	}

	public void remover(Integer id) throws IdNotFoundException {
		Cinema cinema= pesquisar(id);
		em.remove(cinema);
		
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
