package br.org.com.parasemear.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.org.com.parasemear.model.Administrador;

public class AdministradorDTO {

	private long id;
	private String cpf, nome, sobrenome, telefone, email, senha, uf, cidade, bairro, logradouro, cep, numero;
	private LocalDate dataNasc;
	
	public AdministradorDTO() {
	}
	public AdministradorDTO(Administrador adm) {
		this.id = adm.getId();
		this.cpf = adm.getCpf();
		this.nome = adm.getNome();
		this.sobrenome = adm.getSobrenome();
		this.telefone = adm.getTelefone();
		this.email = adm.getEmail();
		this.senha = adm.getSenha();
		this.uf = adm.getUf();
		this.cidade = adm.getCidade();
		this.bairro = adm.getBairro();
		this.logradouro = adm.getLogradouro();
		this.cep = adm.getCep();
		this.numero = adm.getNumero();
		this.dataNasc = adm.getDataNasc();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
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
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public static List<AdministradorDTO> converter(List<Administrador> adm){
		return adm.stream().map(AdministradorDTO::new).collect(Collectors.toList());
	}
}
