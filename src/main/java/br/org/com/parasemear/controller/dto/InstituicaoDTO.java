package br.org.com.parasemear.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.org.com.parasemear.model.Instituicao;

public class InstituicaoDTO {

	private long id;
	private String cnpj, razao, nomeFan, nomeRes, telefone, email, senha, uf, cidade, bairro, logradouro, cep, numero;
	
	public InstituicaoDTO() {
	}
	public InstituicaoDTO(Instituicao insti) {
		this.id = insti.getId();
		this.cnpj = insti.getCnpj();
		this.razao = insti.getRazao();
		this.nomeFan = insti.getNomeFan();
		this.nomeRes = insti.getNomeRes();
		this.telefone = insti.getTelefone();
		this.email = insti.getEmail();
		this.senha = insti.getSenha();
		this.uf = insti.getUf();
		this.cidade = insti.getCidade();
		this.bairro = insti.getBairro();
		this.logradouro = insti.getLogradouro();
		this.cep = insti.getCep();
		this.numero = insti.getNumero();
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
	public String getRazao() {
		return razao;
	}
	public void setRazao(String razao) {
		this.razao = razao;
	}
	public String getNomeFan() {
		return nomeFan;
	}
	public void setNomeFan(String nomeFan) {
		this.nomeFan = nomeFan;
	}
	public String getNomeRes() {
		return nomeRes;
	}
	public void setNomeRes(String nomeRes) {
		this.nomeRes = nomeRes;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public static List<InstituicaoDTO> converter(List<Instituicao> insti){
		return insti.stream().map(InstituicaoDTO::new).collect(Collectors.toList());
	}
}
