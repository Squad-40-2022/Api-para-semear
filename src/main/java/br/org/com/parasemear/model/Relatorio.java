package br.org.com.parasemear.model;

import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Relatorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String cnpj, nome, tipo, cidade;
	private double preco_dia, desconto;
//	@Lob
//	private byte[] imagem;
	
	public Relatorio() {
	}
	public Relatorio(long id, String cnpj, String nome, String tipo, String cidade, double preco_dia, double desconto) {
		this.id = id;
		this.cnpj = cnpj;
		this.nome = nome;
		this.tipo = tipo;
		this.cidade = cidade;
		this.preco_dia = preco_dia;
		this.desconto = desconto;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public double getPreco_dia() {
		return preco_dia;
	}
	public void setPreco_dia(double preco_dia) {
		this.preco_dia = preco_dia;
	}
	public double getDesconto() {
		return desconto;
	}
	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
//	public byte[] getImagem() {
//		return imagem;
//	}
//	public void setImagem(byte[] imagem) {
//		this.imagem = imagem;
//	}
	@Override
	public int hashCode() {
		return Objects.hash(cidade, cnpj, desconto, id, nome, preco_dia, tipo);
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
		return Objects.equals(cidade, other.cidade) && Objects.equals(cnpj, other.cnpj)
				&& Double.doubleToLongBits(desconto) == Double.doubleToLongBits(other.desconto) && id == other.id
				&& Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(preco_dia) == Double.doubleToLongBits(other.preco_dia)
				&& Objects.equals(tipo, other.tipo);
	}
}
