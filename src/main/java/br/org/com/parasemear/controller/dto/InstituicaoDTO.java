package br.org.com.parasemear.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.org.com.parasemear.model.Colaborador;
import br.org.com.parasemear.model.Instituicao;

public class InstituicaoDTO {

	private long id;
	private String cpf, nome, nomeFan, nomeRes, telefone, senha, email, logradouro, cidade, uf, voluntario,
			disponibilidade;

	public InstituicaoDTO() {
	}

	public InstituicaoDTO(Instituicao cliente) {
		this.id = cliente.getId();
		this.cpf = cliente.getCnpj();
		this.nome = cliente.getNome();
		this.nomeFan = cliente.getNomeFan();
		this.nomeRes = cliente.getNomeRes();
		this.telefone = cliente.getTelefone();
		this.senha = cliente.getSenha();
		this.email = cliente.getEmail();
		this.logradouro = cliente.getLogradouro();
		this.cidade = cliente.getCidade();
		this.uf = cliente.getUf();
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getVoluntario() {
		return voluntario;
	}

	public void setVoluntario(String voluntario) {
		this.voluntario = voluntario;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public static List<InstituicaoDTO> converter(List<Instituicao> cliente) {
		return cliente.stream().map(InstituicaoDTO::new).collect(Collectors.toList());
	}

}
