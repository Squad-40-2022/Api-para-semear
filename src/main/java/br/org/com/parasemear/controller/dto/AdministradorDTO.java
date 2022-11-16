package br.org.com.parasemear.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.org.com.parasemear.model.Administrador;

public class AdministradorDTO {
	
	private long id;
	private String senha, email, nome;
	
	public AdministradorDTO() {
		super();
	}

	public AdministradorDTO(Administrador user) {
		super();
		this.id = user.getId();
		this.senha = user.getSenha();
		this.email = user.getEmail();
		this.nome = user.getNome();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static List<AdministradorDTO> converter(List<Administrador> user){
		return user.stream().map(AdministradorDTO::new).collect(Collectors.toList());
	}
	
}
