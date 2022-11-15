package br.org.com.parasemear.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.org.com.parasemear.model.Colaborador;

public class ColaboradorDTO {

	private long id;
	private String cpf, nome, sobrenome, genero, telefone, email, senha, voluntario, disponibilidade, uf, cidade, bairro, logradouro, cep, numero;
	private LocalDate dataNasc;
		
	public ColaboradorDTO() {
	}
	public ColaboradorDTO(Colaborador colab) {
		this.id = colab.getId();
		this.cpf = colab.getCpf();
		this.nome = colab.getNome();
		this.sobrenome = colab.getSobrenome();
		this.genero = colab.getGenero();
		this.telefone = colab.getTelefone();
		this.email = colab.getEmail();
		this.senha = colab.getSenha();
		this.voluntario = colab.getVoluntario();
		this.disponibilidade = colab.getDisponibilidade();
		this.uf = colab.getUf();
		this.cidade = colab.getCidade();
		this.bairro = colab.getBairro();
		this.logradouro = colab.getLogradouro();
		this.cep = colab.getCep();
		this.numero = colab.getNumero();
		this.dataNasc = colab.getDataNasc();
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
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
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
	public static List<ColaboradorDTO> converter(List<Colaborador> colab){
		return colab.stream().map(ColaboradorDTO::new).collect(Collectors.toList());
	}
}
