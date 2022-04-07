package br.com.fiap.entidade;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_CINEMA")
@SequenceGenerator(name="cinema", sequenceName = "SQ_TB_CINEMA",allocationSize = 1)
public class Cinema {

	@Id
	@Column(name="cd_cinema")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cinema")
	private Integer codigo;
	
	@Column(name="nm_cinema", nullable = false, length = 50)
	private String nome;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_criacao")
	private Calendar dataCriacao;
	
	@Column(name="ds_endereco", length = 8)
	private String endereco;
	
	@Column(name="ds_horario", nullable = false, length = 50)
	private String horario;
	
	@Column(name="ds_capacidade")
	private Integer capacidade;
	
	public Cinema() {}

	public Cinema(String nome, Calendar dataCriacao, 
			String endereco, String horario, Integer capacidade) {
		super();
		this.nome = nome;
		this.dataCriacao = dataCriacao;
		this.endereco = endereco;
		this.horario = horario;
		this.capacidade = capacidade;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}


	
	
	
}