package br.org.com.parasemear.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.org.com.parasemear.model.Endereco;
import br.org.com.parasemear.model.Instituicao;

public class InstituicaoForm {
	@NotNull
	@NotEmpty
	@NotBlank
	private String cnpj;
	@NotNull
	@NotEmpty
	@NotBlank
	private String razao;
	@NotNull
	@NotEmpty
	@NotBlank
	private String nomeFan;
	@NotNull
	@NotEmpty
	@NotBlank
	private String nomeRes;
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
	private Endereco endereco;

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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Instituicao converter(BCryptPasswordEncoder encoder) {

		this.setSenha(encoder.encode(senha));
		return new Instituicao(cnpj, razao, nomeFan, nomeRes, telefone, email, senha, endereco);
	}
}
