package br.org.com.parasemear.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
public class Relatorio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String mes;

	private String descricao;

	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private BigDecimal quantia;

	private long voluntarios;

	private long contemplados;

	public Relatorio() {
	}

	public Relatorio(long id, String mes, String descricao, BigDecimal quantia, long voluntarios, long contemplados) {
		this.id = id;
		this.mes = mes;
		this.descricao = descricao;
		this.quantia = quantia;
		this.voluntarios = voluntarios;
		this.contemplados = contemplados;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(contemplados, descricao, id, mes, quantia, voluntarios);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Relatorio other = (Relatorio) obj;
		return contemplados == other.contemplados && Objects.equals(descricao, other.descricao) && id == other.id
				&& Objects.equals(mes, other.mes) && Objects.equals(quantia, other.quantia)
				&& voluntarios == other.voluntarios;
	}

}
