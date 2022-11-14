package br.org.com.parasemear.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.org.com.parasemear.model.Colaborador;
import br.org.com.parasemear.model.Endereco;

public class ColaboradorDTO {

	private long id;
	private String cpf, nome, sobrenome, genero, telefone, email, senha, voluntario, disponibilidade;
	private Endereco endereco;
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
		this.endereco = colab.getEndereco();
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
	public static List<ColaboradorDTO> converter(List<Colaborador> colab){
		return colab.stream().map(ColaboradorDTO::new).collect(Collectors.toList());
	}
}
