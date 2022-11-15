package br.org.com.parasemear.controller.dto;

import org.springframework.security.core.Authentication;

import br.org.com.parasemear.model.Instituicao;

public class InsTokenDTO {

	private long idIns;
	private String emailIns;
	private String nomeIns;

	private String token;
	private String tipo;

	public InsTokenDTO(String token, String tipo, Authentication authentication) {
		Instituicao logado = (Instituicao) authentication.getPrincipal();
		this.token = token;
		this.tipo = tipo;

		this.idIns = logado.getId();
		this.emailIns = logado.getEmail();
		this.nomeIns = logado.getRazao();
	}

	public long getIdIns() {
		return this.idIns;
	}

	public String getEmailIns() {
		return this.emailIns;
	}

	public String getNomeIns() {
		return this.nomeIns;
	}

	public String getToken() {
		return this.token;
	}

	public String getTipo() {
		return this.tipo;
	}

}
