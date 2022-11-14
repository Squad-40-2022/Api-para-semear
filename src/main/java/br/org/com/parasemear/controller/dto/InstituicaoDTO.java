package br.org.com.parasemear.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.org.com.parasemear.model.Endereco;
import br.org.com.parasemear.model.Instituicao;

public class InstituicaoDTO {

	private long id;
	private String cnpj, razao, nomeFan, nomeRes, telefone, email, senha;
	private Endereco endereco;
	
	public InstituicaoDTO() {
	}
	public InstituicaoDTO(Instituicao insti) {
		this.id = insti.getId();
		this.cnpj = insti.getCnpj();
		this.razao = insti.getRazao();
		this.nomeFan = insti.getNomeFan();
		this.nomeRes = insti.getNomeRes();
		this.telefone = insti.getTelefone();
		this.email = insti.getEmail();
		this.senha = insti.getSenha();
		this.endereco = insti.getEndereco();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public static List<InstituicaoDTO> converter(List<Instituicao> insti){
		return insti.stream().map(InstituicaoDTO::new).collect(Collectors.toList());
	}
}
