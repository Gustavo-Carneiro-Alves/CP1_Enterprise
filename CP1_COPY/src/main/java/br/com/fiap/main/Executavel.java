package br.com.fiap.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.CinemaDao;
import br.com.fiap.dao.FilmeDao;
import br.com.fiap.entidade.Cinema;
import br.com.fiap.entidade.Filme;
import br.com.fiap.entidade.GeneroFilme;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.impl.CinemaDaoImpl;
import br.com.fiap.impl.FilmeDaoImpl;
import br.com.fiap.singleton.EntityManagerFactorySingleton;



public class Executavel {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		
		//Obter um entity manager
		EntityManager em = fabrica.createEntityManager();
		
		
		Filme filme = new Filme("Action Now", GeneroFilme.ACAO, new GregorianCalendar(2010, Calendar.FEBRUARY, 15), "01:25:36", "Micael Baía", 5);
		Filme filme2 = new Filme("Romance in romanceverse", GeneroFilme.ROMANCE, new GregorianCalendar(2021, Calendar.JANUARY, 2), "02:07:42", "Zé Rodrigo", 3);
		
		FilmeDao dao = new FilmeDaoImpl(em);
		
		//Cadastrar
		try {
			dao.cadastrar(filme);
			dao.cadastrar(filme2);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		try {
			//Pesquisar pela PK
			Filme busca = dao.pesquisar(1);
			//Exibir o nome
			System.out.println(busca.getNome());
		} catch (IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//Atualizar o nome
			filme.setNome("Pow-Pow");
			dao.atualizar(filme);
			dao.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Remover
		try {
			dao.remover(1);
			dao.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		//----CINEMA----
		
		
		Cinema cinema = new Cinema("Cinema UAU", new GregorianCalendar(2015, Calendar.FEBRUARY, 20), "Rua X", "09:00-23:00", 50);
		Cinema cinema2 = new Cinema("Cinema INCRIVEL", new GregorianCalendar(2001, Calendar.AUGUST, 14), "Rua Y", "10:00-22:00", 70);
		
		
		CinemaDao dao2 = new CinemaDaoImpl(em);
		
		//Cadastrar
		try {
			dao2.cadastrar(cinema);
			dao2.cadastrar(cinema2);
			dao2.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		try {
			//Pesquisar pela PK
			Cinema busca = dao2.pesquisar(1);
			//Exibir o nome
			System.out.println(busca.getNome());
		} catch (IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//Atualizar o nome
			cinema.setNome("Cinema Sensacional");
			dao2.atualizar(cinema);
			dao2.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Remover
		try {
			dao2.remover(1);
			dao2.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		//Fechar
		em.close();
		fabrica.close();
	}
}
