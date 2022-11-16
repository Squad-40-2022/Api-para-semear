package br.org.com.parasemear.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String ativo;

	private String descricao;

	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private BigDecimal quantia;

	private long contemplados;

	public Projeto() {
	}

	public Projeto(Long id, String nome, String ativo, String descricao, BigDecimal quantia, long contemplados) {
		this.id = id;
		this.nome = nome;
		this.ativo = ativo;
		this.descricao = descricao;
		this.quantia = quantia;
		this.contemplados = contemplados;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	@Override
	public int hashCode() {
		return Objects.hash(ativo, contemplados, descricao, id, nome, quantia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		return Objects.equals(ativo, other.ativo) && contemplados == other.contemplados
				&& Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(quantia, other.quantia);
	}

}
