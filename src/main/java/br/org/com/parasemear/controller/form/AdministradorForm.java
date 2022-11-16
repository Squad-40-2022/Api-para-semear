package br.org.com.parasemear.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.org.com.parasemear.model.Administrador;

public class AdministradorForm {

	@NotNull
	@NotEmpty
	@NotBlank
	private String nome;
	@NotNull
	@NotEmpty
	private String email;
	@NotNull
	@NotEmpty
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Administrador converter(BCryptPasswordEncoder encoder) {

		this.setSenha(encoder.encode(senha));
		return new Administrador(senha, email, nome);
	}
}
