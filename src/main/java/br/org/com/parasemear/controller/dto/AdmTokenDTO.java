package br.org.com.parasemear.controller.dto;

import org.springframework.security.core.Authentication;

import br.org.com.parasemear.model.Administrador;

public class AdmTokenDTO {

	private long idAdm;
	private String emailAdm;
	private String nomeAdm;

	private String token;
	private String tipo;

	public AdmTokenDTO(String token, String tipo, Authentication authentication) {
		Administrador logado = (Administrador) authentication.getPrincipal();
			this.token = token;
			this.tipo = tipo;
			
			this.idAdm = logado.getId();
			this.emailAdm = logado.getEmail();
			this.nomeAdm = logado.getNome();
		}

	public long getIdAdm() {
		return idAdm;
	}

	public String getEmailAdm() {
		return emailAdm;
	}

	public String getNomeAdm() {
		return nomeAdm;
	}

	public String getToken() {
		return token;
	}

	public String getTipo() {
		return tipo;
	}
	
}
