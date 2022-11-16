package br.org.com.parasemear.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Instituicao implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String cnpj, nome, nomeFan, nomeRes, telefone, senha, email, logradouro, cidade, uf;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate nasc;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfis = new ArrayList<>();

	public Instituicao() {
		super();
	}

	public Instituicao(String cnpj, String nome, String nomeFan, String nomeRes, String telefone,
			String senha, String email, String logradouro, String cidade, String uf) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.nomeFan = nomeFan;
		this.nomeRes = nomeRes;
		this.telefone = telefone;
		this.senha = senha;
		this.email = email;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.uf = uf;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public LocalDate getNasc() {
		return nasc;
	}

	public void setNasc(LocalDate nasc) {
		this.nasc = nasc;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public Instituicao id(long id) {
		setId(id);
		return this;
	}

	public Instituicao cnpj(String cnpj) {
		setCnpj(cnpj);
		return this;
	}

	public Instituicao nome(String nome) {
		setNome(nome);
		return this;
	}

	public Instituicao nomeFan(String nomeFan) {
		setNomeFan(nomeFan);
		return this;
	}

	public Instituicao nomeRes(String nomeRes) {
		setNomeRes(nomeRes);
		return this;
	}

	public Instituicao telefone(String telefone) {
		setTelefone(telefone);
		return this;
	}

	public Instituicao senha(String senha) {
		setSenha(senha);
		return this;
	}

	public Instituicao email(String email) {
		setEmail(email);
		return this;
	}
	public Instituicao logradouro(String logradouro) {
		setLogradouro(logradouro);
		return this;
	}

	public Instituicao cidade(String cidade) {
		setCidade(cidade);
		return this;
	}

	public Instituicao uf(String uf) {
		setUf(uf);
		return this;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(cidade, cnpj, email, id, logradouro, nasc, nomeFan, nomeRes, perfis, nome, senha, telefone,
				uf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instituicao other = (Instituicao) obj;
		return Objects.equals(cidade, other.cidade) && Objects.equals(cnpj, other.cnpj)
				&& Objects.equals(email, other.email) && id == other.id && Objects.equals(logradouro, other.logradouro)
				&& Objects.equals(nasc, other.nasc) && Objects.equals(nomeFan, other.nomeFan)
				&& Objects.equals(nomeRes, other.nomeRes) && Objects.equals(perfis, other.perfis)
				&& Objects.equals(nome, other.nome) && Objects.equals(senha, other.senha)
				&& Objects.equals(telefone, other.telefone) && Objects.equals(uf, other.uf);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.perfis;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
