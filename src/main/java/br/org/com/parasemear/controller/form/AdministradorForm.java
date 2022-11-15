package br.org.com.parasemear.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.org.com.parasemear.model.Administrador;

public class AdministradorForm {
	@NotNull
	@NotEmpty
	@NotBlank
	private String cpf;
	@NotNull
	@NotEmpty
	@NotBlank
	private String nome;
	@NotNull
	@NotEmpty
	@NotBlank
	private String sobrenome;
	@NotNull
	@NotEmpty
	private String telefone;
	@NotNull
	@NotEmpty
	private String email;
	@NotNull
	@NotEmpty
	private String senha;
	@NotNull
	@NotEmpty
	private String uf;
	@NotNull
	@NotEmpty
	private String cidade;
	@NotNull
	@NotEmpty
	private String bairro;
	@NotNull
	@NotEmpty
	private String logradouro;
	@NotNull
	@NotEmpty
	private String cep;
	@NotNull
	@NotEmpty
	private String numero;
	private LocalDate dataNasc;
	
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



	public Administrador converter(BCryptPasswordEncoder encoder) {

		this.setSenha(encoder.encode(senha));
		return new Administrador(cpf, nome, sobrenome, telefone, email, senha, uf, cidade, bairro, logradouro, cep, numero, dataNasc);
	}

}
