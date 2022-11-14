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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
public class Relatorio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "mes_rel", nullable = false, length = 10)
	private String mes;
	
	@ManyToMany
    @JoinTable(
        name = "projeto_relatorio",
        joinColumns = @JoinColumn(name = "projeto_id_fk"),
        inverseJoinColumns = @JoinColumn(name = "relatorio_id_fk")
    )
    private List<Projeto> projetos;
	
	@Column(name = "descricao_rel",nullable = false, columnDefinition = "TEXT")
    private String descricao;
	
	@Column(name = "quantia_rel", nullable = false)
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal quantia;
	
	@Column(name = "voluntarios_rel", nullable = false)
    private long voluntarios;
	
	@Column(name = "contemplados_rel", nullable = false)
    private long contemplados;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inst_id_fk", nullable = false)
    private Instituicao instituicao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
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

	public long getVoluntarios() {
		return voluntarios;
	}

	public void setVoluntarios(long voluntarios) {
		this.voluntarios = voluntarios;
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
	
	
}
