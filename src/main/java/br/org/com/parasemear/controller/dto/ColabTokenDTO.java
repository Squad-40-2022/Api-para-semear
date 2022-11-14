package br.org.com.parasemear.controller.dto;

import org.springframework.security.core.Authentication;

import br.org.com.parasemear.model.Administrador;

public class ColabTokenDTO {
	
	private long idCol;
	private String emailCol;
	private String nomeCol;

	private String token;
	private String tipo;

	public ColabTokenDTO(String token, String tipo, Authentication authentication) {
		Administrador logado = (Administrador) authentication.getPrincipal();
			this.token = token;
			this.tipo = tipo;
			
			this.idCol = logado.getId();
			this.emailCol = logado.getEmail();
			this.nomeCol = logado.getNome();
		}

	public long getIdCol() {
		return idCol;
	}

	public String getEmailCol() {
		return emailCol;
	}

	public String getNomeCol() {
		return nomeCol;
	}

	public String getToken() {
		return token;
	}

	public String getTipo() {
		return tipo;
	}
	
}
