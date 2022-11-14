package br.org.com.parasemear.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.org.com.parasemear.model.Administrador;
import br.org.com.parasemear.model.Endereco;

public class AdministradorDTO {

	private long id;
	private String cpf, nome, sobrenome, telefone, email, senha;
	private Endereco endereco;
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
		this.endereco = adm.getEndereco();
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
