package br.org.com.parasemear.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
public class Doacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String tipo;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate data;

	private String descricao;

	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private BigDecimal quantia;

	private String anonimo;

	public Doacao() {
	}

	public Doacao(String tipo, LocalDate data, String descricao, BigDecimal quantia, String anonimo) {
		this.tipo = tipo;
		this.data = data;
		this.descricao = descricao;
		this.quantia = quantia;
		this.anonimo = anonimo;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(anonimo, data, descricao, id, quantia, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doacao other = (Doacao) obj;
		return Objects.equals(anonimo, other.anonimo) && Objects.equals(data, other.data)
				&& Objects.equals(descricao, other.descricao) && id == other.id
				&& Objects.equals(quantia, other.quantia) && Objects.equals(tipo, other.tipo);
	}
}