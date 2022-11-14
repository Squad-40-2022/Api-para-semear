package br.org.com.parasemear.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
public class Doacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "tipo_doa", nullable = false, length = 1)
	private String tipo;
	
	@Column(name = "data_doa", nullable = false)
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate data;
	
	@Column(name = "descricao_doa",nullable = false, columnDefinition = "TEXT")
    private String descricao;
	
	@Column(name = "quantia_doa", nullable = false)
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal quantia;
	
	@Column(name = "anonimo_doa", nullable = false, length = 1)
	private String anonimo;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "colab_id_fk", nullable = false)
    private Colaborador colaborador;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inst_id_fk", nullable = false)
    private Instituicao instituicao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
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

	public String getAnonimo() {
		return anonimo;
	}

	public void setAnonimo(String anonimo) {
		this.anonimo = anonimo;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	
	
}
