package br.com.fiap.entidade;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_FILME")
@SequenceGenerator(name="filme", sequenceName = "SQ_TB_FILME",allocationSize = 1)
public class Filme {

	@Id
	@Column(name="cd_filme")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "filme")
	private Integer codigo;
	
	@Column(name="nm_filme", nullable = false, length = 50)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero", length = 20)
	private GeneroFilme genero;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_lancamento")
	private Calendar dataLancamento;
	
	@Column(name="ds_duracao", length = 8)
	private String duracao;
	
	@Column(name="nm_diretor", nullable = false, length = 50)
	private String nomeDiretor;
	
	@Column(name="ds_nota")
	private Integer nota;
	
	public Filme() {}

	public Filme(String nome, GeneroFilme genero, Calendar dataLancamento, 
			String duracao, String nomeDiretor,	Integer nota) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.dataLancamento = dataLancamento;
		this.duracao = duracao;
		this.nomeDiretor = nomeDiretor;
		this.nota = nota;
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

	public GeneroFilme getGenero() {
		return genero;
	}

	public void setGenero(GeneroFilme genero) {
		this.genero = genero;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getNomeDiretor() {
		return nomeDiretor;
	}

	public void setNomeDiretor(String nomeDiretor) {
		this.nomeDiretor = nomeDiretor;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Filme [codigo=" + codigo + ", nome=" + nome + ", genero=" + genero + ", dataLancamento="
				+ dataLancamento + ", duracao=" + duracao + ", nomeDiretor=" + nomeDiretor + ", nota=" + nota + "]";
	}
	
	
	
}