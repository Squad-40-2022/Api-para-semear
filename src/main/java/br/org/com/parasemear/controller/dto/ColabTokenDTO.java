package br.org.com.parasemear.controller.dto;

import org.springframework.security.core.Authentication;

import br.org.com.parasemear.model.Colaborador;

public class ColabTokenDTO {

	private Long idUser;
	private String emailUser;
	private String nomeUser;

	private String token;
	private String tipo;

	public ColabTokenDTO(String token, String tipo, Authentication authentication) {
		Colaborador logado = (Colaborador) authentication.getPrincipal();
		this.token = token;
		this.tipo = tipo;

		this.idUser = logado.getId();
		this.emailUser = logado.getEmail();
		this.nomeUser = logado.getNome();

	}

	public String getToken() {
		return this.token;
	}

	public String getTipo() {
		return this.tipo;
	}

	public Long getIdUser() {
		return this.idUser;
	}

	public String getEmailUser() {
		return this.emailUser;
	}

	public String getNomeUser() {
		return this.nomeUser;
	}
}
