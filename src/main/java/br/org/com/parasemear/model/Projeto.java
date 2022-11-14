package br.org.com.parasemear.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
public class Projeto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome_pro", nullable = false)
	private String nome;
	
	@Column(name = "ativo_doa", nullable = false, length = 1)
	private String ativo;
	
	@Column(name = "descricao_pro",nullable = false, columnDefinition = "TEXT")
    private String descricao;
	
	@Column(name = "quantia_rel", nullable = false)
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal quantia;
	
	@Column(name = "contemplados_pro", nullable = false)
    private long contemplados;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inst_id_fk", nullable = false)
    private Instituicao instituicao;
	
	@ManyToMany(mappedBy = "projetos", fetch = FetchType.LAZY)
    private List<Relatorio> relatorios;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getQuantia() {
		return quantia;
	}

	public void setQuantia(BigDecimal quantia) {
		this.quantia = quantia;
	}

	public long getContemplados() {
		return contemplados;
	}

	public void setContemplados(long contemplados) {
		this.contemplados = contemplados;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public List<Relatorio> getRelatorios() {
		return relatorios;
	}

	public void setRelatorios(List<Relatorio> relatorios) {
		this.relatorios = relatorios;
	}

	
	
	
}
